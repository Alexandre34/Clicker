
public enum EnumLégumes {

	VIDE(0,0,0,0,0),
	PATATE(1,10,5,2,4),
	TOMATE(2,20,15,3,5),
	MAIS(3,40, 30, 5, 7),
	OIGNON(4, 100, 70, 10, 12),
	POIREAU(5, 400, 350, 30, 32),
	CAROTTE(6, 900, 800, 50, 52);
	
	private float fibresPrixBase, vitaminesPrixBase, fibresProdBase, vitaminesProdBase;
	private int num;
	
	//Constructeur
	private EnumLégumes(int num, float fibresPrixBase, float vitaminesPrixBase, float fibresProdBase, float vitaminesProdBase){
		
		this.fibresPrixBase = fibresPrixBase;
		this.vitaminesPrixBase = vitaminesPrixBase;
		this.fibresProdBase = fibresProdBase;
		this.vitaminesProdBase = vitaminesProdBase;
		this.num = num;
	}
	
	
	public float getFibresPrixBase(){
		
		return this.fibresPrixBase;
		
	}
	
	public float getVitaminesPrixBase(){
		
		return this.vitaminesPrixBase;
		
	}
	
	public float getVitaminesProdBase(){
		
		return this.vitaminesProdBase;
		
	}
	
	public float getFibresProdBase(){
		
		return this.vitaminesProdBase;
		
	}
	
	//le toString est automatiquement substitué par le renvoi d'une chaîne de même nom que l'élément de l'énumération
	
}
