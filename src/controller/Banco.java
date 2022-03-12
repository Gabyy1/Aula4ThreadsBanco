package controller;

import java.util.concurrent.Semaphore;

public class Banco extends Thread {
	private int idBanco;
	private Semaphore semaforo;
	
	public Banco(int idBanco, Semaphore semaforo) {
		this.idBanco = idBanco;	
		this.semaforo = semaforo;
	}

	public void run() {
		if (idBanco % 3 == 0) {
			calculo();
			transacao();
			calculo();
			transacao();
			calculo();
			transacao();
		}
		
		if (idBanco % 3 == 1) {
			calculo();
			transacao();
			calculo();
			transacao();
		}
		
		if (idBanco % 3 == 2) {
			calculo();
			transacao();
			calculo();
			transacao();
			calculo();
			transacao();
		}
		
		
	}
	
	public void transacao() {
		int tempo = 0;
		
		if(idBanco % 3 == 0)  {
			tempo = 1500;
		}
		
		if (idBanco % 3 == 1 ) {
			tempo = 1000;
		}
		
		if(idBanco % 3 == 2)  {
			tempo = 1500;
		}
		
		
		try {
			semaforo.acquire();
			System.out.println("A thread #" + idBanco + " está fazendo a transação.");
			Thread.sleep(tempo);
		} catch (InterruptedException e1) {
			
			e1.printStackTrace();
		}finally {
			semaforo.release();
		}
		
		System.out.println("A thhread # " + idBanco + " acabou a transação.");
		
		
	}
	
	public void calculo() {
		int tempo = 0;
		
		if(idBanco % 3 == 0)  {
			tempo = (int) ((int) ((Math.random() * 1.1) +1) * Math.pow(10, 9));
		}
	
		if (idBanco % 3 == 1 ) {
			tempo = (int) (int) ((Math.random() + 0.2) * Math.pow(10, 9));
		}
		
		if(idBanco % 3 == 2)  {
			tempo = (int) ((int) ((Math.random() + 1.6) + 0.5 )* Math.pow(10, 9));
		}
		
		
		
		System.out.println("A thread #" + idBanco + " está fazendo o calculo.");
		
		try {
			Thread.sleep(tempo);
		} catch (Exception e) {
	}
}
}