package com.springdatajpamappings.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.id.factory.internal.UUIDGenerationTypeStrategy;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "sdj_student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int _id;
    private String name;
    private String about;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private Laptop laptop;
}
