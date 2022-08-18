package com.example.thymeleafview;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // 자동으로 Getter Setter 메소드를 호출 해줌
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    private int id;
    private String title;
    private String author;
    private String category;
    private int price;

    private String image;
    private String url;

}
