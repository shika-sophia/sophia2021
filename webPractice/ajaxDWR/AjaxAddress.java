/**
 * @title webPractice / ajaxDWR / AjaxAddress.java
 * @reference 山田祥寛 『独習 Java サーバーサイド編 第２版』 翔泳社, 2013
 * @content 第９章 外部ライブラリ / List 9-4, 9-5, 9-6
 * @content DWR Servlet / Ajax (=非同期のJavaScript通信)
 * @content 【web.xml】 DWR Servletを有効にする / 未配置
 * @content 【context.xml】 JavaScript経由でのアクセスを有効にする / 未配置
 * @deploy /WEB-INF/lib/dwr.jar
 *         http://directwebremoting.org/dwr/
 * @deploy /WEB-INF/lib/commons.logging-X.X.jar
 *         https://commons.apache.org/proper/commons-logging/
 * @file ajaxDwr.jsp
 * @author shika
 * @date 2021-07-20
 */
package webPractice.ajaxDWR;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.directwebremoting.annotations.DataTransferObject;
import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProperty;
import org.directwebremoting.annotations.RemoteProxy;
import org.directwebremoting.annotations.ScriptScope;

@DataTransferObject
@RemoteProxy(scope=ScriptScope.APPLICATION)
public class AjaxAddress implements Serializable {
    @RemoteProperty
    private int id;
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    @RemoteProperty
    private String name;
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @RemoteProperty
    private String address;
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    @RemoteProperty
    private String tel;
    public String getTel() { return tel; }
    public void setTel(String tel) { this.tel = tel; }

    @RemoteProperty
    private String email;
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    //DB接続し nameを keyとして 各propertyの値を取得、AjaxAdressでインスタンス
    @RemoteMethod
    public static List<AjaxAddress> getInfoByName(String name){
        List<AjaxAddress> adList = new ArrayList<>();

        String sql = "SELECT * FROM address_tb WHERE name LIKE ?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Context context = new InitialContext();
            DataSource ds = (DataSource) context.lookup(
                    "java:comp/env/jdbc/selfjsp");
            conn = ds.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + name + "%");
            rs = ps.executeQuery();

            while(rs.next()) {
                AjaxAddress ad = new AjaxAddress();
                ad.setId(rs.getInt("id"));
                ad.setName(rs.getString("name"));
                ad.setAddress(rs.getString("address"));
                ad.setTel(rs.getString("tel"));
                ad.setEmail(rs.getString("email"));

                adList.add(ad);
            }//while

        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(rs != null) { rs.close(); }
                if(ps != null) { ps.close(); }
                if(conn != null) { conn.close(); }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }//try-catch-finally

        return adList;
    }//getInfoByName
}//class

/*
【web.xml】 DWR Servletを有効にする
<? xml version="1.0" encoding="UTF-8" ?>
<web-app xmlns="http://java.sun.com/xml/ns/javaee"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://java.sun.com/xml/ns/javaee
  http://java.sun.com/xml/ns/javaee/web-javataglibrary_3_0.xsd"
  version="3.0" >

  <servlet>
    <servlet-name>dwr-invoker</servlet-name>
    <servlet-class>org.directwebremoting.servlet.DwrServlet</servlet-class>

    <init-param>
      <param-name>debug</param-name>
      <param-value>true</param-value>
    </init-param>
    <init-param>
      <param-name>classes</param-name>
      <param-value>webPractice.ajaxDWR.AjaxAddress</param-value>
    </init-param>

    <load-on-startup>1</load-on-startup>
  <servlet>

  <servlet-mapping>
    <servlet-name>dwr-invoker</servlet-name>
    <url-pattern>/dwr/*</url-pattern>
  </servlet-mapping>
<web-app>

【context.xml】 JavaScript経由でのアクセスを有効にする 〔Servlet 3.0 [Tomcat 7.0]- 〕
<? xml version="1.0" encoding="UTF-8" ?>
<Context displayName="Teach Yourself JavaServer"
    docBase="selfjsp" path="/selfjsp"
    reloadable="true" useHttpOnly="false">

</Context>
*/