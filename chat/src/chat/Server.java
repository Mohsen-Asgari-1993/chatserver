/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author king
 */
public class Server extends javax.swing.JFrame {

    private static List<User> userList = new ArrayList<>();
    private static List<Socket> socketList = new ArrayList<>();

    /**
     * Creates new form Server
     */
    public Server() {
        initComponents();
        userList.add(new User("Ali", "mat"));
        userList.add(new User("mat", "far"));
        userList.add(new User("mohsen", "asgari"));
        userList.add(new User("mohammad", "farahani"));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TA = new javax.swing.JTextArea();
        Start = new javax.swing.JButton();
        TF = new javax.swing.JTextField();
        Send = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Server");

        TA.setColumns(20);
        TA.setRows(5);
        jScrollPane1.setViewportView(TA);

        Start.setText("Start");
        Start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartActionPerformed(evt);
            }
        });

        TF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFActionPerformed(evt);
            }
        });

        Send.setText("send");
        Send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SendActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(TF)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Start)
                    .addComponent(Send))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(Start)))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Send))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void StartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartActionPerformed
        // TODO add your handling code here:
        Thread starter = new Thread(new ServerStart());
        starter.start();
        TA.append("Server Started");
    }//GEN-LAST:event_StartActionPerformed

    private void TFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFActionPerformed

    private void SendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SendActionPerformed
        // TODO add your handling code here:
        try {
            if (!TF.getText().equals("")) {
                Socket socket = RecieveFromClient.getClientSocket();
                if (socket != null) {
                    String msg = null;
                    System.err.println("send message to client by port = " + socket.getPort());
                    msg = TF.getText();

                    PrintWriter pwPrintWriter = new PrintWriter(new OutputStreamWriter(
                            socket.getOutputStream()));//get outputstream

                    pwPrintWriter.println(msg);//send message to client with PrintWriter
                    pwPrintWriter.flush();//flush the PrintWriter

                    System.out.println("message sent to " + socket.getPort());
                    System.out.println("Please enter something to send back to client..");
                    TA.append("\nMe: " + msg);
                    TF.setText("");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_SendActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Server.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Server.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Server.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Server.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Server().setVisible(true);
            }
        });
    }

    public static void print(String s) {
        TA.append("\n" + s);
    }

    public static String getMessage() {
        return TF.getText();
    }

    public static List<User> getUserList() {
        return userList;
    }

    public static void setUserList(List<User> userList) {
        Server.userList = userList;
    }

    public static List<Socket> getSocketList() {
        return socketList;
    }

    public static void setSocketList(List<Socket> socketList) {
        Server.socketList = socketList;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Send;
    private javax.swing.JButton Start;
    private static javax.swing.JTextArea TA;
    private static javax.swing.JTextField TF;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

class ServerStart implements Runnable {

    private int i = 1;

    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(5050);
            while (true) {
                Socket socket = serverSocket.accept();
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String text = reader.readLine();

                boolean isTrue = compare(text, socket);
                PrintWriter writer = new PrintWriter(new OutputStreamWriter(
                        socket.getOutputStream()));
                if (isTrue) {

                    writer.println("true");
                    writer.flush();
                    String name = "";
                    for (User u : Server.getUserList()) {
                        if (socket == u.getSocket()) {
                            name = u.getUserName();
                        }
                    }
                    Server.print("\t\t new Connection found!!! :" + name);
                    ClientHandler client = new ClientHandler(socket, i);
                    new Thread(client).start();
                    i++;
                } else {
                    writer.println("false");
                    writer.flush();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean compare(String s, Socket socket) {
        String[] data = s.split(":");
        for (User u : Server.getUserList()) {
            if (u.getUserName().equals(data[0]) && u.getPassWord().equals(data[1])) {
                u.setSocket(socket);
                return true;
            }
        }
        return false;
    }
}

class ClientHandler implements Runnable {

    private Socket socket;
    private int i;

    public ClientHandler(Socket socket, int i) {
        this.socket = socket;
        this.i = i;
    }

    @Override
    public void run() {
        RecieveFromClient recieve = new RecieveFromClient(socket, i);
        new Thread(recieve).start();
    }
}

class RecieveFromClient implements Runnable {

    private Socket socket;
    private static Socket clientSocket;
    private int i;

    public RecieveFromClient(Socket clientSocket, int i) {
        this.socket = clientSocket;
        this.i = i;

    }//end constructor

    public static Socket getClientSocket() {
        return clientSocket;
    }

    public static void setClientSocket(Socket clientSocket) {
        RecieveFromClient.clientSocket = clientSocket;
    }

    public void run() {
        try {

            BufferedReader brBufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String msg;
            while (true) {
                while ((msg = brBufferedReader.readLine()) != null) {
//                    if (msg.equals("EXIT")) {
//                        break;
//                    }
                    setClientSocket(socket);
                    Server.print("client " + i + ":" + msg);
                    System.out.println("From Client" + i + " : " + msg + " from port : " + socket.getPort());//print the message from client
                    System.out.println("Please enter something to send back to client..");
                }
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
