package com.project.restaurantly.Entity.order;

import com.project.restaurantly.Entity.products.Product;
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
public class ShopCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    long user_id;

    @OneToOne
    Product product;

    int quantity;

    LocalDateTime create_at;

    int status;
}
