package com.example.easybank_v4.Interfaces;

import com.example.easybank_v4.DTO.Account;
import com.example.easybank_v4.DTO.Enum.Status;
import com.example.easybank_v4.Interfaces.DataInterface;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface AccountInterface extends DataInterface<Account,String> {
    abstract List<Account> showByCreationDate(LocalDate creationDate);
    abstract List<Account> showByStatus(Status status);
    abstract Optional<Account> searchByOperationNumber(int operationNumber);
    boolean changeState(String accNum, Status status);
}