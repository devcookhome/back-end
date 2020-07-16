package com.devcookhome.web;

import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;

public class App {
    public static void main(String[] args) throws Exception {
        
        HomeHandler homeHandler = new HomeHandler();
        GroupHandler groupHandler = new GroupHandler();
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/home", homeHandler);
        server.createContext("/inicio", homeHandler);
        server.createContext("/grupos", groupHandler);
        server.createContext("/groups", groupHandler);
        server.setExecutor(null);
        server.start();
    }
}