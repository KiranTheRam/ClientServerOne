import java.net.*;
import java.io.*;
import java.sql.Timestamp;
import java.util.Date;

public class Server {
    public static void main(String[] args) throws IOException {
        Date date = new Date();
        ServerSocket serverSocket = new ServerSocket(4999);
        System.out.println(new Timestamp(date.getTime()) + " [Server] Waiting for client to connect ...");
        Socket socket = serverSocket.accept();

//        So we know a client has connected
        date = new Date();
        System.out.println(new Timestamp(date.getTime()) + " [Server] Client has connected");

//        Convert message sent by client and display it on server
        InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String message = bufferedReader.readLine();
        date = new Date();
        System.out.println(new Timestamp(date.getTime()) +" "+ message);

//        Send a message back to the client to inform them their message has been received
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
        printWriter.println(" [Server] You have successfully connected to the server and your message was received");



    }
}
