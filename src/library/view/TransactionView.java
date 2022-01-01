package library.view;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import library.controller.GenericDao;
import library.model.Book;
import library.model.Client;
import library.model.Transactions;
//THE BELLOW FILES ARE THE FILES FROM THE POI FOLDER OF JAR FILES.
//IN CASE THEY ARE SHOWING ERRORS, PLEASE MAKE SURE YOU PUT FILES IN THE POI FOLDER IN THE PROJECT FILES.
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.VerticalAlignment;


public class TransactionView extends javax.swing.JInternalFrame {

    List<Transactions> operationList;
    List<Book> bookList;
    List<Client>  clientList;
    
    Book book = new Book();
    Client client = new Client();
    Transactions operations = new Transactions();
    
    GenericDao<Transactions> operationDao = new GenericDao(Transactions.class);
    GenericDao<Book> bookDao = new GenericDao(Book.class);
    GenericDao<Client> clientDao = new GenericDao(Client.class);
    
    DefaultTableModel model;
    
    public TransactionView() {
        initComponents();
        getOperationListFromDao();
        getListOfClientsFromDao();
        getListOfBooksFromDao();
        displayOperationsInTable(operationList);
        updateBookNameComboBox();
        updateClientNameComboBox();
    }

    public void getOperationListFromDao() {
        operationList = operationDao.retrieveAll(operations);
    }
    
    public void getListOfBooksFromDao() {
        bookList= bookDao.retrieveAll(book);
    }

    public void getListOfClientsFromDao() {
        clientList= clientDao.retrieveAll(client);
    }
    
    public void displayOperationsInTable(List<Transactions> transactions) {
        model = (DefaultTableModel) bookTransactionTable.getModel();
        model.setRowCount(0);

        for (Transactions anOperation : operationList) {
            model.addRow(new Object[]{
                anOperation.getOperationNumber(),
                anOperation.getTransactionType(),
                anOperation.getClientName(),
                anOperation.getBook(),
                anOperation.getTransactionDate(),
                anOperation.getReturnDate()
            });
        }
    }
    
    public void updateBookNameComboBox(){
        bookNameComboBox.removeAllItems();
        
        bookList.forEach((Book bk)->{
            bookNameComboBox.addItem(bk.getTitle());
        });
    }

    public void updateClientNameComboBox(){
        clientNameComboBox.removeAllItems();
        
        clientList.forEach((Client cl)->{
            clientNameComboBox.addItem(cl.getFirstName()+" "+cl.getLastName());
        });
    }
    
