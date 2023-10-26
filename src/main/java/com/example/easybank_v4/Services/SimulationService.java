package com.example.easybank_v4.Services;

import java.util.Scanner;
import java.lang.Math;
public class SimulationService {

    public double Simulater(double montant, int mois) {
        double taux = 7.0 / 100.0; // Divide with floating-point numbers

        double tauxFloat = taux / 12.0; // Divide with floating-point numbers
        double moisFloat = mois;

        double mensualite = (montant * tauxFloat / (1 - Math.pow(1 + tauxFloat, -moisFloat)));
        return mensualite;
    }
}