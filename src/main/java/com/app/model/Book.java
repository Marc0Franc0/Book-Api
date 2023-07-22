package com.app.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "books")
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Book {
    @Id
    private String id;
    private String name;
    private String author;
}
