/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package SpeedClick;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author bapti
 */

public class TestMoyen extends javax.swing.JFrame {  
    private ArrayList<JButton> boutons = new ArrayList<>();
    private List<JButton> boutonsVertsActifs = new ArrayList<>();
    private Timer timer;
    private int secondsLeft = 10;
    private int score = 0;
   
    private List<Integer> scores = new ArrayList<>();
 
    /**
     * Creates new form GrilleBoutons
     */
    public TestMoyen() {
        initComponents();
        int nbLignes = 5;
        int nbColonnes = 5;
        GrilleBoutons.setLayout(new GridLayout(nbLignes, nbColonnes));
        setLocationRelativeTo(null);
        
        // Affichage initial du chronomètre
        labelChrono.setText("Temps restant : " + secondsLeft + " secondes");
        add(labelChrono, BorderLayout.EAST);
        
        // Affichage initial du score
        labelScore.setText("Score : " + score);
        add(labelScore, BorderLayout.SOUTH);
        
        // Bouton pour recommencer une nouvelle partie
        
        boutonNouvellePartie.setText("Nouvelle \n Partie");
        add(boutonNouvellePartie, BorderLayout.NORTH);

        boutonNouvellePartie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Réinitialise le jeu
                reinitialiserPartie();
            }
        });
        
        // Bouton pour retourner à l'accueil
        boutonRetourAccueil.setText("Accueil"); 
        add(boutonRetourAccueil, BorderLayout.WEST);

        boutonRetourAccueil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Retourne à la fenêtre d'accueil
                retournerAccueil();
            }
        });
        
        // Bouton pour afficher les scores
        boutonAfficherScores.setText("Scores");
        add(boutonAfficherScores, BorderLayout.CENTER);

        boutonAfficherScores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Affiche la fenêtre des scores
                afficherScores();
            }
        });

        
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                JButton bouton_cellule = new JButton();
                boutons.add(bouton_cellule);
                GrilleBoutons.add(bouton_cellule);

                bouton_cellule.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Lance le chronomètre lors du premier clic
                        if (timer == null) {
                            lancerChronometre();
                        }
                        
                        
                        
                        JButton source = (JButton) e.getSource();
                        
                        
                        // Vérifie si le bouton cliqué est vert
                        if (source.getBackground() == Color.GREEN) {
                            incrementerScore();
                        } else {
                            decrementerScore();
                        }
                        source.setBackground(null);
                        
                        colorierBoutonsSiEteint();
                        // Rétablit la couleur normale du bouton cliqué
                        //if (boutonsVertsActifs.contains(source)) {
                         //   boutonsVertsActifs.remove(source);
                         //   source.setBackground(null);

                            // Si tous les boutons verts ont été éteints, en générer de nouveaux
                        //    if (boutonsVertsActifs.isEmpty()) {
                        //        colorierBoutonsAleatoires();
                        //    }
                        //} 
                        
                        

                     
                    }
                });
            }
        }

        // Initialisation du premier bouton vert
        colorierBoutonsAleatoires();
    }
    
    private boolean tousLesBoutonsEteints() {
    for (JButton bouton : boutons) {
        if (bouton.getBackground() != null) {
            // Le bouton a une couleur de fond, ce n'est pas éteint
            return false;
        }
    }
    // Aucun bouton n'a de couleur de fond, tous les boutons sont éteints
    return true;
}
    private void colorierBoutonsSiEteint() {
    // Vérifie si tous les boutons sont éteints
    if (tousLesBoutonsEteints()==true) {
        colorierBoutonsAleatoires();
    } 
}

    private void lancerChronometre() {
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                secondsLeft--;

                // Met à jour l'affichage du chronomètre
                labelChrono.setText("Temps restant : " + secondsLeft + " secondes");

                // Vérifie si le temps est écoulé
                if (secondsLeft <= 0) {
                    // Arrête le chronomètre et désactive les boutons
                    timer.stop();
                    desactiverBoutons();
                    // Ajoute le score actuel à la liste des scores
                    scores.add(score);
                    // Trie les scores par ordre décroissant
                    Collections.sort(scores, Collections.reverseOrder());
                    // Conserve seulement les trois meilleurs scores
                    if (scores.size() > 3) {
                        scores = scores.subList(0, 3);
                    }
                }
            }
        });

        // Lance le chronomètre
        timer.start();
    }
