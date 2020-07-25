package com.devcookhome.web;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.*;

public class HomeHandler implements HttpHandler {
	@Override
	public void handle(HttpExchange t) throws IOException {
		String response = getResponse();
		t.sendResponseHeaders(200, response.length());
		OutputStream os = t.getResponseBody();
		os.write(response.getBytes());
		os.close();
	}
	private String getResponse(){
 
		return "<!DOCTYPE html><html><head><title>CookHome</title><meta charset=\"utf-8\"></head><body><h1>Bem vindo ao CookHome</h1><div><header><nav><a href=\"grupos\">Grupos</a></nav></header></div></body></html>";

	}
}

