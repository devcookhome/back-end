package com.devcookhome.web;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.*;
import com.devcookhome.dao.GenericDAO;
import com.devcookhome.model.Group;
import java.util.List;

public class NewGroupSucessHandler implements HttpHandler {
	@Override
	public void handle(HttpExchange t) throws IOException {
		String response = getResponse();
		t.sendResponseHeaders(200, response.length());
		OutputStream os = t.getResponseBody();
		os.write(response.getBytes());
		os.close();
	}
	private String getResponse(){
 
		String response = "<!DOCTYPE html><html><head><title>CookHome</title><meta charset=\"utf-8\"></head><body><h1>Grupo inserido com sucesso!</h1><ul>";
		response += "</ul><input type=\"button\" value=\"Voltar\" onClick=\"history.go(-2)\"></body></html>";
		return response;
	}
}

