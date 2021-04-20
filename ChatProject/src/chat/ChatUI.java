package chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.Writer;

public class ChatUI {
    private JFrame frame;
    private JTextArea chatText;
    private JScrollPane scrollPane;
    private JTextField entryText;


    public ChatUI(final String titleBar, final Writer output) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                frame = new JFrame(titleBar);

                chatText = new JTextArea();
                chatText.setEditable(false);
                scrollPane = new JScrollPane(chatText);
                frame.add(scrollPane, BorderLayout.CENTER);

                entryText = new JTextField();
                frame.add(entryText, BorderLayout.SOUTH);

                entryText.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String line = entryText.getText();
                       try {
                           output.write(line + '\n');
                           output.flush();
                       } catch (IOException ioe) {
                           chatText.append("Other party hung up\n");
                       }

                        chatText.append("ME:" + line + '\n');
                        entryText.setText("");
                    }
                });


                frame.setVisible(true);
                frame.setBounds(30, 30, 300, 300);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });

    }
    public void appendText(final String message) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                chatText.append("THEY:" + message + '\n');
            }
        });
    }
}
