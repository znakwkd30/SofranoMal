package kr.hs.dgsw.webclass01.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter // getter 생성
@Setter // setter 생성
@NoArgsConstructor // default 생성자 생성
@AllArgsConstructor // 모든 인자를 가지는 생성자 생성
@ToString // ToString 메소드 생성
public class User {
    @Id
    @GeneratedValue
    private Long id; // 문자열값 id
    private String username; // 문자열값 name
    private String email; // 문자열값 email
    private String password;
    @CreationTimestamp
    private LocalDateTime joined;
    @UpdateTimestamp
    private LocalDateTime modified;
    private String storedPath;
    private String originalName;

    public User(String username, String email, String password, String storedPath, String originalName) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.storedPath = storedPath;
        this.originalName = originalName;
    }
}
