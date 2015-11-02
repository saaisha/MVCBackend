package com.saaisha.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.saaisha.bean.nearestEvent;
import com.saaisha.dao.getNearestEventDAO;


@WebServlet("/getNearestEvent")
public class getNearestEvent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public getNearestEvent() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		StringBuffer jb = new StringBuffer();
		String line = null;
		JSONObject incjson,outjson;
		String json;
		getNearestEventDAO ne = new getNearestEventDAO();
		List<nearestEvent> nearestEvents = new ArrayList<nearestEvent>();
		Gson gson = new Gson();
		
		try {
		    BufferedReader reader = request.getReader();
		    while ((line = reader.readLine()) != null)
		      jb.append(line);
		    incjson = new JSONObject(jb.toString());
			Float latitude= Float.valueOf(incjson.optString("mLatitude"));
			Float longitude = Float.valueOf(incjson.optString("mLongitude"));
			nearestEvents= ne.getEvents(latitude,longitude);
			json = gson.toJson(nearestEvents);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);
			
		  } catch (Exception e) {
			  e.printStackTrace(); }
	
			
	}

}
