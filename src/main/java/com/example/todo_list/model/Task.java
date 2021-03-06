package com.example.todo_list.model;

import com.example.todo_list.types.ItemType;
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "item_id")
    private Item item;

    @Column(name = "category")
    private ItemType category;

    @Column(name = "item")
    private String name;

    @Column(name = "path")
    private String path;

    @Column(name = "amount")
    private double amount;

    @Column(name = "total_price")
    private BigDecimal totalPrice;
}

