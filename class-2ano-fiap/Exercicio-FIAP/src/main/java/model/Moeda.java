package model;

public class Moeda {
	
	private Double valor;
	private Double taxa;
	
	public Moeda() {
		
	}

	public Moeda(Double valor, Double taxa) {
		setValor(valor);
		setTaxa(taxa);
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Double getTaxa() {
		return taxa;
	}

	public void setTaxa(Double taxa) {
		this.taxa = taxa;
	}
	
	public Double converter() {
		return valor * taxa;
	}
	

}
