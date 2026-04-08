package br.com.fiap.revisao;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Principal {

	public static void main(String[] args) {
		
		Animal a1 = new Cao(4, 22.7332, 40.123, CorEnum.CARAMELO, 
				ClasseEnum.MAMIFERO,  DietaEnum.ONIVORO );
		Animal a2 = new Gato(4, 3.232, 16.7, CorEnum.MARROM, 
				ClasseEnum.MAMIFERO, DietaEnum.ONIVORO);
		
		Cao cao = new Cao(4, 3.2321321, 16.7, CorEnum.MARROM, 
				ClasseEnum.MAMIFERO, DietaEnum.ONIVORO);
		
		a1.comunicar();
		a2.comunicar();
		cao.comunicarInterface();
		
		ArrayList<Animal> lista = new ArrayList<>();
		lista.add(a1);
		lista.add(a2);
		lista.add(cao);
		
		for(int i = 0; i < lista.size(); i++) {
			System.out.println("\nPeso animal: " + new DecimalFormat("#.##").format(lista.get(i).getPeso())
					+ " KG | Classe: " +
					lista.get(i).getClasse().getDescricao());
		}
		
		for(Animal a : lista) {
			System.out.println(String.format("\nPeso Animal: %.2fKg \nClasse: %s", a.getPeso(), a.getClasse()));
		}
		
		if(lista.contains(cao)){
			System.out.println("\nSim");
		}else {
			System.out.println("Nao");
		}
		
		
		Date dt = new Date();
		
		System.out.println(dt);
		
		System.out.println(new SimpleDateFormat("dd/MM/yyyy ").format(dt));
		
		System.out.println(new SimpleDateFormat("dd/MM/yyyy 'ás' HH:mm:ss"));
		
		Calendar cal1 = Calendar.getInstance();
		
		cal1.set(Calendar.DAY_OF_MONTH, 11);
		cal1.set(Calendar.MONTH, 11);
		cal1.set(Calendar.YEAR, 2006);
		
		System.out.println(new SimpleDateFormat("EEEE, dd 'de' MMMM 'de' yyyy").format(cal1.getTime()));
		
		Calendar cal2 = Calendar.getInstance();
		
		System.out.println(cal2.before(cal1)? "Sim" : "Nao");
		System.out.println(cal2.after(cal1)? "Sim" : "Nao");
		System.out.println(cal2.equals(cal1)? "Sim" : "Nao");
		
		LocalDate ld = LocalDate.now();
		
		LocalDateTime lt = LocalDateTime.now();
		
		System.out.println("Data: "+ ld + " Hora: " + lt);
		
	}
}
