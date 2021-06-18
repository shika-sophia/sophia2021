package javaGoF.chap15Facade.facade;

import java.io.FileWriter;
import java.io.IOException;

public class PageMakerFacade {
    private PageMakerFacade() { }

    public static void welcomePage(
            String mailAd, String output) {
        try {
            var property = DaoFacade.getProperty("mailData");
            String userName = property.getProperty(mailAd);

            var htmlWriter = new HtmlWriterFacade(new FileWriter(output));
            htmlWriter.header("Welcome to " + userName + "'s Page!");
            htmlWriter.message(userName + "のページに ようこそ");
            htmlWriter.message("メール待ってますね");
            htmlWriter.mailto(mailAd, userName);
            htmlWriter.footer();

            System.out.printf(
                "%s is created for %s(%s) \n",
                output, mailAd, userName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//welcomePage()

    public static void linkPage(String output) {
        try {
            var property = DaoFacade.getProperty("mailData");
            var htmlWriter = new HtmlWriterFacade(new FileWriter(output));

            htmlWriter.header("Link Page");
            property.entrySet().stream()
                .forEach(entry -> {
                    try {
                        htmlWriter.mailto(
                            (String) entry.getKey(), (String) entry.getValue());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            htmlWriter.footer();

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(output + " is created.");
    }//linkPage()
}//class
