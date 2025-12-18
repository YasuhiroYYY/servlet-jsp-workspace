package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/GetNumber")
public class GetNumber extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = (int)(Math.random() * 9) + 1;
		request.setCharacterEncoding("UTF-8");
		String userTxt = request.getParameter("user");
		
	
	
		String msg = "";
		String errorMsg = "";
		int user = 0;
		try {
			user = Integer.parseInt(userTxt);
		} catch (NumberFormatException e) {
			errorMsg = "数字を入力してください。";
		}
		
		if(user == num) {
		   msg = "正解です。";
		} else if (user > num) {
			msg = "大きすぎます。";
		} else {
			msg = "小さすぎます。";
		}
		
		if (errorMsg.length() > 0) {
			msg = errorMsg;
		}
		
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>数当て結果</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<p>" + msg + "</p>");
		out.println("<a href='index.jsp'>もどる</a");
		out.println("</body>");
		out.println("</html>");

	}

}
