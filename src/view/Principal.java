package view;

import java.util.concurrent.Semaphore;

import controller.Banco;



public class Principal {
	public static void main (String[]args) {
		Semaphore semaforo = new Semaphore(1);
		
		for (int idBanco = 1; idBanco < 22; idBanco++) {
			Thread Banco = new Banco (idBanco, semaforo);
			Banco.start();
	}
	

}
}
