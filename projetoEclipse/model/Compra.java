package model;



public class Compra {

		   private int id_Compra;
		   private String data_Compra;
		   private float total_Compra;
		   private Cliente cliente;
		   private Destinos destinos;
		  
		   
		public Compra() {
		}
		public Compra(int id_Compra, String data_Compra, float total_Compra, Cliente cliente, Destinos destinos) {
			
			this.id_Compra = id_Compra;
			this.data_Compra = data_Compra;
			this.total_Compra = total_Compra;
			this.cliente = cliente;
			this.destinos = destinos;
		}
				
		public Compra(String data_Compra, float total_Compra, Cliente cliente, Destinos destinos) {
			super();
			this.data_Compra = data_Compra;
			this.total_Compra = total_Compra;
			this.cliente = cliente;
			this.destinos = destinos;
		}
		public int getId_Ccmpra() {
			return id_Compra;
			
		}
		public void setId_Compra(int id_Compra) {
			this.id_Compra = id_Compra;
		}
		public String getData_Compra() {
			return data_Compra;
		}
		public void setData_Compra(String data_Compra) {
			this.data_Compra = data_Compra;
		}
		public float getTotal_Compra() {
			return total_Compra;
		}
		public void setTotal_Compra(float total_Compra) {
			this.total_Compra = total_Compra;
		}
		public Cliente getCliente() {
			return cliente;
		}
		public void setCliente(Cliente cliente) {
			this.cliente = cliente;
		}
		public Destinos getDestinos() {
			return destinos;
		}
		public void setDestinos(Destinos destinos) {
			this.destinos = destinos;
		}
		public int getId_Compra() {
			return id_Compra;
		}
		@Override
		public String toString() {
			return "Compra [id_Compra=" + id_Compra + ", data_Compra=" + data_Compra + ", total_Compra=" + total_Compra
					+ ", cliente=" + cliente + ", destinos=" + destinos + "]";
		}
	  

}
		   
			  
