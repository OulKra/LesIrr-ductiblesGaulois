package personnages;

public class Gaulois {
	private String nom;
	//private int force;
	private int effetPotion = 1;

	
	private int force;
	private int nb_trophees;
	public Equipement trophees[] = new Equipement[100];
	
	public Gaulois(String nom, int force) {
		super();
		this.nom = nom;
		this.force = force;
	}
	
	public String getNom() {
		return nom;
	}

	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "�" + texte + "�");
	}
	
	
	private String prendreParole() {
		String texte = "Le gaulois " + nom + " : ";
		return texte;
		}
	
	

	public void frapper(Romain romain) 
	{
		System.out.println(nom + " envoie un grand coup dans la	m�choire de " + romain.getNom());
		Equipement trophees[] = romain.recevoirCoup((force / 3) *
		effetPotion);
		for (int i = 0; trophees != null && i < trophees.length; i++, nb_trophees++) 
		{
			this.trophees[nb_trophees] = trophees[i];
		}
		return;
	}

	
	void boirePotion(int forcePotion)
	{
		effetPotion = forcePotion;
		parler("Merci Druide, je sens que ma force est " + forcePotion + " fois d�cupl�e");
	}
	
	
	
	
	
	public void faireUneDonnation(Musee musee)
	{
		if(nb_trophees > 0)
		{
			String texte = "Je donne au musee tous mes trophees";
			while(nb_trophees > 0)
			{
				Equipement equip = trophees[nb_trophees-1];
				trophees[nb_trophees] = null;
				nb_trophees--;
				texte += "\n - " + equip.nom;
				Trophee tropheePourDon = new Trophee(this, equip);
				musee.donnerTrophees(this, tropheePourDon);
			}
			parler(texte);
		}
		else
		{
			parler("Je n'ai rien � donner :/");
		}

	}
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Ast�rix", 8);
		Romain romain = new Romain("Romain (le mec de Emilie)", 5);
		
		System.out.println(asterix);
		asterix.parler("Hey");
		asterix.frapper(romain);
		asterix.boirePotion(5);
	}
}