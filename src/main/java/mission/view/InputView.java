package mission.view;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import mission.utils.MessageConstants;
import mission.utils.Validator;

public class InputView {
    Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public int inputFeature() {
        System.out.println(MessageConstants.FEATURE_SELECT_GUIDE.getMessage());
        return Integer.parseInt(scanner.nextLine());
    }

    public String inputName() {
        System.out.println(MessageConstants.INPUT_NAME_GUIDE.getMessage());
        return scanner.nextLine();
    }

    public String inputFullNumber() {
        System.out.println(MessageConstants.INPUT_FULL_NUMBER_GUIDE.getMessage());
        return Validator.isPhoneNumberFormPipe(scanner.nextLine());
    }

    public String inputLastNumber() {
        System.out.println(MessageConstants.INPUT_LAST_NUMBER_GUIDE.getMessage());
        return Validator.isFourDigitsFormPipe(scanner.nextLine());
    }

    public String checkName(List<String> names) {
        System.out.printf(MessageConstants.CHECK_SEVERAL_MEMBER_GUIDE.getMessage() + "%n", String.join(", ", names));
        return scanner.nextLine();
    }

    public boolean checkName(String name) {
        System.out.printf(MessageConstants.CHECK_SINGLE_MEMBER_GUIDE.getMessage() + "%n", name);
        String line = scanner.nextLine();
        if (Objects.equals(line, "Y")) {
            return true;
        }
        if (Objects.equals(line, "N")) {
            return false;
        }
        throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다.");
    }

    public int getAddNumber() {
        System.out.println(MessageConstants.INPUT_ADD_COUPON_GUIDE.getMessage());
        return Integer.parseInt(scanner.nextLine());
    }

    public int getSubNumber() {
        System.out.println(MessageConstants.INPUT_SUB_COUPON_GUIDE.getMessage());
        return Integer.parseInt(scanner.nextLine());
    }
}
