/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package northwayapp;

import java.awt.CardLayout;
import java.awt.Point;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Rashad
 */
public class NorthwayApp extends javax.swing.JFrame {

    /**
     * Creates new form NorthwayApp
     */
    
    int position = 0;
    List<String> fileInfo;
    File quoteFile, clientFile;
    
    //TestQuestion testQ = new TestQuestion();
    Survey survey;
    GUIDrawer drawer;
    ValidationTool validator;
    FileOperator twoFiles;
    String quoteType, agent, lastName, firstName, quoteTypeLabel;
    
    public NorthwayApp() {
        initComponents();
        fileInfo = new ArrayList<>();
        validator = new ValidationTool();
        twoFiles = new FileOperator();
        
        //temporary to work on layout
        /*
        quoteType = "Auto";
        twoFiles.setQuoteSheet(quoteType);
        twoFiles.setFile("Dell", "Doe", "John");
        
        createSurveySpace(twoFiles,
                textPanel, fieldsPanel, navPanel);
        */
    }
    
    // function to create the survey and put it in the correct panels
    public void createSurveySpace(
            FileOperator files,
            JPanel textP, JPanel fieldsP, JPanel navP){
        
        survey  = files.createSurvey();
        try {
            notebookText.setText(files.readNotes());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(NorthwayApp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        CardLayout cl = (CardLayout)cardPanel.getLayout();
        cl.next(cardPanel);
        quoteTypeLabel = quoteType.toUpperCase();
        quoteHeaderLabel.setText(quoteTypeLabel);
        drawer = new GUIDrawer(survey, textP, fieldsP, navP);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        fileCreationErrorDB = new javax.swing.JDialog();
        jLabel6 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        notebook = new javax.swing.JDialog();
        jScrollPane1 = new javax.swing.JScrollPane();
        notebookText = new javax.swing.JTextArea();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        cardPanel = new javax.swing.JPanel();
        tempStartPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        agentName = new javax.swing.JTextField();
        quotePicker = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        clientLastName = new javax.swing.JTextField();
        clientFirstName = new javax.swing.JTextField();
        checkFileButton = new javax.swing.JButton();
        fileExistsField = new javax.swing.JTextField();
        startSurveyButton = new javax.swing.JButton();
        surveyPanel = new javax.swing.JPanel();
        textPanel = new javax.swing.JPanel();
        fieldsPanel = new javax.swing.JPanel();
        navPanel = new javax.swing.JPanel();
        quoteHeaderLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        jLabel6.setText("An Error has occured");

        jButton2.setText("Someday I'll do something");

        javax.swing.GroupLayout fileCreationErrorDBLayout = new javax.swing.GroupLayout(fileCreationErrorDB.getContentPane());
        fileCreationErrorDB.getContentPane().setLayout(fileCreationErrorDBLayout);
        fileCreationErrorDBLayout.setHorizontalGroup(
            fileCreationErrorDBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fileCreationErrorDBLayout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fileCreationErrorDBLayout.createSequentialGroup()
                .addContainerGap(82, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(161, 161, 161))
        );
        fileCreationErrorDBLayout.setVerticalGroup(
            fileCreationErrorDBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fileCreationErrorDBLayout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(156, Short.MAX_VALUE))
        );

        notebook.setAlwaysOnTop(true);
        notebook.setMinimumSize(new java.awt.Dimension(400, 500));

        notebookText.setColumns(20);
        notebookText.setRows(5);
        jScrollPane1.setViewportView(notebookText);

        jButton3.setText("Save");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Save and Close");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout notebookLayout = new javax.swing.GroupLayout(notebook.getContentPane());
        notebook.getContentPane().setLayout(notebookLayout);
        notebookLayout.setHorizontalGroup(
            notebookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(notebookLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, notebookLayout.createSequentialGroup()
                .addContainerGap(210, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addGap(20, 20, 20))
        );
        notebookLayout.setVerticalGroup(
            notebookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(notebookLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(notebookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Title");

        cardPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cardPanel.setLayout(new java.awt.CardLayout());

        jLabel1.setText("Welcome to the Northway Survey Quote Thingamajig");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Please Enter information to find/create a file", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel2.setText("Agent Name");

        jLabel5.setText("Type of Quote");

        agentName.setText("Dell");
        agentName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agentNameActionPerformed(evt);
            }
        });

        quotePicker.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "(Select)", "Auto", "Home" }));
        quotePicker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quotePickerActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Client Information"));

        jLabel3.setText("Last Name");

        jLabel4.setText("First Name");

        clientLastName.setText("Doe");

