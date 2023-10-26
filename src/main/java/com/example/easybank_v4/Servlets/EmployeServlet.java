package com.example.easybank_v4.Servlets;

import java.io.*;
import java.util.List;
import java.util.Optional;

import com.example.easybank_v4.DAO.EmployeDao;
import com.example.easybank_v4.DTO.Employe;
import com.example.easybank_v4.Helpers.HibernateUtil;
import com.example.easybank_v4.Mapping.EmployeMap;
import com.example.easybank_v4.Services.EmployeService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.hibernate.SessionFactory;

@WebServlet(name = "EmployeServlet" , urlPatterns = {"/listEmploye","/insertEmploye","/deleteEmploye","/editEmploye","/updateEmploye", "/login","/signin"})
public class EmployeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private EmployeService employeService;
    public List<Employe> listEmploye;
    private EmployeMap employeMap;
    public String att;
    private Employe employe = new Employe();
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public void init() {
        employeService = new EmployeService(new EmployeDao(sessionFactory));
        employeMap = new EmployeMap(this.employe);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        switch (action) {
            case "/insertEmploye":
                insertEmploye(request, response);
                break;
            case "/deleteEmploye":
                deleteEmploye(request, response);
                break;
            case "/editEmploye":
                showEditForm(request, response);
                break;
            case "/updateEmploye":
                updateEmploye(request, response);
                break;
            case "/listEmploye":
                if (this.check(request))
                    listEmploye(request, response);
                else
                    search(request, response);
                break;
            case "/login" :
               request.getRequestDispatcher("Employe/login.jsp").forward(request , response);
                break;
            case "/signin" :
                login(request , response);
                break;

        }
    }

    private void listEmploye(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.listEmploye = this.employeService.showAllEmploye();
        request.setAttribute("listEmploye", listEmploye);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Employe/employeDashboard.jsp");
        dispatcher.forward(request, response);
    }
    private void search(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String attribute = request.getParameter("attribut");
        this.listEmploye = this.employeService.searchByAttribute(attribute);
        request.setAttribute("listEmploye", listEmploye);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Employe/employeDashboard.jsp");
        dispatcher.forward(request, response);
    }

    private boolean check(HttpServletRequest request) {
        return request.getParameter("attribut") == null ;
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String code = request.getParameter("id");
        Optional<Employe> existingEmploye = employeService.findByIdEmploye(code);
        if (existingEmploye.isPresent()) {
            this.employe = existingEmploye.get();
            request.setAttribute("employe", this.employe);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Employe/updateEmploye.jsp");
        dispatcher.forward(request, response);
    }

    private void insertEmploye(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        if (employeService.saveEmploye(employeMap.mapping(request)).isPresent())
            response.sendRedirect("listEmploye");
    }

    private void updateEmploye(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        this.employe = employeMap.mapping(request);
        if (this.employeService.updateEmploye(this.employe).isPresent())
            response.sendRedirect("listEmploye");
    }

    private void deleteEmploye(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String code = request.getParameter("id");
        Optional<Employe> employe1 = employeService.findByIdEmploye(code);
        this.employe = employe1.isPresent()?employe1.get():null;
        if (this.employeService.deleteEmploye(this.employe) > 0)
            response.sendRedirect("listEmploye");
    }
    private void login(HttpServletRequest request , HttpServletResponse response )throws  ServletException , IOException{
        String email = request.getParameter("email");
        String matricule = request.getParameter("matricule");
        Optional<Employe> employe = employeService.login(email,matricule);
        if(employe.isPresent()){
            request.setAttribute("employe",employe.get());

            response.sendRedirect("listEmploye");
        }else {
            request.getRequestDispatcher("/Employe/login.jsp").forward(request,response);
        }
    }
    public void destroy() {
    }
}