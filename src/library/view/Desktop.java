package library.view;

public class Desktop extends javax.swing.JFrame {

    public Desktop() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        clientMenuItem = new javax.swing.JMenuItem();
        bookMenuItem = new javax.swing.JMenuItem();
        OperationMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Library SYstem Home");

        fileMenu.setMnemonic('h');
        fileMenu.setText("Home");

        clientMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        clientMenuItem.setMnemonic('c');
        clientMenuItem.setText("Client");
        clientMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(clientMenuItem);

        bookMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        bookMenuItem.setMnemonic('b');
        bookMenuItem.setText("Book");
        bookMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(bookMenuItem);

        OperationMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        OperationMenuItem.setMnemonic('o');
        OperationMenuItem.setText("Operations");
        OperationMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OperationMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(OperationMenuItem);

        menuBar.add(fileMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1195, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 642, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clientMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientMenuItemActionPerformed
        ClientView clientForm = new ClientView();
        desktopPane.add(clientForm);
        clientForm.setVisible(true);
    }//GEN-LAST:event_clientMenuItemActionPerformed

    private void bookMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookMenuItemActionPerformed
        BookView bookForm = new BookView();
        desktopPane.add(bookForm);
        bookForm.setVisible(true);
    }//GEN-LAST:event_bookMenuItemActionPerformed

    private void OperationMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OperationMenuItemActionPerformed
        TransactionView operationForm = new TransactionView();
        desktopPane.add(operationForm);
        operationForm.setVisible(true);
    }//GEN-LAST:event_OperationMenuItemActionPerformed

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
            java.util.logging.Logger.getLogger(Desktop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Desktop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Desktop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Desktop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Desktop().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem OperationMenuItem;
    private javax.swing.JMenuItem bookMenuItem;
    private javax.swing.JMenuItem clientMenuItem;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuBar menuBar;
    // End of variables declaration//GEN-END:variables

}
