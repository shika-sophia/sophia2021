/**
 * @title webPractice / applet / HelloApplet.java
 * @reference 結城 浩 『Java言語プログラミングレッスン  上 [第３版]』 SB Creative, 2012
 * @content 付録Ｂ: Applet / p315 / サーバーに置く簡易Webプログラム (実行失敗)
 * @author shika
 * @date 2021-04-08
 */
/*
java.applet.Applet
@Deprecated(since="9")
使用すべきではありません。
    The Applet API is deprecated, no replacement.
    An applet is a small program that is intended not to be run onits own,
    but rather to be embedded inside another application.
    The Applet class must be the superclass of anyapplet
    that is to be embedded in a Web page or viewed by the JavaApplet Viewer.
    The Applet class provides a standardinterface between applets and their environment.
開始:1.0
作成者:Arthur van HoffChris Warth
 */
package webPractice.applet;

import java.applet.Applet;
import java.awt.FontMetrics;
import java.awt.Graphics;

@Deprecated(since="9")
public class HelloApplet extends Applet {
    @Override
    public void paint(Graphics graph) {
        FontMetrics font = graph.getFontMetrics();
        int x = 0;
        int y = font.getAscent();
        graph.drawString("HelloApplet", x, y);
    }//paint()
}//class

/*
//コンパイル, classファイルの生成
>javac HelloApplet.java -encoding UTF-8

// jarファイルの生成
>jar cf HelloApplet.jar HelloApplet.class

htmlファイル, jnlpファイル, deployJava.jsをつけて、
Desktopに全て置いて実行してみましたが、
意図どうり実行できず。

【考察】
java部分は 非推奨Appletクラスを extendsして作ればいい。
本来サーバーに置くためのファイルなので、
jar, html, jnlp, deploy.jsが必要だったが、
この sophia2021は動的Webプロジェクトで作っているので、
Tomcat 8.5に乗せて実行するのがいいと思う。

試しに HelloApplet.javaを「サーバーで実行」にしてみると
    エラー: メイン・クラスsun.applet.AppletViewerを検出およびロードできませんでした
    原因: java.lang.ClassNotFoundException: sun.applet.AppletViewer

これ、Appletのエントリーポイントが見つけられないというエラーなら、
Appletクラスの init(), start(), stop(), destroy()を付ければ行けるかな？
なんか Servletのメソッドに似ている。

ビルドの xmlファイル(jnlpファイル)や jarを読み込まなくても
Tomcat上で動作できるよう改良したら行けそう。
テキストの付録Ｂには、あと２つ Appletサンプルが載っている。
それは また、いずれ・・

やるかは分からん。

*/