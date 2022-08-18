package com.example.springbasic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// getter & setter , Constructor
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Link {

    private String href;
    private String imgSrc;

}
