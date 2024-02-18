package server;

import javax.swing.*;
import java.awt.*;

public class ServerWindow extends JFrame implements ServerView{
    private static final int WINDOW_HEIGHT = 400;
    private static final int WINDOW_WIDTH = 400;

    private JButton Start, Finish;
    private JTextArea log;
    private JPanel panBottom;
    private Server server;

    public ServerWindow() {
        settings();
        createMap();
        setVisible(true);
    }
    private void settings(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Server Chat");

        server = new Server(this, new FileStorage());
    }

    private void createMap(){
        log = new JTextArea(21, 30);
        log.setEditable(false);
        add(log);
        add(createButtons(),BorderLayout.SOUTH);
    }
    private JPanel createButtons(){
        panBottom = new JPanel(new GridLayout(1,3));
        Start = new JButton("Start");
        Start.addActionListener(e -> server.serverPowerOn());
        Finish = new JButton("Finish");
        Finish.addActionListener(e -> server.serverPowerOff());
        panBottom.add(Start);
        panBottom.add(Finish);
        return panBottom;
    }
    @Override
    public void showMessage(String message){
        log.append(message + '\n');
    }

    public Server getConnection(){
        return server;
    }

}
