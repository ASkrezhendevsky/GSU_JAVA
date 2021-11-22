package by.gsu.pms.server;

import by.gsu.pms.Messages;

import java.io.*;
import java.net.Socket;

class ServerConnection extends Thread {
    private Socket socket;
    private BufferedReader in;
    private BufferedWriter out;
    private int recipient;

    public ServerConnection(Socket socket) throws IOException {
        this.socket = socket;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        start();
    }

    @Override
    public void run() {
        String message;
        try {
            send("Select client, available 0 - " + (Server.connections.size()-1));
            recipient = Integer.parseInt(in.readLine());
            send("Sent message to " + recipient);
            while (true) {
                message = in.readLine();
                if (Messages.STOP.isEqualMessage(message)) {
                    break;
                }
                Server.connections.get(recipient).send(message);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void send(String msg) throws IOException {
        out.write(msg + "\n");
        out.flush();
    }
}