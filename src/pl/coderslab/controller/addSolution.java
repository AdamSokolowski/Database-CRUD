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

@WebServlet("/addSolution")
public class addSolution extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public addSolution() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		getServletContext().getRequestDispatcher("/views/newSolutionForm.jsp").forward(request, response);		
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String description = request.getParameter("description");
		String exerciseIdS = request.getParameter("exercise_id");
		String userIdS = request.getParameter("user_id");
		int exerciseId = Integer.parseInt(exerciseIdS);
		int userId = Integer.parseInt(userIdS);
		
		Solution solution = new Solution(description, exerciseId, userId);
		int id;
		try {
			Connection conn = DbUtil.getConn();
			id = solution.saveToDB(conn);
			solution = Solution.loadById(conn, id);
			conn.close();
			System.out.println(solution.getCreatedAsString());
			Solution[] solutions = new Solution[1];
			solutions[0]=solution;
			request.setAttribute("solutions", solutions);
			String title = "Added Solution";
			request.setAttribute("title", title);
			getServletContext().getRequestDispatcher("/views/index.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
