package com.example.easybank_v4.Services;

import com.example.easybank_v4.DTO.Historical;
import com.example.easybank_v4.Interfaces.HistoricalInterface;

import java.util.List;
import java.util.Optional;

public class HistoricalService {
    private HistoricalInterface historicalDao;
    public HistoricalService(HistoricalInterface historicalDao)
    {
        this.historicalDao = historicalDao ;
    }
    public Optional<Historical> saveHistorical(Historical historical)
    {
        if (historical == null) {
            return Optional.empty();
        }
        return historicalDao.save(historical);
    }
    public int deleteHistorical(Historical historical)
    {
        if (historical == null) {
            return 0;
        }
        return historicalDao.delete(historical);
    }
    public Optional<Historical> updateHistorical(Historical historical)
    {
        if (historical == null) {
            return Optional.empty();
        }
        return historicalDao.update(historical);
    }
    public Optional<Historical> findByIdHistorical(Integer id)
    {
        if (id == null) {
            return Optional.empty();
        }
        return historicalDao.findById(id);
    }
    public List<Historical> getHistoricalByNumber(int numero){
        return historicalDao.getHistoricalByNumber(numero);
    };
    public List<Historical> showAllHistorical()
    {
        return historicalDao.showAll();
    }
}