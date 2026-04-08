package br.com.fiap.revisao;

public class Gato extends Animal {
	
	public Gato() {
		
	}
	
	public Gato(Integer qtdPatas, Double peso, Double altura,
			CorEnum cor, ClasseEnum classe, DietaEnum dieta) {
		super(qtdPatas, peso, altura, cor, classe, dieta );
	}
	
	@Override
	public void comunicar() {
		System.out.println("Gato mia");
	}
}
