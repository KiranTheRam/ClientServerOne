import java.net.*;
import java.io.*;
import java.sql.Timestamp;
import java.util.Date;

public class Client {
    public static void main(String[] args) throws IOException{
        Socket socket = new Socket("localhost", 4999);
        Date date = new Date();

//        Message client is sending to the server
        String messageToBeSent = "[Client] Test Message, did the server receive it?";
//        Displaying to the client what message is about to be sent
        date = new Date();
        System.out.println(new Timestamp(date.getTime()) + " Sending the server this message: \"" + messageToBeSent+ "\"");
//        Sending the message to the server
        PrintWriter sending = new PrintWriter(socket.getOutputStream(), true);
        sending.println(messageToBeSent);

//        Receiving message back from the server.
        InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String message = bufferedReader.readLine();
        date = new Date();
        System.out.println(new Timestamp(date.getTime()) + message);
    }
}
