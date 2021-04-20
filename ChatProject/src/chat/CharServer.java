package chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;

public class CharServer {
    public static void main(String[] args) throws Throwable {
        ServerSocket ss = new ServerSocket(1234);
        Socket s = ss.accept();

        BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
        Writer output = new OutputStreamWriter(s.getOutputStream());

        ChatUI theUI = new ChatUI("Server Side",output);
        String line;
        while ((line = input.readLine()) != null) {
            theUI.appendText(line);
        }
        theUI.appendText("connection lost...");

    }
}
