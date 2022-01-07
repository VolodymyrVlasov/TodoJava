package com.example.todo_list.model;

import com.example.todo_list.types.ItemType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

//@Data
@Entity
//@Table(name = "items")
@NoArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(mappedBy = "item", cascade = CascadeType.ALL)
    private Task task;

    @Column(name = "category")
    private ItemType category;

    @Column(name = "name")
    private String name;

//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name = "price")
//    private List<BigDecimal> price;

    @Column(name = "total_price")
    private BigDecimal totalPrice;
}
