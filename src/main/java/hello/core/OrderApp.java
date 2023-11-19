package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member); // 맴버를 메모리 객체에 넣어놓은다.

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        System.out.println("order = " + order); // 이걸 출력하면 toString으로 출력됨
        System.out.println("order.calculatePrice = " + order.calculatePrice());
    }
}
