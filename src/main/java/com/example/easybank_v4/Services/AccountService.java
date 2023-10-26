package com.example.easybank_v4.Services;

import com.example.easybank_v4.DAO.AccountDao;
import com.example.easybank_v4.DTO.Account;
import com.example.easybank_v4.DTO.Client;
import com.example.easybank_v4.DTO.Enum.Status;
import com.example.easybank_v4.Helpers.HibernateUtil;
import com.example.easybank_v4.Interfaces.AccountInterface;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class AccountService {
    private AccountInterface accountDao = new AccountDao(new Client(), new HibernateUtil().getSessionFactory().openSession());
    public List<Account> showByCreationDate(LocalDate creationDate) {
        return null;
    }


    public List<Account> showByStatus(Status status) {
        return null;
    }

    public Optional<Account> searchByOperationNumber(int operationNumber) {
        return Optional.empty();
    }


    public boolean changeState(String accNum, Status status) {
        return false;
    }


    public Optional<Account> save(Account account) {
        if(account == null)
            return accountDao.save(account);
        return Optional.empty();
    }


    public int delete(Account account) {
        if(account == null)
            return accountDao.delete(account);
        return 0;
    }

    public Optional<Account> update(Account account) {
        if(account == null)
            return accountDao.update(account);
        return Optional.empty();
    }
    public Optional<Account> findById(String id) {
        if(id == null)
            return accountDao.findById(id);
        return Optional.empty();
    }

    public List<Account> showAll() {
        return accountDao.showAll();
    }

}
