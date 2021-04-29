/**
 * @title javaGold / se11Violet / sampleCode / chap11Locale / resourceBundle / MainListResourceBundle.java
 * @reference 山本道子 『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021
 * @content 第11章 Locale, Format / List 11-3, 11-4
 * @content ListResourceBundle getBundle(), getString(), getObject()
 * @class resource/MyLocale       //default, Japanese
 * @class resource/MyLocale_en_US //English
 * @class resource/MyData         //Long, Integer, int[], String の Object[][]
 * @author shika
 * @date 2021-04-28
 */
package javaGold.se11Violet.sampleCode.chap11Locale.resourceBundle;

import java.util.Arrays;
import java.util.Locale;
import java.util.ResourceBundle;

public class MainListResourceBundle {

    public static void main(String[] args) {
        String here = System.getProperty("sun.java.command"); //ここの完全修飾名
        String dir = here.substring(0, here.lastIndexOf("."));//クラス名を除去
        dir = dir + "."; //「.」を追加。下記 旧dirと同じ dirを作成。
        //String dir = "javaGold.se11Violet.sampleCode.chap11Locale.resourceBundle.";
        //System.out.println(dir);

        //====== List 11-3 / getBundle(), getString() ======
        //Locale japan = Locale.getDefault();
        Locale japan = new Locale("ja", "JP");
        Locale us = new Locale("en", "US");
        Locale[] localeAry = {japan, us};

        for(Locale locale : localeAry) {
            ResourceBundle rb =
                ResourceBundle.getBundle(dir + "resource.MyLocale", locale);
            System.out.println("Locale: " + locale);
            System.out.println("send: " + rb.getString("send"));
            System.out.println("cancel: " + rb.getString("cancel"));
            System.out.println();
        }//for

        ResourceBundle rb2 =
            ResourceBundle.getBundle(dir + "resource.MyLocale");
        System.out.println("Locale: " + Locale.ROOT); //""_""
        System.out.println("send: " + rb2.getString("send"));
        System.out.println("cancel: " + rb2.getString("cancel"));
        System.out.println();

        //====== List 11-4 / getObject()======
        ResourceBundle rbData =
            ResourceBundle.getBundle(dir + "resource.MyData");
        Long data1 = (Long) rbData.getObject("data1");
        Integer data2 = (Integer) rbData.getObject("data2");
        int[] data3 = (int[]) rbData.getObject("data3");

        System.out.println("data1: " + data1);
        System.out.println("data2: " + data2);
        System.out.println("data3: " + Arrays.toString(data3));
    }//main()

}//class

