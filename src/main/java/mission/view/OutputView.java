package mission.view;

import mission.utils.MessageConstants;

public class OutputView {
    public void printCouponCount(int count) {
        System.out.printf(MessageConstants.ACCUMULATED_COUPON_INFO.getMessage() + "%n", count);
    }
}
