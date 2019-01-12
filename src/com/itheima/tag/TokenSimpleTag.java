package com.itheima.tag;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class TokenSimpleTag extends SimpleTagSupport {

	public void doTag() throws JspException, IOException {
		//产生一个唯一的token
		String token = UUID.randomUUID().toString();
		//放到HttpSession中一个：token
		PageContext pc = (PageContext)getJspContext();
		HttpSession session = pc.getSession();
		session.setAttribute("token", token);
		//输出一个<input type="hidden" name="token" value=""/>
		pc.getOut().write("<input type='hidden' name='token' value='"+token+"'/>");
	}
	
}
