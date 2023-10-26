package com.example.easybank_v4.Mapping;

import com.example.easybank_v4.DTO.Employe;
import jakarta.servlet.http.HttpServletRequest;

import java.time.LocalDate;

public class EmployeMap {
    private Employe employe;
    public EmployeMap(Employe employe)
    {
        this.employe = employe;
    }

    public Employe mapping(HttpServletRequest request)
    {
        this.employe.setAdresseemail(request.getParameter("adresseemail"));
        this.employe.setMatricule(request.getParameter("matricule"));
        this.employe.setPrenom(request.getParameter("prenom"));
        this.employe.setNom(request.getParameter("nom"));
        this.employe.setTelephone(request.getParameter("telephone"));
        String dateNaissance = request.getParameter("datenaissance");
        String datederecrutement = request.getParameter("datederecrutement");

        if(datederecrutement != null)
            this.employe.setDatederecrutement(LocalDate.parse(datederecrutement));

        if(dateNaissance != null)
            this.employe.setDatenaissance(LocalDate.parse(dateNaissance));

        return this.employe;
    }
}
