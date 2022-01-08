package com.example.todo_list.model;

import com.example.todo_list.types.OrderStatusType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "ORDERS")
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "MANAGER_ID")
    private Customer manager;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "MAKER_ID")
    private Customer maker;

    @Column(name = "CREATED_DATE")
    private LocalDateTime createdDate;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "TASKS")
    private List<Task> tasks;

//    @Column(name = "finished_date")
//    private LocalDateTime finishedDate;
//
//    @Column(name = "status")
//    private OrderStatusType status;
//
//    @Column(name = "paid")
//    private BigDecimal paid;
//
//    @Column(name = "payment_type")
//    private String paymentType;
}
