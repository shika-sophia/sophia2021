
package webPractice.cookieReader;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class CookieReader {
    private List<String> nameList;
    private List<String> contentList;
    private String headerStr;

    CookieReader() {
        nameList = new ArrayList<String>(24);
        contentList = new ArrayList<String>(24);
    }

    public void headerReader(
            Enumeration<String> headerEnum,
            HttpServletRequest request) {

        while(headerEnum.hasMoreElements()) {
            String headerName = (String)headerEnum.nextElement();
            nameList.add(headerName);

            String headerContent = request.getHeader(headerName);
            contentList.add(headerContent);
        }//while headerEnum

        buildHeader();
        //System.out.println("nameList: " + nameList);
        //System.out.println("contentList: " + contentList);
    }// headerReader()

    public String buildHeader() {
        var bld = new StringBuilder(1024);

        for(int i = 0; i < nameList.size(); i++) {
            bld.append(nameList.get(i)).append(": ")
               .append(contentList.get(i)).append("\n");
        }

        this.headerStr = bld.toString();
        //System.out.println("str.length(): " + headerStr.length());
        return headerStr;
    }//buildHeader

    //====== getter ======
    public List<String> getNameList() {
        return nameList;
    }

    public List<String> getContentList() {
        return contentList;
    }

    public String getHeaderStr() {
        return headerStr;
    }

}//class

/*
nameList: [host, connection, content-length, cache-control, sec-ch-ua, sec-ch-ua-mobile, upgrade-insecure-requests,
    origin, content-type, user-agent, accept, sec-fetch-site, sec-fetch-mode, sec-fetch-user, sec-fetch-dest, referer,
     accept-encoding, accept-language, cookie]

contentList: [localhost:8080, keep-alive, 20, max-age=0, "Chromium";v="88", "Google Chrome";v="88",
    ";Not A Brand";v="99", ?0, 1, http://localhost:8080, application/x-www-form-urlencoded,
    Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/88.0.4324.182 Safari/537.36,
     text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,
     ＊/＊;q=0.8,application/signed-exchange;v=b3;q=0.9, same-origin, navigate, ?1, document,
     http://localhost:8080/sophia2021/CookieServlet, gzip, deflate, br, ja,en-US;q=0.9,en;q=0.8,
     JSESSIONID=CF3FA7A93F1B6D5DE49AD251778F55B3]

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

