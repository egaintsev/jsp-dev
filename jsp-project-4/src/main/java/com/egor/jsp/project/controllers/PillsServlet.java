package com.egor.jsp.project.controllers;

import java.io.IOException;

import com.egor.jsp.project.models.Pills;
import com.egor.jsp.project.facades.PillsFacade;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ejb.EJB;

public class PillsServlet extends HttpServlet {
    
    @EJB
    private PillsFacade pillsFacade;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String editing = (String)request.getParameter("edit");
        String pillId = (String)request.getParameter("id");
        
        if (editing != null && editing.equals("true") && pillId != null)
        {
            request.setAttribute("editing", editing);
            request.setAttribute("pill", pillsFacade.findById(pillId));
        }
        else
        {
            request.setAttribute("pills", pillsFacade.findAllRecords());
        }
        
        request.getRequestDispatcher("/pills.jsp")
                .forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        request.setCharacterEncoding("UTF-8");
        Pills pill = pillsFacade.findById(request.getParameter("id"));
        pill.setName(request.getParameter("name"));
        pill.setFirm(request.getParameter("firm"));
        pill.setDose(request.getParameter("dose"));
        pill.setCountry(request.getParameter("country"));
        pill.setDescription(request.getParameter("descr"));
        pillsFacade.update(pill);
        
        response.sendRedirect(request.getContextPath() + "/pills");
    }
}
