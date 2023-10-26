package com.example.easybank_v4.Servlets;

import java.io.*;
import java.util.List;
import java.util.Optional;

import com.example.easybank_v4.DAO.ClientDao;
import com.example.easybank_v4.DTO.Client;
import com.example.easybank_v4.Helpers.HibernateUtil;
import com.example.easybank_v4.Mapping.ClientMap;
import com.example.easybank_v4.Services.ClientService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.hibernate.SessionFactory;

@WebServlet(name = "ClientServlet" , urlPatterns = {"/list","/insert","/delete","/edit","/update","/"})
public class ClientServlet extends HttpServlet {
    private String message;

    private static final long serialVersionUID = 1L;
    private ClientService clientService;
    public List<Client> listClient;
    private ClientMap clientMap;
    public String att;
    private Client client = new Client();
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public void init() {
        clientService = new ClientService(new ClientDao(sessionFactory));
        clientMap = new ClientMap(this.client);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        switch (action) {
            case "/insert":
                insertClient(request, response);
                break;
            case "/delete":
                deleteClient(request, response);
                break;
            case "/edit":
                showEditForm(request, response);
                break;
            case "/update":
                updateClient(request, response);
                break;
            case "/list":
                if (this.check(request))
                    listClient(request, response);
                else
                    search(request, response);
            break;
        }
    }

    private void listClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.listClient = this.clientService.showAllClient();
        request.setAttribute("listClient", listClient);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Client/clientDashboard.jsp");
        dispatcher.forward(request, response);
    }
    private void search(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String attribute = request.getParameter("attribut");
        this.listClient = this.clientService.searchByAttribute(attribute);
        request.setAttribute("listClient", listClient);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Client/clientDashboard.jsp");
        dispatcher.forward(request, response);
    }

    private boolean check(HttpServletRequest request) {
        return request.getParameter("attribut") == null ;
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String code = request.getParameter("id");
        Optional<Client> existingClient = clientService.findByIdClient(code);
        if (existingClient.isPresent()) {
            this.client = existingClient.get();
            request.setAttribute("client", this.client);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Client/updateClient.jsp");
        dispatcher.forward(request, response);
    }

    private void insertClient(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        if (clientService.saveClient(clientMap.mapping(request)).isPresent())
            response.sendRedirect("list");
    }

    private void updateClient(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        this.client = clientMap.mapping(request);
        if (this.clientService.updateClient(this.client).isPresent())
            response.sendRedirect("list");
    }

    private void deleteClient(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String code = request.getParameter("id");
        Optional<Client> client1 = clientService.findByIdClient(code);
        this.client = client1.isPresent()?client1.get():null;
        if (this.clientService.deleteClient(this.client) > 0)
            response.sendRedirect("list");
    }
    public void destroy() {
    }
}