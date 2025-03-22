package mission;

import mission.controller.CouponController;
import mission.view.InputView;
import mission.view.OutputView;

public class Application {
    public static void main(String[] args) {
        //Todo: 프로그램 구현
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        CouponController couponController = new CouponController(inputView, outputView);
        couponController.run();
    }
}
