package com.example.todo_list.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "tasks")
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "category")
    private String category;

    @Column(name = "item")
    private String itemName;

    @Column(name = "path")
    private String path;

    @Column(name = "amount")
    private double amount;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "paid")
    private BigDecimal paid;

    @Column(name = "payment_type")
    private String paymentType;

}

