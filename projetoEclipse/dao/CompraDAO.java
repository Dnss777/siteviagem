package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import factory.ConnectionMySQL;
import model.Cliente;
import model.Compra;
import model.Destinos;

public class CompraDAO {

	// create
	public void create(Compra compra) {

		String sql = "insert into Compra (data_Compra, total_Compra, id_cliente, id_Destino) values (?, ?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1,compra.getData_Compra());
			pstm.setFloat(2, compra.getTotal_Compra());
			pstm.setInt(3, compra.getCliente().getId());
			pstm.setInt(4, compra.getDestinos().getId_Destino());

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	// read
	public List<Compra> read() {
		List<Compra> compras = new ArrayList<Compra>();
		String sql = "select * from Compra";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Compra compra = new Compra();

				compra.setId_Compra(rset.getInt("id_Compra"));
				compra.setData_Compra(rset.getString("data_Compra"));
				compra.setTotal_Compra(rset.getFloat("total_Compra"));
				int id_Cliente = rset.getInt("id_Cliente");
				int id_Destino = rset.getInt("id_Destino");
				ClienteDAO clientedao = new ClienteDAO();
				Cliente cliente = clientedao.readById(id_Cliente);
				DestinosDAO destinosdao = new DestinosDAO();
				Destinos destinos = destinosdao.readById(id_Destino);
				
				compra.setCliente(cliente);
				compra.setDestinos(destinos);
				
				compras.add(compra); 
			}} 
			catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return compras;
	}

	// update
	public void update(Compra compra) {
		String sql = "UPDATE Compra SET data_Compra = ?, total_Compra = ?, id_cliente = ?, id_Destino= ? WHERE id_Compra = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, compra.getData_Compra());
			pstm.setFloat(2, compra.getTotal_Compra());
			pstm.setInt(3, compra.getCliente().getId());
			pstm.setInt(4, compra.getDestinos().getId_Destino());
            pstm.setInt(5, compra.getId_Compra());
			pstm.execute();
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	// delete
	public void delete(int id) {
		String sql = "DELETE FROM Compra WHERE id_Compra = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	// readById
	public Compra readById(int id_Compra) {
		Compra compra = new Compra();
		String sql = "select * from Compra WHERE id_Compra = ?";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, id_Compra);
			
			rset = pstm.executeQuery();
			
			rset.next();
			
			compra.setId_Compra(rset.getInt("id_Compra"));
			compra.setData_Compra(rset.getString("data_Compra"));
			compra.setTotal_Compra(rset.getFloat("total_Compra"));
			
			int id_Cliente = rset.getInt("id_Cliente");
		int id_Destino = rset.getInt("id_Destino");
			ClienteDAO clientedao = new ClienteDAO();
			Cliente cliente = clientedao.readById(id_Cliente);
			DestinosDAO destinosdao = new DestinosDAO();
			Destinos destinos = destinosdao.readById(id_Destino);
			
		compra.setCliente(cliente);
		compra.setDestinos(destinos);
					

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return compra;
	}

}