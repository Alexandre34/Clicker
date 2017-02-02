
public class Environnement1 {

	public static final int NOMBRE_BOUTONS_EMPLACEMENTS = 15;
	public static final int NOMBRE_BOUTONS_BOUTIQUE = 6;
	
	public static L�gume[] champs = cr�erChamps();
	public static Achetable[] �l�mentBoutique;
	
	public static Object tenir = null;
	
	//Cr�ation des champs
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
	
	//Constructeur
	public Environnement1(){
		
		//cr�er la boutique
		�l�mentBoutique = new Graine[6];
		
		�l�mentBoutique[0] = new Graine(EnumL�gumes.PATATE);
		�l�mentBoutique[1] = new Graine(EnumL�gumes.TOMATE);
		�l�mentBoutique[2] = new Graine(EnumL�gumes.MAIS);
		�l�mentBoutique[3] = new Graine(EnumL�gumes.OIGNON);
		�l�mentBoutique[4] = new Graine(EnumL�gumes.POIREAU);
		�l�mentBoutique[5] = new Graine(EnumL�gumes.CAROTTE);
	}
	
	//Augmente le score du joueur en cas de clic sur un l�gume
	public static void augmenterScore(L�gume �l�mentChamps){
		
		Principale.scoreFibres += �l�mentChamps.getFibresProd();
		Principale.scoreVitamines += �l�mentChamps.getVitaminesProd();
		
		Principale.score = Principale.scoreVitamines + Principale.scoreFibres;
		
	}
	
	public static void afficherScore(){
		
		System.out.println("Score : "+Principale.score+" Vitamines : "+Principale.scoreVitamines+" Fibres : "+Principale.scoreFibres);
		
	}
}
