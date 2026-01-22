package br.com.fiap.bean;

import java.io.*;

public class Pessoa {
    //atributos
    private String codigo;
    private String nome;
    private String email;
    //construtores
    public Pessoa(){}

    public Pessoa(String codigo, String nome, String email) {
        this.codigo = codigo;
        this.nome = nome;
        this.email = email;
    }
    //getters and setters

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    //metodos particulares
    public Pessoa ler(String path) throws IOException {
        BufferedReader br = new BufferedReader(
                new FileReader(path + "/" + codigo + ".txt")
        );
        codigo = br.readLine();
        nome = br.readLine();
        email = br.readLine();
        br.close();
        return this;
    }
    public String gravar(String path) throws IOException{
        try{
            File dir = new File(path);
            if (!dir.exists()){
                dir.mkdir();
            }
            PrintWriter pw = new PrintWriter(path + "/" + codigo + ".txt");
            pw.println(codigo);
            pw.println(nome);
            pw.println(email);
            pw.flush();
            pw.close();
            return "Arquivo gravado com sucesso";
        }catch (IOException e){
            throw new IOException("Falha ao gravar o arquivo!" + e.getMessage());
        }
    }
}
