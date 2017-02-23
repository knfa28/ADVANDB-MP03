package view;

import controller.Controller;
import java.util.ArrayList;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import model.TransactionQuery;
import network.Client;

public class AppView extends javax.swing.JFrame {
    private Controller control;
    private DefaultTableModel queryModel;
    
    public AppView(Controller control) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {}
        
        this.control = control;
        initComponents();
        queryTable.setAutoCreateRowSorter(true);
        queryModel = (DefaultTableModel) queryTable.getModel();
        
        this.setResizable(false);
        setLocationRelativeTo(null);  
        setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    
    public void updateTable(ArrayList<TransactionQuery> list){
        Object temp[];
        
        queryModel.getDataVector().removeAllElements();
        queryModel.fireTableDataChanged();
        
        for(int i = 0; i < list.size(); i++) {
            temp = new Object[]{list.get(i).getId(),
                                list.get(i).getMem(),
                                list.get(i).getSex(),
                                list.get(i).getAge(),
                                list.get(i).getReason(),
                                list.get(i).getOthers()};
            
            queryModel.addRow(temp);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        centralNodeBtn = new javax.swing.JRadioButton();
        palawanNodeBtn = new javax.swing.JRadioButton();
        marinduqueNodeBtn = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        centralStatus = new javax.swing.JLabel();
        palawanStatus = new javax.swing.JLabel();
        marinduqueStatus = new javax.swing.JLabel();
        startBtn = new javax.swing.JButton();
        refreshBtn = new javax.swing.JButton();
        stopBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        queryTable = new javax.swing.JTable();
        updateQueryBtn = new javax.swing.JButton();
        palawanQueryBtn = new javax.swing.JRadioButton();
        marinduqueQueryBtn = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        palawanDBBtn = new javax.swing.JRadioButton();
        marinduqueDBBtn = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        selectBtn = new javax.swing.JRadioButton();
        updateBtn = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        listedUpdateCombo = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        listedUpdateBtn = new javax.swing.JRadioButton();
        othersUpdateBtn = new javax.swing.JRadioButton();
        othersUpdateText = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        deleteBtn = new javax.swing.JRadioButton();
        insertBtn = new javax.swing.JRadioButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        listedInsertBtn = new javax.swing.JRadioButton();
        othersInsertBtn = new javax.swing.JRadioButton();
        othersInsertText = new javax.swing.JTextField();
        listedInsertCombo = new javax.swing.JComboBox();
        hhInsertText = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        sexInsertCombo = new javax.swing.JComboBox();
        ageInsertText = new javax.swing.JTextField();
        startTransactionBtn = new javax.swing.JButton();
        memInsertText = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        isolationCombo = new javax.swing.JComboBox();
        commitCombo = new javax.swing.JComboBox();
        hhSelectText = new javax.swing.JTextField();
        hhDeleteText = new javax.swing.JTextField();
        hhUpdateText = new javax.swing.JTextField();
        memUpdateText = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel1.setText("Database Management System Dashboard");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED), "Node Settings:"));
        jPanel1.setToolTipText("");
        jPanel1.setName(""); // NOI18N

        jLabel2.setText("System Node:");

        centralNodeBtn.setSelected(true);
        centralNodeBtn.setText("Central");
        centralNodeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                centralNodeBtnActionPerformed(evt);
            }
        });

        palawanNodeBtn.setText("Palawan");
        palawanNodeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                palawanNodeBtnActionPerformed(evt);
            }
        });

        marinduqueNodeBtn.setText("Marinduque");
        marinduqueNodeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                marinduqueNodeBtnActionPerformed(evt);
            }
        });

        jLabel3.setText("Connection Status:");

        centralStatus.setText("Disconnected");

        palawanStatus.setText("Disconnected");

        marinduqueStatus.setText("Disconnected");

        startBtn.setText("START");
        startBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startBtnActionPerformed(evt);
            }
        });

        refreshBtn.setText("REFRESH");
        refreshBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshBtnActionPerformed(evt);
            }
        });

        stopBtn.setText("STOP");
        stopBtn.setPreferredSize(new java.awt.Dimension(65, 23));
        stopBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(palawanNodeBtn)
                                    .addComponent(centralNodeBtn)
                                    .addComponent(marinduqueNodeBtn))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(centralStatus)
                            .addComponent(palawanStatus)
                            .addComponent(marinduqueStatus)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(startBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(refreshBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(stopBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(centralNodeBtn)
                    .addComponent(centralStatus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(palawanNodeBtn)
                    .addComponent(palawanStatus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(marinduqueNodeBtn)
                    .addComponent(marinduqueStatus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startBtn)
                    .addComponent(refreshBtn)
                    .addComponent(stopBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED), "Result Set:"));
        jPanel2.setToolTipText("");
        jPanel2.setName(""); // NOI18N
        jPanel2.setPreferredSize(new java.awt.Dimension(12, 200));

        queryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "hpq_hh_id", "mem_id", "mdeadsx", "mdeadage", "mdeady", "mdeady_o"
            }){
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return false;
                }}
            );
            jScrollPane10.setViewportView(queryTable);

            updateQueryBtn.setText("Refresh Result Set");
            updateQueryBtn.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    updateQueryBtnActionPerformed(evt);
                }
            });

            palawanQueryBtn.setText("Palawan");
            palawanQueryBtn.setEnabled(false);
            palawanQueryBtn.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    palawanQueryBtnActionPerformed(evt);
                }
            });

            marinduqueQueryBtn.setText("Marinduque");
            marinduqueQueryBtn.setEnabled(false);
            marinduqueQueryBtn.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    marinduqueQueryBtnActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
            jPanel2.setLayout(jPanel2Layout);
            jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(palawanQueryBtn)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(marinduqueQueryBtn)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
                    .addComponent(updateQueryBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 661, Short.MAX_VALUE))
            );
            jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(updateQueryBtn)
                        .addComponent(palawanQueryBtn)
                        .addComponent(marinduqueQueryBtn))
                    .addGap(0, 0, Short.MAX_VALUE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 31, Short.MAX_VALUE)
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)))
            );

            jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED), "Log Results:"));
            jPanel3.setPreferredSize(new java.awt.Dimension(375, 200));

            jTextArea1.setColumns(20);
            jTextArea1.setRows(5);
            jScrollPane1.setViewportView(jTextArea1);

            javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
            jPanel3.setLayout(jPanel3Layout);
            jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            );
            jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
            );

            jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED), "Transaction Manager:"));

            jLabel4.setText("Default Database:");

            palawanDBBtn.setSelected(true);
            palawanDBBtn.setText("Palawan");
            palawanDBBtn.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    palawanDBBtnActionPerformed(evt);
                }
            });

            marinduqueDBBtn.setText("Marinduque");
            marinduqueDBBtn.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    marinduqueDBBtnActionPerformed(evt);
                }
            });

            jLabel5.setText("Transactions:");

            selectBtn.setText("SELECT");
            selectBtn.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    selectBtnActionPerformed(evt);
                }
            });

            updateBtn.setText("UPDATE");
            updateBtn.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    updateBtnActionPerformed(evt);
                }
            });

            jLabel7.setText("HH:");

            jLabel8.setText("Mem:");

            listedUpdateCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Diseases of the heart",
                "Diseases of the vascular system",
                "Pneumonia",
                "Tuberculosis",
                "Cancer",
                "Diarrhea",
                "Measles",
                "Complication during pregnancy or childbirth",
                "Accident (ex. hit by a vehicle)",
                "Diabetes",
                "Disease of the lungs",
                "Disease of the kidney",
                "Drowned from flood",
                "Victim of landslide",
                "Electrocuted during typhoon",
                "Murder"}));

    jLabel9.setText("Cause:");

    listedUpdateBtn.setText("Listed");
    listedUpdateBtn.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            listedUpdateBtnActionPerformed(evt);
        }
    });

    othersUpdateBtn.setText("Others");
    othersUpdateBtn.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            othersUpdateBtnActionPerformed(evt);
        }
    });

    jLabel10.setText("HH:");

    deleteBtn.setText("DELETE");
    deleteBtn.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            deleteBtnActionPerformed(evt);
        }
    });

    insertBtn.setText("INSERT");
    insertBtn.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            insertBtnActionPerformed(evt);
        }
    });

    jLabel11.setText("HH:");

    jLabel12.setText("Mem:");

    jLabel13.setText("Cause:");

    listedInsertBtn.setText("Listed");
    listedInsertBtn.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            listedInsertBtnActionPerformed(evt);
        }
    });

    othersInsertBtn.setText("Others");
    othersInsertBtn.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            othersInsertBtnActionPerformed(evt);
        }
    });

    listedInsertCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Diseases of the heart",
        "Diseases of the vascular system",
        "Pneumonia",
        "Tuberculosis",
        "Cancer",
        "Diarrhea",
        "Measles",
        "Complication during pregnancy or childbirth",
        "Accident (ex. hit by a vehicle)",
        "Diabetes",
        "Disease of the lungs",
        "Disease of the kidney",
        "Drowned from flood",
        "Victim of landslide",
        "Electrocuted during typhoon",
        "Murder"}));

