package library.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import library.controller.GenericDao;
import library.model.Book;
import library.model.BookCategory;

public class BookView extends javax.swing.JInternalFrame {

    //Variables and instances
    
    List<Book> bookList;  
    List<BookCategory> bookCategoryList;  
    
    Book book = new Book();
    BookCategory bookCategory = new BookCategory();
    
    GenericDao<Book> bookActions = new GenericDao(Book.class);
    GenericDao<BookCategory> bookCategoryActions = new GenericDao(BookCategory.class);
    
    DefaultTableModel model1;
    DefaultTableModel model2;

    
    //Constructor
    
    public BookView() {
        initComponents();
        retrieveBookList();
        retrieveBookCategoryList();
        displayBooksInTable();
        displayBookCategoriesInTable();
        updateBookCategoryComboBox();
    }

    //My additional Methods
    
    public void retrieveBookList() {
        bookList = bookActions.retrieveAll(book);
    }
    
    public void retrieveBookCategoryList() {
        bookCategoryList = bookCategoryActions.retrieveAll(bookCategory);
    }
    
    private void displayBooksInTable() {
        model1 = (DefaultTableModel) BookTable.getModel();
        model1.setRowCount(0);

        for (Book aBook : bookList) {
            model1.addRow(new Object[]{
                aBook.getBookId(),
                aBook.getTitle(),
                aBook.getAuthor(),
                aBook.getBookCategory(),
                aBook.getPublishingHouse(),
                aBook.getPublicationDate(),
                aBook.getPages(),
                aBook.getAvailable()
            });
        }
    }
    
    private void displayBookCategoriesInTable(){
        model2 = (DefaultTableModel) BookCategoryTable.getModel();
        model2.setRowCount(0);
        
        for (BookCategory aCategry : bookCategoryList) {
            model2.addRow(new Object[]{
                aCategry.getCategoryCode(),
                aCategry.getCategoryName()
            });
        }
    }
    
    public void resetBookTabInputs() {
        bookIdTxtField.setText("");
        bookTitleTxtField.setText("");
        authorTxtField.setText("");
        bookCategoryComboBox.setSelectedIndex(0);
        publicatingHouseTxtField.setText("");
        publicationDateDateChooser.setDate(null);
        pageNumberTxtField.setText("");
        availableOrNotComboBox.setSelectedIndex(0);
    }
    
    public void resetBookCategoryInputs(){
        CategoryCodeTxtField.setText("");
        categoryNameTxtField.setText("");
    }
    
    public void updateBookCategoryComboBox(){
        bookCategoryComboBox.removeAllItems();

        bookCategoryList.forEach((BookCategory bct)->{
            bookCategoryComboBox.addItem(bct.getCategoryName());
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        inputsPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        bookIdTxtField = new javax.swing.JTextField();
        bookTitleTxtField = new javax.swing.JTextField();
        authorTxtField = new javax.swing.JTextField();
        publicatingHouseTxtField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        availableOrNotComboBox = new javax.swing.JComboBox<>();
        publicationDateDateChooser = new com.toedter.calendar.JDateChooser();
        pageNumberTxtField = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        bookCategoryComboBox = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        buttonPanel = new javax.swing.JPanel();
        saveBtnBk = new javax.swing.JButton();
        updateBtnBk = new javax.swing.JButton();
        resetBtnBk = new javax.swing.JButton();
        deleteBtnBk = new javax.swing.JButton();
        tablePanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        BookTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        inputPanel1 = new javax.swing.JPanel();
        CategoryCode = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        CategoryCodeTxtField = new javax.swing.JTextField();
        categoryNameTxtField = new javax.swing.JTextField();
        commandPanel1 = new javax.swing.JPanel();
        saveBtnBkCat = new javax.swing.JButton();
        updateBtnBkCat = new javax.swing.JButton();
        resetBtnBkCat = new javax.swing.JButton();
        deleteBtnBkCat = new javax.swing.JButton();
        presentationPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        BookCategoryTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Books");

        inputsPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        inputsPanel.setForeground(new java.awt.Color(0, 0, 0));

        jLabel2.setText("Book Id");

        jLabel3.setText("Title");

        jLabel4.setText("Author");

        jLabel5.setText("Publishing House");

        jLabel6.setText("Publication Date");

        jLabel7.setText("Pages");

        jLabel8.setText("Available");

        availableOrNotComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Yes", "No" }));

        pageNumberTxtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pageNumberTxtFieldActionPerformed(evt);
            }
        });

