﻿package com.zzti.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse; 

import com.zzti.business.ClassBusiness;
import com.zzti.bean.Class;
import com.zzti.bean.Result;
import com.zzti.utils.WebUtils;
import com.zzti.web.formbean.ClassForm;

/**
 * Servlet implementation class ClassAddServlet
 */
@WebServlet("/ClassAddServlet")
public class ClassAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		ClassForm form = WebUtils.requestToBean(request, ClassForm.class);
		boolean flag = form.validate();
		if(!flag)//ÑéÖ¤Ê§°Ü
		{
			request.setAttribute("form", form);
			request.getRequestDispatcher("/WEB-INF/jsp/class/class_add.jsp").forward(request, response);
			return;
		}
		
		Class data = new Class();
		WebUtils.copyBean(form, data);
		Result result= new ClassBusiness().add(data);
		if(result.getResult() !=1)
		{
			request.setAttribute("message", result.getMessage());
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		
		response.sendRedirect(request.getContextPath()+"/servlet/ClassListUIServlet");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
