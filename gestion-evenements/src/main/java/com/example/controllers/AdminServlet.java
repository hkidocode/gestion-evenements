package com.example.controllers;

import com.example.entity.*;
import com.example.repository.AdminRepository;
import com.example.repository.AdminRepositoryImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

@WebServlet(name = "AdminServlet", urlPatterns = "/")
public class AdminServlet extends HttpServlet {

    AdminRepository adminRepository = new AdminRepositoryImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action  = request.getServletPath();
        System.out.println(action);
        switch (action) {
            case "/insert" :
                insertPerson(request, response);
                break;
            case "/update" :
//                updateClient(request, response);
                break;
            case "/delete" :
//                deleteClient(request, response);
                break;
            case "/dashboard" :
                getAllPersons(request, response);
                break;
        }
    }

    private void insertPerson(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get all value in inputs form
        String firstName = request.getParameter("first-name");
        String lastName = request.getParameter("last-name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String promo = request.getParameter("promo");
        String role = request.getParameter("role");
        String speciality = request.getParameter("speciality");
        String classe = request.getParameter("class");

        // Parse all ids to short type
        short roleId = Short.parseShort(role);
        short promoId = Short.parseShort(promo);
        short classeId = Short.parseShort(classe);
        short specialiteId = Short.parseShort(speciality);
        // Get all existing objects based on its id
        Role existentRole = adminRepository.getRole(roleId);
        Promo existentPromo = adminRepository.getPromo(promoId);
        Classe existentClasse = adminRepository.getClasse(classeId);
        Specialite existentSpecialite = adminRepository.getSpecialite(specialiteId);
        // Reference Person Object
        Person person = new Person(firstName, lastName, phone, existentRole, email, Arrays.toString(hashedPassword(password)));
        // Check if it's select Admin option
        if (role.equals("1")) {
            adminRepository.addPerson(person);
            response.sendRedirect(request.getContextPath() + "/dashboard");
        }
        // Check if it's select Teacher option
        else if (role.equals("2")) {
            Formateur formateur = new Formateur(person.getFirstName(), person.getLastName(), person.getPhoneNumber(), person.getRole(), person.getEmail(), person.getPassword(), existentClasse, existentSpecialite);
            adminRepository.addPerson(formateur);
            response.sendRedirect(request.getContextPath() + "/dashboard");
        }
        // Check if it's select Student option
        else {
            Apprenant apprenant = new Apprenant(person.getFirstName(), person.getLastName(), person.getPhoneNumber(), person.getRole(), person.getEmail(), person.getPassword(), existentClasse, existentSpecialite, existentPromo);
            adminRepository.addPerson(apprenant);
            response.sendRedirect(request.getContextPath() + "/dashboard");
        }

    }

    private void getAllPersons(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            List<Person> personList = adminRepository.getAllPersons();
            request.setAttribute("persons", personList);
            request.getRequestDispatcher("/dashboard.jsp").forward(request, response);
//        } else {
            response.sendRedirect(request.getContextPath() + "/login");
        }
//    }


    private byte[] hashedPassword(String password) {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        // configure the SHA-512 hash function with our salt
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-512");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        md.update(salt);
        // generate our hashed password
        return md.digest(password.getBytes(StandardCharsets.UTF_8));
    }

}
