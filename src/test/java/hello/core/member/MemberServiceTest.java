package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberSerive;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberSerive = appConfig.memberService();
    }

    @Test
    void join() {
        // given
        Member member = new Member(1L, "memberA", Grade.VIP);

        // when
        memberSerive.join(member);
        Member findMember = memberSerive.findMember(1L);

        // then
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
