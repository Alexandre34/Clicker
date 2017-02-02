
public class Environnement1 {

	public static final int NOMBRE_BOUTONS_EMPLACEMENTS = 15;
	public static final int NOMBRE_BOUTONS_BOUTIQUE = 6;
	
	public static Légume[] champs = créerChamps();
	public static Achetable[] élémentBoutique;
	
	public static Object tenir = null;
	
	//Création des champs
	private static Légume[] créerChamps(){
		Légume[] champs;
		//créer le champs
		champs = new Légume[NOMBRE_BOUTONS_EMPLACEMENTS];
		for(int i = 0 ; i < NOMBRE_BOUTONS_EMPLACEMENTS ; i++){
			
			champs[i] = new Légume(EnumLégumes.VIDE);//jeu d'essai ou tous les éléments du champs sont vides
			
		}
		
		champs[0] = new Légume(EnumLégumes.PATATE);
		return champs;
	}
	
	//Constructeur
	public Environnement1(){
		
		//créer la boutique
		élémentBoutique = new Graine[6];
		
		élémentBoutique[0] = new Graine(EnumLégumes.PATATE);
		élémentBoutique[1] = new Graine(EnumLégumes.TOMATE);
		élémentBoutique[2] = new Graine(EnumLégumes.MAIS);
		élémentBoutique[3] = new Graine(EnumLégumes.OIGNON);
		élémentBoutique[4] = new Graine(EnumLégumes.POIREAU);
		élémentBoutique[5] = new Graine(EnumLégumes.CAROTTE);
	}
	
	//Augmente le score du joueur en cas de clic sur un légume
	public static void augmenterScore(Légume élémentChamps){
		
		Principale.scoreFibres += élémentChamps.getFibresProd();
		Principale.scoreVitamines += élémentChamps.getVitaminesProd();
		
		Principale.score = Principale.scoreVitamines + Principale.scoreFibres;
		
	}
	
	public static void afficherScore(){
		
		System.out.println("Score : "+Principale.score+" Vitamines : "+Principale.scoreVitamines+" Fibres : "+Principale.scoreFibres);
		
	}
}
