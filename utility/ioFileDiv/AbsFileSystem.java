/**
 * @title utility / ioFileDiv / AbsFileSystem.java
 * @content Fileの読み書きをする汎用クラス群。javaDocの自動生成も追加。
 * @package utility.ioFileDiv
 * @class AbsFileSystem extends Thread   //共通フィールド。呼び出しクラスのプロパティを取得
 * @class ReadFile extends AbsFileSystem //pathから そのファイルを読み取り
 * @class WriteFile extends ReadFile     //pathから そのファイルに書き込み
 * @class BuildJavaDoc extends WriteFile //javaDocの自動生成機能
 * @class BuildFilePage extends BuildJavaDoc //javaDocを含むファイルページの作成。
 *
 * @reference ◆スタックトレースから呼び出し元の情報を取得する（java）
 * @URL          https://qiita.com/Qui/items/467bb09211772e343c59
 * @reference ◆Javaコード入門 / getPropertiesメソッド
 * @URL          https://java-code.jp/290
 * @author shika
 * @date 2021-01-25
 */

package utility.ioFileDiv;

import java.io.File;
import java.util.Properties;

public abstract class AbsFileSystem extends Thread{
    protected String className;
    protected File path;

    protected AbsFileSystem() {
        seekProperty();
    }

    public void seekProperty() {
        //====== StackTraceの情報を取得 ======
        StackTraceElement[] stackAry
            = Thread.currentThread().getStackTrace();

        for (var stack : stackAry) {
            System.out.println(stack);
        }
        System.out.println();

        //====== Systemプロパティを取得 ======
        Properties property = System.getProperties();

        //---- カレントディレクトリ / クラス名を取得 ----
        System.out.println("user.dir = "
            + property.getProperty("user.dir"));

        System.out.println("sun.java.command = "
            + property.getProperty("sun.java.command"));

//        //---- 全propertyを取得 ----
//        for (Object key : property.keySet()) {
//            System.out.println(key + "=" + property.get(key));
//        }
    }//seekProperty()

    public static void main(String[] args) {
        new ReadFile();
    }//main()

}//class

/*
//====== StackTraceの情報を取得 ======
java.base/java.lang.Thread.getStackTrace(Thread.java:1606)
utility.ioFileDiv.AbsFileSystem.seekPrevious(AbsFileSystem.java:34)
utility.ioFileDiv.AbsFileSystem.<init>(AbsFileSystem.java:29)
utility.ioFileDiv.ReadFile.<init>(ReadFile.java:16)
utility.ioFileDiv.AbsFileSystem.main(AbsFileSystem.java:48)

//====== Systemプロパティを取得 ======
//---- カレントディレクトリ / クラス名を取得 ----
user.dir = C:\Program Files\pleiades\workspace-web\janJava2021
sun.java.command = utility.ioFileDiv.AbsFileSystem

//---- 全propertyを取得 ----
sun.desktop=windows
awt.toolkit=sun.awt.windows.WToolkit
java.specification.version=11
sun.cpu.isalist=amd64
sun.jnu.encoding=MS932
java.class.path=C:\Program Files\pleiades\workspace-web\janJava2021\build\classes;C:\Program Files\pleiades\tomcat\8\lib\annotations-api.jar;C:\Program Files\pleiades\tomcat\8\lib\catalina-ant.jar;C:\Program Files\pleiades\tomcat\8\lib\catalina-ha.jar;C:\Program Files\pleiades\tomcat\8\lib\catalina-storeconfig.jar;C:\Program Files\pleiades\tomcat\8\lib\catalina-tribes.jar;C:\Program Files\pleiades\tomcat\8\lib\catalina.jar;C:\Program Files\pleiades\tomcat\8\lib\ecj-4.6.3.jar;C:\Program Files\pleiades\tomcat\8\lib\el-api.jar;C:\Program Files\pleiades\tomcat\8\lib\jasper-el.jar;C:\Program Files\pleiades\tomcat\8\lib\jasper.jar;C:\Program Files\pleiades\tomcat\8\lib\jaspic-api.jar;C:\Program Files\pleiades\tomcat\8\lib\jsp-api.jar;C:\Program Files\pleiades\tomcat\8\lib\jstl-api-1.2.jar;C:\Program Files\pleiades\tomcat\8\lib\jstl-impl-1.2.jar;C:\Program Files\pleiades\tomcat\8\lib\mysql-connector-java-8.0.20.jar;C:\Program Files\pleiades\tomcat\8\lib\servlet-api.jar;C:\Program Files\pleiades\tomcat\8\lib\tomcat-api.jar;C:\Program Files\pleiades\tomcat\8\lib\tomcat-coyote.jar;C:\Program Files\pleiades\tomcat\8\lib\tomcat-dbcp.jar;C:\Program Files\pleiades\tomcat\8\lib\tomcat-i18n-de.jar;C:\Program Files\pleiades\tomcat\8\lib\tomcat-i18n-es.jar;C:\Program Files\pleiades\tomcat\8\lib\tomcat-i18n-fr.jar;C:\Program Files\pleiades\tomcat\8\lib\tomcat-i18n-ja.jar;C:\Program Files\pleiades\tomcat\8\lib\tomcat-i18n-ko.jar;C:\Program Files\pleiades\tomcat\8\lib\tomcat-i18n-ru.jar;C:\Program Files\pleiades\tomcat\8\lib\tomcat-i18n-zh-CN.jar;C:\Program Files\pleiades\tomcat\8\lib\tomcat-jdbc.jar;C:\Program Files\pleiades\tomcat\8\lib\tomcat-jni.jar;C:\Program Files\pleiades\tomcat\8\lib\tomcat-util-scan.jar;C:\Program Files\pleiades\tomcat\8\lib\tomcat-util.jar;C:\Program Files\pleiades\tomcat\8\lib\tomcat-websocket.jar;C:\Program Files\pleiades\tomcat\8\lib\websocket-api.jar
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
sun.java.command=utility.ioFileDiv.AbsFileSystem
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
user.dir=C:\Program Files\pleiades\workspace-web\janJava2021
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