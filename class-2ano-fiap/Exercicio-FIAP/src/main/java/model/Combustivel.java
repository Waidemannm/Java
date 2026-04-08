package model;

public class Combustivel {
	private Double preco;
	private Double distancia;
	private Double consumo;
	
	public Combustivel() {
		
	}
	
	public Combustivel(Double distancia, Double consumo, Double preco) {
		setPreco(preco);
		setDistancia(distancia);
		setConsumo(consumo);
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Double getDistancia() {
		return distancia;
	}

	public void setDistancia(Double distancia) {
		this.distancia = distancia;
	}

	public Double getConsumo() {
		return consumo;
	}

	public void setConsumo(Double consumo) {
		this.consumo = consumo;
	}

	
	public Double custo() {
		return (distancia/consumo) * preco;
	}


}
