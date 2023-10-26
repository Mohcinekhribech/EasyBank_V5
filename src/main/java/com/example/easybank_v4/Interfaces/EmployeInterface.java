package com.example.easybank_v4.Interfaces;
import com.example.easybank_v4.DTO.Employe;

import java.util.List;
import java.util.Optional;

public interface EmployeInterface extends DataInterface<Employe,String>{
    public List<Employe> searchByAttribute(String attribute);
    public Optional<Employe> findByEmail(String email);
}
