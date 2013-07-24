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

            ServerSocket serverSocket = new ServerSocket(port);

            Socket socket = serverSocket.accept();

            System.out.println("Database");

            InputStream socketIn = socket.getInputStream();
            OutputStream socketOut = socket.getOutputStream();

            DataInputStream in = new DataInputStream(socketIn);
            DataOutputStream out = new DataOutputStream(socketOut);

            String query = null;
            String response = "bad request";
            boolean checked = true;
            while (true) {

                query = in.readUTF();
                System.out.println("query = " + query);
                Scanner sc = new Scanner(query);
                String command = sc.next();
                System.out.println("command = " + command);



                switch (command) {
                    case "create":
                        String ckey = sc.next();
                        String cvalue = sc.next();
                        byte[] bcvalue = cvalue.getBytes();
                        response = "creating key : " + ckey + " value : " + cvalue;
                        System.out.println("log :" + response);
                        shardManager.create(ckey, bcvalue);
                        return;
                    case "read":
                        String rkey = sc.next();
                        byte[] rq = shardManager.read(rkey);
                        response = rq.toString();
                        System.out.println("log :" + response);
                        return;
                    case "update":
                        String ukey = sc.next();
                        byte[] uvalue = sc.next().getBytes();
                        shardManager.update(ukey, uvalue);
                        response = "updating " + ukey;
                        System.out.println("log :" + response);
                        return;
                    case "delete":
                        String dkey = sc.next();
                        shardManager.delete(dkey);
                        response = "deleeting " + dkey;
                        System.out.println("log :" + response);
                        return;
                    case "print":
                        response = shardManager.print().toString();
                        return;
                    case "close":
                        checked = false;
                        response = "closing...";
                        System.out.println("log :" + response);
                        return;
                }

                out.writeUTF(response.toString());
                out.flush();

            }


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
