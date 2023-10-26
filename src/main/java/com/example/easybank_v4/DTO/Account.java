package com.example.easybank_v4.DTO;

import com.example.easybank_v4.DTO.Enum.Status;
import jakarta.persistence.*;
import  lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "account")
public abstract class Account {
    @Id
    private String accountNumber;
    private double balance;
    private LocalDate creationDate;
    private Status status;
    @ManyToOne
    @JoinColumn(name = "code")
    private Client client;
    
}
