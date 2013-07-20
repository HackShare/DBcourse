package database;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: complexityclass
 * Date: 7/16/13
 * Time: 11:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class ServerSide {

    public static void main(String[] args) {

        int port = 6666;
        ShardManager shardManager = new ShardManager();

        try {

            System.out.println("Welcome to VM v0.1 database !");
            System.out.println("Operations :");
            System.out.println("create <key> <value>");
            System.out.println("read <key> ");
            System.out.println("update <key> <value>");
            System.out.println("delete <key> ");

            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Waiting for a client");

            Socket socket = serverSocket.accept();

            System.out.println("Got a client !");
            System.out.println();

            InputStream socketIn = socket.getInputStream();
            OutputStream socketOut = socket.getOutputStream();

            DataInputStream in = new DataInputStream(socketIn);
            DataOutputStream out = new DataOutputStream(socketOut);

            String query = null;
            while (true) {

                query = in.readUTF();
                System.out.println("query = " + query);
                Scanner sc = new Scanner(query);
                String command = sc.next();
                System.out.println("command = " + command);
                String key = sc.next();
                System.out.println("key = " + key);

                switch (command) {
                    case "create":
                        String value = sc.next();
                        byte[] cvalue = value.getBytes();
                        System.out.println("cvalue length" + cvalue.length);
                        shardManager.create(key, cvalue);
                        return;
                    case "read":
                        shardManager.read(key);
                        return;
                    case "update":
                        byte[] uvalue = sc.next().getBytes();
                        shardManager.update(key, uvalue);
                        return;
                    case "delete":
                        shardManager.delete(key);
                        return;
                    case "print":
                        shardManager.print();
                        return;


                }

                String response = "completed";
                out.writeUTF(response);

            }


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
