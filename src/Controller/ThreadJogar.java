package Controller;

import java.util.concurrent.Semaphore;

import View.JokenPo;

public class ThreadJogar extends Thread{
	
	private String jogadorTime1;
	private String jogadorTime2;
	private int pontosJogadorTime1 = 0;
	private int pontosJogadorTime2 = 0;
	private Semaphore registrarPonto;
	
	public ThreadJogar(String jogadorTime1, String jogadorTime2, Semaphore registrarPonto) {
		super();
		this.jogadorTime1 = jogadorTime1;
		this.jogadorTime2 = jogadorTime2;
		this.registrarPonto = registrarPonto;
	}

	@Override
	public void run() {
		
		fight();
		
		try {
			registrarPonto.acquire();
			registrarPontos();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			registrarPonto.release();
		}
		
		super.run();
	}

	private void fight() {
		
	
		String[] jogadas = {"","Papel","Tesoura","Pedra"};
		
		int jogadaTime1;
		int jogadaTime2;
		
		while(pontosJogadorTime1 < 3 && pontosJogadorTime2 < 3) {
			
			jogadaTime1 = (int)((Math.random()*3)+1);
			jogadaTime2 = (int)((Math.random()*3)+1);
			
			if(jogadaTime1 == 1 && jogadaTime2 == 3) {
				System.out.println("O jogador " + jogadorTime1 + " jogou " + jogadas[jogadaTime1] + " e o jogador " + jogadorTime2 + " jogou " + jogadas[jogadaTime2]);
				pontosJogadorTime1++;
			}else if(jogadaTime1 == 2 && jogadaTime2 == 1) {
				System.out.println("O jogador " + jogadorTime1 + " jogou " + jogadas[jogadaTime1] + " e o jogador " + jogadorTime2 + " jogou " + jogadas[jogadaTime2]);
				pontosJogadorTime1++;
			}else if(jogadaTime1 == 3 && jogadaTime2 == 2) {
				System.out.println("O jogador " + jogadorTime1 + " jogou " + jogadas[jogadaTime1] + " e o jogador " + jogadorTime2 + " jogou " + jogadas[jogadaTime2]);
				pontosJogadorTime1++;
			}else if(jogadaTime1 == jogadaTime2) {
				System.out.println("O jogador " + jogadorTime1 + " jogou " + jogadas[jogadaTime1] + " e o jogador " + jogadorTime2 + " jogou " + jogadas[jogadaTime2]);
			}else {
				System.out.println("O jogador " + jogadorTime1 + " jogou " + jogadas[jogadaTime1] + " e o jogador " + jogadorTime2 + " jogou " + jogadas[jogadaTime2]);
				pontosJogadorTime2++;
			}

		}
		
		if(pontosJogadorTime1 == 3) {
			System.out.println("O vencedor do duelo entre os jogadores " + jogadorTime1 + " e " + jogadorTime2 + " foi o " + jogadorTime1);
		}else {
			System.out.println("O vencedor do duelo entre os jogadores " + jogadorTime1 + " e " + jogadorTime2 + " foi o " + jogadorTime2);
		}
		
	}
	

	private void registrarPontos() {
		
		JokenPo.PlacarTime1 += pontosJogadorTime1;
		JokenPo.PlacarTime2 += pontosJogadorTime2;
		
	}
	
	
}
