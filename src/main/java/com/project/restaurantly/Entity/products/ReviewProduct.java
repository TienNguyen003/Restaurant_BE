package com.project.restaurantly.Entity.products;

import com.project.restaurantly.Entity.user.User;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReviewProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @ManyToOne
    User user;

    @ManyToOne
    Product product;

    Integer parent_review_id;

    int rating;

    String comment;

    LocalDateTime created_at;

    int status;
}
