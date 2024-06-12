package org.generation.italy.model;

public class Distributore {

	private double credito;
	private Prodotto[] elencoProdotti;

	public Distributore() {
		super();
		credito = 0;
		this.elencoProdotti = new Prodotto[] { new Bevanda("Aranciata", 1.70f, 20, true),
				new Bevanda("Coca Cola", 2.00f, 15, true), new Bevanda("Acqua", 1.00f, 12, true),
				new Snack("Patatine", 1.10f, 10, 100), new Snack("Taralli", 0.70f, 14, 50),
				new Snack("Pop Corn", 2.10f, 17, 200), };
	}

	public void inserisciMoneta(double monetaInserita) {
		if (monetaInserita == 0.10 || monetaInserita == 0.20 || monetaInserita == 0.50 || monetaInserita == 1
				|| monetaInserita == 2) {
			credito += monetaInserita;
			System.out.println("Inseriti: " + monetaInserita + "€");
		} else {
			System.out.println("Moneta non valida");
		}
	}

	public void erogaProdotto(int nrProdotto) {
		if (nrProdotto < 0 || nrProdotto >= elencoProdotti.length) {
			System.out.println("Prodotto non valido");
		}

		Prodotto prodottoSelezionato = elencoProdotti[nrProdotto];
		if (prodottoSelezionato.getQnt() == 0) {
			System.out.println("Prodotto esaurito");
		}

		if (credito >= prodottoSelezionato.getCosto()) {
			// Sottrazione credito e quantità
			credito -= prodottoSelezionato.getCosto();
			prodottoSelezionato.setQnt(prodottoSelezionato.getQnt() - 1);

			// Verifica se è una bevanda o uno snack
			if (prodottoSelezionato instanceof Bevanda) {
				Bevanda bevandaSelezionata = (Bevanda) prodottoSelezionato;
				System.out.println("Bevanda: " + bevandaSelezionata.getNome() + " erogata correttamente");
			} else if (prodottoSelezionato instanceof Snack) {
				Snack snackSelezionato = (Snack) prodottoSelezionato;
				System.out.println("Snack " + snackSelezionato.getNome() + " erogato correttamente");
			}
		} else {
			System.out.println("Credito insufficiente");
		}
	}

	public void visualizzaProdotti() {
		for (int i = 0; i < elencoProdotti.length; i++) {
			Prodotto stampaProdotto = elencoProdotti[i];
			if (stampaProdotto instanceof Bevanda) {
				Bevanda stampaBevanda = (Bevanda) stampaProdotto;
				String zuccherata = stampaBevanda.isZuccherata() ? "zuccherata" : "Senza zucchero";
				System.out.println(i+" Bevanda: " + stampaBevanda.getNome() + " Zucchero: " + zuccherata + " Costo: "
						+ stampaBevanda.getCosto() + " Quantità: " + stampaBevanda.getQnt());
			} else if (stampaProdotto instanceof Snack) {
				Snack stampaSnack = (Snack) stampaProdotto;
				System.out.println(i+" Snack: " + stampaSnack.getNome() + " grammi: " + stampaSnack.getGrammi()
						+ " Costo: " + stampaSnack.getCosto() + " Quantità: " + stampaSnack.getQnt());
			}
		}
	}
	
	public void erogaResto() {
		System.out.println("Erogato resto:"+credito+"€");
		credito=0;
	}

	public double getCredito() {
		System.out.println("Credito :"+credito+"€");
		return credito;
	}

	public Prodotto[] getElencoProdotti() {
		return elencoProdotti;
	}
}
