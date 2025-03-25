package mission;

import mission.controller.CouponController;

public class Application {
    public static void main(String[] args) {
        //Todo: 프로그램 구현
        AppConfig config = new AppConfig();
        CouponController couponController = config.couponController();

        couponController.run();
    }
}
