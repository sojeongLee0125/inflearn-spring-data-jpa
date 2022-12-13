package spring.datajpa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import spring.datajpa.entity.Member;

@Data
@AllArgsConstructor
public class MemberDto {
    private Long id;
    private String username;
    private String teamName;

    public MemberDto(Member member){
        this.id = member.getId();
        this.username = member.getUsername();
    }
}
