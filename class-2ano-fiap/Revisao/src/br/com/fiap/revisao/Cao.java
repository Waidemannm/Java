package br.com.fiap.revisao;

public class Cao extends Animal implements  AnimalInterface{
	
	public Cao() {
		
	}
	
	public Cao(Integer qtdPatas, Double peso, Double altura,
			CorEnum cor, ClasseEnum classe, DietaEnum dieta) {
		super(qtdPatas, peso, altura, cor, classe, dieta );
	}
	
	@Override
	public void comunicar() {
		System.out.println("Cão lati");
	}


	@Override
	public void comunicarInterface() {
		System.out.println("Cao lati (Interface)");
		
	}
	
	

}
