import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        try (ServerSocket welcomingSocket = new ServerSocket(6023);) {
            System.out.println("Server started.");
            System.out.print("Waiting for a client...");

            Socket connectionSocket = welcomingSocket.accept();
            System.out.println("Client accepted.");

            DataInputStream in = new DataInputStream(new BufferedInputStream(connectionSocket.getInputStream()));
            DataOutputStream out = new DataOutputStream(new BufferedOutputStream(connectionSocket.getOutputStream()));

            String clientData = "";
            while (true) {
                String clientRequest = in.readUTF();

                if (!clientRequest.equals("over\n")) {
                    System.out.println("Client request: " + clientRequest);
                    clientData += clientRequest;
                    out.writeUTF(clientData);
                    out.flush();
                } else {
                    System.out.println("All messages sent.");
                    break;
                }
            }
            in.close();
            out.close();
            connectionSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Server closed.");
    }
}
