package qualite_logiciel.exo_DIP2;

public class Jeu {
	public int getPointsEnonce(Carre s) {
		return s.getPoints();
		
	}

	public static void main(String[] args) {
		Jeu j = new Jeu();
		Carre c = new CarreMalus();
		System.out.println(j.getPointsEnonce(c));
	}
}