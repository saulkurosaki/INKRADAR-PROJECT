package com.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "books")
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String title;

    @Column(length = 255)
    private String description;

    @Column(length = 255)
    private String genre;

    @Column
    private Float averageRating;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<Rating> ratings;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<Reading> readings;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<Recommendation> recommendations;

}
