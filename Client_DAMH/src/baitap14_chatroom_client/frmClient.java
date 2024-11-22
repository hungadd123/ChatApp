/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package baitap14_chatroom_client;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sheam
 */
public class frmClient extends javax.swing.JFrame implements ActionListener {
    private DefaultTableModel tableModel;
	public ServerData connectedServer;
	public String userName = "";
	List<ServerData> serverList;
    /**
     * Creates new form frmClient
     */
   

    public frmClient() {
        initComponents();
            tableModel = (DefaultTableModel) Serverinfotable.getModel();
            serverList = FileManager.getServerList();

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
        Serverinfotable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        addserverbtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        joinbtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Serverinfotable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        Serverinfotable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ServerinfotableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Serverinfotable);

        jButton1.setText("Làm Mới");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        addserverbtn.setText("Thêm Server");
        addserverbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addserverbtnActionPerformed(evt);
            }
        });

        jLabel1.setText("IP:");

        jLabel2.setText("PORT:");

        joinbtn.setText("Join Server");
        joinbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                joinbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(joinbtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(addserverbtn)
                                .addGap(0, 27, Short.MAX_VALUE))
                            .addComponent(jTextField2))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(addserverbtn)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(joinbtn))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
private boolean isServerReachable(String ip, int port) {
        try (Socket socket = new Socket()) {
            socket.connect(new InetSocketAddress(ip, port), 1000); // Timeout of 1 second
            return true; // Connection successful
        } catch (IOException e) {
            return false; // Connection failed
        }
        
    }
public void updateServerTable() {
		if (serverList == null)
			return;
		for (ServerData serverData : serverList) {
      			serverData.isOpen = SocketController.serverOnline(serverData.ip, serverData.port);
			if (serverData.isOpen) {
				serverData.connectAccountCount = SocketController.serverConnectedAccountCount(serverData.ip,
						serverData.port);
			}
		}

		Serverinfotable.setModel(new DefaultTableModel(FileManager.getServerObjectMatrix(serverList), new String[] {
				 "IP server", "Port server", "Trạng thái", "Số user online" }) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int arg0, int arg1) {
				return false;
			}

			@Override
			public Class<?> getColumnClass(int columnIndex) {
				return String.class;
			}

		});
	}


   


public void loginResultAction(String result) {
		if (result.equals("success")) {
			String selectedIP = Serverinfotable.getValueAt(Serverinfotable.getSelectedRow(), 0).toString();
			int selectedPort = Integer.parseInt(Serverinfotable.getValueAt(Serverinfotable.getSelectedRow(), 1).toString());
			connectedServer = serverList.stream().filter(x -> x.ip.equals(selectedIP) && x.port == selectedPort)
					.findAny().orElse(null);

			this.setVisible(false);
			this.dispose();
			Main.mainScreen  = new Chatfrm();
                            Main.mainScreen.setVisible(true);
		} else if (result.equals("existed"))
			JOptionPane.showMessageDialog(this, "Username đã tồn tại", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
		else if (result.equals("closed"))
			JOptionPane.showMessageDialog(this, "Server đã đóng", "Thông báo", JOptionPane.INFORMATION_MESSAGE);

	}
private void joinServer(String ip, int port) {
    // Create the login dialog dynamically
    JDialog askNameDialog = new JDialog();
    JTextField nameText = new JTextField();
    nameText.setPreferredSize(new Dimension(250, 30));
    JButton joinServerButton = new JButton("Vào");
    
    joinServerButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent arg0) {
            if (nameText.getText().isEmpty()) {
                JOptionPane.showMessageDialog(askNameDialog, "Tên không được trống", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            } else {
                ServerData selectedServer = serverList.stream()
                        .filter(x -> x.ip.equals(ip) && x.port == port)
                        .findAny()
                        .orElse(null);
                userName = nameText.getText();
                Main.socketController = new SocketController(nameText.getText(), selectedServer);
                Main.socketController.Login();
                
                // kết quả join ở loginResultAction
                askNameDialog.setVisible(false);
                askNameDialog.dispose();
            }
        }
    });

    JPanel askNameContent = new JPanel();
    askNameContent.add(nameText);
    askNameContent.add(joinServerButton);

    askNameDialog.setContentPane(askNameContent);
    askNameDialog.setTitle("Nhập tên của bạn để vào server " + ip);
    askNameDialog.setModalityType(JDialog.DEFAULT_MODALITY_TYPE);
    askNameDialog.pack();
    askNameDialog.getRootPane().setDefaultButton(joinServerButton);
    askNameDialog.setLocationRelativeTo(null);
    askNameDialog.setVisible(true);
    
}
    private void addserverbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addserverbtnActionPerformed
        // TODO add your handling code here:
    // Validate IP and Port
    try {
		int port = Integer.parseInt(jTextField2.getText());
		String ip = jTextField1.getText();
		boolean serverExists = serverList.stream().anyMatch(server -> server.getIp().equals(ip) && server.getPort() == port);

        if (!serverExists) {
            if (serverList == null) {
                serverList = new ArrayList<>();
            }
            serverList.add(new ServerData(ip, port, false, 0));
            FileManager.setServerList(serverList);
            updateServerTable();
        } else {
            JOptionPane.showMessageDialog(null, "Server with the same IP and Port already exists", "Thông báo",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(null, "Port phải là 1 số nguyên dương", "Thông báo",
                JOptionPane.INFORMATION_MESSAGE);
    }
				
    }//GEN-LAST:event_addserverbtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        updateServerTable();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ServerinfotableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ServerinfotableMouseClicked
        // TODO add your handling code here:
      
    }//GEN-LAST:event_ServerinfotableMouseClicked

    private void joinbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_joinbtnActionPerformed
        // TODO add your handling code here:
    int row = Serverinfotable.getSelectedRow();

    if (row != -1 && row < Serverinfotable.getRowCount()) {
        String ip = (String) Serverinfotable.getValueAt(row, 0);
        int port = (int) Serverinfotable.getValueAt(row, 1);
        joinServer(ip, port);
    } else {
        // Inform the user that no row is selected or the table is empty
        JOptionPane.showMessageDialog(this, "Please select a valid server.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_joinbtnActionPerformed
    private int findRowByIPAndPort(String ip, int port) {
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            String tableIP = (String) tableModel.getValueAt(i, 1);
            int tablePort = (int) tableModel.getValueAt(i, 0);
            if (ip.equals(tableIP) && port == tablePort) {
                return i; // Entry found
            }
        }
        return -1; // Entry not found
    }
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
            java.util.logging.Logger.getLogger(frmClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmClient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Serverinfotable;
    private javax.swing.JButton addserverbtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JButton joinbtn;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

  
    
}
