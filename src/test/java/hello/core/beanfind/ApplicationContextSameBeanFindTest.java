package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.discount.DiscountPolicy;
import hello.core.member.MemberReposiotry;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextSameBeanFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig.class);

    @Test
    @DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면, 중복 오류가 발생한다.")
    void findBeanByTypeDuplicate(){
       // MemberReposiotry bean = ac.getBean(MemberReposiotry.class);
        assertThrows(NoUniqueBeanDefinitionException.class,
                () -> ac.getBean(MemberReposiotry.class));
    }

    @Test
    @DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면, 빈 이름을 지정하면 됩니다.")
    void findBeanByName() {
        MemberReposiotry memberReposiotry = ac.getBean("memberRepository1",MemberReposiotry.class);
        assertThat(memberReposiotry).isInstanceOf(MemberReposiotry.class);
    }


    @Test
    @DisplayName("특정 타입을 모두 조회하기")
    void findAllBeanByType() {
        Map<String, MemberReposiotry> beanOfType = ac.getBeansOfType(MemberReposiotry.class);
        for (String key : beanOfType.keySet()) {
            System.out.println("key = " + key + "value = " + beanOfType.get(key) );
        }
        System.out.println("beansOfType = " + beanOfType);
        assertThat(beanOfType.size()).isEqualTo(2);
    }

    // 클래스 안에다 클래스를 썼다는 것은 이 클래스 안에서만 쓰겠다는 의미이다.
    @Configuration
    static class SameBeanConfig {

        @Bean
        public MemberReposiotry memberRepository1() {
            return new MemoryMemberRepository();
        }

        @Bean
        public MemberReposiotry memberReposiotry2() {
            return new MemoryMemberRepository();
        }
    }

}
