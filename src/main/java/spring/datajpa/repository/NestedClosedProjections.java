package spring.datajpa.repository;

public interface NestedClosedProjections {
    String getUsername();
    TeamInfo getTeam();

    // 중첩 구조일 경우 select 최적화 되지 않는다. 전체 조회한다.
    interface TeamInfo {
        String getName();
    }
}
