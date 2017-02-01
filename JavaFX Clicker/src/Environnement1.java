
public class Environnement1 {

	public static final int NOMBRE_BOUTONS_EMPLACEMENTS = 10;
	public static final int NOMBRE_BOUTONS_BOUTIQUE = 10;


	public static Légume[] champs = créerChamps();
	public static Achetable[] élémentBoutique;
	
	public static Object tenir = null;
	
	
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
	
	public Environnement1(){
		
		//créer la boutique
		élémentBoutique = new Graine[16];
		
		élémentBoutique[0] = new Graine(EnumLégumes.PATATE);
		élémentBoutique[1] = new Graine(EnumLégumes.TOMATE);
		
		for(int i = 2 ; i < NOMBRE_BOUTONS_BOUTIQUE ; i++){
			
			élémentBoutique[i] = new Graine(EnumLégumes.TOMATE);
			
		}
		
	}
	
	public static void augmenterScore(Légume élémentChamps){
		
		Principale.scoreFibres += élémentChamps.getFibresProd();
		Principale.scoreVitamines += élémentChamps.getVitaminesProd();
		
		Principale.score = Principale.scoreVitamines + Principale.scoreFibres;
		
	}
	
	public static void afficherScore(){
		
		System.out.println("Score : "+Principale.score+" Vitamines : "+Principale.scoreVitamines+" Fibres : "+Principale.scoreFibres);
		
	}
}
