package com.example.easybank_v4.Mapping;

import com.example.easybank_v4.DTO.Client;
import jakarta.servlet.http.HttpServletRequest;

import java.time.LocalDate;

public class ClientMap {
    private Client client;
    public ClientMap(Client client)
    {
        this.client = client;
    }

    public Client mapping(HttpServletRequest request)
    {
        this.client.setAdresse(request.getParameter("adresse"));
        this.client.setCode(request.getParameter("code"));
        this.client.setPrenom(request.getParameter("prenom"));
        this.client.setNom(request.getParameter("nom"));
        this.client.setTelephone(request.getParameter("telephone"));
        String date = request.getParameter("datenaissance");
        if(date != null)
            this.client.setDatenaissance(LocalDate.parse(date));
        return this.client;
    }
}