    public void resetInputs(){
        transactionTypeComboBox.setSelectedIndex(0);
        clientNameComboBox.setSelectedIndex(0);
        bookNameComboBox.setSelectedIndex(0);
        transactionDateDateChooser.setDate(null);
        returnDateDateChooser.setDate(null);
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
        transactionTypeComboBox = new javax.swing.JComboBox<>();
        clientNameComboBox = new javax.swing.JComboBox<>();
        bookNameComboBox = new javax.swing.JComboBox<>();
        transactionDateDateChooser = new com.toedter.calendar.JDateChooser();
        returnDateDateChooser = new com.toedter.calendar.JDateChooser();
        searchBoxPanel = new javax.swing.JPanel();
        searchBtn = new javax.swing.JButton();
        searchTextField = new javax.swing.JTextField();
        tablePanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        bookTransactionTable = new javax.swing.JTable();
        buttonPanel = new javax.swing.JPanel();
        saveBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        resetBtn = new javax.swing.JButton();
        deleteBtnBk = new javax.swing.JButton();
        exportPdfBtn = new javax.swing.JButton();
        exportExcelBtn = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Operations");

        TitleLabel.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        TitleLabel.setText("OPERATIONS");

        inputsPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel2.setText("Transaction Type");

        jLabel3.setText("Client");

        jLabel4.setText("Book");

        jLabel5.setText("Transaction Date");

        jLabel6.setText("Return Date");

        transactionTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BORROW", "RETURN" }));

        javax.swing.GroupLayout inputsPanelLayout = new javax.swing.GroupLayout(inputsPanel);
        inputsPanel.setLayout(inputsPanelLayout);
        inputsPanelLayout.setHorizontalGroup(
            inputsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(inputsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(38, 38, 38)
                .addGroup(inputsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(transactionTypeComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(clientNameComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bookNameComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(transactionDateDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                    .addComponent(returnDateDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        inputsPanelLayout.setVerticalGroup(
            inputsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(inputsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(transactionTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(inputsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(clientNameComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(inputsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(bookNameComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(inputsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(transactionDateDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(inputsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(returnDateDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        searchBoxPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        searchBtn.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        searchBtn.setText("SEARCH");
        searchBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout searchBoxPanelLayout = new javax.swing.GroupLayout(searchBoxPanel);
        searchBoxPanel.setLayout(searchBoxPanelLayout);
        searchBoxPanelLayout.setHorizontalGroup(
            searchBoxPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchBoxPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(searchBoxPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchBoxPanelLayout.createSequentialGroup()
                        .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(searchBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        searchBoxPanelLayout.setVerticalGroup(
            searchBoxPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchBoxPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tablePanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        bookTransactionTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Operation Number", "Transaction Type ", "Client", "Book", "Transaction Date", "Return Date"
            }
        ));
        bookTransactionTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bookTransactionTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(bookTransactionTable);

        javax.swing.GroupLayout tablePanelLayout = new javax.swing.GroupLayout(tablePanel);
        tablePanel.setLayout(tablePanelLayout);
        tablePanelLayout.setHorizontalGroup(
            tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        tablePanelLayout.setVerticalGroup(
            tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tablePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE))
        );

        buttonPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        saveBtn.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        saveBtn.setText("SAVE");
        saveBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        updateBtn.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        updateBtn.setText("UPDATE");
        updateBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        resetBtn.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        resetBtn.setText("RESET");
        resetBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        resetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetBtnActionPerformed(evt);
            }
        });

        deleteBtnBk.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        deleteBtnBk.setText("DELETE");
        deleteBtnBk.setToolTipText("");
        deleteBtnBk.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteBtnBk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnBkActionPerformed(evt);
            }
        });

        exportPdfBtn.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        exportPdfBtn.setText("Export PDF");
        exportPdfBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exportPdfBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportPdfBtnActionPerformed(evt);
            }
        });

        exportExcelBtn.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        exportExcelBtn.setText("Export EXCEL");
        exportExcelBtn.setToolTipText("");
        exportExcelBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exportExcelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportExcelBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout buttonPanelLayout = new javax.swing.GroupLayout(buttonPanel);
        buttonPanel.setLayout(buttonPanelLayout);
        buttonPanelLayout.setHorizontalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttonPanelLayout.createSequentialGroup()
                .addContainerGap(62, Short.MAX_VALUE)
                .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(exportPdfBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(resetBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(updateBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(exportExcelBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deleteBtnBk, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
        );
        buttonPanelLayout.setVerticalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(updateBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(saveBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(resetBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deleteBtnBk, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exportPdfBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exportExcelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(371, 371, 371)
                .addComponent(TitleLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(inputsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchBoxPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(tablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(inputsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(TitleLabel)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(searchBoxPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        String transactionType = transactionTypeComboBox.getSelectedItem().toString();
        String clientNames = clientNameComboBox.getSelectedItem().toString();
        String bookTitle = bookNameComboBox.getSelectedItem().toString();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String transactionDate = dateFormat.format(transactionDateDateChooser.getDate());
        String returnDate = dateFormat.format(returnDateDateChooser.getDate());
        
        operations.setTransactionType(transactionType);
        operations.setClientName(clientNames);
        operations.setBook(bookTitle);
        operations.setTransactionDate(transactionDate);
        operations.setReturnDate(returnDate);
        
        operationDao.save(operations);
        
        getOperationListFromDao();
        displayOperationsInTable(operationList);
        resetInputs();
        JOptionPane.showMessageDialog(this, "Transaction Saved", "Success", JOptionPane.INFORMATION_MESSAGE);                
    }//GEN-LAST:event_saveBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        String transactionType = transactionTypeComboBox.getSelectedItem().toString();
        String clientNames = clientNameComboBox.getSelectedItem().toString();
        String bookTitle = bookNameComboBox.getSelectedItem().toString();        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String transactionDate = dateFormat.format(transactionDateDateChooser.getDate());
        String returnDate = dateFormat.format(returnDateDateChooser.getDate());
        
        operations.setTransactionType(transactionType);
        operations.setClientName(clientNames);
        operations.setBook(bookTitle);
        operations.setTransactionDate(transactionDate);
        operations.setReturnDate(returnDate);
        
        operationDao.update(operations);

        getOperationListFromDao();
        displayOperationsInTable(operationList);
        resetInputs();
        JOptionPane.showMessageDialog(this, "Transaction Updated", "Success", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_updateBtnActionPerformed

    private void deleteBtnBkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnBkActionPerformed
        String transactionType = transactionTypeComboBox.getSelectedItem().toString();
        String clientNames = clientNameComboBox.getSelectedItem().toString();
        String bookTitle = bookNameComboBox.getSelectedItem().toString();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String transactionDate = dateFormat.format(transactionDateDateChooser.getDate());
        String returnDate = dateFormat.format(returnDateDateChooser.getDate());
        
        operations.setTransactionType(transactionType);
        operations.setClientName(clientNames);
        operations.setBook(bookTitle);
        operations.setTransactionDate(transactionDate);
        operations.setReturnDate(returnDate);
        
        operationDao.delete(operations);

        getOperationListFromDao();
        displayOperationsInTable(operationList);
        resetInputs();
        JOptionPane.showMessageDialog(this, "Transaction Deleted", "Success", JOptionPane.INFORMATION_MESSAGE);        
        
    }//GEN-LAST:event_deleteBtnBkActionPerformed

    private void resetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetBtnActionPerformed
        resetInputs();
    }//GEN-LAST:event_resetBtnActionPerformed

    private void bookTransactionTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookTransactionTableMouseClicked
        try {
            model = (DefaultTableModel) bookTransactionTable.getModel();
            int selectedRow = bookTransactionTable.getSelectedRow();
            
            transactionTypeComboBox.setSelectedItem(model.getValueAt(selectedRow, 1));
            clientNameComboBox.setSelectedItem(model.getValueAt(selectedRow, 2));
            bookNameComboBox.setSelectedItem(model.getValueAt(selectedRow, 3));
            java.util.Date transactionDate = new SimpleDateFormat("yyyy-MM-dd").parse((String)model.getValueAt(selectedRow, 4).toString());
            transactionDateDateChooser.setDate(transactionDate);
            java.util.Date returnDate = new SimpleDateFormat("yyyy-MM-dd").parse((String)model.getValueAt(selectedRow, 5).toString());
            returnDateDateChooser.setDate(returnDate);
            
        } catch (ParseException ex) {
            Logger.getLogger(TransactionView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bookTransactionTableMouseClicked

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        if ("".equals(searchTextField.getText())) {
            JOptionPane.showMessageDialog(this, "Nothing to search!","Error",JOptionPane.ERROR_MESSAGE);
        } else {
            String searchedItem = searchTextField.getText();
            
            List<Transactions> searchResults = operationDao.searchData(searchedItem, operations);            
            
            if (searchResults.isEmpty()) {
                displayOperationsInTable(searchResults);
                resetInputs();
                JOptionPane.showMessageDialog(this, " No result found!!","Result",JOptionPane.ERROR_MESSAGE);
            } else {
                displayOperationsInTable(searchResults);
                resetInputs();
            }
        }
    }//GEN-LAST:event_searchBtnActionPerformed

    private void exportPdfBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportPdfBtnActionPerformed
        try {
            // TODO add your handling code here:
            String path = "/home/hirwa/Downloads/Documents/";
            JFileChooser pdfFile = new JFileChooser();
            pdfFile.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int x = pdfFile.showSaveDialog(this);
            if (x == JFileChooser.APPROVE_OPTION) {
                path = pdfFile.getSelectedFile().getPath();
            }
            
            Document doc = new Document();
            PdfWriter.getInstance(doc, new FileOutputStream(path + "StudentPdfReport.pdf"));
            doc.open();
            PdfPTable pdfTable = new PdfPTable(6);
            //Adding headers
            pdfTable.addCell("Operatoin Number");
            pdfTable.addCell("Transaction Type");
            pdfTable.addCell("Client Name");
            pdfTable.addCell("Book Name");
            pdfTable.addCell("Transaction Date");
            pdfTable.addCell("Return Date");
            
            //Looping the data from JTable to pdf file
            for (int i=0; i< bookTransactionTable.getRowCount(); i++){
                String operationNumber = bookTransactionTable.getValueAt(i, 0).toString();
                String transactionType = bookTransactionTable.getValueAt(i, 1).toString();
                String clientName = bookTransactionTable.getValueAt(i, 2).toString();
                String bookName = bookTransactionTable.getValueAt(i, 3).toString();
                String transactionDate = bookTransactionTable.getValueAt(i, 4).toString();
                String returnDate = bookTransactionTable.getValueAt(i, 5).toString();

                pdfTable.addCell(operationNumber);
                pdfTable.addCell(transactionType);
                pdfTable.addCell(clientName);
                pdfTable.addCell(bookName);
                pdfTable.addCell(transactionDate);
                pdfTable.addCell(returnDate);
            }
            
            doc.add(pdfTable);
            JOptionPane.showMessageDialog(this, "Successfuly exported Pdf Report!!");    
            doc.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TransactionView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(TransactionView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_exportPdfBtnActionPerformed

    private void exportExcelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportExcelBtnActionPerformed
        FileOutputStream out = null;
        try {
            // TODO add your handling code here:
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Sample");
            
            //Heading
            Row heading = sheet.createRow(0);
            heading.createCell(0).setCellValue("Operation Number");
            heading.createCell(1).setCellValue("Transaction Type");
            heading.createCell(2).setCellValue("Client Names");
            heading.createCell(3).setCellValue("Book Title");
            heading.createCell(4).setCellValue("Transaction Date");
            heading.createCell(5).setCellValue("Return Date");

            
            //Setting fonts and text alignment
            for (int i=0;i<=5;i++){
                CellStyle style = workbook.createCellStyle();
                Font font = workbook.createFont();
                font.setBold(true);
                font.setFontName(HSSFFont.FONT_ARIAL);
                
                style.setFont(font);
                style.setVerticalAlignment(VerticalAlignment.CENTER);
                heading.getCell(i).setCellStyle(style);
            }   

            //Adding data to the table
            int numberOfRow=1;//We are starting on the first row.
            
            for (Transactions anOperation: operationDao.retrieveAll(operations)){
                Row row = sheet.createRow(numberOfRow);//Creating data on a row.
                
                Cell fname = row.createCell(0);
                fname.setCellValue(anOperation.getOperationNumber());
                
                Cell lname = row.createCell(1);
                lname.setCellValue(anOperation.getTransactionType());
                
                Cell regno = row.createCell(2);
                regno.setCellValue(anOperation.getClientName());
                
                Cell email = row.createCell(3);
                email.setCellValue(anOperation.getBook());
                
                Cell faculty = row.createCell(4);
                faculty.setCellValue(anOperation.getTransactionDate());
                
                Cell phone = row.createCell(5);
                phone.setCellValue(anOperation.getReturnDate());
                
                numberOfRow++;
            }   
            
            for (int i=0; i<=5; i++){
                sheet.autoSizeColumn(i);
            }   
            
            //Creating the file
            out = new FileOutputStream(new File("/home/hirwa/Downloads/Documents/Report.xlsx"));
            workbook.write(out);
            out.close();
            workbook.close();
            System.out.println("Data Writen successfully!");
            
            JOptionPane.showMessageDialog(this, "Successfully printed Excel file!","Student Registration", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TransactionView.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Can't find the file.", "Student Registration", JOptionPane.ERROR_MESSAGE);
            
        } catch (IOException ex) {
            Logger.getLogger(TransactionView.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Can't Export the file.", "Student Registration", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                out.close();
            } catch (IOException ex) {
                Logger.getLogger(TransactionView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_exportExcelBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TitleLabel;
    private javax.swing.JComboBox<String> bookNameComboBox;
    private javax.swing.JTable bookTransactionTable;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JComboBox<String> clientNameComboBox;
    private javax.swing.JButton deleteBtnBk;
    private javax.swing.JButton exportExcelBtn;
    private javax.swing.JButton exportPdfBtn;
    private javax.swing.JPanel inputsPanel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton resetBtn;
    private com.toedter.calendar.JDateChooser returnDateDateChooser;
    private javax.swing.JButton saveBtn;
    private javax.swing.JPanel searchBoxPanel;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JPanel tablePanel;
    private com.toedter.calendar.JDateChooser transactionDateDateChooser;
    private javax.swing.JComboBox<String> transactionTypeComboBox;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}
