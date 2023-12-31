/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package SpeedClick;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author bapti
 */
public class FenetreAccueil extends javax.swing.JFrame {

    /**
     * Creates new form FenetreAccueil
     */
    public FenetreAccueil() {
        initComponents();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(730, 450);
        setLocationRelativeTo(null);

        // Crée un JLayeredPane pour gérer les couches
        JLayeredPane layeredPane = new JLayeredPane();
        setContentPane(layeredPane);

        // Ajoute l'image de fond en tant que JLabel
        ImageIcon imageFond = new ImageIcon("src/SpeedClick/Image1.jpg");
        Image image = imageFond.getImage().getScaledInstance(730, 450, Image.SCALE_SMOOTH);
        ImageIcon imageFondScaled = new ImageIcon(image);
        JLabel labelFond = new JLabel(imageFondScaled);
        labelFond.setBounds(0, 0, 730, 450);
        layeredPane.add(labelFond, Integer.valueOf(0));  // Ajoute à la couche de fond

        // Ajoute un JLabel pour le texte
        /*JLabel labelTexte = new JLabel("BIENVENUE SUR SPEEDY GONZALEZ CLICK");
        labelTexte.setForeground(Color.RED);  // Couleur du texte
        labelTexte.setFont(new Font("Arial", Font.BOLD, 24));  // Style et taille de police
        labelTexte.setBounds(50, 75, 550, 50);  // Position et taille du label
        layeredPane.add(labelTexte, Integer.valueOf(1));  // Ajoute à la couche au-dessus du fond*/   
        
        try {
            Font looneyFont = Font.createFont(Font.TRUETYPE_FONT, new File("src/SpeedClick/LOONEYFONT2.ttf"));
            
            // Applique la police au label
            JLabel labelTexte = new JLabel("BIENVENUE SUR SPEEDY GONZALEZ CLICK");
            labelTexte.setForeground(Color.WHITE);
            labelTexte.setFont(looneyFont.deriveFont(Font.BOLD, 24));
            labelTexte.setHorizontalAlignment(JLabel.CENTER);
            labelTexte.setBounds(50,75,600,50);
            layeredPane.add(labelTexte, Integer.valueOf(1));
        
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }

        // Ajoute un bouton cliquable
        JButton bouton = new JButton("COMMENCER");
        bouton.setBounds(290, 335, 150, 30);
        bouton.setFont(new Font("Rockwell Extra Bold", Font.PLAIN,12));
        layeredPane.add(bouton, Integer.valueOf(2));  // Ajoute à la couche au-dessus du texte
        bouton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             
                new FenetrePrincipale().setVisible(true);
                fermerFenetre();

            }
        });

        setVisible(true);

    }
    
    private void fermerFenetre() {
        // Ferme la fenêtre actuelle
        this.dispose();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(450, 220, 500, 500));
        setPreferredSize(new java.awt.Dimension(730, 415));
        setResizable(false);
        setSize(new java.awt.Dimension(500, 300));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
            java.util.logging.Logger.getLogger(FenetreAccueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FenetreAccueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FenetreAccueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FenetreAccueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FenetreAccueil().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