private void colorierBoutonsAleatoires() {
        Random rand = new Random();
        int nombreBoutonsVerts = rand.nextInt(4) + 1; // entre 1 et 4 boutons verts
        for (int i = 0; i < nombreBoutonsVerts; i++) {
            colorierBoutonAleatoire();
        }
    }
    private void colorierBoutonAleatoire() {
        // Rétablit la couleur normale de tous les boutons
        //for (JButton bouton : boutons) {
         //   bouton.setBackground(null);
        //}

        // Choisi aléatoirement un bouton et le colorie en vert
        Random rand = new Random();
        int index = rand.nextInt(boutons.size());
        JButton boutonVert = boutons.get(index);
        boutonVert.setBackground(Color.GREEN);
    }
    private void desactiverBoutons() {
        // Désactive tous les boutons
        for (JButton bouton : boutons) {
            bouton.setEnabled(false);
        }
    }
    
    private void incrementerScore() {
        score++;
        labelScore.setText("Score : " + score);
    }

    private void decrementerScore() {
        score--;
        labelScore.setText("Score : " + score);
    }
    
    private void reinitialiserPartie() {
        // Réinitialise les variables
        score = 0;
        secondsLeft = 10;
        labelScore.setText("Score : " + score);
        labelChrono.setText("Temps restant : " + secondsLeft + " secondes");

        // Réactive les boutons
        for (JButton bouton : boutons) {
            bouton.setEnabled(true);
        }


        // Relance la partie
        colorierBoutonAleatoire();
        
    }
    
    private void retournerAccueil() {
        // Crée une nouvelle instance de la fenêtre d'accueil
        //FenetreAccueil fenetreAccueil = new FenetreAccueil();
        // Affiche la fenêtre d'accueil
        new FenetreAccueil().setVisible(true);
        // Ferme la fenêtre actuelle
        this.dispose();
    }
    
    private void afficherScores() {
        
        // Affiche la fenêtre des scores
        new FenetreScores().setVisible(true);
        this.dispose();
    }

    /**
     * Creates new form NiveauMoyen
     */
    //public NiveauMoyen() {
     //   initComponents();
    //}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GrilleBoutons = new javax.swing.JPanel();
        labelChrono = new javax.swing.JLabel();
        labelScore = new javax.swing.JLabel();
        boutonNouvellePartie = new javax.swing.JButton();
        boutonRetourAccueil = new javax.swing.JButton();
        boutonAfficherScores = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout GrilleBoutonsLayout = new javax.swing.GroupLayout(GrilleBoutons);
        GrilleBoutons.setLayout(GrilleBoutonsLayout);
        GrilleBoutonsLayout.setHorizontalGroup(
            GrilleBoutonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 237, Short.MAX_VALUE)
        );
        GrilleBoutonsLayout.setVerticalGroup(
            GrilleBoutonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 284, Short.MAX_VALUE)
        );

        labelChrono.setText("jLabel1");

        labelScore.setText("jLabel1");

        boutonNouvellePartie.setText("jButton1");

        boutonRetourAccueil.setText("jButton2");

        boutonAfficherScores.setText("jButton3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(GrilleBoutons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(boutonAfficherScores)
                            .addComponent(boutonRetourAccueil))
                        .addGap(89, 89, 89))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(boutonNouvellePartie)
                        .addGap(213, 213, 213))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelScore, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelChrono, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(labelChrono)
                .addGap(41, 41, 41)
                .addComponent(labelScore)
                .addGap(74, 74, 74)
                .addComponent(boutonRetourAccueil)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(boutonNouvellePartie)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(boutonAfficherScores)
                        .addGap(60, 60, 60))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(GrilleBoutons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
        );

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
            java.util.logging.Logger.getLogger(TestMoyen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TestMoyen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TestMoyen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TestMoyen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TestMoyen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel GrilleBoutons;
    private javax.swing.JButton boutonAfficherScores;
    private javax.swing.JButton boutonNouvellePartie;
    private javax.swing.JButton boutonRetourAccueil;
    private javax.swing.JLabel labelChrono;
    private javax.swing.JLabel labelScore;
    // End of variables declaration//GEN-END:variables
}
