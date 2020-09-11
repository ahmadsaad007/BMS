package com.example.demo.domain;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "bookcatalog")
public class Book {
    @Column(name = "book_name")
    private String name;
    @Column(name = "author")
    private String author;
    @Id
    @Column(name = "isbn")
    private int isbn;
    @Column(name = "date_published")
    private String date;

}
