/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package SpeedClick;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author bapti
 */
public class FenetrePrincipale extends javax.swing.JFrame {

    private ArrayList<JButton> boutons = new ArrayList<>();
    private Timer timer;
    private int secondsLeft = 10;
    private int score = 0;
   
    private List<Integer> scores = new ArrayList<>();
 
    /**
     * Creates new form GrilleBoutons
     */
    public FenetrePrincipale() {
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
        boutonNouvellePartie.setText("Nouvelle Partie");
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
                        if (timer== null) {
                            lancerChronometre();
                        }
                        
                        
                        
                        JButton source = (JButton) e.getSource();
                        
                        
                        // Vérifie si le bouton cliqué est vert
                        if (source.getBackground() == Color.ORANGE) {
                            incrementerScore();
                        } else {
                            decrementerScore();
                        }
                        
                        // Rétablit la couleur normale du bouton cliqué
                        source.setBackground(null);
                        
                        

                        // Choisi aléatoirement un autre bouton pour le colorier en vert
                        colorierBoutonAleatoire();
                    }
                });
            }
        }

        // Initialisation du premier bouton vert
        colorierBoutonAleatoire();
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

    private void colorierBoutonAleatoire() {
        // Rétablit la couleur normale de tous les boutons
        for (JButton bouton : boutons) {
            bouton.setBackground(null);
        }

        // Choisi aléatoirement un bouton et le colorie en vert
        Random rand = new Random();
        int index = rand.nextInt(boutons.size());
        JButton boutonOrange = boutons.get(index);
        boutonOrange.setBackground(Color.ORANGE);
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
        timer = null;
       
        

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
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 255));
        setBounds(new java.awt.Rectangle(450, 220, 500, 500));
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setMaximumSize(new java.awt.Dimension(5, 5));
        setResizable(false);
        setSize(new java.awt.Dimension(500, 300));

        GrilleBoutons.setPreferredSize(new java.awt.Dimension(400, 400));

        javax.swing.GroupLayout GrilleBoutonsLayout = new javax.swing.GroupLayout(GrilleBoutons);
        GrilleBoutons.setLayout(GrilleBoutonsLayout);
        GrilleBoutonsLayout.setHorizontalGroup(
            GrilleBoutonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 341, Short.MAX_VALUE)
        );
        GrilleBoutonsLayout.setVerticalGroup(
            GrilleBoutonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 332, Short.MAX_VALUE)
        );

        labelChrono.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 12)); // NOI18N
        labelChrono.setForeground(new java.awt.Color(255, 102, 0));
        labelChrono.setText("labelChrono");

        labelScore.setBackground(new java.awt.Color(255, 255, 0));
        labelScore.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 14)); // NOI18N
        labelScore.setForeground(new java.awt.Color(255, 102, 0));
        labelScore.setText("labelScore");

        boutonNouvellePartie.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 12)); // NOI18N
        boutonNouvellePartie.setText("jButton1");

        boutonRetourAccueil.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 12)); // NOI18N
        boutonRetourAccueil.setText("jButton1");

        boutonAfficherScores.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 12)); // NOI18N
        boutonAfficherScores.setText("jButton1");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SpeedClick/Speedy_Gonzales.svg.png"))); // NOI18N
        jLabel1.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(GrilleBoutons, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelChrono, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(labelScore)))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(boutonNouvellePartie, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(boutonRetourAccueil)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(boutonAfficherScores))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(GrilleBoutons, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelChrono, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelScore, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(23, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(boutonNouvellePartie, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boutonRetourAccueil, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boutonAfficherScores, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34))))
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
            java.util.logging.Logger.getLogger(FenetrePrincipale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FenetrePrincipale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FenetrePrincipale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FenetrePrincipale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FenetreAccueil().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel GrilleBoutons;
    private javax.swing.JButton boutonAfficherScores;
    private javax.swing.JButton boutonNouvellePartie;
    private javax.swing.JButton boutonRetourAccueil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labelChrono;
    private javax.swing.JLabel labelScore;
    // End of variables declaration//GEN-END:variables
}
