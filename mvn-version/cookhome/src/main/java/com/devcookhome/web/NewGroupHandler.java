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
		if (t.getRequestMethod().equals("POST")){

			StringBuilder sb = new StringBuilder();
            InputStream ios = t.getRequestBody();
            int i;
            while ((i = ios.read()) != -1) {
                sb.append((char) i);
            }
            String request = sb.toString();
            String part1 = request.split("&")[0];
            String name = part1.split("=")[1];
            Group g = new Group();
            g.setName(name);
            String response = GenericDAO.save(g).getId() !=null ? "/grupos/novo/sucess" : "/grupos/novo?error=true";
            t.getResponseHeaders().set("Location", response);
			t.sendResponseHeaders(302, response.length());
			OutputStream os = t.getResponseBody();
			os.write(response.getBytes());
			os.close();
		}
		else {

			String response = getResponse();
			t.sendResponseHeaders(200, response.length());
			OutputStream os = t.getResponseBody();
			os.write(response.getBytes());
			os.close();
		}
	}
	private String getResponse(){

		String response = "<!DOCTYPE html><html><head><title>CookHome</title><meta charset='utf-8'></head><body><h1>Criar novo grupo</h1><p id='error'><form action='/grupos/novo' method='post'><label for='name'>Digite o nome do novo grupo:</label><input type='text' name='name'><input type='submit' name='create' value='Criar'></p><input type='button' value='Cancelar' onClick='history.go(-1)'></form><span id='errormensage' style='color: #F00'></span></body><script type='text/javascript'>var url = location.href.indexOf('error=true')>-1;if (url) {document.getElementById('errormensage').innerHTML = 'Erro ao salvar'}</script></html>"; 
		return response;
	}
}

