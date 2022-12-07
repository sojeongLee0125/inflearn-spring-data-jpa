package spring.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.datajpa.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
