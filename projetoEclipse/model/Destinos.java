package model;


public class Destinos {
	private int id_Destino;
	private String data_Destino;
	private String nome_Destino;
	private Float valor_Destino;

	public Destinos() {

	}

	public Destinos(int id_Destino2, String data_Destino, String nome_Destino, Float valor_Destino) {
		super();
		this.id_Destino = id_Destino2;
		this.data_Destino = data_Destino;
		this.nome_Destino = nome_Destino;
		this.valor_Destino = valor_Destino;
	}

	public Destinos(String data_Destino, String nome_Destino, Float valor_Destino) {
		super();
		this.data_Destino = data_Destino;
		this.nome_Destino = nome_Destino;
		this.valor_Destino = valor_Destino;
	}

	public int getId_Destino() {
		return id_Destino;
	}

	public void setId_Destino(int id_Destino) {
		this.id_Destino = id_Destino;
	}

	public String getData_Destino() {
		return data_Destino;
	}

	public void setData_Destino(String data_Destino){
		this.data_Destino = data_Destino;
	}

	public String getNome_Destino() {
		return nome_Destino;
	}

	public void setNome_Destino(String nome_Destino) {
		this.nome_Destino = nome_Destino;
	}

	public Float getValor_Destino() {
		return valor_Destino;
	}

	public void setValor_Destino(Float valor_Destino) {
		this.valor_Destino = valor_Destino;
	}

	@Override
	public String toString() {
		return "Destinos [id_Destino=" + id_Destino + ", data_Destino=" + data_Destino + ", nome_Destino="
				+ nome_Destino + ", valor_Destino=" + valor_Destino + "]";
	}
	
	

}
