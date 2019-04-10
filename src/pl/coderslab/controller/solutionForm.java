package pl.coderslab.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.model.DbUtil;
import pl.coderslab.model.Solution;

@WebServlet("/solutionForm")
public class solutionForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public solutionForm() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ki");
		getServletContext().getRequestDispatcher("/views/newSolutionForm.jsp").forward(request, response);		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	


}
