package org.generation.italy;

import java.util.Scanner;

import org.generation.italy.model.Distributore;

public class Main {

	public static void main(String[] args) {

		Distributore d = new Distributore();
		Scanner sc = new Scanner(System.in);
		String risposta;
		do {
			System.out.println("Premi INVIO per continuare");
			sc.nextLine();
			System.out.println();
			d.visualizzaProdotti();
			System.out.println();
			d.getCredito();
			System.out.println("Selezione programma: ");
			System.out.println("1) Inserisci Moneta - 2)Eroga Prodotto - 3)Eroga Resto - 4)Esci");
			risposta = sc.nextLine();

			switch (risposta) {
			case ("1"):
				System.out.println("Inserisci moneta (0,10, 0,20, 0,50, 1, 2):");
				double monetaInserita = sc.nextDouble();
				sc.nextLine();
				d.inserisciMoneta(monetaInserita);
				break;
			case ("2"):
				System.out.println("Selezione prodotto: ");
				int nrProdotto = sc.nextInt();
				sc.nextLine();
				d.erogaProdotto(nrProdotto);
			case ("3"):
				d.erogaResto();
				break;
			case ("4"):
				break;
			}

		} while (!(risposta.equals("4")));
		System.out.println("Arrivederci");

	}

}
