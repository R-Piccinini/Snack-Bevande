package org.generation.italy.model;

public class Snack extends Prodotto {
	private int grammi;

	public Snack(String nome, float costo, int qnt, int grammi) {
		super(nome, costo, qnt);
		this.grammi = grammi;
	}

	public int getGrammi() {
		return grammi;
	}
}