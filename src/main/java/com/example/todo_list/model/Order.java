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
@Table(name = "orders")
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "customer")
    private Customer customer;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "manager")
    private Customer manager;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "maker")
    private Customer maker;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "tasks")
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
