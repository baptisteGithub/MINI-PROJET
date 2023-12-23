/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package SpeedClick;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.util.List;
/**
 *
 * @author bapti
 */

public class FenetreScores extends javax.swing.JFrame {
    private int score;
    private Date date;
    
    
    public FenetreScores (int score, Date date) {
        this.score = score;
        this.date = date;
    }
    /**
     * Creates new form FenetreScores
     */
    public FenetreScores() {
        initComponents();
        setSize(665, 490);
        setLocationRelativeTo(null);
        
        
        boutonRetour.setText("Jouer");
        
       
        boutonRetour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Affiche la fenêtre des scores
                retourAccueil();
            }
        });
    }
    
    private void retourAccueil(){
        new FenetrePrincipale().setVisible(true);
        this.dispose();
    }
    
/**public FenetreScores(List<Integer> scores) {
        
        initComponents(scores);
        setSize(800, 500);
        setLocationRelativeTo(null);
    }


    private void initComponents(List<Integer> scores) {
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Meilleurs Scores");
        setSize(300, 200);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel labelTitre = new JLabel("Meilleurs Scores");
        labelTitre.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(labelTitre);

        for (int i = 0; i < scores.size(); i++) {
            JLabel labelScore = new JLabel("Score " + (i + 1) + ": " + scores.get(i));
            labelScore.setAlignmentX(Component.CENTER_ALIGNMENT);
            panel.add(labelScore);
        }

        add(panel);
    }
    */
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        boutonRetour = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(650, 490));
        setPreferredSize(new java.awt.Dimension(630, 512));
        setResizable(false);
        setSize(new java.awt.Dimension(650, 440));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        boutonRetour.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 12)); // NOI18N
        boutonRetour.setText("jButton1");
        getContentPane().add(boutonRetour, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 390, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SpeedClick/REGLES.png"))); // NOI18N
        jLabel1.setMaximumSize(new java.awt.Dimension(650, 450));
        jLabel1.setMinimumSize(new java.awt.Dimension(650, 450));
        jLabel1.setName(""); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(650, 450));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(FenetreScores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FenetreScores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FenetreScores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FenetreScores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FenetreScores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boutonRetour;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
