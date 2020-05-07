package kr.hs.dgsw.webclass01.entity;

import lombok.*;

@Getter // getter 생성
@Setter // setter 생성
@NoArgsConstructor // default 생성자 생성
@AllArgsConstructor // 모든 인자를 가지는 생성자 생성
@ToString // ToString 메소드 생성
public class User {
    private String id; // 문자열값 id
    private String name; // 문자열값 name
    private String email; // 문자열값 email
}
