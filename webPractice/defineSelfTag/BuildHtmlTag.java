/**
 * @title webPractice / defineSelfTag / BuildHtmlTag.java
 * @reference 山田祥寛 『独習 Java サーバーサイド編 第２版』 翔泳社, 2013
 * @content 第８章 Deployment Descriptor 応用編 / List 8-11 ～ 8-15
 *          【自作タグを定義】 読込テキストを HTML<table>に加工して返すタグ
 *          <win:BuildHtmlTag
 *            path = "" 読み込みテキストの path。「,」区切りで複数可
 *            [delimiter = ""] 区切り文字。デフォルト「,」 (省略可)
 *            [encoding = "" ] 読み込み時の文字コード。デフォルト「UTF-8」 (省略可)
 *          /> (タグ本体なし)
 *
 * @content 【extends】 TagSupportクラスを継承
 *          PageContext pageContext
 *          @Override doStartTag(), doEndTag()
 *          int SKIP_BODY; TagSupport定数 タグ本体を処理しない
 *
 * @content タグライブラリ・ディスクリプタ(=記述子) / 拡張子「.tld」
 *          【WingsTag.tld】 /WEB-INF/taglibs/xxxx.tld
 * @content 【web.xml】デプロイメント・ディスクリプタに タグライブラリ記述子の配置場所を登録
 * @file buildHtmlTag.jsp
 * @author shika
 * @date 2021-07-14
 */
package webPractice.defineSelfTag;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class BuildHtmlTag extends TagSupport {
    private String path = null;
    private String delimiter = ",";
    private String encoding = "UTF-8";

    @Override
    public int doStartTag() throws JspException {
        ServletContext app = pageContext.getServletContext();
        JspWriter out = pageContext.getOut();

        try (BufferedReader buf = new BufferedReader(
                new InputStreamReader(
                    new FileInputStream(app.getRealPath(path)), encoding
                )
            )){
            boolean isTitle = true;
            out.println("<table border='1'>");

            while(buf.ready()) {
                String line = buf.readLine();
                String[] dataAry = line.split(delimiter);

                out.println("<tr>");
                for(int i = 0; i < dataAry.length; i++) {
                    if(isTitle) {
                        out.println("<th>" + dataAry[i] + "</th>");
                    } else {
                        out.println("<td>" + dataAry[i] + "</td>");
                    }
                }//for
                out.println("</tr>");

                isTitle = false; //最初のwhileループ後 ずっとfalse
            }//while
            out.println("</table>");

        } catch (Exception e) {
            e.printStackTrace();
            throw new JspException(e);
        }

        return SKIP_BODY; //TagSupport定数 タグ本体を処理しない
    }//doStartTag()

    //====== setter ======
    public void setPath(String path) {
        this.path = path;
    }

    public void setDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

}//class

/*
【WingsTag.tld】 /WEB-INF/taglibs/xxxxx.tld
<? xml version="1.0" encoding="UTF-8" ?>
<taglib xmlns="http://java.sun.com/xml/ns/j2ee"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://java.sun.com/xml/ns/j2ee/web-javataglibrary_2_1.xsd"
  version="2.1" >

  <!-- jspページに記述したタグライブラリの uri -->
  <uri>http://www.webPractice.defineSelfTag/WingsTagLibs-1.0</uri>
  <tag>
     <!-- タグライブラリの基本情報を定義 -->
     <name>BuildHtmlTag</name>
     <tag-class>webPractice.defineSelfTag.BuildHtmlTag</tag-class>
     <body-content>empty</body-content>

     <!-- path, [delimiter], [encoding] 属性を定義 -->
     <attribute>
       <name>path</name>
       <require>true</require> //必須かどうか
       <rtexprvalue>true</rtexprvalue> //値にスクリプトレット/式は可能か
     </attribute>
     <attribute>
       <name>delimiter</name>
       <require>false</require>
       <rtexprvalue>true</rtexprvalue>
     </attribute>
     <attribute>
       <name>encoding</name>
       <require>false</require>
       <rtexprvalue>true</rtexprvalue>
     </attribute>
  </tag>
</taglib>

【web.xml】デプロイメント・ディスクリプタに タグライブラリ記述子の配置場所を登録
<? xml version="1.0" encoding="UTF-8" ?>
<web-app xmlns="http://java.sun.com/xml/ns/javaee"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://java.sun.com/xml/ns/javaee
  http://java.sun.com/xml/ns/javaee/web-javataglibrary_3_0.xsd"
  version="3.0" >

  <jsp-config>
    <taglib>
      <tablib-uri>http://www.webPractice.defineSelfTag/WingsTagLibs-1.0</taglib-uri>
      <taglib-location>/WEB-INF/taglibs/WingsTag.tld</taglib-location>
    </taglib>
  </jsp-config>
</web-app>

*/