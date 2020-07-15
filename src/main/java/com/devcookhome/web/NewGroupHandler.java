package com.devcookhome.web;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.*;
import com.devcookhome.dao.GenericDAO;
import com.devcookhome.model.Group;
import java.util.List;

public class NewGroupHandler implements HttpHandler {
	@Override
	public void handle(HttpExchange t) throws IOException {
		String response = getResponse();
		t.sendResponseHeaders(200, response.length());
		OutputStream os = t.getResponseBody();
		os.write(response.getBytes());
		os.close();
	}
	private String getResponse(){
 
		String response = "<!DOCTYPE html><html><head><title>CookHome</title><meta charset=\"utf-8\"></head><body><h1>Criar novo grupo</h1><form><label for=\"name\">Digite o nome do novo grupo:</label><input type=\"text\" name=\"name\">";
		response += "<input type=\"submit\" name=\"create\" value=\"Criar\"><input type=\"button\" value=\"Cancelar\" onClick=\"history.go(-1)\">";
		return response;
	}
}

