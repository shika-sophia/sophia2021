package javaGoF.chap07jgBuilder.interfaceBuilder;

public class IBuilderDirector {
    private IGofBuilder builder;

    public IBuilderDirector(IGofBuilder builder) {
        this.builder = builder;
    }

    //文書構築
    public void construct() {
        builder.makeTitle("Greeting");     //タイトル
        builder.makeString("朝から昼にかけて");//文字列
        builder.makeItem(new String[] {     //箇条書き
            "おはようございます",
            "こんにちは"
        });

        builder.makeString("夜に");         //別の文字列
        builder.makeItem(new String[] {     //別の箇条書き
            "こんばんは",
            "おやすみなさい",
            "さようなら"
        });

        builder.close();                     //文書を完成させる
    }//constract()
}//class
