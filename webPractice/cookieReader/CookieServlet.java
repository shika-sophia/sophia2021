/**
 * @title webPractice / cookieReader / CookieServlet.java
 * @reference 山田祥寛 『独習 Java サーバーサイド編 第２版』 翔泳社, 2013
 * @content HTTP.header情報の取得
 *
 * @class CookieFilter  //setCharacterEncoding("UTF-8")
 * @class CookieServlet //◆EntryPoint / Controler
 * @class CookieReader  //Enum<String> -> headerName, headerContent
 *                           -> nameList, contentList
 *                           -> StringBuilder -> String
 * @page  WebContent/WEB-INF/cookie/cookieIndex.jsp  //<form> name, pass, submit
 *
 * @author shika
 * @date 2021-02-25
 */
package webPractice.cookieReader;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CookieReader reader;
    private MethodSample sample;
    private String message;

    public void init(ServletConfig config) throws ServletException {
        reader = new CookieReader();
        sample = new MethodSample();
    }//init()

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        message = "入力して下さい。";
        doForward(request, response);
    }//doGet()

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Enumeration<String> headerEnum = request.getHeaderNames();
        reader. headerReader(headerEnum, request);
        String headerStr = reader.getHeaderStr();
        sample.requestSample(request);
        System.out.println(headerStr);
        message = "ヘッダー情報を取得しました。";
        doForward(request, response);
    }//doPost()

    private void doForward(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("message", message);

        String path = "/WEB-INF/cookie/cookieIndex.jsp";
        RequestDispatcher dis = request.getRequestDispatcher(path);
        dis.forward(request, response);
    }//doForward()
}//class

/*
==== request method ====
---- request header ----
method: POST
mine: application/x-www-form-urlencoded
authType: null
bodyLength: 20
locale: ja
protocol: HTTP/1.1
addressLocal: 0:0:0:0:0:0:0:1
addressRemote: 0:0:0:0:0:0:0:1
host: 0:0:0:0:0:0:0:1
user: null
session: 8A58422BE2D942083BB1F38EAEBB5048

---- request path ----
scheme: http
server: localhost
port: 8080
url: http://localhost:8080/sophia2021/CookieServlet
uri: /sophia2021/CookieServlet
appli: /sophia2021
servlet: /CookieServlet
query: null
info: null
trans: null

String.length(): 526
*/
/*
//====== result ======
host: localhost:8080
connection: keep-alive
content-length: 20
cache-control: max-age=0
sec-ch-ua: "Chromium";v="88", "Google Chrome";v="88", ";Not A Brand";v="99"
sec-ch-ua-mobile: ?0
upgrade-insecure-requests: 1
origin: http://localhost:8080
content-type: application/x-www-form-urlencoded
user-agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/88.0.4324.182 Safari/537.36
accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,＊/＊;q=0.8,application/signed-exchange;v=b3;q=0.9
sec-fetch-site: same-origin
sec-fetch-mode: navigate
sec-fetch-user: ?1
sec-fetch-dest: document
referer: http://localhost:8080/sophia2021/CookieServlet
accept-encoding: gzip, deflate, br
accept-language: ja,en-US;q=0.9,en;q=0.8
cookie: JSESSIONID=CF3FA7A93F1B6D5DE49AD251778F55B3

headerStr.length(): 845
*/