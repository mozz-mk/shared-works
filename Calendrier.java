/*
 * 
 * @authors Kane Moussa
 * This software is under GNU Public Licence 2.0
 */
import java.applet.Applet;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.SimpleTimeZone;
import java.util.Date;

public class Calendrier extends Applet {

	private static final long serialVersionUID = 1L;

	/**
	 * Variables globales, Elles seront utilisées pour l'affichage
	 */
	public static final String joursDeLaSemaine[] = { "Lun", "Mar", "Mer",
			"Jeu", "Ven", "Sam", "Dim" };
	private String heure = "", minute = "";

	public static Graphics gCalendrier;

	public void init() {
		gCalendrier = getGraphics();
	}

	public void paint(Graphics g) {
		/*
		 * Nous définissions ici des objets de type Date, SimpleTimeZone et
		 * GregorianCalendar. Les deux premiers servent respectivement à
		 * récupérer la date courante et le fuseau horaire.
		 * 
		 * Nous utilisons la méthode formaterAffichage() pour mettre les "0"
		 * lorsque les minutes et les heures sont inférieures à 10.
		 * 
		 * Lorsque l'année est bissextile, le nombre de jours du mois de Février
		 * est fixé à 29, autrement il prend une des valeurs fournies dans le
		 * tableau.
		 */
		Date laDate = new Date();
		SimpleTimeZone fuseauHoraire = new SimpleTimeZone(-18000000, "EST",
				Calendar.MARCH, 8, -Calendar.SUNDAY, 7200000,
				SimpleTimeZone.WALL_TIME, Calendar.NOVEMBER, 1,
				-Calendar.SUNDAY, 7200000, SimpleTimeZone.WALL_TIME, 3600000);
		Calendar unCalendrier = new GregorianCalendar(fuseauHoraire);
		unCalendrier.setTime(laDate);

		int jourToday = unCalendrier.get(Calendar.DAY_OF_MONTH);
		int mois = unCalendrier.get(Calendar.MONTH);
		formaterAffichage(unCalendrier);

		int nbreJoursDuMois;
		boolean bissextile = unCalendrier
				.getActualMaximum(Calendar.DAY_OF_YEAR) > 365;
		int nombreJourDansMois[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31,
				30, 31 };
		/*
		 * 
		 */
		if (mois == 1 && bissextile == true) {
			nbreJoursDuMois = 29;
		} else {
			nbreJoursDuMois = nombreJourDansMois[mois];
		}

		/*
		 * Nous définissions la date au 1er jour du mois pour savoir de quel
		 * jour il s'agit et bien positionner le calendrier.
		 */
		unCalendrier.set(Calendar.DAY_OF_MONTH, 1);
		int col = debutSemaine(unCalendrier);

		unCalendrier.set(Calendar.DAY_OF_MONTH, jourToday);
		String jour;

		/*
		 * Nous récupérons les dimensions et les adaptons.
		 */
		Dimension d = getSize();
		int x = d.width / 8;
		int y = d.height / 8;
		/*
		 * Nous mettons les jours de la semaine, prédéfinis dans un tableau. La
		 * variable "rangée" nous permet de nous retrouver dans l'affichage.
		 */
		int rangee = 1;
		for (int i = 0; i < 7; i++) {
			gCalendrier.drawString("" + joursDeLaSemaine[i], (i + 1) * x, y);
		}
		rangee++;

		/*
		 * Affichage des jours
		 */
		for (int i = 1; i <= nbreJoursDuMois; i++) {
			jour = "" + i;
			if (jourToday == i) {
				jour += "*";
			}
			gCalendrier.drawString(jour, col * x, rangee * y);
			col++;
			/*
			 * Pour assurer le saut de ligne chaque lundi, nous remettons la
			 * valeur de la colonne à 1 et incrémentons le compteur de la
			 * rangée.
			 */
			if (col > 7) {
				col = 1;
				rangee++;
			}
		}
		rangee++;

		/*
		 * Affichage de l'heure autour d'un rectangle. Nous utilisons la classe
		 * Rectangle2D pour l'affichage de la case.
		 */
		gCalendrier.drawString("Heure : " + heure + ":" + minute, x,
				(rangee * y) + 10);

		Rectangle2D[] tailleCase = new Rectangle2D[1];
		tailleCase[0] = gCalendrier.getFontMetrics().getStringBounds(
				"Heure : " + heure + ":" + minute, gCalendrier);
		gCalendrier.drawRect(x - 5,
				((rangee * y) + 10) - (int) tailleCase[0].getHeight(),
				(int) tailleCase[0].getWidth() + 10,
				(int) tailleCase[0].getHeight() + 5);

	}

	public void formaterAffichage(Calendar cal) {
		if (cal.get(Calendar.HOUR) < 10) {
			heure += "0" + cal.get(Calendar.HOUR_OF_DAY);
		} else {
			heure += cal.get(Calendar.HOUR_OF_DAY);
		}

		if (cal.get(Calendar.MINUTE) < 10) {
			minute += "0" + cal.get(Calendar.MINUTE);
		} else {
			minute += cal.get(Calendar.MINUTE);
		}

	}

	/*
	 * Cette méthode permet de fixer le premier jour de la semaine au Lundi car
	 * dans le premier jour affiché par la méthode DAY_OF_WEEK de calendar est
	 * le Dimanche
	 */
	private int debutSemaine(Calendar cal) {
		int debutSemaine = cal.get(Calendar.DAY_OF_WEEK);

		if (debutSemaine == 1) {
			debutSemaine = 7;
			return debutSemaine;
		} else {
			debutSemaine -= 1;
			return debutSemaine;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
