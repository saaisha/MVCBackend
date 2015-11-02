package com.saaisha.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.saaisha.bean.Event;
import com.saaisha.dao.EventsDAO;

@WebServlet("/InsertEventDetails")
public class InsertEventDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		StringBuffer sb = new StringBuffer();
		String line = null;
		JSONObject incjson, outjson;

		try {
			BufferedReader reader = request.getReader();
			while ((line = reader.readLine()) != null)
				sb.append(line);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			incjson = new JSONObject(sb.toString());
			Event e= new Event();
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
			java.sql.Date sqlDateCreated = new java.sql.Date(format.parse(incjson.getString("dateCreated")).getTime());
			e.setDateCreated(sqlDateCreated);
			java.sql.Date sqlDate = new java.sql.Date(format.parse(incjson.getString("date")).getTime());
			e.setDate(sqlDate);
			e.setType(incjson.optString("type"));
			e.setDescrip(incjson.optString("descrip"));
			e.setLocationLat(Float.valueOf(incjson.optString("locationLat")));
			e.setLocationLong(Float.valueOf(incjson.optString("locationLong")));
			e.setReqdPeople(incjson.optInt("reqdPeople"));
			e.setRegisteredPeople(incjson.optInt("registeredPeople"));
			
			EventsDAO edao = new EventsDAO();
			int eid = edao.insertEvent(e);
			System.out.println(eid);

		} catch (JSONException | ParseException e) {
			e.printStackTrace();
		}
	}

}
