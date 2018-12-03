package com.example.fljis.invisibledrums;

import java.io.IOException;
import java.net.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
//implements Runnable
public class UDPSender implements Runnable {
    private String command;
    private int opcode;

    public UDPSender(){


    }
    public UDPSender(String mes, int i){
        command = mes;
        opcode = i;

    }

    public void send(String command,int i ){
        // Check the arguments
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(9879);
            // Convert the arguments first, to ensure that they are valid
            InetAddress host = InetAddress.getByName( "172.20.10.2" ) ;
            i = opcode;
            //int port =  i;
            //socket = new DatagramSocket() ;
            //String message = command;
            byte [] data = command.getBytes() ;
            DatagramPacket packet = new DatagramPacket( data, data.length, host, i ) ;
            socket.send( packet ) ;
            socket.close();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //System.out.println( "command sent" );
    }

//    public static void main(String[] args) throws Exception {
//        UDPSender sender = new UDPSender();
//        sender.send("wow",1234);
//    }
    @Override
    public void run() {
        // TODO Auto-generated method stub
       // UDPSender sender = new UDPSender();
        send(command,opcode);
    }

//    public String getCommand() {
//        return command;
//    }
//
    public void setCommand(String command) {
        this.command = command;
    }
//
//    public int getOpcode() {
//        return opcode;
//    }
//
    public void setPort(int port) {
        this.opcode = opcode;
    }
}

