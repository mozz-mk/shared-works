/**
 * This software is under GNU Public License 2.0
 * @author Moussa Kane
 * NOTE: Lors d'une partie en solo, la partie action automatique peut présenter des anomalies de fonctionnement, mais le jeu à deux joueurs est totalement fonctionnel.
 * 
 */

import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class TicTacToe3 extends JApplet implements ActionListener {

	private static final long serialVersionUID = 1L;

	/**
	 * Varibables d'instance. "game" est le tableau qui va représenter l'état du
	 * jeu; "fini" permet de savoir si le jeu est toujours en cours ou terminé;
	 * winner détermine le gagnant; a,i,j sont des compteurs.
	 * 
	 */

	private int[][] game = new int[3][3];
	private byte mode;
	private String winner;
	private int compteur = 0;
	private boolean fini;
	private int i = (int) (Math.random() * 10);
	private int j = (int) (Math.random() * 3);
	private int a = (int) (Math.random() * 3);

	public TicTacToe3() {
		getContentPane().setLayout(null);

		/**
		 * Ici sont déclarés les différents éléments de l'applet, leur position,
		 * leur visibilité, leurs propriétés en général, ainsi que les fonctions
		 * exécutées par chaque bouton (intéractions). Les noms des variables
		 * utilisées ont été choisis dans le but de rendre le code
		 * compréhensible.
		 * 
		 * Chaque case est définie par un bouton cliquable. Lorsqu'un joueur
		 * clique sur un bouton, une série d'actions est lancée, dépendant du
		 * mode de jeu (solo ou duo). ce bouton prend la valeur "X" ou "O" selon
		 * le joueur. Le niveau d'avancement est connu avec la variable
		 * "compteur".
		 * 
		 * 
		 */

		final JPanel panneau_jeu = new JPanel();
		panneau_jeu.setBackground(Color.LIGHT_GRAY);
		panneau_jeu.setBounds(0, 0, 420, 310);
		getContentPane().add(panneau_jeu);
		panneau_jeu.setLayout(null);
		panneau_jeu.setVisible(false);

		final JButton case1 = new JButton("");
		case1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				if (mode == 1) {
					jeuDuo(case1, 0, 0);
				}
				if (mode == 2) {
					jeuDuo(case1, 0, 0);
				}

			}
		});
		case1.setBounds(0, 0, 140, 90);
		panneau_jeu.add(case1);

		final JButton case2 = new JButton("");
		case2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				if (mode == 1) {
					jeuDuo(case2, 0, 1);
				}
				if (mode == 2) {
					jeuDuo(case2, 0, 1);
				}

			}
		});
		case2.setBounds(140, 0, 140, 90);
		panneau_jeu.add(case2);

		final JButton case3 = new JButton("");
		case3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				if (mode == 1) {
					jeuDuo(case3, 0, 2);
				}
				if (mode == 2) {
					jeuDuo(case3, 0, 2);
				}
			}
		});
		case3.setBounds(280, 0, 140, 90);
		panneau_jeu.add(case3);

		final JButton case4 = new JButton("");
		case4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				if (mode == 1) {
					jeuDuo(case4, 1, 0);
				}
				if (mode == 2) {
					jeuDuo(case4, 1, 0);
				}
			}
		});
		case4.setBounds(0, 90, 140, 90);
		panneau_jeu.add(case4);

		final JButton case5 = new JButton("");
		case5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				if (mode == 1) {
					jeuDuo(case5, 1, 1);
				}
				if (mode == 2) {
					jeuDuo(case5, 1, 1);
				}
			}
		});
		case5.setBounds(140, 90, 140, 90);
		panneau_jeu.add(case5);

		final JButton case6 = new JButton("");
		case6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				if (mode == 1) {
					jeuDuo(case6, 1, 2);
				}
				if (mode == 2) {
					jeuDuo(case6, 1, 2);
				}
			}
		});
		case6.setBounds(280, 90, 140, 90);
		panneau_jeu.add(case6);

		final JButton case7 = new JButton("");
		case7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				if (mode == 1) {
					jeuDuo(case7, 2, 0);
				}
				if (mode == 2) {
					jeuDuo(case7, 2, 0);
				}
			}
		});
		case7.setBounds(0, 180, 140, 90);
		panneau_jeu.add(case7);

		final JButton case8 = new JButton("");
		case8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				if (mode == 1) {
					jeuDuo(case8, 2, 1);
				}
				if (mode == 2) {
					jeuDuo(case8, 2, 1);
				}
			}
		});
		case8.setBounds(140, 180, 140, 90);
		panneau_jeu.add(case8);

		final JButton case9 = new JButton("");
		case9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				if (mode == 1) {
					jeuDuo(case9, 2, 2);
				}
				if (mode == 2) {
					jeuDuo(case9, 2, 2);
				}
			}
		});
		case9.setBounds(280, 180, 140, 90);
		panneau_jeu.add(case9);

		final JLabel reEssayer = new JLabel("Reessayez SVP");
		reEssayer.setForeground(Color.RED);
		reEssayer.setBounds(195, 280, 116, 14);
		panneau_jeu.add(reEssayer);
		reEssayer.setVisible(false);

		final JButton jeuAutomatique = new JButton("Jeu automatique");
		jeuAutomatique.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent paramActionEvent) {
				int tmpI = i;
				int tmpJ = j;
				a = (int) (Math.random() * 10);
				;
				do {
					j = (int) (Math.random() * 3);
					i = (int) (Math.random() * 3);
				} while (i == tmpI || j == tmpJ);
				jeuAuto(reEssayer, a, i, j, case1, case2, case3, case4, case5,
						case6, case7, case8, case9);
			}
		});
		jeuAutomatique.setBounds(32, 276, 120, 23);
		panneau_jeu.add(jeuAutomatique);
		jeuAutomatique.setVisible(false);

		final JPanel panneau_accueil = new JPanel();
		panneau_accueil.setBounds(0, 0, 420, 310);
		getContentPane().add(panneau_accueil);
		panneau_accueil.setLayout(null);

		JLabel message1 = new JLabel("Tic Tac Toe");
		message1.setBounds(179, 87, 160, 43);
		panneau_accueil.add(message1);

		JLabel message2 = new JLabel("Selectionner le mode de jeu");
		message2.setBounds(150, 129, 148, 14);
		panneau_accueil.add(message2);

		JButton partieUnJoueur = new JButton("Un joueur");
		partieUnJoueur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				panneau_accueil.setVisible(false);
				panneau_jeu.setVisible(true);
				mode = 1;
				initialiserTableau(game);
				jeuAutomatique.setVisible(true);
				JOptionPane
						.showMessageDialog(
								null,
								"Voulez-vous commencer en premier? Jouez et appuyez sur le bouton jeu automatique pour faire jouer l'ordinateur");
			}
		});
		partieUnJoueur.setBounds(73, 185, 122, 23);
		panneau_accueil.add(partieUnJoueur);

		JButton partieDeuxJoueurs = new JButton("Deux joueurs");
		partieDeuxJoueurs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				panneau_accueil.setVisible(false);
				panneau_jeu.setVisible(true);
				mode = 2;
				initialiserTableau(game);

			}

		});
		partieDeuxJoueurs.setBounds(250, 185, 141, 23);
		panneau_accueil.add(partieDeuxJoueurs);

		JButton rejouer = new JButton("Rejouer");
		rejouer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panneau_jeu.setVisible(false);
				panneau_accueil.setVisible(true);
				case1.setText("");
				case2.setText("");
				case3.setText("");
				case4.setText("");
				case5.setText("");
				case6.setText("");
				case7.setText("");
				case8.setText("");
				case9.setText("");
				compteur = 0;
				fini = false;
				initialiserTableau(game);
				winner = null;
				jeuAutomatique.setVisible(false);
				reEssayer.setVisible(false);
			}
		});
		rejouer.setBounds(321, 276, 89, 23);
		panneau_jeu.add(rejouer);

	}

	/**
	 * A partir de ce niveau, nous avons les fonctions qui définissent les
	 * actions sur les boutons et le le fonctionnement du jeu.
	 * 
	 * "initialiserTableau()" remplit le tableau de jeu avec la valeur "2". Le
	 * premier joueur "X" se voit attribuer la valeur "0" et le deuxième joueur
	 * "O" se voit attribuer la valeur "1".
	 * 
	 * "jeuAuto()" définit un comportement automatique lorsqu'on joue seul avec
	 * "la machine" Pour cela il récupère les objets que représentent chaque
	 * bouton afin de pouvoir en modifier un au hasard, sans un comportement
	 * précis. A cause de cette procédure, il faut dès fois appuyer plusieurs
	 * fois sur le bouton "jeu automatique).
	 * 
	 * "verifJeuFini()" permet de savoir si le jeu est terminé et si certaines
	 * conditions de réussite sont réunies, c'est à dire quand les 9 cases sont
	 * cochées. Dans ce cas, s'il n'y pas de vainqueur, la partie est déclarée
	 * nulle.
	 * 
	 * "quiAGagne()" permet de déterminer quel joueur a remporté la partie en
	 * comparant l'état de tableau de jeu avec les différentes conditions de
	 * réussite qui sont déjà saisies dans un tableau.
	 * 
	 * "dejaJoue()" permet de savoir si la case que l'on veut jouer ou pas à été
	 * déja cliquée et retourne un booléen.
	 * 
	 */

	public void jeuDuo(Object obj, int i, int j) {
		if (compteur % 2 == 0 && !dejaJoue((JButton) obj)) {
			((JButton) obj).setText("X");
			compteur++;
			game[i][j] = 0;
			verifJeuFini(game);

		} else if ((compteur % 2 != 0) && !dejaJoue((JButton) obj)) {
			((JButton) obj).setText("O");
			compteur++;
			game[i][j] = 1;
			verifJeuFini(game);
		}

		while (!fini) {
			quiAGagne(game);
			if (winner == "X" || winner == "O")
				JOptionPane.showMessageDialog(null, "Partie terminée! "
						+ winner + " a gagné");
			break;
		}
		if (fini) {
			quiAGagne(game);
			JOptionPane.showMessageDialog(null, "Partie terminée! " + winner
					+ " a gagné");
		}
	}

	public void jeuAuto(JLabel reEssayer, int a, int i, int j, JButton bouton1,
			JButton bouton2, JButton bouton3, JButton bouton4, JButton bouton5,
			JButton bouton6, JButton bouton7, JButton bouton8, JButton bouton9) {
		while (true) {
			if (a == 1 && !dejaJoue(bouton1)) {
				jeuDuo(bouton1, i, j);
				reEssayer.setVisible(false);
				break;
			} else if (a == 2 && !dejaJoue(bouton2)) {
				jeuDuo(bouton2, i, j);
				reEssayer.setVisible(false);
				break;
			} else if (a == 3 && !dejaJoue(bouton3)) {
				jeuDuo(bouton3, i, j);
				reEssayer.setVisible(false);
				break;
			} else if (a == 4 && !dejaJoue(bouton4)) {
				jeuDuo(bouton4, i, j);
				reEssayer.setVisible(false);
				break;
			} else if (a == 5 && !dejaJoue(bouton5)) {
				jeuDuo(bouton5, i, j);
				reEssayer.setVisible(false);
				break;
			} else if (a == 6 && !dejaJoue(bouton6)) {
				jeuDuo(bouton6, i, j);
				reEssayer.setVisible(false);
				break;
			} else if (a == 7 && !dejaJoue(bouton7)) {
				jeuDuo(bouton7, i, j);
				reEssayer.setVisible(false);
				break;
			} else if (a == 8 && !dejaJoue(bouton8)) {
				jeuDuo(bouton8, i, j);
				reEssayer.setVisible(false);
				break;
			} else if (a == 9 && !dejaJoue(bouton9)) {
				jeuDuo(bouton9, i, j);
				reEssayer.setVisible(false);
				break;
			} else {
				reEssayer.setVisible(true);
				break;
			}
		}
	}

	private void quiAGagne(int[][] tab) {
		if (((tab[0][0] == 0 && tab[0][1] == 0 && tab[0][2] == 0)
				|| (tab[1][0] == 0 && tab[1][1] == 0 && tab[1][2] == 0) || (tab[2][0] == 0
				&& tab[2][1] == 0 && tab[2][2] == 0))/**/
				|| /**/((tab[0][0] == 0 && tab[1][0] == 0 && tab[2][0] == 0)
						|| (tab[0][1] == 0 && tab[1][1] == 0 && tab[2][1] == 0) || (tab[0][2] == 0
						&& tab[1][2] == 0 && tab[2][2] == 0))/**/
				|| /**/((tab[0][0] == 0 && tab[1][1] == 0 && tab[2][2] == 0) || (tab[0][2] == 0
						&& tab[1][1] == 0 && tab[2][0] == 0))

		) {
			winner = "X";
			// X a gagné
		}

		else if (((tab[0][0] == 1 && tab[0][1] == 1 && tab[0][2] == 1)
				|| (tab[1][0] == 1 && tab[1][1] == 1 && tab[1][2] == 1) || (tab[2][0] == 1
				&& tab[2][1] == 1 && tab[2][2] == 1)) /**/
				|| /**/((tab[0][0] == 1 && tab[1][0] == 1 && tab[2][0] == 1)
						|| (tab[0][1] == 1 && tab[1][1] == 1 && tab[2][1] == 1) || (tab[0][2] == 1
						&& tab[1][2] == 1 && tab[2][2] == 1)) /**/
				|| /**/((tab[0][0] == 1 && tab[1][1] == 1 && tab[2][2] == 1) || (tab[0][2] == 1
						&& tab[1][1] == 1 && tab[2][0] == 1))) {
			winner = "O";
			// O a gagné

		}

		else {
			// Partie nulle
			winner = "Personne n'";
		}
	}

	private boolean dejaJoue(Object obj) {
		if (((JButton) obj).getText() == "X"
				|| (((JButton) obj).getText() == "O")) {
			return true;
		} else {
			return false;
		}
	}

	private void verifJeuFini(int[][] tab) {
		if (compteur == 9) {
			fini = true;
		}
	}

	private void initialiserTableau(int[][] tab) {
		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab.length; j++) {
				tab[i][j] = 2;
			}
		}
	}

	public static void main(String[] args) {

	}

	@Override
	public void actionPerformed(ActionEvent a) {
		// TODO Auto-generated method stub

	}
}