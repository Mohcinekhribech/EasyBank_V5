package com.example.easybank_v4.Servlets;

import java.io.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.example.easybank_v4.DAO.ClientDao;
import com.example.easybank_v4.DAO.CreditDao;
import com.example.easybank_v4.DAO.HistoricalDao;
import com.example.easybank_v4.DTO.Client;
import com.example.easybank_v4.DTO.Credit;
import com.example.easybank_v4.DTO.Historical;
import com.example.easybank_v4.Helpers.HibernateUtil;
import com.example.easybank_v4.Mapping.CreditMap;
import com.example.easybank_v4.Services.ClientService;
import com.example.easybank_v4.Services.CreditService;
import com.example.easybank_v4.Services.HistoricalService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;

@WebServlet(name = "CreditServlet" , urlPatterns = {"/historical","/listCredit","/deleteCredit","/refuseCredit","/acceptCredit"})
public class CreditServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CreditService creditService;
    public List<Credit> listCredit;
    private CreditMap creditMap;
    private Client client = new Client();
    private Credit credit = new Credit();
    private ClientService clientService;
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private HistoricalService historicalService;
    private Historical historical;
    public List<Historical> listHistorical;
    public void init() {
        historical = new Historical();
        historicalService = new HistoricalService(new HistoricalDao());
        creditMap = new CreditMap(this.credit);
        clientService = new ClientService(new ClientDao(sessionFactory));
        creditService = new CreditService(new CreditDao());
        creditMap = new CreditMap(this.credit);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        switch (action) {
            case "/historical":
                listHistorical(request, response);
                break;
            case "/deleteCredit":
                deleteCredit(request, response);
                break;
            case "/refuseCredit":
                refuseCredit(request, response);
                break;
            case "/acceptCredit":
                acceptCredit(request, response);
                break;
            case "/listCredit":
                listCredit(request, response);
                break;
        }
    }

    private void listHistorical(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listHistorical = this.historicalService.getHistoricalByNumber(Integer.valueOf(request.getParameter("id")));
        request.setAttribute("listHistorical", listHistorical);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Credit/Historical.jsp");
        dispatcher.forward(request, response);
    }
    private void listCredit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listCredit", this.creditService.showAllCredit());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Credit/creditDashboard.jsp");
        dispatcher.forward(request, response);
    }
    private void refuseCredit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.client= clientService.findByIdClient(request.getParameter("code")).get();
        this.credit = creditService.findByIdCredit(request.getParameter("id")).get();
        if (this.creditService.refuseCredit(this.credit).isPresent())
        {
            historical.setDescription("Credit Refused");
            historical.setDate(LocalDate.now());
            historical.setCredit(creditMap.mapping(request,this.client));
            this.historicalService.saveHistorical(historical);
            response.sendRedirect("listCredit");
        }
    }

    private void acceptCredit(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        this.client= clientService.findByIdClient(request.getParameter("code")).get();
        this.credit = creditService.findByIdCredit(request.getParameter("id")).get();
        if (this.creditService.acceptCredit(this.credit).isPresent()){
            historical.setDescription("Credit Accepted");
            historical.setDate(LocalDate.now());
            historical.setCredit(this.credit);
            this.historicalService.saveHistorical(historical);
            response.sendRedirect("listCredit");
        }
    }

    private void deleteCredit(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String code = request.getParameter("id");
        Optional<Credit> credit1 = creditService.findByIdCredit(code);
        this.credit = credit1.isPresent()?credit1.get():null;
        if (this.creditService.deleteCredit(this.credit) > 0)
            response.sendRedirect("listCredit");
    }
    public void destroy() {
    }
}