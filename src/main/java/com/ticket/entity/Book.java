package com.ticket.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ticket-booking")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    @Column(name = "firstName", length = 25)
    private String firstName;
    @Column(name = "lastName", length = 25)
    private String lastName;
    @Column(name = "email", length = 25)
    private String email;
    @Column(name = "phone", length = 25)
    private String phone;
    @Column(name = "address", length = 25)
    private String address;
    @Column(name = "city", length = 25)
    private String city;
}
