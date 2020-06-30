package kr.hs.dgsw.webclass01.Domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class Cart {
    private Long id;
    private Long userId;
    private Long productId;
    private int price;
    private int amount;
    private int total;
    private LocalDateTime created;
}
