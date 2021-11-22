package by.gsu.pms.client;

import by.gsu.pms.Messages;

import java.io.*;
import java.net.ConnectException;
import java.net.Socket;

public class Client {
    private final int PORT = 4004;
    private final String HOST = "localhost";

    private static final String NO_SERVER = "No server to connect";

    private final String name;

    public Client(String name) {
        this.name = name;
    }

    private void connect(){
        try (Socket clientSocket = new Socket(HOST, PORT);
             BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()))
        ) {
            Thread readThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            String serverWord = in.readLine();
                            System.out.println(serverWord);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });

            readThread.setDaemon(true);

            readThread.start();
            while (true){
                String message = reader.readLine();

                if(Messages.STOP.isEqualMessage(message))
                {
                    sendMessage(out, message);
                    break;
                }

                sendMessage(out, message);
                out.flush();
            }
        }
        catch (ConnectException e) {
            System.out.println(NO_SERVER);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void InitializeConnection(){

    }

    private void sendMessage(Writer out, String message) throws IOException {
        out.write(message + "\n");
    }

    private void sendMessage(Writer out, int message) throws IOException {
        out.write(String.valueOf(message) + "\n");
    }

    public static void main(String[] args) {
        new Client(args[0]).connect();
    }
}
