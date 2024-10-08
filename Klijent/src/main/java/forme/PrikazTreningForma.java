/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forme;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Bogdan Blagojevic
 */
public class PrikazTreningForma extends javax.swing.JFrame {

    /**
     * Creates new form PrikazTreningForma
     */
    public PrikazTreningForma() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldTipTreninga = new javax.swing.JTextField();
        jTextFieldDatumTreninga = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTrening = new javax.swing.JTable();
        jButtonPretrazi = new javax.swing.JButton();
        jButtonReset = new javax.swing.JButton();
        jButtonGlavniMeni = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel4.setText("Tip treninga:");

        jLabel5.setText("Datum treninga:");

        jTextFieldDatumTreninga.setText("format: yyyy-MM-dd");

        jTableTrening.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableTrening);

        jButtonPretrazi.setText("Pretrazi");

        jButtonReset.setText("Resetuj pretragu");

        jButtonGlavniMeni.setText("Glavni meni");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 766, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldTipTreninga, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                            .addComponent(jTextFieldDatumTreninga))
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonReset, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonPretrazi)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 256, Short.MAX_VALUE)
                                .addComponent(jButtonGlavniMeni)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextFieldTipTreninga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonPretrazi)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonGlavniMeni)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextFieldDatumTreninga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jButtonReset)))
                .addGap(78, 78, 78)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public JButton getjButtonPretrazi() {
        return jButtonPretrazi;
    }

    public void setjButtonPretrazi(JButton jButtonPretrazi) {
        this.jButtonPretrazi = jButtonPretrazi;
    }

    public JButton getjButtonReset() {
        return jButtonReset;
    }

    public void setjButtonReset(JButton jButtonReset) {
        this.jButtonReset = jButtonReset;
    }

    public JTable getjTableTrening() {
        return jTableTrening;
    }

    public void setjTableTrening(JTable jTableTrening) {
        this.jTableTrening = jTableTrening;
    }

    public JTextField getjTextFieldDatumTreninga() {
        return jTextFieldDatumTreninga;
    }

    public void setjTextFieldDatumTreninga(JTextField jTextFieldDatumTreninga) {
        this.jTextFieldDatumTreninga = jTextFieldDatumTreninga;
    }

    public JTextField getjTextFieldTipTreninga() {
        return jTextFieldTipTreninga;
    }

    public void setjTextFieldTipTreninga(JTextField jTextFieldTipTreninga) {
        this.jTextFieldTipTreninga = jTextFieldTipTreninga;
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonGlavniMeni;
    private javax.swing.JButton jButtonPretrazi;
    private javax.swing.JButton jButtonReset;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableTrening;
    private javax.swing.JTextField jTextFieldDatumTreninga;
    private javax.swing.JTextField jTextFieldTipTreninga;
    // End of variables declaration//GEN-END:variables

    public void addBtnPretraziActionListener(ActionListener actionListener) {
        jButtonPretrazi.addActionListener(actionListener);
    }

    public void addBtnResetujActionListener(ActionListener actionListener) {
        jButtonReset.addActionListener(actionListener);
    }

    public void addGlavniMeniActionListener(ActionListener actionListener) {
        jButtonGlavniMeni.addActionListener(actionListener);
    }
}
