package mission.utils;

import java.util.regex.Pattern;

public class Validator {
    public static String isPhoneNumberFormPipe(String number) {
        if (!Pattern.compile("^\\d{3}-\\d{4}-\\d{4}$").matcher(number).matches()) {
            throw new IllegalArgumentException("[ERROR] 전화번호 형식이 아닙니다.");
        }
        return number;
    }

    public static String isFourDigitsFormPipe(String number) {
        if (!Pattern.compile("^\\d{4}$").matcher(number).matches()) {
            throw new IllegalArgumentException("[ERROR] 숫자 4자리 형식이 아닙니다.");
        }
        return number;
    }
}
