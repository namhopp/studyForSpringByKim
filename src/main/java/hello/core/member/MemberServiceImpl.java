package hello.core.member;

public class MemberServiceImpl implements MemberService {

    private MemberReposiotry memberReposiotry = new MemoryMemberRepository();
    @Override
    public void join(Member member) {
        memberReposiotry.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberReposiotry.findById(memberId);
    }
}
