package library.view;

import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import library.controller.GenericDao;
import library.model.Client;
import library.model.ClientType;

public class ClientView extends javax.swing.JInternalFrame {

    //THIS SECTION CONTAINS GLOBAL VARIABLES. 
    //Variables to be used when dealing with selection of the image.
    int selectedRow;
    byte[] person_image;
    FileInputStream fileinputstream;
    String thePathOfTheImage;
    File theimage, selectedImage;    
    byte[] ImagePhotoFileFromDatabase;
    
    //Additional but necessary variables and instances
    
    List<Client> clientList;
    
    Client client = new Client();
    GenericDao<Client> clientDao = new GenericDao(Client.class);
    
    DefaultTableModel model;
    
    //This is a non-parametarized constructor. Everything inside runs when the project is run.
    public ClientView() {
        initComponents();//Comes with the project
        //These two methods below are the ones I added myself
        getClientListFromDao();
        displayClientsInTable();
    }
    
    //METHOD TO GET CLIENT LIST FROM THE LIST MAKE IN CLIENTDAO
    public void getClientListFromDao(){
        clientList = clientDao.retrieveAll(client);
    }
    
    //METHOD TO DISPLAY DATE IN TABLE
    private void displayClientsInTable(){   
        model = (DefaultTableModel) clientTable.getModel();
        model.setRowCount(0);
        
        for (Client aClient : clientList) {
            model.addRow(new Object[]{
                aClient.getRegistrationNumber(),
                aClient.getFirstName(),
                aClient.getLastName(),
                aClient.getPhoneNumber(),
                aClient.getEmail(),
                aClient.getClientCategory(),
                aClient.getImage()
            });
        }
    }

