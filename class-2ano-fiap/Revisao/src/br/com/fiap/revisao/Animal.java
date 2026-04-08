package br.com.fiap.revisao;

public class Animal {

	private Integer qtdPatas;
	private Double peso;
	private Double altura;
	private CorEnum cor;
	private ClasseEnum classe;
	private DietaEnum dieta;
	
	public Animal() {
		
	}
	
	public Animal(Integer qtdPatas, Double peso, Double altura,
			CorEnum cor, ClasseEnum classe, DietaEnum dieta) {
		setQtdPatas(qtdPatas);
		setPeso(peso);
		setAltura(altura);
		setCor(cor);
		setClasse(classe);
		setDieta(dieta);
	}

	public void comunicar() {
		
	}
	
	public Integer getQtdPatas() {
		return this.qtdPatas;
	}

	public void setQtdPatas(Integer qtdPatas) {

		if (qtdPatas >= 1 && qtdPatas <= 1306) {
			this.qtdPatas = qtdPatas;
		}

	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public CorEnum getCor() {
		return cor;
	}

	public void setCor(CorEnum cor) {
		this.cor = cor;
	}

	public ClasseEnum getClasse() {
		return classe;
	}

	public void setClasse(ClasseEnum classe) {
		this.classe = classe;
	}

	public DietaEnum getDieta() {
		return dieta;
	}

	public void setDieta(DietaEnum dieta) {
		this.dieta = dieta;
	}
	
	
}
