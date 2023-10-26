package com.example.easybank_v4.Services;

import com.example.easybank_v4.DTO.Client;
import com.example.easybank_v4.DTO.Employe;
import com.example.easybank_v4.Interfaces.EmployeInterface;

import java.util.List;
import java.util.Optional;

public class EmployeService {
    private EmployeInterface employeDao;
    public EmployeService(EmployeInterface employeDao)
    {
        this.employeDao = employeDao;
    }
    public Optional<Employe> saveEmploye(Employe employe)
    {
        if (employe == null) {
            return Optional.empty();
        }
        return employeDao.save(employe);
    }
    public int deleteEmploye(Employe employe)
    {
        if (employe == null) {
            return 0;
        }
        return employeDao.delete(employe);
    }
    public Optional<Employe> updateEmploye(Employe employe)
    {
        if (employe == null) {
            return Optional.empty();
        }
        return employeDao.update(employe);
    }
    public Optional<Employe> findByIdEmploye(String id)
    {
        if (id == null) {
            return Optional.empty();
        }
        return employeDao.findById(id);
    }
    public List<Employe> showAllEmploye()
    {
        return employeDao.showAll();
    }
    //login
    public Optional<Employe> login(String email,String matricule)
    {
       //Call find by id method
        Optional<Employe> employe  = employeDao.findByEmail(email);

        if(employe.isPresent())
        {
            if(employe.get().getMatricule().equals(matricule))
            {

                return employe;
            }
        }
        return Optional.empty();
    }

    public List<Employe> searchByAttribute(String attribute)
    {
        return employeDao.searchByAttribute(attribute);
    }
}