jLabel14.setText("Age:");

jLabel15.setText("Sex:");

sexInsertCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Male", "Female" }));

startTransactionBtn.setText("Execute");
startTransactionBtn.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) {
    startTransactionBtnActionPerformed(evt);
    }
    });

    jLabel16.setText("HH:");

    isolationCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Read Uncommited", "Read Commited", "Repeatable", "Serealizable" }));

    commitCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Commit", "Rollback" }));

    javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
    jPanel4.setLayout(jPanel4Layout);
    jPanel4Layout.setHorizontalGroup(
        jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel4Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel9)
                                .addComponent(jLabel8)
                                .addComponent(jLabel7))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(listedUpdateBtn)
                                        .addComponent(othersUpdateBtn))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(othersUpdateText)
                                        .addComponent(listedUpdateCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(hhUpdateText, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(memUpdateText, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(0, 0, Short.MAX_VALUE))))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGap(2, 2, 2)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel12)
                                        .addComponent(jLabel13)
                                        .addComponent(jLabel11))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(listedInsertBtn)
                                                .addComponent(othersInsertBtn))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(listedInsertCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(othersInsertText)))
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(hhInsertText, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(memInsertText, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel4Layout.createSequentialGroup()
                                                    .addGap(2, 2, 2)
                                                    .addComponent(jLabel14))
                                                .addComponent(jLabel15))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(ageInsertText)
                                                .addComponent(sexInsertCombo, 0, 82, Short.MAX_VALUE)))))
                                .addComponent(insertBtn)))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(marinduqueDBBtn)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(deleteBtn)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel10)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(hhDeleteText, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(updateBtn)
                                .addComponent(palawanDBBtn)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(selectBtn)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel16)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(hhSelectText, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addGap(10, 10, 10))
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(startTransactionBtn))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(isolationCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(commitCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addContainerGap())))
    );
    jPanel4Layout.setVerticalGroup(
        jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(isolationCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(commitCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel4)
                .addComponent(startTransactionBtn))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(palawanDBBtn)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(marinduqueDBBtn)
            .addGap(7, 7, 7)
            .addComponent(jLabel5)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(hhSelectText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(selectBtn))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel10)
                .addComponent(deleteBtn)
                .addComponent(hhDeleteText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(updateBtn)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel7)
                .addComponent(hhUpdateText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel8)
                .addComponent(memUpdateText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(listedUpdateBtn)
                .addComponent(listedUpdateCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel9))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(othersUpdateBtn)
                .addComponent(othersUpdateText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(insertBtn)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(hhInsertText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel14)
                                .addComponent(ageInsertText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel15))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGap(23, 23, 23)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12)
                                    .addComponent(memInsertText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(sexInsertCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(listedInsertBtn)
                        .addComponent(listedInsertCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(othersInsertBtn)
                        .addComponent(othersInsertText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addContainerGap())
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                        .addComponent(jSeparator1))
                    .addGap(14, 14, 14))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE))
            .addContainerGap())
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addContainerGap())
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startBtnActionPerformed
              
        if(centralNodeBtn.isSelected()){
            control.configSlaves(true, null);
            centralStatus.setText("Running");
            
            if(control.isPalConnected())
                palawanStatus.setText("Connected");
            else palawanStatus.setText("Disconnected");
            
            if(control.isMarConnected())
                marinduqueStatus.setText("Connected");
            else marinduqueStatus.setText("Disconnected");
            
            palawanQueryBtn.setEnabled(true);
            palawanQueryBtn.setSelected(true);
            marinduqueQueryBtn.setEnabled(true);
            marinduqueQueryBtn.setSelected(false);
            
        } else if(palawanNodeBtn.isSelected()){ 
            control.configSlaves(false, "master-2");
            
            palawanStatus.setText("Running");
            
            if(control.isCentralConnected())
                centralStatus.setText("Connected");
            else centralStatus.setText("Disconnected");
            
            marinduqueStatus.setText("N/A");
            
            palawanQueryBtn.setEnabled(true);
            palawanQueryBtn.setSelected(true);
            marinduqueQueryBtn.setEnabled(false);
            marinduqueQueryBtn.setSelected(false);
            
        } else if(marinduqueNodeBtn.isSelected()){
            control.configSlaves(false, "master-3");
                       
            marinduqueStatus.setText("Running");
            
            if(control.isCentralConnected())
                centralStatus.setText("Connected");
            else centralStatus.setText("Disconnected");
            
            palawanStatus.setText("N/A");
            
            palawanQueryBtn.setEnabled(false);
            palawanQueryBtn.setSelected(false);
            marinduqueQueryBtn.setEnabled(true);
            marinduqueQueryBtn.setSelected(true);
            
        }
        control.startServer();
    }//GEN-LAST:event_startBtnActionPerformed

    private void startTransactionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startTransactionBtnActionPerformed
        String node = "";
        int isolationType = isolationCombo.getSelectedIndex();
        int commitType = commitCombo.getSelectedIndex();
        ArrayList<Integer> params = new ArrayList<Integer>();
        String others = "";
        Client client = null;
        boolean isGlobal = false;
        
        if(control.isCentral()){
            if(palawanDBBtn.isSelected()){
                node = "master-2";
                client = control.startPalawanClient();
                
            }
            else if(marinduqueDBBtn.isSelected()){    
                node = "master-3";
                client = control.startMarinduqueClient();
            }         
        } else if (palawanNodeBtn.isSelected() && marinduqueDBBtn.isSelected()){
            node = "master-3";
            client = control.startCentralClient();
            isGlobal = true;
        } else if(marinduqueNodeBtn.isSelected() && palawanDBBtn.isSelected()){
            node = "master-2";
            client = control.startCentralClient();
            isGlobal = true;
        } else {
            node = control.getLocalNode();
            client = control.startCentralClient();
        }
        
        if(selectBtn.isSelected()){
            params.add(Integer.parseInt(hhSelectText.getText()));
            
            control.startTransaction(node, isolationType, commitType, 1, params, null, client, isGlobal);
        } else if(deleteBtn.isSelected()){
            params.add(Integer.parseInt(hhDeleteText.getText()));
            
            control.startTransaction(node, isolationType, commitType, 2, params, null, client, isGlobal);
        } else if(updateBtn.isSelected()){
            params.add(Integer.parseInt(hhUpdateText.getText()));
            params.add(Integer.parseInt(memUpdateText.getText()));
            
            if(listedUpdateBtn.isSelected()){
                params.add(1);
                params.add(listedUpdateCombo.getSelectedIndex() + 1);
                
                control.startTransaction(node, isolationType, commitType, 3, params, null, client, isGlobal);
            } else if(othersUpdateBtn.isSelected()){
                params.add(0);
                others = othersUpdateText.getText();
                
                control.startTransaction(node, isolationType, commitType, 3, params, others, client, isGlobal);
            }
        } else if(insertBtn.isSelected()){
            params.add(Integer.parseInt(hhInsertText.getText()));
            params.add(Integer.parseInt(memInsertText.getText()));
            params.add(sexInsertCombo.getSelectedIndex() + 1);
            params.add(Integer.parseInt(ageInsertText.getText()));
            
            if(listedInsertBtn.isSelected()){
                params.add(1);
                params.add(listedInsertCombo.getSelectedIndex() + 1);
                
                control.startTransaction(node, isolationType, commitType, 4, params, null, client, isGlobal);
            } else if(othersInsertBtn.isSelected()){
                params.add(0);
                others = othersInsertText.getText();
                
                control.startTransaction(node, isolationType, commitType, 4, params, others, client, isGlobal);
            }
        } 
    }//GEN-LAST:event_startTransactionBtnActionPerformed

    private void centralNodeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_centralNodeBtnActionPerformed
        if(centralNodeBtn.isSelected()){
            palawanNodeBtn.setSelected(false);
            marinduqueNodeBtn.setSelected(false);
        }
    }//GEN-LAST:event_centralNodeBtnActionPerformed

    private void palawanNodeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_palawanNodeBtnActionPerformed
        if(palawanNodeBtn.isSelected()){
            centralNodeBtn.setSelected(false);
            marinduqueNodeBtn.setSelected(false);
        }
    }//GEN-LAST:event_palawanNodeBtnActionPerformed

    private void marinduqueNodeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_marinduqueNodeBtnActionPerformed
        if(marinduqueNodeBtn.isSelected()){
            centralNodeBtn.setSelected(false);
            palawanNodeBtn.setSelected(false);
        }
    }//GEN-LAST:event_marinduqueNodeBtnActionPerformed

    private void palawanDBBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_palawanDBBtnActionPerformed
        if(palawanDBBtn.isSelected()){
            marinduqueDBBtn.setSelected(false);
        }
    }//GEN-LAST:event_palawanDBBtnActionPerformed

    private void marinduqueDBBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_marinduqueDBBtnActionPerformed
        if(marinduqueDBBtn.isSelected()){
            palawanDBBtn.setSelected(false);
        }
    }//GEN-LAST:event_marinduqueDBBtnActionPerformed

    private void selectBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectBtnActionPerformed
        if(selectBtn.isSelected()){
            updateBtn.setSelected(false);
            insertBtn.setSelected(false);
            deleteBtn.setSelected(false);
        }
    }//GEN-LAST:event_selectBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        if(deleteBtn.isSelected()){
            updateBtn.setSelected(false);
            insertBtn.setSelected(false);
            selectBtn.setSelected(false);
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        if(updateBtn.isSelected()){
            deleteBtn.setSelected(false);
            insertBtn.setSelected(false);
            selectBtn.setSelected(false);
        }
    }//GEN-LAST:event_updateBtnActionPerformed

    private void insertBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertBtnActionPerformed
        if(insertBtn.isSelected()){
            deleteBtn.setSelected(false);
            updateBtn.setSelected(false);
            selectBtn.setSelected(false);
        }
    }//GEN-LAST:event_insertBtnActionPerformed

    private void listedUpdateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listedUpdateBtnActionPerformed
        if(listedUpdateBtn.isSelected()){
            othersUpdateBtn.setSelected(false);
        }
    }//GEN-LAST:event_listedUpdateBtnActionPerformed

    private void othersUpdateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_othersUpdateBtnActionPerformed
        if(othersUpdateBtn.isSelected()){
            listedUpdateBtn.setSelected(false);
        }
    }//GEN-LAST:event_othersUpdateBtnActionPerformed

    private void listedInsertBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listedInsertBtnActionPerformed
        if(listedInsertBtn.isSelected()){
            othersInsertBtn.setSelected(false);
        }
    }//GEN-LAST:event_listedInsertBtnActionPerformed

    private void othersInsertBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_othersInsertBtnActionPerformed
        if(othersInsertBtn.isSelected()){
            listedInsertBtn.setSelected(false);
        }
    }//GEN-LAST:event_othersInsertBtnActionPerformed

    private void refreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshBtnActionPerformed
        control.checkConnection();
        
        if(control.isCentral()){
            if(control.isPalConnected())
                palawanStatus.setText("Connected");
            else palawanStatus.setText("Disconnected");
            
            if(control.isMarConnected())
                marinduqueStatus.setText("Connected");
            else marinduqueStatus.setText("Disconnected");
        } else {
            if(control.isCentralConnected())
                centralStatus.setText("Connected");
            else centralStatus.setText("Disconnected");
        }
            
    }//GEN-LAST:event_refreshBtnActionPerformed

    private void stopBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopBtnActionPerformed
        control.stopSlaves();
        
        if(control.isCentral()){
            centralStatus.setText("Stopped");
            
            if(control.isPalConnected())
                palawanStatus.setText("Connected");
            else palawanStatus.setText("Disconnected");
            
            if(control.isMarConnected())
                marinduqueStatus.setText("Connected");
            else marinduqueStatus.setText("Disconnected");
            
        } else if(control.getLocalNode().equals("master-2")){ 
            palawanStatus.setText("Stopped");
            
            if(control.isCentralConnected())
                centralStatus.setText("Connected");
            else centralStatus.setText("Disconnected");
           
        } else if(control.getLocalNode().equals("master-3")){ 
            marinduqueStatus.setText("Stopped");
            
            if(control.isCentralConnected())
                centralStatus.setText("Connected");
            else centralStatus.setText("Disconnected");
        }
    }//GEN-LAST:event_stopBtnActionPerformed

    private void updateQueryBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateQueryBtnActionPerformed
        if(control.isCentral()){
            if(palawanQueryBtn.isSelected())
                control.updateTable("master-2");
            else if(marinduqueQueryBtn.isSelected()) control.updateTable("master-3");
        } else control.updateTable(control.getLocalNode());
    }//GEN-LAST:event_updateQueryBtnActionPerformed

    private void palawanQueryBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_palawanQueryBtnActionPerformed
        if(palawanQueryBtn.isSelected())
            marinduqueQueryBtn.setSelected(false);
    }//GEN-LAST:event_palawanQueryBtnActionPerformed

    private void marinduqueQueryBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_marinduqueQueryBtnActionPerformed
        if(marinduqueQueryBtn.isSelected())
            palawanQueryBtn.setSelected(false);
    }//GEN-LAST:event_marinduqueQueryBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ageInsertText;
    private javax.swing.JRadioButton centralNodeBtn;
    private javax.swing.JLabel centralStatus;
    private javax.swing.JComboBox commitCombo;
    private javax.swing.JRadioButton deleteBtn;
    private javax.swing.JTextField hhDeleteText;
    private javax.swing.JTextField hhInsertText;
    private javax.swing.JTextField hhSelectText;
    private javax.swing.JTextField hhUpdateText;
    private javax.swing.JRadioButton insertBtn;
    private javax.swing.JComboBox isolationCombo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JRadioButton listedInsertBtn;
    private javax.swing.JComboBox listedInsertCombo;
    private javax.swing.JRadioButton listedUpdateBtn;
    private javax.swing.JComboBox listedUpdateCombo;
    private javax.swing.JRadioButton marinduqueDBBtn;
    private javax.swing.JRadioButton marinduqueNodeBtn;
    private javax.swing.JRadioButton marinduqueQueryBtn;
    private javax.swing.JLabel marinduqueStatus;
    private javax.swing.JTextField memInsertText;
    private javax.swing.JTextField memUpdateText;
    private javax.swing.JRadioButton othersInsertBtn;
    private javax.swing.JTextField othersInsertText;
    private javax.swing.JRadioButton othersUpdateBtn;
    private javax.swing.JTextField othersUpdateText;
    private javax.swing.JRadioButton palawanDBBtn;
    private javax.swing.JRadioButton palawanNodeBtn;
    private javax.swing.JRadioButton palawanQueryBtn;
    private javax.swing.JLabel palawanStatus;
    private javax.swing.JTable queryTable;
    private javax.swing.JButton refreshBtn;
    private javax.swing.JRadioButton selectBtn;
    private javax.swing.JComboBox sexInsertCombo;
    private javax.swing.JButton startBtn;
    private javax.swing.JButton startTransactionBtn;
    private javax.swing.JButton stopBtn;
    private javax.swing.JRadioButton updateBtn;
    private javax.swing.JButton updateQueryBtn;
    // End of variables declaration//GEN-END:variables
}
