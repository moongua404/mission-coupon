package mission.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 회원 명부 클래스
 */
public class MembershipList {
    private List<Member> membershipList;

    public MembershipList() {
        membershipList = new ArrayList<Member>();
    }

    public void addMember(String name, String fullNumber) {
        duplicationCheck(name, fullNumber);
        membershipList.add(new Member(name, fullNumber));
    }

    public List<String> searchMembers(String lastNumber) {
        return membershipList.stream()
                .filter(member -> member.getLastNumber().equals(lastNumber))
                .map(Member::getName)
                .toList();
    }

    public int searchMemberCoupon(String name, String lastNumber) {
        return membershipList.stream()
                .filter(member -> Objects.equals(member.getLastNumber(), lastNumber)
                        && member.getName().equals(name))
                .map(Member::getCoupon)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("[ERROR] 검색한 고객정보가 없습니다."));
    }

    public void addMemberCoupon(String name, String lastNumber, int amount) {
        Member found = membershipList.stream()
                .filter(member -> Objects.equals(member.getLastNumber(), lastNumber)
                        && member.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("[ERROR] 검색한 고객정보가 없습니다."));
        found.addCoupon(amount);
    }

    public void subMemberCoupon(String name, String lastNumber, int amount) {
        Member found = membershipList.stream()
                .filter(member -> Objects.equals(member.getLastNumber(), lastNumber)
                        && member.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("[ERROR] 검색한 고객정보가 없습니다."));
        found.subCoupon(amount);
    }

    private void duplicationCheck(String name, String fullNumber) {
        Member newMember = new Member(name, fullNumber);
        membershipList.forEach(member -> {
            if (Objects.equals(member.getName(), newMember.getName())
                    && Objects.equals(member.getLastNumber(), newMember.getLastNumber())) {
                throw new IllegalArgumentException("[ERROR] 동일한 이름과 유사한 번호를 가진 사용자가 존재합니다.");
            }
        });
    }
}
