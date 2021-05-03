/**
 * @title WebContent / secureCode / CsrfFilter.java
 * @reference 山田祥寛 『独習 Java サーバーサイド編 第２版』 翔泳社, 2013
 * @content 第10章 Security / p502 / List 10-3
 * @content CSRF: Cross-Site Request Forgeries
 *                本来のWebページに似せた偽ページから自サイトに誘導し、
 *                ユーザー権限を奪ったのち、その権限で本来のWebサイトにアクセスする攻撃
 *          [Tomcat7-] CsrfPrevntionFilterが用意されているが、そのフィルタを自作。
 * @author shika
 * @date 2021-05-03
 */

package webPractice.secureCode;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter("/CsrfFilter")
public class CsrfFilter implements Filter {

    public void doFilter(
        ServletRequest req, ServletResponse res, FilterChain chain)
        throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;

        //HTTP.GET要求で新規トークンの作成
        if(request.getMethod().equals("GET")) {
            createToken(request);

        //HTTP.POST要求であればトークンの一致をチェック
        } else {
            if(!checkToken(request)) {
                throw new ServletException("<!> 不正なアクセスです");
            }
        }

        chain.doFilter(req, res);
    }//doFilter()

    public void init(FilterConfig fConfig) throws ServletException { }
    public void destroy() { }

    //トークンを生成するためのメソッド
    private void createToken(HttpServletRequest request) {
        MessageDigest md = null;
        HttpSession session = request.getSession();

        //sessionIDをもとに「md5ハッシュ値」を生成。　byte[] -> 16進数
        try {
            md = MessageDigest.getInstance("MD5");
            md.update(session.getId().getBytes());
            session.setAttribute("token", toHex(md.digest()));

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }//createToken()

    private boolean checkToken(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String sesToken = (String) session.getAttribute("token");
        String reqToken = (String) request.getParameter("token");

        //トークンが空の場合は不正と見なす
        if (sesToken == null || reqToken == null || reqToken.isEmpty()) {
            return false;
        }

        return sesToken.equals(reqToken);
    }//checkToken()

    //バイト配列を 16進数の文字列に変換
    private String toHex(byte[] digest) {
        StringBuffer buff = new StringBuffer();
        for(int i = 0; i < digest.length; i++) {
            buff.append(Integer.toHexString((digest[i] >> 4) & 0x0F));
            buff.append(Integer.toHexString(digest[i] & 0x0F));
        }//for

        return buff.toString();
    }//toHex

}//class

/*
◆攻撃者の用意するページ
＊untrue.html
ようこそ、いらっしゃいました！
<iframe src="auto_submit.html" width="1" heghit="1"></iframe>

＊auto_submit.html
<body onload="document.fm.submit();">
<form name="fm" method="POST"
        action="http://localhost:8080/selfjsp/chap4/insert_process.jsp">
    <input type="hidden" name="name" value="bad_man" />
    <input type="hidden" name="address" value="bad_street" />
    <input type="hidden" name="tel" value="0x-0000-0000" />
    <input type="hidden" name="email" value="bad@example.com" />
</form>
</body>

1×1サイズのインラインフレームを使って、自動的に <form>内容を送信する仕組み。
untrue.htmlを開くと、自動的に auto_submit.htmlを開き実行する。
ここでの行き先は、selfjsp/chap4/insert_process.jsp

◆認証用にユーザーから送ってもらうフォーム
＊insert_form.jsp
<form method="POST" action="insert_process.jsp">
    <input type="hidden" name="token" value="${sessionScope['token']}" />
    <input ・・中略・・
</form>
*/