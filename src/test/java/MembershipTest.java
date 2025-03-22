import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import mission.model.MembershipList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MembershipTest {
    private MembershipList membershipList;

    @BeforeEach
    void setUp() {
        membershipList = new MembershipList();
    }

    @Test
    void 회원추가_정상작동() {
        membershipList.addMember("박호건", "010-1111-1111");
        List<String> result = membershipList.searchMembers("1111");
        assertEquals(1, result.size());
        assertEquals("박호건", result.getFirst());
    }

    @Test
    void 중복회원_예외발생() {
        membershipList.addMember("박호건", "010-1111-1111");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                membershipList.addMember("박호건", "010-1111-1111")
        );

        assertEquals("[ERROR] 동일한 이름과 유사한 번호를 가진 사용자가 존재합니다.", exception.getMessage());
    }

    @Test
    void 마지막번호로_회원검색() {
        membershipList.addMember("박호건", "010-1111-2222");
        membershipList.addMember("김나연", "010-3333-2222");

        List<String> result = membershipList.searchMembers("2222");
        assertEquals(2, result.size());
        assertTrue(result.contains("박호건"));
        assertTrue(result.contains("김나연"));
    }

    @Test
    void 쿠폰조회_성공() {
        membershipList.addMember("박호건", "010-1111-2222");

        int coupon = membershipList.searchMemberCoupon("박호건", "2222");
        assertEquals(0, coupon); // 초기값은 0
    }

    @Test
    void 쿠폰조회_실패() {
        IllegalStateException exception = assertThrows(IllegalStateException.class, () ->
                membershipList.searchMemberCoupon("서현아", "9999")
        );
        assertEquals("[ERROR] 검색한 고객정보가 없습니다.", exception.getMessage());
    }

    @Test
    void 쿠폰추가() {
        membershipList.addMember("박호건", "010-1234-5678");
        membershipList.addMemberCoupon("박호건", "5678", 3);
        int coupon = membershipList.searchMemberCoupon("박호건", "5678");

        assertEquals(3, coupon);
    }

    @Test
    void 쿠폰차감() {
        membershipList.addMember("박호건", "010-1234-5678");
        membershipList.addMemberCoupon("박호건", "5678", 5);
        membershipList.subMemberCoupon("박호건", "5678", 2);

        int coupon = membershipList.searchMemberCoupon("박호건", "5678");
        assertEquals(3, coupon);
    }

    @Test
    void 쿠폰차감_실패_고객없음() {
        IllegalStateException exception = assertThrows(IllegalStateException.class, () ->
                membershipList.subMemberCoupon("서현아", "9999", 2)
        );
        assertEquals("[ERROR] 검색한 고객정보가 없습니다.", exception.getMessage());
    }
}