/*
//====== List 11-3 ======
Locale: ja_JP
send: 送信
cancel: 取消

Locale: en_US
send: send
cancel: cancel

---- Locale.ROOT / ""_"" ----
Locale:
send: 送信
cancel: 取消

//====== List 11-4 ======
data1: 1000
data2: 500
data3: [10, 20, 30]

【考察】
パッケージの場合はbaseNameの前にパッケージ名を完全修飾名で記述。
「src.」は不要。

System.getProperty()で このクラスの完全修飾名を取得。
クラス名を除去して、このクラスからの相対パスによってResouceにアクセスできるように変更。
もともと Eclipse内のカレントディレクトリは プロジェクト名の「sophia2021」にある。
相対パスにすると、旧 dirのような完全修飾名が必要。

//====== おまけ / System.properties() ======
実行結果から、「=」の左辺を keyとして、
System.getProperty(key)をすると、
右辺の valueを取得できる。

Properties property = System.getProperties();
property.entrySet().stream()
        .forEach(System.out::println);

sun.desktop=windows
awt.toolkit=sun.awt.windows.WToolkit
java.specification.version=11
sun.cpu.isalist=amd64
sun.jnu.encoding=MS932
java.class.path=C:\Program Files\pleiades\workspace-web\sophia2021\build\classes;C:\Program Files\pleiades\tomcat\8\lib\annotations-api.jar;C:\Program Files\pleiades\tomcat\8\lib\catalina-ant.jar;C:\Program Files\pleiades\tomcat\8\lib\catalina-ha.jar;C:\Program Files\pleiades\tomcat\8\lib\catalina-storeconfig.jar;C:\Program Files\pleiades\tomcat\8\lib\catalina-tribes.jar;C:\Program Files\pleiades\tomcat\8\lib\catalina.jar;C:\Program Files\pleiades\tomcat\8\lib\ecj-4.6.3.jar;C:\Program Files\pleiades\tomcat\8\lib\el-api.jar;C:\Program Files\pleiades\tomcat\8\lib\jasper-el.jar;C:\Program Files\pleiades\tomcat\8\lib\jasper.jar;C:\Program Files\pleiades\tomcat\8\lib\jaspic-api.jar;C:\Program Files\pleiades\tomcat\8\lib\jsp-api.jar;C:\Program Files\pleiades\tomcat\8\lib\jstl-api-1.2.jar;C:\Program Files\pleiades\tomcat\8\lib\jstl-impl-1.2.jar;C:\Program Files\pleiades\tomcat\8\lib\mysql-connector-java-8.0.20.jar;C:\Program Files\pleiades\tomcat\8\lib\servlet-api.jar;C:\Program Files\pleiades\tomcat\8\lib\tomcat-api.jar;C:\Program Files\pleiades\tomcat\8\lib\tomcat-coyote.jar;C:\Program Files\pleiades\tomcat\8\lib\tomcat-dbcp.jar;C:\Program Files\pleiades\tomcat\8\lib\tomcat-i18n-de.jar;C:\Program Files\pleiades\tomcat\8\lib\tomcat-i18n-es.jar;C:\Program Files\pleiades\tomcat\8\lib\tomcat-i18n-fr.jar;C:\Program Files\pleiades\tomcat\8\lib\tomcat-i18n-ja.jar;C:\Program Files\pleiades\tomcat\8\lib\tomcat-i18n-ko.jar;C:\Program Files\pleiades\tomcat\8\lib\tomcat-i18n-ru.jar;C:\Program Files\pleiades\tomcat\8\lib\tomcat-i18n-zh-CN.jar;C:\Program Files\pleiades\tomcat\8\lib\tomcat-jdbc.jar;C:\Program Files\pleiades\tomcat\8\lib\tomcat-jni.jar;C:\Program Files\pleiades\tomcat\8\lib\tomcat-util-scan.jar;C:\Program Files\pleiades\tomcat\8\lib\tomcat-util.jar;C:\Program Files\pleiades\tomcat\8\lib\tomcat-websocket.jar;C:\Program Files\pleiades\tomcat\8\lib\websocket-api.jar;C:\Program Files\pleiades\workspace-web\sophia2021\WebContent\WEB-INF\lib\jstl-api-1.2.jar;C:\Program Files\pleiades\workspace-web\sophia2021\WebContent\WEB-INF\lib\jstl-impl-1.2.jar;C:\Program Files\pleiades\workspace-web\sophia2021\WebContent\WEB-INF\classes
java.vm.vendor=AdoptOpenJDK
sun.arch.data.model=64
user.variant=
java.vendor.url=https://adoptopenjdk.net/
user.timezone=
os.name=Windows 10
java.vm.specification.version=11
sun.java.launcher=SUN_STANDARD
user.country=JP
sun.boot.library.path=C:\Program Files\pleiades\eclipse\jre\bin
sun.java.command=javaGold.se11Violet.sampleCode.chap11Locale.resourceBundle.MainListResourceBundle
jdk.debug=release
sun.cpu.endian=little
user.home=C:\Users\sophia
user.language=ja
java.specification.vendor=Oracle Corporation
java.version.date=2019-10-15
java.home=C:\Program Files\pleiades\eclipse\jre
file.separator=\
java.vm.compressedOopsMode=Zero based
line.separator=

java.specification.name=Java Platform API Specification
java.vm.specification.vendor=Oracle Corporation
java.awt.graphicsenv=sun.awt.Win32GraphicsEnvironment
user.script=
sun.management.compiler=HotSpot 64-Bit Tiered Compilers
java.runtime.version=11.0.5+10
user.name=sophia
path.separator=;
os.version=10.0
java.runtime.name=OpenJDK Runtime Environment
file.encoding=UTF-8
java.vm.name=OpenJDK 64-Bit Server VM
java.vendor.version=AdoptOpenJDK
java.vendor.url.bug=https://github.com/AdoptOpenJDK/openjdk-build/issues
java.io.tmpdir=C:\Users\sophia\AppData\Local\Temp\
java.version=11.0.5
user.dir=C:\Program Files\pleiades\workspace-web\sophia2021
os.arch=amd64
java.vm.specification.name=Java Virtual Machine Specification
java.awt.printerjob=sun.awt.windows.WPrinterJob
sun.os.patch.level=
java.library.path=C:\Program Files\pleiades\eclipse\jre\bin;C:\WINDOWS\Sun\Java\bin;C:\WINDOWS\system32;C:\WINDOWS;C:/Program Files/pleiades/eclipse//jre/bin/server;C:/Program Files/pleiades/eclipse//jre/bin;C:\Program Files\AdoptOpenJDK\jdk-11.0.7.10-hotspot\bin;C:\Program Files (x86)\Common Files\Oracle\Java\javapath;C:\WINDOWS\system32;C:\WINDOWS;C:\WINDOWS\System32\Wbem;C:\WINDOWS\System32\WindowsPowerShell\v1.0\;C:\WINDOWS\System32\OpenSSH\;C:\Program Files\Java\jdk1.8.0_251\bin;C:\Program Files\Apache24\bin;C:\Program Files\MySQL\MySQL Shell 8.0\bin\;C:\Users\sophia\AppData\Local\Microsoft\WindowsApps;C:\Program Files\Java\jdk1.8.0_251\bin;C:\Users\sophia\AppData\Local\GitHubDesktop\bin;%USERPROFILE%\AppData\Local\Microsoft\WindowsApps;;C:\Program Files\pleiades\eclipse;;.
java.vendor=AdoptOpenJDK
java.vm.info=mixed mode
java.vm.version=11.0.5+10
sun.io.unicode.encoding=UnicodeLittle
java.class.version=55.0
*/