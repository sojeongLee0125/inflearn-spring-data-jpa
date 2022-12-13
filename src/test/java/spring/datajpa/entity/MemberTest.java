package spring.datajpa.entity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import spring.datajpa.repository.MemberRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@SpringBootTest
@Rollback(value = false)
class MemberTest {

    @PersistenceContext
    EntityManager em;

    @Autowired
    MemberRepository memberRepository;

    @Test
    void testEntity() {
        Team teamA = new Team("teamA");
        Team teamB = new Team("teamB");
        em.persist(teamA);
        em.persist(teamB);

        Member member1 = new Member("member1", 10, teamA);
        Member member2 = new Member("member2", 20, teamA);
        Member member3 = new Member("member3", 30, teamB);
        Member member4 = new Member("member4", 40, teamB);

        em.persist(member1);
        em.persist(member2);
        em.persist(member3);
        em.persist(member4);

        //초기화
        em.flush();
        em.clear();
        List<Member> members = em.createQuery("select m from Member m", Member.class).getResultList();
        for (Member member : members) {
            System.out.println("member = " + member);
            System.out.println("memberTeam = " + member.getTeam());
        }

    }

    @Test
    void JpaEventBaseEntity() throws Exception {
        // given
        Member member1 = new Member("member1");
        memberRepository.save(member1); // @PrePersist

        Thread.sleep(100);
        member1.setUsername("member2");

        em.flush(); //@PreUpdate
        em.clear();

        // when
        Member find = memberRepository.findById(member1.getId()).get();

        // then
        System.out.println("find.getCreatedDate() = " + find.getCreatedDate());
//        System.out.println("find.getUpdatedDate() = " + find.getUpdatedDate());
        System.out.println("find.getUpdatedDate() = " + find.getLastModifiedDate());
        System.out.println("find.getCreatedBy() = " + find.getCreatedBy());
        System.out.println("find.getModifiedBy() = " + find.getModifiedBy());
    }

}