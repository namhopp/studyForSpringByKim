package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberReposiotry;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class ConfigurationSingletonTest {

    @Test
    void configurationTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberReposiotry memberReposiotry = ac.getBean("memberRepository", MemberReposiotry.class);

        MemberReposiotry memberReposiotry1 = memberService.getMemberReposiotry();
        MemberReposiotry memberReposiotry2 = orderService.getMemberReposiotry();

        System.out.println("memberService -> memberReposiotry1 = " + memberReposiotry1);
        System.out.println("orderService -> memberRepository2 = " + memberReposiotry2);
        System.out.println("memberReposiotry = " + memberReposiotry);

        assertThat(memberService.getMemberReposiotry()).isSameAs(memberReposiotry);
        assertThat(orderService.getMemberReposiotry()).isSameAs(memberReposiotry);
    }

    @Test
    void configurationDeep() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        AppConfig bean = ac.getBean(AppConfig.class);
        System.out.println("bean = " + bean.getClass());
    }
}