        clientFirstName.setText("John");
        clientFirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientFirstNameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clientLastName))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clientFirstName)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(clientLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(clientFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        checkFileButton.setText("Check if a file already exists");
        checkFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkFileButtonActionPerformed(evt);
            }
        });

        fileExistsField.setEditable(false);
        fileExistsField.setOpaque(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(agentName, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jLabel5)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(quotePicker, 0, 90, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(checkFileButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fileExistsField)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(agentName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(quotePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkFileButton)
                    .addComponent(fileExistsField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );

        startSurveyButton.setText("Start Survey");
        startSurveyButton.setEnabled(false);
        startSurveyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startSurveyButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tempStartPanelLayout = new javax.swing.GroupLayout(tempStartPanel);
        tempStartPanel.setLayout(tempStartPanelLayout);
        tempStartPanelLayout.setHorizontalGroup(
            tempStartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tempStartPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tempStartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(252, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tempStartPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(startSurveyButton)
                .addContainerGap())
        );
        tempStartPanelLayout.setVerticalGroup(
            tempStartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tempStartPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(startSurveyButton)
                .addContainerGap())
        );

        cardPanel.add(tempStartPanel, "card2");

        surveyPanel.setNextFocusableComponent(fieldsPanel);
        surveyPanel.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                surveyPanelComponentAdded(evt);
            }
        });

        textPanel.setLayout(new javax.swing.BoxLayout(textPanel, javax.swing.BoxLayout.X_AXIS));

        fieldsPanel.setNextFocusableComponent(navPanel);
        fieldsPanel.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                fieldsPanelComponentAdded(evt);
            }
        });

        quoteHeaderLabel.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        quoteHeaderLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        quoteHeaderLabel.setText("Quote Type");

        jButton1.setText("Bring up notepad");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout surveyPanelLayout = new javax.swing.GroupLayout(surveyPanel);
        surveyPanel.setLayout(surveyPanelLayout);
        surveyPanelLayout.setHorizontalGroup(
            surveyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(surveyPanelLayout.createSequentialGroup()
                .addGroup(surveyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, surveyPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(quoteHeaderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, surveyPanelLayout.createSequentialGroup()
                        .addGap(0, 115, Short.MAX_VALUE)
                        .addGroup(surveyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, surveyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(navPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(fieldsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(textPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        surveyPanelLayout.setVerticalGroup(
            surveyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(surveyPanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(quoteHeaderLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(fieldsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(navPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        cardPanel.add(surveyPanel, "card3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void quotePickerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quotePickerActionPerformed
        //sets the quote file if there is a valid selection
        JComboBox cb = (JComboBox)evt.getSource();
        quoteType = String.valueOf(cb.getSelectedItem());
        if(!twoFiles.setQuoteSheet(quoteType)){
            twoFiles.setQuoteSheet(null);
        }
    }//GEN-LAST:event_quotePickerActionPerformed

    private void checkFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkFileButtonActionPerformed
        agent = agentName.getText();
        lastName = clientLastName.getText();
        firstName = clientFirstName.getText();
        startSurveyButton.setEnabled(false);
        //if the quote is selected and file works

        if(twoFiles.validQuote()){
            if(twoFiles.setFile(agent, lastName, firstName)){
                if (twoFiles.fileExists()){
                    startSurveyButton.setText("Continue quote");
                    fileExistsField.setText("File exists");
                    startSurveyButton.setEnabled(true);
                }
                else{
                    //twoFiles.createFile();
                    startSurveyButton.setText("Make a new quote");
                    fileExistsField.setText(twoFiles.getFileName());
                    startSurveyButton.setEnabled(true);
                }
                if(!twoFiles.notesExists()) twoFiles.createNotes();
            }
            else fileExistsField.setText("Please fill in all fields");  
        }


        else fileExistsField.setText("Quote type is not supported");
    }//GEN-LAST:event_checkFileButtonActionPerformed

    private void startSurveyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startSurveyButtonActionPerformed
        if(!twoFiles.fileExists()){
            twoFiles.createFile();
        }
        try{
            createSurveySpace(twoFiles,
                textPanel, fieldsPanel, navPanel);
        }catch(IllegalArgumentException e){
            System.err.println("fileOperator can't make the survey: " + e.getMessage());
            fileCreationErrorDB.getParent().add(fileCreationErrorDB);
        }
    }//GEN-LAST:event_startSurveyButtonActionPerformed

    private void fieldsPanelComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_fieldsPanelComponentAdded
        if(evt.getComponent() instanceof JTextField){
            evt.getComponent().requestFocus();
        }
        evt.getComponent().requestFocus();
    }//GEN-LAST:event_fieldsPanelComponentAdded

    private void surveyPanelComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_surveyPanelComponentAdded
        if(evt.getComponent() instanceof JTextField){
            evt.getComponent().requestFocus();
        }
        evt.getComponent().requestFocus();
    }//GEN-LAST:event_surveyPanelComponentAdded

    private void clientFirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientFirstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clientFirstNameActionPerformed

    private void agentNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agentNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_agentNameActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Point tempPoint = this.getLocation();
        tempPoint.setLocation(tempPoint.getX() + this.getWidth(), tempPoint.getY());
        notebook.setLocation(tempPoint);
        notebook.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            //this is clunky, found it on SOF, but it seems to work well
            notebookText.write(new BufferedWriter(
                    new FileWriter(twoFiles.getNotesFile())));
        } catch (IOException ex) {
            Logger.getLogger(NorthwayApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            //this is clunky, found it on SOF, but it seems to work well
            notebookText.write(new BufferedWriter(
                    new FileWriter(twoFiles.getNotesFile())));
            notebook.setVisible(false);
        } catch (IOException ex) {
            Logger.getLogger(NorthwayApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed
    
    
    
    
    
    
    
    
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
            java.util.logging.Logger.getLogger(NorthwayApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NorthwayApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NorthwayApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NorthwayApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NorthwayApp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField agentName;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel cardPanel;
    private javax.swing.JButton checkFileButton;
    private javax.swing.JTextField clientFirstName;
    private javax.swing.JTextField clientLastName;
    private javax.swing.JPanel fieldsPanel;
    private javax.swing.JDialog fileCreationErrorDB;
    private javax.swing.JTextField fileExistsField;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel navPanel;
    private javax.swing.JDialog notebook;
    private javax.swing.JTextArea notebookText;
    private javax.swing.JLabel quoteHeaderLabel;
    private javax.swing.JComboBox quotePicker;
    private javax.swing.JButton startSurveyButton;
    private javax.swing.JPanel surveyPanel;
    private javax.swing.JPanel tempStartPanel;
    private javax.swing.JPanel textPanel;
    // End of variables declaration//GEN-END:variables

}
