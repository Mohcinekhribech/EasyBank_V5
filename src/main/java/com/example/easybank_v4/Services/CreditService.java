package com.example.easybank_v4.Services;

import com.example.easybank_v4.DTO.Client;
import com.example.easybank_v4.DTO.Credit;
import com.example.easybank_v4.DTO.Enum.CreditEtat;
import com.example.easybank_v4.Interfaces.CreditInterface;

import java.util.List;
import java.util.Optional;

public class CreditService {
    private CreditInterface creditDao;
    public CreditService(CreditInterface creditDao)
    {
        this.creditDao = creditDao ;
    }
    public Optional<Credit> saveCredit(Credit credit)
    {
        if (credit == null) {
            return Optional.empty();
        }
        return creditDao.save(credit);
    }
    public int deleteCredit(Credit credit)
    {
        if (credit == null) {
            return 0;
        }
        return creditDao.delete(credit);
    }

    public Optional<Credit> acceptCredit(Credit credit)
    {
        if (credit == null) {
            return Optional.empty();
        }
        credit.setCreditEtat(String.valueOf(CreditEtat.APPROVED));
        return creditDao.update(credit);
    }
    public Optional<Credit> refuseCredit(Credit credit)
    {
        if (credit == null) {
            return Optional.empty();
        }
        return creditDao.update(credit);
    }
    public Optional<Credit> findByIdCredit(String id)
    {
        if (id == null) {
            return Optional.empty();
        }
        return creditDao.findById(id);
    }
    public List<Credit> showAllCredit()
    {
        return creditDao.showAll();
    }

}
