package com.devcookhome.web;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.*;
import com.devcookhome.dao.GenericDAO;
import com.devcookhome.model.Group;
import java.util.List;

public class GroupHandler implements HttpHandler {
	@Override
	public void handle(HttpExchange t) throws IOException {
		String response = getResponse();
		t.sendResponseHeaders(200, response.length());
		OutputStream os = t.getResponseBody();
		os.write(response.getBytes());
		os.close();
	}
	private String getResponse(){
 
		String response = "<!DOCTYPE html><html><head><title>CookHome</title><meta charset=\"utf-8\"></head><body><div><header><nav><a href=\"grupos/novo\">Novo Grupo</a></nav></header></div><h1>Grupos</h1><ul>";
		List<Group> groups = new GenericDAO<Group>().list(Group.class);
		for(Group g:groups){
			response += "<li>" + g.getName() + "</li>";
		}
		response += "</ul><input type=\"button\" value=\"Voltar\" onClick=\"history.go(-1)\"></body></html>";

		return response;
	}
}

