package component;
import java.util.regex.Pattern;

public class CheckInput {

    /*判断字符串空白或者是否含有空白字符*/
    public static boolean isBlank(String str){
        if (str == null || str.equals("") || !str.equals(Pattern.compile("\\s*|\t|\r|\n|&nbsp;").matcher(str).replaceAll(""))){
            return true;//含有空白字符
        }else {
            return false;//不含有空白字符
        }
    }

    /*去除字符串中的空白字符*/
    public static String clearBlankString(String str) {
        if (str == null) {
            return null;
        }else {
            return Pattern.compile("\\s*|\t|\r|\n|&nbsp;").matcher(str).replaceAll("");
        }
    }

    /*判断字符串是否全部为半角字符*/
    public static boolean isHalfwidth(String str){
        if (str.length() == str.getBytes().length){
            return true;//全部为半角字符
        }else {
            return false;//含有全角字符
        }
    }

    /*判断字符串是否全部为数字*/
    public static boolean isNumber(String str){
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(str).matches();
    }

}
