package kr.hs.dgsw.webclass01.Domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Product {
    private Long id;
    private String name;
    private int price;
    private Long menuid;
    private Long submenuid;
    private Long details;
    private String factory;
    private Long eventid;
}
