package mission.controller;

import java.util.List;
import mission.model.MembershipList;
import mission.model.dto.MemberBasicInfoDto;
import mission.view.InputView;
import mission.view.OutputView;

public class CouponController {
    InputView inputView;
    OutputView outputView;
    MembershipList membershipList;

    public CouponController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.membershipList = new MembershipList();
    }

    public void run() {
        boolean willStop = false;

        while (!willStop) {
            willStop = execute();
        }
    }

    private boolean execute() {
        try {
            switch (inputView.inputFeature()) {
                case 1 -> registerMember();
                case 2 -> searchCoupon();
                case 3 -> accumulateCoupon();
                case 4 -> useCoupon();
                case 5 -> {
                    return true;
                }
                default -> throw new IllegalArgumentException("[ERROR] 1~5 사이의 숫자를 입력해주세요. ");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    private void registerMember() {
        membershipList.addMember(inputView.inputName(), inputView.inputFullNumber());
    }

    private MemberBasicInfoDto searchCoupon() {
        String lastNumber = getLastNumber();
        String name = getName(lastNumber);

        int couponCount = membershipList.searchMemberCoupon(name, lastNumber);
        outputView.printCouponCount(couponCount);

        return new MemberBasicInfoDto(name, lastNumber, couponCount);
    }

    private String getLastNumber() {
        return inputView.inputLastNumber();
    }

    private String getName(String lastNumber) {
        List<String> names = membershipList.searchMembers(lastNumber);
        if (!names.isEmpty()) {
            if (names.size() == 1 && inputView.checkName(names.getFirst())) {
                return names.getFirst();
            }
            String name = inputView.checkName(names);
            if (names.contains(name)) {
                return name;
            }
        }
        throw new IllegalStateException("[ERROR] 회원을 찾을 수 없습니다.");
    }

    private void accumulateCoupon() {
        MemberBasicInfoDto info = searchCoupon();
        int amount = inputView.getAddNumber();
        membershipList.addMemberCoupon(info.name(), info.lastNumber(), amount);
    }

    private void useCoupon() {
        MemberBasicInfoDto info = searchCoupon();
        int amount = inputView.getSubNumber();
        if (info.couponCount() < amount) {
            throw new IllegalStateException("[ERROR] 보유량이 부족합니다.");
        }
        membershipList.subMemberCoupon(info.name(), info.lastNumber(), amount);
    }
}
