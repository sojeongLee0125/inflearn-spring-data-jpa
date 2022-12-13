package spring.datajpa.repository;

public class UsernameOnlyDto {

    private final String username;

    // 생성자 파라미터 이름으로 매칭해서 프로젝션 생성
    public UsernameOnlyDto(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
