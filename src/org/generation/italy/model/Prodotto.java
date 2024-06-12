package org.generation.italy.model;

public class Prodotto {
	private String nome;
	private float costo;
	private int qnt;
	
	public Prodotto(String nome, float costo, int qnt) {
		super();
		this.nome=nome;
		this.costo=costo;
		this.qnt=qnt;
		
		
	}

	public String getNome() {
		return nome;
	}


	public float getCosto() {
		return costo;
	}


	public int getQnt() {
		return qnt;
	}

	public void setQnt(int qnt) {
		this.qnt = qnt;
	}


	


}
