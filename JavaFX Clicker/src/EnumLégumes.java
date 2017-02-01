
public enum EnumL�gumes {

	VIDE(0,0,0,0,0),
	TOMATE(1,22,19,3,5),
	PATATE(2,21,20,2,4);
	
	private float fibresPrixBase, vitaminesPrixBase, fibresProdBase, vitaminesProdBase;
	private int num;
	
	private EnumL�gumes(int num, float fibresPrixBase, float vitaminesPrixBase, float fibresProdBase, float vitaminesProdBase){
		
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
	
	//le toString est automatiquement substitu� par le renvoi d'une cha�ne de m�me nom que l'�l�ment de l'�num�ration
	
}
