package mission;

import mission.controller.CouponController;
import mission.model.MembershipList;
import mission.view.InputView;
import mission.view.OutputView;

public class AppConfig {
    public InputView inputView() {
        return new InputView();
    }

    public OutputView outputView() {
        return new OutputView();
    }

    public MembershipList membershipList() {
        return new MembershipList();
    }

    public CouponController couponController() {
        return new CouponController(inputView(), outputView(), membershipList());
    }
}
