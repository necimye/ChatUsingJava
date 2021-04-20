package chat;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ChatProject {

    public static void main(String[] args) throws Throwable {
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

        ChatUI theUI = new ChatUI("messanger", new OutputStreamWriter(System.out));

        String line;
        while((line = keyboard.readLine()) != null) {
            theUI.appendText(line);
        }
    }
}
