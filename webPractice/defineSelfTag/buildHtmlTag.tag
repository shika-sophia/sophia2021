<%-- /**
 * @title webPractice / defineSelfTag / BuildHtmlTag.tag
 * @reference 山田祥寛 『独習 Java サーバーサイド編 第２版』 翔泳社, 2013
 * @content 第８章 Deployment Descriptor 応用編 / List 8-16
 *          【自作タグを定義】 読込テキストを HTML<table>に加工して返すタグ
 *          <win:BuildHtmlTag
 *            path = "" 読み込みテキストの path。「,」区切りで複数可
 *            [delimiter = ""] 区切り文字。デフォルト「,」 (省略可)
 *            [encoding = "" ] 読み込み時の文字コード。デフォルト「UTF-8」 (省略可)
 *          /> (タグ本体なし)
 *
 * @content 【/WEB-INF/tags/xxxx.tag】 タグファイル
 *          JSPページから、このタグファイルを読み込ませることで、
 *          タグ定義のクラス、登録のための web.xmlを代替。
 * @content 【forTagFile.jsp】 タグファイル対応の JSPページ
 *          JSPページでのタグ呼出。
 *          <win:buildHtmlTag>
 *          prefix「win」を keyとして tagdir属性からディレクトリを検出
 *          win:以後をファイル名として「.tag」を付けてファイルロード

 * @prepair /WEB-INF/tags/buildHtmlTag.tag 未配置
 * @prepair /WEB-INF/pathData/data.txt 未配置
 * @see BuildHtmlTag.java
 * @author shika
 * @date 2021-07-19
 */ --%>

 <%@ tag body-content="empty" pageEncoding="UTF-8" import="java.io.*" %>
 <%@ attribute name="path" required="true" rtexprvalue="true" %>
 <%@ attribute name="delimiter" required="false" rtexprvalue="false" %>
 <%@ attribute name="encoding" required="false" rtexprvalue="false" %>

<table border="1">
 <%
 String path = (String) jspContext.getAttribute("path");
 String delimiter = (String) jspContext.getAttribute("delimiter");
 String encoding = (String) jspContext.getAttribute("encoding");

 delimiter = (delimiter == null) ? "," : delimiter;
 encoding = (encoding == null) ? "UTF-8" : encoding;

 try(BufferedReader buf = new BufferedReader(
         new InputStreamReader(
             new FileInputStream(application.getRealPath(path)), encoding)
     )) {
    boolean isTitle = true;
    while(buf.ready()){
        String line = buf.readLine();
        String[] lineAry = line.split(delimiter);

        out.println("<tr>");
        for(int i = 0; i < lineAry.length; i++){
            if(isTitle){
                out.println("<th>" + lineAry[i] + "</th>");
            } else {
                out.println("<td>" + lineAry[i] + "</td>");
            }
        }//for
        out.println("</tr>");
        isTitle = false;
    }//while
 }//try() //catch節は無効なので resourceの close()のみ実行
 %>
</table>