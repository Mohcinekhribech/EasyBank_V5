package com.example.easybank_v4.Mapping;

import com.example.easybank_v4.DTO.Client;
import com.example.easybank_v4.DTO.Credit;
import com.example.easybank_v4.DTO.Enum.CreditEtat;
import com.example.easybank_v4.Services.SimulationService;
import jakarta.servlet.http.HttpServletRequest;

import java.time.LocalDate;

public class CreditMap {
    private Credit credit;
    SimulationService simulationService = new SimulationService();
    public CreditMap(Credit credit)
    {
        this.credit = credit;
    }
    public Credit mapping(HttpServletRequest request, Client client)
    {
//        this.credit.setCode(request.getParameter("code"));
        this.credit.setClient(client);
        this.credit.setMois(Integer.parseInt(request.getParameter("mois")));
        this.credit.setCreditEtat(String.valueOf(CreditEtat.PENDING));
        this.credit.setMontant(Double.parseDouble(request.getParameter("montant")));
        this.credit.setSimulation(1221211.221);
//        simulationService.Simulater(this.credit.getMontant(),this.credit.getMois())
        this.credit.setDate(LocalDate.now());
        return this.credit;
    }
}
