package com.example.easybank_v4.Servlets;

import com.example.easybank_v4.DAO.ClientDao;
import com.example.easybank_v4.DAO.CreditDao;
import com.example.easybank_v4.DAO.HistoricalDao;
import com.example.easybank_v4.DTO.Client;
import com.example.easybank_v4.DTO.Credit;
import com.example.easybank_v4.DTO.Historical;
import com.example.easybank_v4.Helpers.HibernateUtil;
import com.example.easybank_v4.Mapping.ClientMap;
import com.example.easybank_v4.Mapping.CreditMap;
import com.example.easybank_v4.Services.ClientService;
import com.example.easybank_v4.Services.CreditService;
import com.example.easybank_v4.Services.HistoricalService;
import com.example.easybank_v4.Services.SimulationService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;

@WebServlet(name = "SimulationServlet", urlPatterns = {"/simuler","/info","/home","/insertCredit"})
public class SimulationServlet extends HttpServlet {

    private SimulationServlet simulationServlet;
    private ClientService clientService;
    private CreditService creditService;
    private CreditMap creditMap;
    private Optional<Client> client;
    private HistoricalService historicalService;
    private Historical historical;
    private ClientMap clientMap;

    @Override
    public void init() throws ServletException {
        // Initialize the client service (dependency injection or create an instance directly)
        historical = new Historical();
        historicalService = new HistoricalService(new HistoricalDao());
        creditMap = new CreditMap(new Credit());
        clientMap = new ClientMap(new Client());
        creditService = new CreditService(new CreditDao());
        clientService = new ClientService(new ClientDao(HibernateUtil.getSessionFactory()));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getRequestURI();
        switch (path) {
            case "/home":
                req.getRequestDispatcher("/index.jsp").forward(req, resp);
                break;
            case "/simuler":
                req.getRequestDispatcher("/Simulation/simuler.jsp").forward(req, resp);
                break;
            case "/info":
                    client = clientService.findByIdClient(req.getParameter("id"));
                if(client.isPresent()){
                    req.setAttribute("client",client.get());
                    req.getRequestDispatcher("/Simulation/infospersonel.jsp").forward(req, resp);
                } else resp.sendRedirect("simuler");
                break;
            case "/insertCredit" :
                this.creditService.saveCredit(creditMap.mapping(req,client.get()));
                historical.setDescription("Credit Created");
                historical.setDate(LocalDate.now());
                historical.setCredit(creditMap.mapping(req,clientMap.mapping(req)));
                this.historicalService.saveHistorical(historical);
                resp.sendRedirect("/");
                break;
            default:
                req.getRequestDispatcher("/").forward(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getRequestURI();
        switch (path) {
            case "/simuler":
                Float montant = Float.parseFloat(req.getParameter("montant"));
                Integer mois = Integer.parseInt(req.getParameter("mois"));
                SimulationService simulationService = new SimulationService();
                simulationService.Simulater(montant, mois);
                req.getRequestDispatcher("/Simulation/simuler.jsp").forward(req, resp);
                break;
            default:
                req.getRequestDispatcher("/").forward(req, resp);
                break;
        }
    }
}