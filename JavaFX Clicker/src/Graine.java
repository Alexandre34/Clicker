
public class Graine implements Achetable{
	
	private EnumL�gumes type;
	
	private float fibresPrix;
	private float vitaminesPrix;
	
	public Graine(EnumL�gumes l�gume){
		
		this.type = l�gume;
		this.fibresPrix = this.type.getFibresPrixBase();
		this.vitaminesPrix = this.type.getVitaminesPrixBase();
	}
	
	public float getFibresPrix (){
		return this.fibresPrix;
	}
	
	public float getVitaminesPrix() {
		return this.vitaminesPrix;
	}
	
	public EnumL�gumes getType(){
		
		return this.type;
		
	}
	
	public void setFibresPrix(float fib){
		this.fibresPrix = fib;
	}
	
	public void setVitaminesPrix(float vit){
		this.vitaminesPrix = vit ;
	}
	
	public void setType(EnumL�gumes l�gume){
		this.type = l�gume;
	}
	
	public void acheter(){
		
		if(Principale.scoreFibres >= this.fibresPrix && Principale.scoreVitamines >= this.vitaminesPrix){
			//tenir
			Environnement1.tenir = this.type;
			
			//d�penser
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
