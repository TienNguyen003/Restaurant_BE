package com.project.restaurantly.Entity.order;

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
public class Payments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @ManyToOne
    @JoinColumn(nullable = true)
    Orders orders;

    @ManyToOne
    @JoinColumn(nullable = true)
    OrderTables ordersTables;

    String payment_method;

    String payment_status;

    LocalDateTime create_at;

    int status;
}
