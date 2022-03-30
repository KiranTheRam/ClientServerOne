import java.net.*;
import java.io.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 4999);
        Scanner scanner = new Scanner(System.in);
        Date date;
        String messageToBeSent;
        String message;

//        In a loop so multiple message can be sent to the server
        while (socket.isConnected()) {
            System.out.println("\nEnter message to send server (exit to end)");
            messageToBeSent = scanner.nextLine();

//            Send the message captured with scanner
            PrintWriter sending = new PrintWriter(socket.getOutputStream(), true);
            sending.println(messageToBeSent);
            date = new Date();
            System.out.println(new Timestamp(date.getTime()) + " [Client] Message has been sent");

//            Receive message from server
            InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            message = bufferedReader.readLine();

//            Handling the closing of the socket
            date = new Date();
            System.out.println(new Timestamp(date.getTime()) + " " + message);
            if (message.equals("[Server] Socket closed")) {
                System.exit(1);
            }
        }
    }
}
