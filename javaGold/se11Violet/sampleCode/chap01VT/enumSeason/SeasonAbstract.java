package javaGold.se11Violet.sampleCode.chap01VT.enumSeason;

public enum SeasonAbstract {
    SPRING(0, "春"){
        @Override
        public void show() {
            System.out.println("春は あけぼの");
        }
    },
    SUMMER(1, "夏"){
        @Override
        public void show() {
            System.out.println("夏は夜");
        }
    },
    AUTUMN(2, "秋"){
        @Override
        public void show() {
            System.out.println("秋は夕暮れ");
        }
    },
    WINTER(3, "冬"){
        @Override
        public void show() {
            System.out.println("冬は つとめて");
        }
    };

    private int code;
    private String jpName;

    private SeasonAbstract(int code, String jpName) {
        this.code = code;
        this.jpName = jpName;
    }
    public abstract void show();

    public int getCode() {
        return code;
    }
    public String getJpName() {
        return jpName;
    }
}//enum