        jLabel11.setText("Book Category");

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel9.setText("BOOK CATEGORY");

        javax.swing.GroupLayout inputsPanelLayout = new javax.swing.GroupLayout(inputsPanel);
        inputsPanel.setLayout(inputsPanelLayout);
        inputsPanelLayout.setHorizontalGroup(
            inputsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inputsPanelLayout.createSequentialGroup()
                .addContainerGap(84, Short.MAX_VALUE)
                .addGroup(inputsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addGroup(inputsPanelLayout.createSequentialGroup()
                        .addGroup(inputsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(inputsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(bookIdTxtField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bookTitleTxtField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(authorTxtField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bookCategoryComboBox, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(inputsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(inputsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(inputsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(availableOrNotComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pageNumberTxtField, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(publicatingHouseTxtField, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(publicationDateDateChooser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59))
        );
        inputsPanelLayout.setVerticalGroup(
            inputsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputsPanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel9)
                .addGap(29, 29, 29)
                .addGroup(inputsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(inputsPanelLayout.createSequentialGroup()
                        .addGroup(inputsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(inputsPanelLayout.createSequentialGroup()
                                .addGroup(inputsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(inputsPanelLayout.createSequentialGroup()
                                        .addGroup(inputsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel2)
                                            .addComponent(bookIdTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel3))
                                    .addComponent(bookTitleTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4))
                            .addComponent(authorTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(inputsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bookCategoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)))
                    .addGroup(inputsPanelLayout.createSequentialGroup()
                        .addGroup(inputsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(publicatingHouseTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(15, 15, 15)
                        .addGroup(inputsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(inputsPanelLayout.createSequentialGroup()
                                .addComponent(publicationDateDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(inputsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(pageNumberTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addGap(12, 12, 12)
                                .addGroup(inputsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(availableOrNotComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8)))
                            .addComponent(jLabel6))))
                .addContainerGap(99, Short.MAX_VALUE))
        );

        buttonPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        buttonPanel.setForeground(new java.awt.Color(0, 0, 0));

        saveBtnBk.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        saveBtnBk.setText("SAVE");
        saveBtnBk.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        saveBtnBk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnBkActionPerformed(evt);
            }
        });

        updateBtnBk.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        updateBtnBk.setText("UPDATE");
        updateBtnBk.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        updateBtnBk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnBkActionPerformed(evt);
            }
        });

        resetBtnBk.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        resetBtnBk.setText("RESET");
        resetBtnBk.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        resetBtnBk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetBtnBkActionPerformed(evt);
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

        javax.swing.GroupLayout buttonPanelLayout = new javax.swing.GroupLayout(buttonPanel);
        buttonPanel.setLayout(buttonPanelLayout);
        buttonPanelLayout.setHorizontalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttonPanelLayout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(deleteBtnBk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(resetBtnBk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(updateBtnBk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(saveBtnBk, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );
        buttonPanelLayout.setVerticalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(saveBtnBk, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(updateBtnBk)
                .addGap(18, 18, 18)
                .addComponent(resetBtnBk, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(deleteBtnBk, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(81, Short.MAX_VALUE))
        );

        tablePanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        tablePanel.setForeground(new java.awt.Color(0, 0, 0));

        BookTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book Id", "Title", "Author", "Book Category", "Publishing House", "Publication Date", "Pages", "Available"
            }
        ));
        BookTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BookTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(BookTable);

        javax.swing.GroupLayout tablePanelLayout = new javax.swing.GroupLayout(tablePanel);
        tablePanel.setLayout(tablePanelLayout);
        tablePanelLayout.setHorizontalGroup(
            tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        tablePanelLayout.setVerticalGroup(
            tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(tablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(inputsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inputsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("BOOK", jPanel2);

        inputPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        CategoryCode.setText("Category Code");

        jLabel10.setText("Category Name");

        javax.swing.GroupLayout inputPanel1Layout = new javax.swing.GroupLayout(inputPanel1);
        inputPanel1.setLayout(inputPanel1Layout);
        inputPanel1Layout.setHorizontalGroup(
            inputPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(inputPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(CategoryCode, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(inputPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(CategoryCodeTxtField, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                    .addComponent(categoryNameTxtField))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        inputPanel1Layout.setVerticalGroup(
            inputPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(inputPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(inputPanel1Layout.createSequentialGroup()
                        .addGroup(inputPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CategoryCode)
                            .addComponent(CategoryCodeTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10))
                    .addComponent(categoryNameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        commandPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        saveBtnBkCat.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        saveBtnBkCat.setForeground(new java.awt.Color(255, 255, 255));
        saveBtnBkCat.setText("SAVE");
        saveBtnBkCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnBkCatActionPerformed(evt);
            }
        });

        updateBtnBkCat.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        updateBtnBkCat.setForeground(new java.awt.Color(255, 255, 255));
        updateBtnBkCat.setText("UPDATE");
        updateBtnBkCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnBkCatActionPerformed(evt);
            }
        });

        resetBtnBkCat.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        resetBtnBkCat.setForeground(new java.awt.Color(255, 255, 255));
        resetBtnBkCat.setText("RESET");
        resetBtnBkCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetBtnBkCatActionPerformed(evt);
            }
        });

        deleteBtnBkCat.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        deleteBtnBkCat.setForeground(new java.awt.Color(255, 255, 255));
        deleteBtnBkCat.setText("DELETE");
        deleteBtnBkCat.setToolTipText("");
        deleteBtnBkCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnBkCatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout commandPanel1Layout = new javax.swing.GroupLayout(commandPanel1);
        commandPanel1.setLayout(commandPanel1Layout);
        commandPanel1Layout.setHorizontalGroup(
            commandPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(commandPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(commandPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(resetBtnBkCat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(saveBtnBkCat, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(commandPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(commandPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(updateBtnBkCat, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, commandPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(deleteBtnBkCat, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        commandPanel1Layout.setVerticalGroup(
            commandPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(commandPanel1Layout.createSequentialGroup()
                .addGroup(commandPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(updateBtnBkCat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(saveBtnBkCat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(commandPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(resetBtnBkCat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deleteBtnBkCat, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        presentationPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        BookCategoryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Category Id", "Category Name"
            }
        ));
        BookCategoryTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BookCategoryTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(BookCategoryTable);

        javax.swing.GroupLayout presentationPanel1Layout = new javax.swing.GroupLayout(presentationPanel1);
        presentationPanel1.setLayout(presentationPanel1Layout);
        presentationPanel1Layout.setHorizontalGroup(
            presentationPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        presentationPanel1Layout.setVerticalGroup(
            presentationPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, presentationPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("BOOK CATEGORY");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(presentationPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(inputPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(commandPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(347, 347, 347)
                        .addComponent(jLabel1)))
                .addContainerGap(146, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(inputPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(commandPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(presentationPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        jTabbedPane1.addTab("BOOK CATEGORY", jPanel3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 938, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
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

    private void saveBtnBkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnBkActionPerformed
        String bookId = bookIdTxtField.getText();
        String title = bookTitleTxtField.getText();
        String author = authorTxtField.getText();
        String bookCategory = bookCategoryComboBox.getSelectedItem().toString();
        String publishingHouse = publicatingHouseTxtField.getText();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String publicationDate = dateFormat.format(publicationDateDateChooser.getDate());
        int pages = Integer.parseInt(pageNumberTxtField.getText());
        String available = availableOrNotComboBox.getSelectedItem().toString();
        
        book = new Book(bookId, title, author, bookCategory, publishingHouse, publicationDate, pages, available);
        
        bookActions.save(book);
        
        retrieveBookList();
        displayBooksInTable();
        resetBookTabInputs();
        JOptionPane.showMessageDialog(this, "Book Saved", "Success", JOptionPane.INFORMATION_MESSAGE);
        
    }//GEN-LAST:event_saveBtnBkActionPerformed

    private void updateBtnBkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnBkActionPerformed
        String bookId = bookIdTxtField.getText();
        String title = bookTitleTxtField.getText();
        String author = authorTxtField.getText();
        String bookCategory = bookCategoryComboBox.getSelectedItem().toString();
        String publishingHouse = publicatingHouseTxtField.getText();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String publicationDate = dateFormat.format(publicationDateDateChooser.getDate());
        int pages = Integer.parseInt(pageNumberTxtField.getText());
        String available = availableOrNotComboBox.getSelectedItem().toString();
        
        book = new Book(bookId, title, author, bookCategory, publishingHouse, publicationDate, pages, available);
        
        bookActions.update(book);
        
        retrieveBookList();
        displayBooksInTable();
        resetBookTabInputs();
        JOptionPane.showMessageDialog(this, "Book Updated", "Success", JOptionPane.INFORMATION_MESSAGE);
        
    }//GEN-LAST:event_updateBtnBkActionPerformed

    private void deleteBtnBkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnBkActionPerformed
        String bookId = bookIdTxtField.getText();
        String title = bookTitleTxtField.getText();
        String author = authorTxtField.getText();
        String bookCategory = bookCategoryComboBox.getSelectedItem().toString();
        String publishingHouse = publicatingHouseTxtField.getText();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String publicationDate = dateFormat.format(publicationDateDateChooser.getDate());
        int pages = Integer.parseInt(pageNumberTxtField.getText());
        String available = availableOrNotComboBox.getSelectedItem().toString();
        
        book = new Book(bookId, title, author, bookCategory, publishingHouse, publicationDate, pages, available);
        
        bookActions.delete(book);
        
        retrieveBookList();
        displayBooksInTable();
        resetBookTabInputs();
        JOptionPane.showMessageDialog(this, "Book Deleted", "Success", JOptionPane.INFORMATION_MESSAGE);
        
            }//GEN-LAST:event_deleteBtnBkActionPerformed

    private void resetBtnBkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetBtnBkActionPerformed
        resetBookTabInputs();
    }//GEN-LAST:event_resetBtnBkActionPerformed

    private void saveBtnBkCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnBkCatActionPerformed
        String bookCategoryCode = CategoryCodeTxtField.getText();
        String bookCategoryName = categoryNameTxtField.getText();
        
        bookCategory = new BookCategory(bookCategoryCode, bookCategoryName);
        
        bookCategoryActions.save(bookCategory);
        
        retrieveBookCategoryList();
        displayBookCategoriesInTable();
        resetBookCategoryInputs();
        
        JOptionPane.showMessageDialog(this, "Category Saved", "Success", JOptionPane.INFORMATION_MESSAGE);
        
        updateBookCategoryComboBox();
    }//GEN-LAST:event_saveBtnBkCatActionPerformed

    private void updateBtnBkCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnBkCatActionPerformed
        String bookCategoryCode = CategoryCodeTxtField.getText();
        String bookCategoryName = categoryNameTxtField.getText();
        
        bookCategory = new BookCategory(bookCategoryCode, bookCategoryName);
        
        bookCategoryActions.update(bookCategory);
        
        retrieveBookCategoryList();
        displayBookCategoriesInTable();
        resetBookCategoryInputs();
        
        JOptionPane.showMessageDialog(this, "Category Updated", "Success", JOptionPane.INFORMATION_MESSAGE);
        
        updateBookCategoryComboBox();
    }//GEN-LAST:event_updateBtnBkCatActionPerformed

    private void deleteBtnBkCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnBkCatActionPerformed
        String bookCategoryCode = CategoryCodeTxtField.getText();
        String bookCategoryName = categoryNameTxtField.getText();
        
        bookCategory = new BookCategory(bookCategoryCode, bookCategoryName);
        
        bookCategoryActions.delete(bookCategory);
        
        retrieveBookCategoryList();
        displayBookCategoriesInTable();
        resetBookCategoryInputs();
       
        JOptionPane.showMessageDialog(this, "Category Deleted", "Success", JOptionPane.INFORMATION_MESSAGE);
        
        updateBookCategoryComboBox();
    }//GEN-LAST:event_deleteBtnBkCatActionPerformed

    private void resetBtnBkCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetBtnBkCatActionPerformed
        resetBookCategoryInputs();
    }//GEN-LAST:event_resetBtnBkCatActionPerformed

    private void BookTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BookTableMouseClicked
        try {
            model1 = (DefaultTableModel) BookTable.getModel();
            int selectedRow1 = BookTable.getSelectedRow();
            
            bookIdTxtField.setText(model1.getValueAt(selectedRow1, 0).toString());
            bookTitleTxtField.setText(model1.getValueAt(selectedRow1, 1).toString());
            authorTxtField.setText(model1.getValueAt(selectedRow1, 2).toString());
            bookCategoryComboBox.setSelectedItem(model1.getValueAt(selectedRow1, 3).toString());
            publicatingHouseTxtField.setText(model1.getValueAt(selectedRow1, 4).toString());
            java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String)model1.getValueAt(selectedRow1, 5).toString());
            publicationDateDateChooser.setDate(date);
            pageNumberTxtField.setText(model1.getValueAt(selectedRow1, 6).toString());
            availableOrNotComboBox.setSelectedItem(model1.getValueAt(selectedRow1, 7).toString());
        
        } catch (ParseException ex) {
            Logger.getLogger(BookView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_BookTableMouseClicked

    private void BookCategoryTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BookCategoryTableMouseClicked
        model2 = (DefaultTableModel) BookCategoryTable.getModel();
        int selectedRow2 = BookCategoryTable.getSelectedRow();
        
        CategoryCodeTxtField.setText(model2.getValueAt(selectedRow2, 0).toString());
        categoryNameTxtField.setText(model2.getValueAt(selectedRow2, 1).toString());
        
    }//GEN-LAST:event_BookCategoryTableMouseClicked

    private void pageNumberTxtFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pageNumberTxtFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pageNumberTxtFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable BookCategoryTable;
    private javax.swing.JTable BookTable;
    private javax.swing.JLabel CategoryCode;
    private javax.swing.JTextField CategoryCodeTxtField;
    private javax.swing.JTextField authorTxtField;
    private javax.swing.JComboBox<String> availableOrNotComboBox;
    private javax.swing.JComboBox<String> bookCategoryComboBox;
    private javax.swing.JTextField bookIdTxtField;
    private javax.swing.JTextField bookTitleTxtField;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JTextField categoryNameTxtField;
    private javax.swing.JPanel commandPanel1;
    private javax.swing.JButton deleteBtnBk;
    private javax.swing.JButton deleteBtnBkCat;
    private javax.swing.JPanel inputPanel1;
    private javax.swing.JPanel inputsPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField pageNumberTxtField;
    private javax.swing.JPanel presentationPanel1;
    private javax.swing.JTextField publicatingHouseTxtField;
    private com.toedter.calendar.JDateChooser publicationDateDateChooser;
    private javax.swing.JButton resetBtnBk;
    private javax.swing.JButton resetBtnBkCat;
    private javax.swing.JButton saveBtnBk;
    private javax.swing.JButton saveBtnBkCat;
    private javax.swing.JPanel tablePanel;
    private javax.swing.JButton updateBtnBk;
    private javax.swing.JButton updateBtnBkCat;
    // End of variables declaration//GEN-END:variables
}
