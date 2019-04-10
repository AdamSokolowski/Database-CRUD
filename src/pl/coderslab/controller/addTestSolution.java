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

@WebServlet("/addTestSolution")
public class addTestSolution extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public addTestSolution() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Solution solution = new Solution("test solution description", 1, 1);
		int id;
		try {
			Connection conn = DbUtil.getConn();
			id = solution.saveToDB(conn);
			solution = Solution.loadById(conn, id);
			conn.close();
			Solution[] solutions = new Solution[1];
			solutions[0]=solution;
			request.setAttribute("solutions", solutions);
			String title = "Added Solution";
			request.setAttribute("title", title);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		getServletContext().getRequestDispatcher("/views/index.jsp").forward(request, response);		
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
