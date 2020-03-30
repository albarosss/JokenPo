package View;

import java.util.concurrent.Semaphore;

import Controller.ThreadJogar;

public class JokenPo {

	public static int PlacarTime1;
	public static int PlacarTime2;

	public static void main(String[] args) {

		String[] time1 = { "A", "B", "C", "D", "E" };
		String[] time2 = { "F", "G", "H", "I", "J" };
		Semaphore registrarPonto = new Semaphore(1);

		Thread jogar1 = new ThreadJogar(time1[0], time2[0], registrarPonto);
		Thread jogar2 = new ThreadJogar(time1[1], time2[1], registrarPonto);
		Thread jogar3 = new ThreadJogar(time1[2], time2[2], registrarPonto);
		Thread jogar4 = new ThreadJogar(time1[3], time2[3], registrarPonto);
		Thread jogar5 = new ThreadJogar(time1[4], time2[4], registrarPonto);
		jogar1.start();
		jogar2.start();
		jogar3.start();
		jogar4.start();
		jogar5.start();
		
		while((jogar1.isAlive() || jogar2.isAlive() || jogar3.isAlive() || jogar4.isAlive() || jogar5.isAlive())) {
			
			
			
		}
		
		if(PlacarTime1 > PlacarTime2) {
			System.out.println("O time 1 ganhou com " + PlacarTime1);
			System.err.println("O time 2 perdeu com " + PlacarTime2);
		}else{
			System.out.println("O time 2 ganhou com " + PlacarTime2);
			System.err.println("O time 1 perdeu com " + PlacarTime1);
		}

	}

}
