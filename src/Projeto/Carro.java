package Projeto;

public class Carro {
	private int idCarro;
	private String marcaCarro;
	private String modeloCarro;
	private int AnoCarro;
	
	public Carro(int idCarro, String marcaCarro, String modeloCarro, int AnoCarro) {
		this.idCarro = idCarro;
		this.marcaCarro = marcaCarro;
		this.modeloCarro = modeloCarro;
		this.AnoCarro = AnoCarro;
	}

	public int getIdCarro() {
		return idCarro;
	}

	public void setIdCarro(int idCarro) {
		this.idCarro = idCarro;
	}

	public String getMarcaCarro() {
		return marcaCarro;
	}

	public void setMarcaCarro(String marcaCarro) {
		this.marcaCarro = marcaCarro;
	}

	public String getModeloCarro() {
		return modeloCarro;
	}

	public void setModeloCarro(String modeloCarro) {
		this.modeloCarro = modeloCarro;
	}

	public int getAnoCarro() {
		return AnoCarro;
	}

	public void setAnoCarro(int AnoCarro) {
		this.AnoCarro = AnoCarro;
	}

}
