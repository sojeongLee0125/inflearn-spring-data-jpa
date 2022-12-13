package spring.datajpa.repository;

import org.springframework.beans.factory.annotation.Value;

public interface UsernameOnly {

    // @Value 오픈 프로젝션 : 전부 select 해서 username과 age를 조합한 문자만 준다.
    // @Value("#{target.username + ' ' + target.age}")
    // 클로즈 프로젝션 : username만 db에서 조회한다.
    String getUsername();
}
