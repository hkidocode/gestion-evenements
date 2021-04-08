package com.example.controllers;

import com.example.entity.*;
import com.example.repository.LoginRepository;
import com.example.repository.LoginRepositoryImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    LoginRepository loginRepository = new LoginRepositoryImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Get all value in inputs form
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Person person = loginRepository.isMember(email, Arrays.toString(hashedPassword(password)));
        System.out.println(person);
        if (person != null) {
            HttpSession session = request.getSession();
            session.setAttribute("email", email);
            response.sendRedirect(request.getContextPath() + "/dashboard");
        } else {
            response.sendRedirect(request.getContextPath() + "/login");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/login.jsp").forward(request, response);
//            // Get all value in inputs form
//            String email = request.getParameter("email");
//            String password = request.getParameter("password");
//            Person person = loginRepository.isMember(email, hashedPassword(password));
//        System.out.println("dsdsdsd " + person.getEmail());
//            if (person != null) {
//                HttpSession session = request.getSession();
//                session.setAttribute("email", email);
//                session.setAttribute("password", hashedPassword(password));
//                request.getRequestDispatcher("/dashboard").forward(request, response);
//            } else {
//                request.getRequestDispatcher("/login").forward(request, response);
//            }

    }

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
