package chat;

import java.io.*;
import java.net.Socket;

public class ChatClient {
    public static void main(String[] args) throws Throwable {
        Socket s = new Socket("127.0.0.1", 1234);

        BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
        Writer output = new OutputStreamWriter(s.getOutputStream());

        ChatUI theUI = new ChatUI("Client side", output);

        String line;
        while ((line = input.readLine()) != null) {
            theUI.appendText(line);
        }
        theUI.appendText("connection lost...");

    }

}
