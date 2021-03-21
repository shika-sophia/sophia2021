package javaGold.se11Violet.sampleCode.chap01VT.enumSeason;

public enum SeasonConstructor {
    SPRING(0, "春"),
    SUMMER(1, "夏"),
    AUTUMN(2, "秋"),
    WINTER(3, "冬");

    private int code;
    private String jpName;

    private SeasonConstructor(int code, String jpName) {
        this.code = code;
        this.jpName = jpName;
    }

    public int toSeasonCode() {
        return code;
    }

    public String toJpName() {
        return jpName;
    }
}//enum

