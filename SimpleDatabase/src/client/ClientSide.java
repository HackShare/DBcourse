package client;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * User: complexityclass
 * Date: 7/16/13
 * Time: 11:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class ClientSide {

    public static void main(String[] args) {

        int serverPort = 6666;
        String address = "127.0.0.1";

        try {

            System.out.println("Welcome to VM-database version 0.1 !");
            System.out.println("Operations :");
            System.out.println("create <key> <value>");
            System.out.println("read <key> ");
            System.out.println("update <key> <value>");
            System.out.println("delete <key> ");
            System.out.println("print");

            InetAddress ipAdress = InetAddress.getByName(address);
            Socket socket = new Socket(ipAdress, serverPort);


            InputStream socketIn = socket.getInputStream();
            OutputStream socketOut = socket.getOutputStream();

            DataInputStream in = new DataInputStream(socketIn);
            DataOutputStream out = new DataOutputStream(socketOut);

            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
            String line = null;
            System.out.println("Enter command");
            System.out.println();

            boolean checked = true;

            while (true) {


                line = keyboard.readLine();
                System.out.println("injecting query");
                System.out.println(line);
                out.writeUTF(line);

                out.flush();
                System.out.println();

                //line = in.readUTF();

                //checked = (line.equals("closing...")) ? false : true;

                System.out.println("reponse : " + line);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
