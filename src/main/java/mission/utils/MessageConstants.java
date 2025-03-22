package mission.utils;

public enum MessageConstants {
    FEATURE_SELECT_GUIDE("쿠폰 적립 시스템입니다. 사용할 기능을 선택해주세요.\n"
            + "1) 회원 등록, 2) 쿠폰 검색, 3) 쿠폰 적립, 4) 쿠폰 사용 5) 프로그램 종료"),
    INPUT_NAME_GUIDE("이름을 입력해주세요."),
    INPUT_FULL_NUMBER_GUIDE("전화번호를 입력해주세요 (ex. 010-1234-1234)"),
    INPUT_LAST_NUMBER_GUIDE("전화번호 뒤 네자리를 입력해주세요"),
    CHECK_SINGLE_MEMBER_GUIDE("%s 회원님 맞으신가요? (Y/N)"),
    CHECK_SEVERAL_MEMBER_GUIDE("이름을 입력해주세요. (%s)"),
    INPUT_ADD_COUPON_GUIDE("적립할 쿠폰 갯수를 입력해주세요."),
    INPUT_SUB_COUPON_GUIDE("사용할 쿠폰 갯수를 입력해주세요. "),

    REGISTER_MEMBER_INFO("회원정보가 등록되었습니다."),
    ADD_COUPON_INFO("쿠폰이 적립되었습니다."),
    SUB_COUPON_INFO("쿠폰이 사용되었습니다."),
    ACCUMULATED_COUPON_INFO("현재 적립된 쿠폰은 %d개 입니다.");

    String message;

    MessageConstants(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
