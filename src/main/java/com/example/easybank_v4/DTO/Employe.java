package com.example.easybank_v4.DTO;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "employe")
public class Employe  extends Personne{
@Id

    String matricule;
    LocalDate datederecrutement;
    String adresseemail;
}
