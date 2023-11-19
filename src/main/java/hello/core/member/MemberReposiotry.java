package hello.core.member;

public interface MemberReposiotry {

    void save(Member member);

    Member findById(Long memberId);
}
