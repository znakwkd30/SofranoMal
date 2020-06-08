package kr.hs.dgsw.webclass01.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.logging.Logger;

@Entity // jpa 엔티티
@Data // getter, setter set
@NoArgsConstructor // 생성자
public class User {
    @Id // pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ai
    private long id;
    @Column(nullable = false, unique = true, length = 20) // table column null값 불가, 유니크값, 길이 20
    private String account;
    @Column(nullable = false) // table column null값 불가
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // 쓰려는 경우에만 접근 허용
    private String password;

    // 비밀번호 암호화
    public void setPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(password.getBytes(), 0, password.getBytes().length);
            this.password = new BigInteger(1, md.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            Logger logger = (Logger) LoggerFactory.getLogger(User.class);
            logger.warning(e.getMessage());
        }
    }

    @Column(nullable = false) // table column null값 불가
    private String name;
    @Column(unique = true) // table column 유니크값
    private String email;
    @Column(unique = true) // table column 유니크값
    private String phone;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // 쓰려는 경우에만 접근 허용
    private String profilePath;
    @CreationTimestamp // 생성과 동시에 시간 저장
    @Column(updatable = false, nullable = false) // table column null값 불가 수정 불가
    private LocalDateTime created;
    @UpdateTimestamp // 업데이트시 시간 저장
    @Column(nullable = false) // table column null값 불가
    @JsonFormat(pattern = "yyyy-mm-dd HH:mm:ss") // 포맷방식
    private LocalDateTime modified;

    public User(String account, String password, String name, String email, String phone, String profilePath) {
        this.account = account;
        setPassword(password);
        this.name = name;
        this.email = email;
        this.profilePath = profilePath;
    }
}
