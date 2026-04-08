package model;

public class VerificarCpf {
	private String cpf;

	public VerificarCpf() {

	}

	public VerificarCpf(String cpf) {
		setCpf(cpf);
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	
	public boolean verificarCpf() {
		if(cpf.length() == 11 && isNumber(cpf) == true) {
			return true;
		}else {
		return false;
		}
	}
	
	public boolean isNumber(String cpf) {
		return cpf.matches("\\d+"); // ese regex verifica se é digitos de (0-9), contando coemecar com zero
	}
}
