package com.example.easybank_v4.DAO;


import com.example.easybank_v4.DTO.Account;
import com.example.easybank_v4.DTO.Client;
import com.example.easybank_v4.DTO.Enum.Status;
import com.example.easybank_v4.Interfaces.AccountInterface;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.*;

public class AccountDao implements AccountInterface {
    private Session session;
    private Client client;
    public AccountDao()
    {
    }
    public AccountDao(Client client ,Session session)
    {
        this.client = client ;
        this.session = session ;
    }

    @Override
    public List<Account> showByCreationDate(LocalDate creationDate) {
        return null;
    }

    @Override
    public List<Account> showByStatus(Status status) {
        return null;
    }
    @Override
    public Optional<Account> searchByOperationNumber(int operationNumber) {
        return Optional.empty();
    }

    @Override
    public boolean changeState(String accNum, Status status) {
        return false;
    }

    @Override
    public Optional<Account> save(Account account) {
        if(session.save(account) != null) {
            return Optional.of(account);
        }
            return Optional.empty();
    }

    @Override
    public int delete(Account account) {
        if(account != null) {
            session.delete(account);
            return 1;
        }
        return 0;
    }
    @Override
    public Optional<Account> update(Account account) {
        session.saveOrUpdate(account);
        return Optional.of(account);
    }

    @Override
    public Optional<Account> findById(String id) {
        return Optional.of(session.get(Account.class, id));
    }
    @Override
    public List<Account> showAll() {
        Query<Account> query = session.createQuery("From Account", Account.class);
        return query.list();
    }

}
