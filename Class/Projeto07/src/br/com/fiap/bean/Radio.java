package br.com.fiap.bean;

public class Radio {
    //atributos
    private int  volume;
    private float estacao;
    //metodos getters and setters
    public void setVolume(int volume){
       try{
           if(volume >= 0 && volume <= 100){
               this.volume = volume;
           } else {
               throw new Exception("Estação fora de ar! (min= 80.0 e max= 105.0)");
           }
       }catch (Exception e){
           System.out.println(e.getMessage());
       }
    }
    public void setEstacao(float estacao){
        try{
            if(estacao >= 80.0 && estacao <=105.0){
                this.estacao = estacao;
            } else{
                throw new Exception("Volume não permitido! min= 0 e max= 100)");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public int getVolume(){
        return volume;
    }
    public float getEstacao(){
        return estacao;
    }
    //metodos
    public void aumentarVolume(){
        if(volume < 100){
            volume++;
        }
    }
    public void dimnuiriVolume(){
        if(volume > 0){
            volume--;
        }
    }

}
