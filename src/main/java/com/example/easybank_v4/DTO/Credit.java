package com.example.easybank_v4.DTO;

import com.example.easybank_v4.DTO.Enum.CreditEtat;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "credit")
public class Credit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int numero ;
    LocalDate date;
    double simulation;
    @ManyToOne
    @JoinColumn(name = "code")
    Client client;
    double montant ;
    int mois;
    @Column(name = "credit_etat")
    String creditEtat;

    public Credit()
    {

    }
    public Credit(int numero, LocalDate date, double simulation, Client cl, double montant, String creditEtat ) {
        this.setNumero(numero);
        this.setDate(date);
        this.setSimulation(simulation);
        this.setClient(cl);
        this.setMontant(montant);
        this.setCreditEtat(creditEtat);
    }
}