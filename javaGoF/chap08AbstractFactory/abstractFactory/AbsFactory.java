package javaGoF.chap08AbstractFactory.abstractFactory;

public abstract class AbsFactory {

    @Deprecated(since="9") //abstractのインスタンス取得のため利用
    public static AbsFactory getFactory(String className) {
        AbsFactory factory = null;
        try {
            factory =
                (AbsFactory) Class.forName(className)
                                  .newInstance();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return factory;
    }//getFactory()

    public abstract AbsLink createLink(String caption, String url);
    public abstract AbsTray createTray(String caption);
    public abstract AbsPage createPage(String title, String author);

    public AbsPage createYahooPage(String select) {
        AbsLink link = createLink("Yahoo!", "http://www.yahoo.com/");
        AbsPage page = createPage(select + "_Yahoo", "Yahoo!");
        page.addContent(link);

        return page;
    }//createYahooPage()
}//class
