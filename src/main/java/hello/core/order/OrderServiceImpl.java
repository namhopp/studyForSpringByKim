package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberReposiotry;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberReposiotry memberReposiotry;
   // private  DiscountPolicy discountPolicy;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberReposiotry memberReposiotry, DiscountPolicy discountPolicy) {
        this.memberReposiotry = memberReposiotry;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        Member member = memberReposiotry.findById(memberId); // 회원 정보를 조회

        int discountPrice = discountPolicy.discount(member, itemPrice); // 할인 정책에 넘김 -> 최종 할인 가격

        return new Order(memberId, itemName, itemPrice, discountPrice); //주문을 만들어서 반환
    }
}
