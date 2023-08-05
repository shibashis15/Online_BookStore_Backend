package com.Book_Service.com.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "book_table")
public class Book {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String bookName;

    private String bookAuthor;

    private Long bookPrice;

    private Long discount;

    private String description;

    private

}
