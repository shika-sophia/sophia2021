/**
 * @title WebContent / secureCode / InputChecker.java
 * @reference 山田祥寛 『独習 Java サーバーサイド編 第２版』 翔泳社, 2013
 * @content 第10章 Security / p512 / List 10-8
 * @content 入力値の検証、定型的な処理
 * @author shika
 * @date 2021-05-06
 */
package webPractice.secureCode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.StringTokenizer;

public class InputChecker {
    private final List<String> errList;

    public InputChecker() {
        this.errList = new ArrayList<String>();
    }

    //---- 必須検証 ----
    public void requiredCheck(String name, String value) {
        if(value == null || value.trim().isEmpty()){
            errList.add(name + "は必須入力です。");
        }
    }//requiredCheck()

    //---- 文字列長検証 max以内かどうか ----
    public void lengthCkeck(
            String name, String value, int max) {
        if(value.length() > max) {
            errList.add(String.format(
                "%sは %d文字以内で入力してください。", name, max));
        }
    }//lengthCheck()

    //---- 数値型検証 ----
    public void numberTypeCheck(String name, String value) {
        if(value != null && !value.trim().isEmpty()) {
            try {
                Integer.parseInt(value);
            } catch(NumberFormatException e) {
                errList.add(name + "は整数で入力してください。");
            }
        }//if
    }//numberTypeCheck()

    //---- 数値範囲検証 min～max
    public void numberRangeCheck(
            String name, String value, int max, int min) {
        int valueInt = 0;
        try {
            valueInt = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            errList.add(name + "は整数で入力してください。");
        }

        if(min <= valueInt && valueInt <= max) {
            ;
        } else {
            errList.add(String.format(
                "%sは %d～%dの範囲で入力して下さい。", name, min, max));
        }
    }//numberRangeCheck()

    //日付型チェック
    public void dateTypeCheck(String name, String value) {
        if(value != null && !value.trim().isEmpty()) {
            //「YYYY-MM-DD」の形式であるか
            if(value.matches("^[0-9]{4}-[0-9]{2}-[0-9]{2}$")) {
                StringTokenizer token = new StringTokenizer(value, "-");
                int year = Integer.parseInt((String) token.nextToken());
                int month = Integer.parseInt((String) token.nextToken());
                int day = Integer.parseInt((String) token.nextToken());

                Calendar cal = Calendar.getInstance();
                cal.set(year, (month - 1), day);
                if(cal.get(Calendar.YEAR) != year
                        || cal.get(Calendar.MONTH) != (month - 1)
                        || cal.get(Calendar.DATE) != day) {
                    errList.add(name + "は正しい日付で入力してください。");
                }
            } else {
                errList.add(name + "は「YYYY-MM-DD」の形式で入力して下さい。");
            }
        }//if null or empty
    }//dateTypeCheck()

    //---- 正規表現チェック ----
    public void regexCheck(
            String name, String value, String pattern) {
        if(value != null && !value.isBlank()) {
            if(value.matches(pattern)) {
                errList.add(name + "は正しい形式で入力してください。");
            }
        }
    }//regexCheck()

    //---- DBとの重複検証 ----
    public void duplicateCheck(String name, String value) {
        String sql = "SELECT * FROM USER_TB WHERE NAME = ?";

        try(Connection conn = DriverManager.getConnection("path", "root", "root");
            PreparedStatement ps = conn.prepareStatement(sql); ){

            ps.setString(1, value);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                errList.add(name + "は重複しています。");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//duplicateCheck()

    //====== getter ======
    public List<String> getErrList() {
        return errList;
    }

    public boolean hasErrList() {
        return !errList.isEmpty();
    }

    //====== Test main() ======
    public static void main(String[] args) {
        var here = new InputChecker();
        String name = "date";
        String value = "2021-05-06";

        here.dateTypeCheck(name, value);

        List<String> errList = here.getErrList();
        errList.forEach(System.out::println);
    }//main()
}//class

/*
//結果
＊(month - 1)を忘れていた。修正後、解決
dateは正しい日付で入力してください。

＊「2021-05-062」
dateは「YYYY-MM-DD」の形式で入力して下さい。

【考察】
◆java.util.StringTokenizerクラス
    StringTokenizer implements Enumeration<Object>
StringTokenizer(String str, String separator)
コンストラクタの引数で、文字列と区切り文字を代入。

StringTokenizer token.nextToken()で、区切り文字ごとの文字列を取得。

*/