package com.example.easybank_v4.DTO;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "historical")
public class Historical {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Getter(AccessLevel.NONE)
    @ManyToOne()
    @JoinColumn(name = "numero_credit")
    Credit credit;
    String description;
    LocalDate date;
}