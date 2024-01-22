package com.egor.jsp.project.controllers;

import java.io.IOException;

import com.egor.jsp.project.models.Pill;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletConfig;

import java.util.UUID;

public class PillsServlet extends HttpServlet {
    private static Pill pill=new Pill();
    
    @Override
    public void init(ServletConfig config) throws ServletException
    {
        super.init();
        pill.setId(UUID.randomUUID());
        pill.setName("Цитрамон");
        pill.setFirm("Ozon");
        pill.setCountry("Россия");
        pill.setDescription("Обезбол");
        pill.setDose("10");
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("pill", pill);
        String test = (String)request.getParameter("edit");
        request.setAttribute("editing", test);
        request.getRequestDispatcher("/pills.jsp")
                .forward(request, response);

    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {

        pill = new Pill(
                UUID.randomUUID(),
                request.getParameter("name"),
                request.getParameter("country"),
                request.getParameter("releaseForm"),
                request.getParameter("firm"),
                request.getParameter("dose"),
                request.getParameter("description")
        );
        
        response.sendRedirect(request.getContextPath() + "/pills");
    }
}
