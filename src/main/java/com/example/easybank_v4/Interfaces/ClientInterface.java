package com.example.easybank_v4.Interfaces;


import com.example.easybank_v4.DTO.Client;

import java.util.List;
import java.util.Optional;

public interface ClientInterface extends DataInterface<Client,String>{
    public List<Client> searchByAttribute(String attribute);
}