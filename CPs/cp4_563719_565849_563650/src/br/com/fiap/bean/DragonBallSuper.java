// Gabriel Sbrana Campos, RM: 565849
// Moisés Waidemannm Molinillo Júnior, RM:  563719
// Thiago Rodrigues da Mota, RM: 563650

package br.com.fiap.bean;

import br.com.fiap.interface_.IDBSuper;

public class DragonBallSuper implements IDBSuper {
    //Atributos
    String nome;
    int ki;
    int tecnicas;
    int velocidade;
    int transformacoes;

    // Construtor Vazio
    public DragonBallSuper(){}
    public DragonBallSuper(String nome, int ki, int tecnicas, int velocidade, int transformacoes) {
        this.nome = nome;
        this.ki = ki;
        this.tecnicas = tecnicas;
        this.velocidade = velocidade;
        this.transformacoes = transformacoes;
    }

    //getters and setters
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getKi() {
        return ki;
    }
    public void setKi(int ki) {
        this.ki = ki;
    }
    public int getTecnicas() {
        return tecnicas;
    }
    public void setTecnicas(int tecnicas) {
        this.tecnicas = tecnicas;
    }
    public int getVelocidade() {
        return velocidade;
    }
    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }
    public int getTransformacoes() {
        return transformacoes;
    }
    public void setTransformacoes(int transformacoes) {
        this.transformacoes = transformacoes;
    }
}
