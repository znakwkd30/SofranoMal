package kr.hs.dgsw.webclass01.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity // jpa 엔티티
@Data // getter, setter set
@NoArgsConstructor // 생성자
public class Post {
    @Id // pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ai
    private Long id;
    @Column(nullable = false) // table column null값 불가
    private Long userId;
    @Column(nullable = false) // table column null값 불가
    private String title;
    @Column(nullable = false, columnDefinition = "TEXT") // table column null값 불가
    private String content;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true) //
    private List<Attachment> pictures;
    @CreationTimestamp // 생성과 동시에 시간 저장
    @Column(updatable = false, nullable = false) // table column null값 불가 수정 불가
    @JsonFormat(pattern = "yyyy-mm-dd HH:mm:ss") // 포맷방식
    private LocalDateTime created;
    @UpdateTimestamp // 업데이트시 시간 저장
    @Column(nullable = false) // table column null값 불가
    @JsonFormat(pattern = "yyyy-mm-dd HH:mm:ss") // 포맷방식
    private LocalDateTime modified;

    public Post(Long userId, String title, String content) {
        this.userId = userId;
        this.title = title;
        this.content = content;
    }
}
