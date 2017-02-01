
public class Graine implements Achetable{
	
	private EnumLégumes type;
	
	private float fibresPrix;
	private float vitaminesPrix;
	
	public Graine(EnumLégumes légume){
		
		this.type = légume;
		this.fibresPrix = this.type.getFibresPrixBase();
		this.vitaminesPrix = this.type.getVitaminesPrixBase();
	}
	
	public float getFibresPrix (){
		return this.fibresPrix;
	}
	
	public float getVitaminesPrix() {
		return this.vitaminesPrix;
	}
	
	public EnumLégumes getType(){
		
		return this.type;
		
	}
	
	public void setFibresPrix(float fib){
		this.fibresPrix = fib;
	}
	
	public void setVitaminesPrix(float vit){
		this.vitaminesPrix = vit ;
	}
	
	public void setType(EnumLégumes légume){
		this.type = légume;
	}
	
	public void acheter(){
		
		if(Principale.scoreFibres >= this.fibresPrix && Principale.scoreVitamines >= this.vitaminesPrix){
			//tenir
			Environnement1.tenir = this.type;
			
			//dépenser
			Principale.scoreFibres -= this.getFibresPrix();
			Principale.scoreVitamines -= this.getVitaminesPrix();
			
		}
		else{
			
			System.out.println("Impossible d'acheter cet article.");
			
		}

	}
	
	public String toString(){
		return type.name();
	}
	
	public String affichage() {
		return "Prix vit : " +this.vitaminesPrix+ ". Prix fib : " +this.fibresPrix;
	}
}
