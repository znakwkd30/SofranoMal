package kr.hs.dgsw.webclass01.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // jpa 엔티티
@Data // getter, setter set
public class Attachment {
    @Id // pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ai
    private Long id;
    private String storedPath;
    private Long postId;
}
