package com.example.todo_list.model;

import com.example.todo_list.types.RoleType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "CUSTOMERS")
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    @Column(name = "CUSTOMERS")
    private Set<Order> customers;

    @OneToMany(mappedBy = "manager", fetch = FetchType.LAZY)
    @Column(name = "MANAGERS")
    private Set<Order> managers;

    @OneToMany(mappedBy = "maker", fetch = FetchType.LAZY)
    @Column(name = "MAKERS")
    private Set<Order> makers;

    @Column(name = "NAME")
    private String name;

    @Column(name = "LASTNAME")
    private String lastName;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "TELEGRAM_ID")
    private String telegramId;

    @ElementCollection
    @Column(name = "ROLE")
    private List<RoleType> role;

    @Column(name = "AUTH_KEY")
    private String key;

}
