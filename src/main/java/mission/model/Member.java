package mission.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Member {
    private final String name;
    private final String phoneNumber;
    private int coupon;

    Member(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        coupon = 0;
    }

    String getName() {
        return name;
    }

    String getLastNumber() {
        Matcher matcher = Pattern.compile("(?<=-)[0-9]+$").matcher(phoneNumber);
        if (matcher.find()) {
            return matcher.group();
        }
        throw new IllegalStateException("[ERROR] 뒷번호를 추출할 수 없습니다 : " + phoneNumber);
    }

    public int getCoupon() {
        return coupon;
    }

    public void addCoupon(int amount) {
        coupon += amount;
    }

    public void subCoupon(int amount) {
        coupon -= amount;
    }
}