    //METHOD FOR CLEANING INPUT FIELDS
    private void resetInputs(){
        regNoTxtField.setText("");
        fnameTxtField.setText("");
        lnameTxtField.setText("");
        phoneTxtField.setText("");
        emailTxtField.setText("");
        clientCategoryComboBox.setSelectedIndex(0);
        imageLabel.setIcon(null);
        imageFilePathTxtField.setText("");;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        TitleLabel = new javax.swing.JLabel();
        inputsPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        regNoTxtField = new javax.swing.JTextField();
        fnameTxtField = new javax.swing.JTextField();
        lnameTxtField = new javax.swing.JTextField();
        phoneTxtField = new javax.swing.JTextField();
        emailTxtField = new javax.swing.JTextField();
        clientCategoryComboBox = new javax.swing.JComboBox<>();
        buttonPanel = new javax.swing.JPanel();
        saveBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        resetBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        tablePanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        clientTable = new javax.swing.JTable();
        imagePanel = new javax.swing.JPanel();
        imageLabel = new javax.swing.JLabel();
        BrowseImageBtn = new javax.swing.JButton();
        imageFilePathTxtField = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Clients");

        TitleLabel.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        TitleLabel.setText("CLIENTS");

        inputsPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        inputsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("ID number");
        inputsPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 30, -1, -1));

        jLabel3.setText("First Name");
        inputsPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 64, -1, -1));

        jLabel4.setText("Last Name");
        inputsPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 96, -1, -1));

        jLabel5.setText("Phone Number");
        inputsPanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 128, -1, -1));

        jLabel6.setText("Email");
        inputsPanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 156, -1, -1));

        jLabel7.setText("Client Category");
        inputsPanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 188, -1, -1));
        inputsPanel.add(regNoTxtField, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 28, 153, -1));
        inputsPanel.add(fnameTxtField, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 60, 153, -1));
        inputsPanel.add(lnameTxtField, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 92, 153, -1));
        inputsPanel.add(phoneTxtField, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 124, 153, -1));
        inputsPanel.add(emailTxtField, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 154, 153, -1));

        clientCategoryComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Student", "Staff" }));
        inputsPanel.add(clientCategoryComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 184, 153, -1));

        buttonPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        saveBtn.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        saveBtn.setForeground(new java.awt.Color(255, 255, 255));
        saveBtn.setText("SAVE");
        saveBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        updateBtn.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        updateBtn.setForeground(new java.awt.Color(255, 255, 255));
        updateBtn.setText("UPDATE");
        updateBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        resetBtn.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        resetBtn.setForeground(new java.awt.Color(255, 255, 255));
        resetBtn.setText("RESET");
        resetBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        resetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetBtnActionPerformed(evt);
            }
        });

        deleteBtn.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        deleteBtn.setForeground(new java.awt.Color(255, 255, 255));
        deleteBtn.setText("DELETE");
        deleteBtn.setToolTipText("");
        deleteBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout buttonPanelLayout = new javax.swing.GroupLayout(buttonPanel);
        buttonPanel.setLayout(buttonPanelLayout);
        buttonPanelLayout.setHorizontalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttonPanelLayout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(deleteBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(resetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );
        buttonPanelLayout.setVerticalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(saveBtn)
                .addGap(18, 18, 18)
                .addComponent(updateBtn)
                .addGap(18, 18, 18)
                .addComponent(resetBtn)
                .addGap(18, 18, 18)
                .addComponent(deleteBtn)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        tablePanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        clientTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Reg Number", "First Name", "Last Name", "Phone Number", "Email Address", "Client Category", "Image"
            }
        ));
        clientTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clientTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(clientTable);

        javax.swing.GroupLayout tablePanelLayout = new javax.swing.GroupLayout(tablePanel);
        tablePanel.setLayout(tablePanelLayout);
        tablePanelLayout.setHorizontalGroup(
            tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 904, Short.MAX_VALUE)
        );
        tablePanelLayout.setVerticalGroup(
            tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
        );

        imagePanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        imagePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        imagePanel.add(imageLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 3, 190, 220));

        BrowseImageBtn.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        BrowseImageBtn.setText("Browse Image");
        BrowseImageBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BrowseImageBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BrowseImageBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(417, 417, 417)
                        .addComponent(TitleLabel))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(inputsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BrowseImageBtn)
                            .addComponent(imageFilePathTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addComponent(imagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(tablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(TitleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inputsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(BrowseImageBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(imageFilePathTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(buttonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(imagePanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //CODE FOR SAVE BUTTON
    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        client = new Client();
        
        client.setRegistrationNumber( regNoTxtField.getText());
        client.setFirstName(fnameTxtField.getText());
        client.setLastName(lnameTxtField.getText());
        client.setPhoneNumber(phoneTxtField.getText());
        client.setEmail(emailTxtField.getText());
        if (clientCategoryComboBox.getSelectedItem().toString().equalsIgnoreCase("Student")) {
            client.setClientCategory(ClientType.Student);
        } else if (clientCategoryComboBox.getSelectedItem().toString().equalsIgnoreCase("Staff")){
            client.setClientCategory(ClientType.Staff);
        }
        client.setImage(person_image);
        
        clientDao.save(client);
        getClientListFromDao();
        displayClientsInTable();
        resetInputs();
        
        JOptionPane.showMessageDialog(this, "Saved Client Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_saveBtnActionPerformed

    //What happens when we click on browse image.
    private void BrowseImageBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BrowseImageBtnActionPerformed
        JFileChooser imageChooser = new JFileChooser();
        imageChooser.showOpenDialog(null);
        selectedImage = imageChooser.getSelectedFile();
        thePathOfTheImage = selectedImage.getAbsolutePath();
        imageFilePathTxtField.setText(thePathOfTheImage);
        theimage = new File(thePathOfTheImage);
       
        convertImageFileIntoByteArray(theimage);
        displaySelectedImage(thePathOfTheImage);
    }//GEN-LAST:event_BrowseImageBtnActionPerformed
    
    //Converting the image into BYTE ARRAYS that can be easily saved and retrieved to and from the database.
    public byte[] convertImageFileIntoByteArray(File image) {
        try {
            fileinputstream = new FileInputStream(theimage);
            
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            
            byte[] buf = new byte[2048];
            for(int readNum; (readNum = fileinputstream.read(buf))!=-1;){
                byteArrayOutputStream.write(buf,0,readNum);
            }
            person_image = byteArrayOutputStream.toByteArray();
            
        } catch (IOException ex) {
            Logger.getLogger(ClientView.class.getName()).log(Level.SEVERE, null, ex);
        }
        return person_image;
    }
    
    //Method to display the chosen Image
    public void displaySelectedImage(String thePathOfTheImage1){
        ImageIcon image = new ImageIcon(thePathOfTheImage1);
        Image im = image.getImage();
        Image myImg = im.getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newImage = new ImageIcon(myImg);
        imageLabel.setIcon(newImage);
    }
    
    //Method to display images.
    public void displayImage(byte[] ImagePhotoFileFromDatabase1){
        ImageIcon image = new ImageIcon(ImagePhotoFileFromDatabase);
        Image im = image.getImage();
        Image myImg = im.getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newImage = new ImageIcon(myImg);
        imageLabel.setIcon(newImage);
    }
    
    //CODE FOR UPDATE BUTTON
    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        client = new Client();
        
        client.setRegistrationNumber( regNoTxtField.getText());
        client.setFirstName(fnameTxtField.getText());
        client.setLastName(lnameTxtField.getText());
        client.setPhoneNumber(phoneTxtField.getText());
        client.setEmail(emailTxtField.getText());
        if (clientCategoryComboBox.getSelectedItem().toString().equalsIgnoreCase("student")) {
            client.setClientCategory(ClientType.Student);
        } else if (clientCategoryComboBox.getSelectedItem().toString().equalsIgnoreCase("staff")){
            client.setClientCategory(ClientType.Staff);
        }
        person_image=imageFilePathTxtField.getText().getBytes();
        client.setImage(person_image);
                
        clientDao.update(client);
        getClientListFromDao();
        displayClientsInTable();
        resetInputs();
        
        JOptionPane.showMessageDialog(this, "Updated Client Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_updateBtnActionPerformed

    //CODE FOR DELETE BUTTON
    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        client = new Client();
        
        client.setRegistrationNumber( regNoTxtField.getText());
        client.setFirstName(fnameTxtField.getText());
        client.setLastName(lnameTxtField.getText());
        client.setPhoneNumber(phoneTxtField.getText());
        client.setEmail(emailTxtField.getText());
        if (clientCategoryComboBox.getSelectedItem().toString().equalsIgnoreCase("student")) {
            client.setClientCategory(ClientType.Student);
        } else if (clientCategoryComboBox.getSelectedItem().toString().equalsIgnoreCase("staff")){
            client.setClientCategory(ClientType.Staff);
        }
        person_image=imageFilePathTxtField.getText().getBytes();
        client.setImage(person_image);
        
        clientDao.delete(client);
        getClientListFromDao();
        displayClientsInTable();
        resetInputs();
        
        JOptionPane.showMessageDialog(this, "Client Deleted Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_deleteBtnActionPerformed

    //WHEN WE CLICK ON RESET BUTTON
    private void resetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetBtnActionPerformed
        resetInputs();
    }//GEN-LAST:event_resetBtnActionPerformed

    //WHAT HAPPENS WHEN WE CLICK ON A TABLE ROW
    private void clientTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clientTableMouseClicked
        model = (DefaultTableModel) clientTable.getModel();
        int selectedRow = clientTable.getSelectedRow();
        
        regNoTxtField.setText(model.getValueAt(selectedRow, 0).toString());
        fnameTxtField.setText(model.getValueAt(selectedRow, 1).toString());
        lnameTxtField.setText(model.getValueAt(selectedRow, 2).toString());
        phoneTxtField.setText(model.getValueAt(selectedRow, 3).toString());
        emailTxtField.setText(model.getValueAt(selectedRow, 4).toString());
        clientCategoryComboBox.setSelectedItem(model.getValueAt(selectedRow, 5).toString());
        imageFilePathTxtField.setText(model.getValueAt(selectedRow, 6).toString());
        ImagePhotoFileFromDatabase = (byte[]) model.getValueAt(selectedRow, 6);
        
        displayImage(ImagePhotoFileFromDatabase);
        
    }//GEN-LAST:event_clientTableMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BrowseImageBtn;
    private javax.swing.JLabel TitleLabel;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JComboBox<String> clientCategoryComboBox;
    private javax.swing.JTable clientTable;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JTextField emailTxtField;
    private javax.swing.JTextField fnameTxtField;
    private javax.swing.JTextField imageFilePathTxtField;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JPanel imagePanel;
    private javax.swing.JPanel inputsPanel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField lnameTxtField;
    private javax.swing.JTextField phoneTxtField;
    private javax.swing.JTextField regNoTxtField;
    private javax.swing.JButton resetBtn;
    private javax.swing.JButton saveBtn;
    private javax.swing.JPanel tablePanel;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}
