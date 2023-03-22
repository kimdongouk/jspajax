package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mvcmember.dao.MemberDAOMybatis;
import com.mvcmember.vo.MemberVO;

import membership.MemberDAO;
import membership.MemberDTO;

@WebServlet("*.do")
public class MemberControlller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println(path);
		if(path.equals("/index.do")) {
			response.sendRedirect("index.jsp");
//			request.getRequestDispatcher("index.jsp").forward(request,response);
		} else if(path.equals("/getMember.do")) {
			String id = request.getParameter("id");
			MemberDAO dao = new MemberDAO();
			MemberDTO dto = dao.getMemberDTO(id);
			request.setAttribute("dto", dto);
			request.getRequestDispatcher("getMember.jsp").forward(request, response);
		} else if(path.equals("/getMemberJson.do")) {
			String id = request.getParameter("id");
			MemberDAO dao = new MemberDAO();
			MemberDTO dto = dao.getMemberDTO(id);
			System.out.println(dto);
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(dto);
			System.out.println(json);
//			JSON -> BW
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			out.print(json);
		} else if(path.equals("/getMemberList.do")) {
			String id = request.getParameter("id");
			MemberDAO dao = new MemberDAO();
			MemberDTO dto = dao.getMemberDTO(id);
			List<MemberDTO> list = new ArrayList<>();
			list = dao.selectList();
			request.setAttribute("dto", dto);
			request.setAttribute("list", list);
			request.getRequestDispatcher("getMemberList.jsp").forward(request, response);
		} else if(path.equals("/getMemberListJson.do")) {
			String id = request.getParameter("id");
			MemberDAO dao = new MemberDAO();
			MemberDTO dto = new MemberDTO();
			List<MemberDTO> list = new ArrayList<>();
			list = dao.selectList();
			System.out.println(dto);
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(list);
			System.out.println(json);
//			JSON -> BW
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			out.print(json);
		} else if(path.equals("/getMemberListMybatis.do")) {
			MemberDAOMybatis dao = new MemberDAOMybatis();
			List<MemberVO> list = dao.getMemberList();
			request.setAttribute("list", list);
			request.getRequestDispatcher("/getMemberListMybatis.jsp").forward(request, response);
		} else if(path.equals("/getMemberMybatis.do")) {
			String id = request.getParameter("id");
			MemberDAOMybatis dao = new MemberDAOMybatis();
			MemberVO vo = dao.getMember(id);
			request.setAttribute("vo", vo);
			request.getRequestDispatcher("/getMemberMybatis.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
