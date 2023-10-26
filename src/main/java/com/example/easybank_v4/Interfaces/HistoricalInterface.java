package com.example.easybank_v4.Interfaces;

import com.example.easybank_v4.DTO.Historical;

import java.util.List;

public interface HistoricalInterface extends DataInterface<Historical,Integer>{
    public List<Historical> getHistoricalByNumber(int numero);
}
