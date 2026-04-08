package model;

public class Bissexto {
	
	private Integer ano;
	
	public Bissexto() {
		
	}

	public Bissexto(Integer ano) {
		setAno(ano);
	}
	
	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public boolean bissexto() {
        if ((ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0)) {
            return true; 
        } else {
            return false; 
        }
    }
}
