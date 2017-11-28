package br.com.dicons.dominio;

public class Dicon {

	private String numeroAtendimento;
	private String cliente;
	private String diretorio;

	public Dicon(String numeroAtendimento, String cliente, String diretorio) {
		this.numeroAtendimento = numeroAtendimento;
		this.cliente = cliente;
		this.diretorio = diretorio;

	}

	public String getNumeroAtendimento() {
		return numeroAtendimento;
	}

	public void setNumeroAtendimento(String numeroAtendimento) {
		this.numeroAtendimento = numeroAtendimento;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getDiretorio() {
		return diretorio;
	}

	public void setDiretorio(String diretorio) {
		this.diretorio = diretorio;
	}

}
