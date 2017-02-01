
public class Légume extends Graine{
	
	private float fibresProd;
	private float vitaminesProd;
	private int niveau;
	
	public Légume(EnumLégumes légume) {
		super(légume);
		this.fibresProd=this.getType().getFibresProdBase();
		this.vitaminesProd=this.getType().getVitaminesProdBase();
		this.niveau=1;
	}
	
	
	public float getFibresPrix (){
		return super.getFibresPrix();
	}
	
	public float getVitaminesPrix() {
		return super.getVitaminesPrix();
	}
	
	public float getFibresProd (){
		return this.fibresProd;
	}
	
	public float getVitaminesProd() {
		return this.vitaminesProd;
	}
	public int getNiveau(){
		return this.niveau;
	}
	
	public void setFibresPrix(float fib){
		super.setFibresPrix(fib);
	}
	public void setVitaminesPrix(float vit){
		super.setVitaminesPrix(vit);
	}
	
	public void setFibresProd (float fibresProd){
		this.fibresProd = fibresProd;
	}
	
	public void setVitaminesProd (float vitaminesProd){
		this.vitaminesProd = vitaminesProd;
	}
	
	public void clone(Légume légume){
		légume.fibresProd = this.fibresProd;
		légume.vitaminesProd = this.vitaminesProd;
		légume.niveau = this.niveau;
		légume.setFibresPrix(this.getFibresPrix());
		légume.setVitaminesPrix(this.getVitaminesPrix());
		légume.setType(légume.getType());
	}
	
	
	public void monterNiveau(){
		this.niveau++;
		this.setFibresPrix((float) (this.getFibresPrix() * Math.exp(0.2)));
		this.setVitaminesPrix((float) (this.getVitaminesPrix()* Math.exp(0.2)));
		if (this.niveau == 25 || this.niveau == 50 || this.niveau == 100 || this.niveau == 200){
			this.fibresProd*= 2;
			this.vitaminesProd*= 2;
		}

	}
	public String toString(){
		return ("je suis une "+ this.getType().toString()+", niveau "+ this.getNiveau()+
				" je produits "+Math.round(this.getVitaminesProd()) +
						" vitamines et "+Math.round(this.getFibresProd())+" fibres"+
							" upgrade = "+Math.round(this.getVitaminesPrix())+
							" vit et "+ Math.round(this.getFibresPrix())+" fib");
	}
	
	
	
}
