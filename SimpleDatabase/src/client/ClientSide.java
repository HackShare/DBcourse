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

            InetAddress ipAdress = InetAddress.getByName(address);
            System.out.println("heard of a socket with IP address" + address + "port" + serverPort + "?");
            Socket socket = new Socket(ipAdress, serverPort);

            System.out.println("hold programm");


            InputStream socketIn = socket.getInputStream();
            OutputStream socketOut = socket.getOutputStream();

            DataInputStream in = new DataInputStream(socketIn);
            DataOutputStream out = new DataOutputStream(socketOut);

            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
            String line = null;
            System.out.println("Type text and press enter to send it to the server");
            System.out.println();

            while (true) {
                line = keyboard.readLine();
                System.out.println("sending to the server");
                out.writeUTF(line);
                out.flush();

                line = in.readUTF();
                System.out.println("Server sent " + line);

                System.out.println();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
