
public class Environnement1 {

	public static final int NOMBRE_BOUTONS_EMPLACEMENTS = 10;
	public static final int NOMBRE_BOUTONS_BOUTIQUE = 10;


	public static L�gume[] champs = cr�erChamps();
	public static Achetable[] �l�mentBoutique;
	
	public static Object tenir = null;
	
	
	private static L�gume[] cr�erChamps(){
		L�gume[] champs;
		//cr�er le champs
		champs = new L�gume[NOMBRE_BOUTONS_EMPLACEMENTS];

		
		for(int i = 0 ; i < NOMBRE_BOUTONS_EMPLACEMENTS ; i++){
			
			champs[i] = new L�gume(EnumL�gumes.VIDE);//jeu d'essai ou tous les �l�ments du champs sont vides
			
		}
		
		champs[0] = new L�gume(EnumL�gumes.PATATE);
		
		
		return champs;
	}
	
	public Environnement1(){
		
		//cr�er la boutique
		�l�mentBoutique = new Graine[16];
		
		�l�mentBoutique[0] = new Graine(EnumL�gumes.PATATE);
		�l�mentBoutique[1] = new Graine(EnumL�gumes.TOMATE);
		
		for(int i = 2 ; i < NOMBRE_BOUTONS_BOUTIQUE ; i++){
			
			�l�mentBoutique[i] = new Graine(EnumL�gumes.TOMATE);
			
		}
		
	}
	
	public static void augmenterScore(L�gume �l�mentChamps){
		
		Principale.scoreFibres += �l�mentChamps.getFibresProd();
		Principale.scoreVitamines += �l�mentChamps.getVitaminesProd();
		
		Principale.score = Principale.scoreVitamines + Principale.scoreFibres;
		
	}
	
	public static void afficherScore(){
		
		System.out.println("Score : "+Principale.score+" Vitamines : "+Principale.scoreVitamines+" Fibres : "+Principale.scoreFibres);
		
	}
}
