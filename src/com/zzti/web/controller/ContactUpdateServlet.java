﻿package com.zzti.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zzti.business.ClassBusiness;
import com.zzti.business.ContactBusiness;
import com.zzti.bean.Contact;
import com.zzti.bean.ListResult;
import com.zzti.bean.Result;
import com.zzti.utils.WebUtils;
import com.zzti.web.formbean.ContactForm;

/**
 * Servlet implementation class ContactUpdateServlet
 */
@WebServlet("/ContactUpdateServlet")
public class ContactUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ContactUpdateServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ContactForm form = WebUtils.requestToBean(request, ContactForm.class);
		boolean flag = form.validate();
		// 验证
		if (!flag) {
			// 获取班级列表
			ListResult<com.zzti.bean.Class> result = new ClassBusiness()
					.getList();
			if (result.getResult() != 1) {
				request.setAttribute("message", result.getMessage());
				request.getRequestDispatcher("/message.jsp").forward(request,
						response);
				return;
			}
			request.setAttribute("list", result.getList());
			// 表单
			request.setAttribute("form", form);
			request.getRequestDispatcher(
					"/WEB-INF/jsp/contact/contact_update.jsp").forward(request,
					response);
			return;
		}

		Contact data = new Contact();
		WebUtils.copyBean(form, data);
		data.setIp(WebUtils.getRemoteAddress(request));
		// 修改联系人
		Result result = new ContactBusiness().update(data);
		if (result.getResult() != 1)// 错误
		{
			if (result.getResult() == -1)// 说明用户名已存在
			{
				form.getErrors().put("name", result.getMessage());
				// 获取班级列表
				ListResult<com.zzti.bean.Class> result1 = new ClassBusiness()
						.getList();
				request.setAttribute("list", result1.getList());

				// 表单
				request.setAttribute("form", form);
				request.getRequestDispatcher(
						"/WEB-INF/jsp/contact/contact_update.jsp").forward(
						request, response);
				return;
			}

			request.setAttribute("message", result.getMessage());
			request.getRequestDispatcher("/message.jsp").forward(request,
					response);
			return;
		}
		// 修改成功 跳转到列表页面
		response.sendRedirect(request.getContextPath()
				+ "/servlet/ContactListUIServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
