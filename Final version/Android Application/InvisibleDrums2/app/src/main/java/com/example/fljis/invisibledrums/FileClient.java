package com.example.fljis.invisibledrums;

import java.io.*;
import java.net.*;
public class FileClient implements Runnable{
	String filepath;
	int port = 1238;
	
	public FileClient() {
		
	}
	
	public void send(Socket sr,String path) throws Exception {
		FileInputStream fr= new FileInputStream(path);
		byte b[]=new byte[40000];
		fr.read(b, 0, b.length);
		OutputStream os = sr.getOutputStream();
		os.write(b,0,b.length);
		fr.close();
	}
	
	public void applysend() throws Exception {
		Socket sr=new Socket("172.20.10.2",port);
		FileClient sender = new FileClient();
		sender.send(sr,filepath);
		sr.close();
	}
	
//
//	public static void main(String[] args) throws Exception{
//		Socket sr=new Socket("192.168.43.245",4333);
//		FileClient sender = new FileClient();
//		sender.send(sr,"");
//		sr.close();
//
//	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		try {
			applysend();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void setCommand(String command) {
		this.filepath = command;
	}

}		
