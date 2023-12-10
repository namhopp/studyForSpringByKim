package hello.core.member;

public class MemberServiceImpl implements MemberService {

    private final MemberReposiotry memberReposiotry;

    public MemberServiceImpl(MemberReposiotry memberReposiotry) {
        this.memberReposiotry = memberReposiotry;
    }

    @Override
    public void join(Member member) {
        memberReposiotry.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberReposiotry.findById(memberId);
    }

    //테스트 용도
    public MemberReposiotry getMemberReposiotry() {
        return memberReposiotry;
    }
}
