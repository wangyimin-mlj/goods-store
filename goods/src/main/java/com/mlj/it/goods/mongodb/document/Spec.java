package com.mlj.it.goods.mongodb.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Spec {
    @Id
    private String test;
}
