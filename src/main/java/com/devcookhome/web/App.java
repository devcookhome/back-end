package com.devcookhome.web;

import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;

public class App {
    public static void main(String[] args) throws Exception {
        
        HomeHandler handler = new HomeHandler();
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/home", handler);
        server.createContext("/inicio", handler);
        server.setExecutor(null);
        server.start();
    }
}