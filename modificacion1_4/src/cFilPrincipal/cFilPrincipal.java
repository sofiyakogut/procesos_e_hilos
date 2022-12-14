package cFilPrincipal;
import cFil.cFil;
import java.util.Scanner;
import java.util.ArrayList;

public class cFilPrincipal {
  public static void main (String [] pArguments) {
	  
	System.out.println ("Numero de procesos? :)");
	Scanner scan = new Scanner(System.in);
	int numero = scan.nextInt();
	
	while (numero < 0 || numero > 6){ 
	    System.out.print("Numero de procesos entre 0 y 5? :)");
	    numero = scan.nextInt();
	}
	
	int contador = 1;
	ArrayList<Thread> lista = new ArrayList<>();
	
	for(int vComptador = 0; vComptador < numero; vComptador ++){
		cFil vObjecteFil = new cFil("#" + contador);
		vObjecteFil.sTemporitzacio(contador * 100);
		Thread vFil = new Thread(vObjecteFil);
		vFil.start();
		lista.add(vFil);
		contador++;
	}
		
    System.out.println("Iniciant execució procés principal");
	    try {
	      for(int vComptador = 0; vComptador < 3; vComptador ++){
	        Thread.sleep(500);
	        
	        for (Thread i: lista) {
	            i.join();
	        }
	        
	        System.out.println("Despertant aturada " + vComptador + " procès principal");
	      }
	    }
	    catch(InterruptedException pExcepcio){
	      System.out.println("Interrompent execució procès principal");
	    }
    System.out.println("Acabant execució procès principal");
    
    
  }
}