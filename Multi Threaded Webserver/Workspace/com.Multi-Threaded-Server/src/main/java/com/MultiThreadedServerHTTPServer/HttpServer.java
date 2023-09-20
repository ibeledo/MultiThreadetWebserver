package com.MultiThreadedServerHTTPServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.module.Configuration;
import java.net.ServerSocket;
import java.net.Socket;

import httpServerConfig.ConfigurationManager;

/*
 * 
 * Driver Class for the HTTP Server
 * Tutorial: https://www.youtube.com/watch?v=N4f-D-oBvTc&list=PLAuGQNR28pW56GigraPdiI0oKwcs8gglW&index=3
 *
 */
public class HttpServer {

	public static void main(String[] args) {
		System.err.println("Server Starting...");
		ConfigurationManager.getInstance().loadConfigurationFile("src/main/resources/http.json");
		httpServerConfig.Configuration conf = ConfigurationManager.getInstance().getCurrentConfiguration();
		
		System.out.println("Using Port: " + conf.getPort());
		System.out.println("Using WebRoot: " + conf.getWebroot());
		
		try {
			ServerSocket serverSocket = new ServerSocket(conf.getPort());
			Socket socket = serverSocket.accept();
			
			InputStream inputStream = socket.getInputStream();
			OutputStream outputStream = socket.getOutputStream();
			
			// TODO we would read
			String html = "<!DOCTYPE html>\r\n"
					+ "<html>\r\n"
					+ "	<head>\r\n"
					+ "		<h1>Test Seite</h1>\r\n"
					+ "	</head>\r\n"
					+ "	<body>\r\n"
					+ "		<h1>\r\n"
					+ "			This Page was served using Multi Threaded Server\r\n"
					+ "		</h1>\r\n"
					+ "	</body>\r\n"
					+ "</html>";
			final String CRLF = "\n\r"; //10,13
			String response = "HTTP/1.1 200 OK" + CRLF + 
							  "Content-Length: " + html.getBytes().length + CRLF + CRLF + html+ CRLF + CRLF ; // Status Line: HTTP Version Response_Code Response_Message
			//TODO we would writing 
			outputStream.write(response.getBytes());
			inputStream.close();
			outputStream.close();
			socket.close();
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
