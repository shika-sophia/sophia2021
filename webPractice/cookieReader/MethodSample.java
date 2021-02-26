package webPractice.cookieReader;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

public class MethodSample {

    public void requestSample(HttpServletRequest request) {
        //---- request header / p115 ----
        String method = request.getMethod();
        String mine   = request.getContentType();
        String authType = request.getAuthType();
        int bodyLength = request.getContentLength();
        Locale locale = request.getLocale();
        String protocol = request.getProtocol();
        String addressLocal = request.getLocalAddr();
        String addressRemote = request.getRemoteAddr();
        String host = request.getRemoteHost();
        String user = request.getRemoteUser();
        String session = request.getRequestedSessionId();

        //---- request path / p116 ----
        String scheme = request.getScheme();
        String server = request.getServerName();
        int port = request.getServerPort();
        StringBuffer url = request.getRequestURL();
        String uri = request.getRequestURI();
        String appli = request.getContextPath();
        String servlet = request.getServletPath();
        String query = request.getQueryString();
        String info = request.getPathInfo();
        String trans = request.getPathTranslated();

        var bld = new StringBuilder(600);
        bld.append("==== request method ====\n");
        bld.append("---- request header ----\n");
        bld.append("method: ").append(method).append("\n");
        bld.append("mine: ").append(mine).append("\n");
        bld.append("authType: ").append(authType).append("\n");
        bld.append("bodyLength: ").append(bodyLength).append("\n");
        bld.append("locale: ").append(locale).append("\n");
        bld.append("protocol: ").append(protocol).append("\n");
        bld.append("addressLocal: ").append(addressLocal).append("\n");
        bld.append("addressRemote: ").append(addressRemote).append("\n");
        bld.append("host: ").append(host).append("\n");
        bld.append("user: ").append(user).append("\n");
        bld.append("session: ").append(session).append("\n");

        bld.append("\n---- request path ----\n");
        bld.append("scheme: ").append(scheme).append("\n");
        bld.append("server: ").append(server).append("\n");
        bld.append("port: ").append(port).append("\n");
        bld.append("url: ").append(url).append("\n");
        bld.append("uri: ").append(uri).append("\n");
        bld.append("appli: ").append(appli).append("\n");
        bld.append("servlet: ").append(servlet).append("\n");
        bld.append("query: ").append(query).append("\n");
        bld.append("info: ").append(info).append("\n");
        bld.append("trans: ").append(trans).append("\n");

        System.out.println(bld.toString());
        System.out.println("String.length(): " + bld.length());
        System.out.println();
    }//requestSample()

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