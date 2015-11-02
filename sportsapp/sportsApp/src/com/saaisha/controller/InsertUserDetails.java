package com.saaisha.controller;

import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONException;
import org.json.JSONObject;
import com.saaisha.bean.Sports;
import com.saaisha.dao.SportsDAO;

@WebServlet("/InsertUserDetails")
public class InsertUserDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
	//	initialiseUser();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		StringBuffer jb = new StringBuffer();
		String line = null;
		JSONObject incjson,outjson;
		
		try {
		    BufferedReader reader = request.getReader();
		    while ((line = reader.readLine()) != null)
		      jb.append(line);
		  } catch (Exception e) {
			  e.printStackTrace(); }
		try {
			incjson = new JSONObject(jb.toString());
			line = incjson.optString("fName");
			int uid = initialiseUser(line);
			
			outjson = new JSONObject();
			outjson.put("uid",uid);
			
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(outjson.toString());
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	
	public int initialiseUser(String name)
	{
		Sports sp= new Sports();
		SportsDAO spdao= new SportsDAO();
	    sp.setName(name);
	    sp.setEvents_created(0);
	    sp.setEvents_attended(0);
	    sp.setCurr_active_event(0);
	    sp.setNo_active_event(0);
	    return spdao.insertUser(sp);
	    
	    
	}

}
