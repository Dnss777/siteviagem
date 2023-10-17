package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import factory.ConnectionMySQL;
import model.Destinos;

public class DestinosDAO {

	// create
	public void create(Destinos destinos) {

		String sql = "insert into Destinos (data_Destino, nome_Destino, valor_Destino) values (?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, destinos.getData_Destino());
			pstm.setString(2, destinos.getNome_Destino());
			pstm.setFloat(3, destinos.getValor_Destino());

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
	public List<Destinos> read() {
		List<Destinos> destinos = new ArrayList<Destinos>();
		String sql = "select * from destinos";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Destinos destino = new Destinos();

				destino.setId_Destino(rset.getInt("id_Destino"));
				destino.setData_Destino(rset.getString("data_Destino"));
				destino.setNome_Destino(rset.getString("nome_Destino"));
				destino.setValor_Destino(rset.getFloat("valor_Destino"));
				
				destinos.add(destino);
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

		return destinos;
	}

	// update
	public void update(Destinos destinos) {
		String sql = "UPDATE Destinos SET data_Destino = ?, nome_Destino= ?,  Valor_Destino = ? WHERE id_Destino = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1,destinos.getData_Destino());
			pstm.setString(2, destinos.getNome_Destino());
			pstm.setFloat(3, destinos.getValor_Destino());
			pstm.setInt(4, destinos.getId_Destino());

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
		String sql = "DELETE FROM Destinos WHERE id_Destino = ?";

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
	public Destinos readById(int id_Destino) {
		Destinos destinos = new Destinos();
		String sql = "select * from Destinos WHERE id_Destino = ?";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, id_Destino);
			
			rset = pstm.executeQuery();
			
			rset.next();
			
			destinos.setId_Destino(rset.getInt("id_Destino"));
			destinos.setData_Destino(rset.getString("data_Destino"));
			destinos.setNome_Destino(rset.getString("nome_Destino"));
			destinos.setValor_Destino(rset.getFloat("valor_Destino"));
					

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
		return destinos;
	}

}