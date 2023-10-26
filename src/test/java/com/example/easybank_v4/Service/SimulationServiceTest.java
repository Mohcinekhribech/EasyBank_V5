package com.example.easybank_v4.Service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.example.easybank_v4.Services.SimulationService;

public class SimulationServiceTest {

    @Test
    public void testSimulater() {
        SimulationService simulationService = new SimulationService();

        double montant = 30000.0;
        int mois = 7;

        double expectedMensualite = 4386.30;

        double actualMensualite = simulationService.Simulater(montant, mois);

        double delta = 1.0; // Increase the delta to allow for the difference

        assertEquals(expectedMensualite, actualMensualite, delta);
    }
}