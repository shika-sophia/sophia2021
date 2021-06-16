package javaGoF.chap15Facade.facade;

import java.io.FileWriter;
import java.io.IOException;

public class PageMakerFacade {
    private PageMakerFacade() { }

    public static void welcomePage(
            String mailAd, String fileName) {
        try {
            var property = DaoFacade.getProperty("mailData");
            String userName = property.getProperty(mailAd);

            var htmlWriter = new HtmlWriterFacade(new FileWriter(fileName));
            htmlWriter.header("Welcome to " + userName + "'s Page!");
            htmlWriter.message(userName + "のページに ようこそ");
            htmlWriter.message("メール待ってますね");
            htmlWriter.mailto(mailAd, userName);
            htmlWriter.footer();

            System.out.printf(
                "%s is created for %s(%s) \n",
                fileName, mailAd, userName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//welcomePage()
}//class
