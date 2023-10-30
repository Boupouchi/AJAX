/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.school.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ma.school.beans.Machine;
import ma.school.beans.Marque;
import ma.school.service.MachineService;
import ma.school.service.MarqueService;

/**
 *
 * @author a
 */
@WebServlet(name = "MachineController", urlPatterns = {"/MachineController"})
public class MachineController extends HttpServlet {
    MarqueService ms = new MarqueService();
    MachineService mms = new MachineService();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String op = request.getParameter("op");
         if (op != null) {
            if (op.equalsIgnoreCase("envoyer")) {
                // Code pour l'ajout d'une machine
                String ref = request.getParameter("ref");
                double prix = Double.parseDouble(request.getParameter("prix"));
                Date dateAchat = new Date(request.getParameter("dateAchat").replace("-", "/"));
                Marque marque = ms.findById(Integer.parseInt(request.getParameter("marque")));
                mms.create(new Machine(dateAchat, prix, marque, null));
                response.sendRedirect("machineForm.jsp");
            } else if (op.equalsIgnoreCase("delete")) {
                // Code pour la suppression d'une machine
                int id = Integer.parseInt(request.getParameter("id"));
                mms.delete(mms.findById(id));
                response.sendRedirect("machineForm.jsp");
            } else if (op.equalsIgnoreCase("update")) {
//                // Code pour la mise à jour d'une machine
//                int id = Integer.parseInt(request.getParameter("id"));
//                String ref = request.getParameter("ref");
//                double prix = Double.parseDouble(request.getParameter("prix"));
//                Date dateAchat = new Date(request.getParameter("dateAchat").replace("-", "/"));
//                Marque marque = ms.findById(Integer.parseInt(request.getParameter("marque")));
//                // Utilisez ces valeurs pour mettre à jour la machine avec l'ID spécifié
//                mms.update(ref, prix, dateAchat, marque);
                
            response.sendRedirect("machineForm.jsp");
        }
        
         }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
         System.out.println("get");
    }

    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
         System.out.println("post");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
