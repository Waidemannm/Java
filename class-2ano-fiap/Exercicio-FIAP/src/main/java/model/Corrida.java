package model;

public class Corrida {
	private Double distancia;
	private Double velocidade;
	public Corrida() {
		
	}
	public Corrida(Double distancia, Double velocidade) {
		setDistancia(distancia);
		setVelocidade(velocidade);
	}
	public Double getDistancia() {
		return distancia;
	}
	public void setDistancia(Double distancia) {
		this.distancia = distancia;
	}
	public Double getVelocidade() {
		return velocidade;
	}
	public void setVelocidade(Double velocidade) {
		this.velocidade = velocidade;
	}
	
	public Double tempoViagem() {
		return distancia / velocidade;
	}

}
