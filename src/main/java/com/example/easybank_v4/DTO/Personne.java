package com.example.easybank_v4.DTO;

import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@MappedSuperclass
public class Personne {
    String nom;
    String prenom;
    LocalDate datenaissance;
    String telephone;
}
