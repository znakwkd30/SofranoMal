package kr.hs.dgsw.webclass01.Domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class Review {
    private Long id;
    private Long productId;
    private Long userId;
    private String content;
    private LocalDateTime created;
    private LocalDateTime modified;
}