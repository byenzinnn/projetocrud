package Projeto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conector {
	Connection con;
	public void Dbconnect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetocrud", "root", "******"); 
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
	
	public void inseriCarro(Carro c) { 
		String sqlcmd = "insert into carro values (?,?,?,?)";
		try {
			PreparedStatement pst;
			pst = con.prepareStatement(sqlcmd);
			pst.setInt(1, c.getIdCarro());
			pst.setString(2, c.getModeloCarro()); 
			pst.setString(3, c.getMarcaCarro());
			pst.setInt(4, c.getAnoCarro());
			pst.executeUpdate(); 
			System.out.println("Carro Cadastrado");
		} catch (SQLException ex) {
			System.out.println("Carro NÃO foi Cadastrado " + ex);
		}
	}
	
	public void selecionaCarro() {
		String sqlcmd = "SELECT id_carro, modelo_carro, marca_carro, ano_carro FROM carro";
		try {
			PreparedStatement pst;
			pst = con.prepareStatement(sqlcmd);
			ResultSet rst = pst.executeQuery();
			while(rst.next()) {
				int id = rst.getInt("id_carro");
				String marca = rst.getString(2);
				String modelo = rst.getString(3);
				int ano = rst.getInt("ano_carro");
				System.out.printf("\n Id do carro : %d //// Marca : %s //// Modelo : %s //// Ano : %d", id, marca, modelo, ano);
			}
					
		}catch (SQLException ex){
			System.out.println("Erro ao consultar o Carro" + ex);
		}
	}
	
	public void atualizaCarro(int idcarro, String marcacarro, String modelocarro, int anocarro) {
		String sqlcmd = "UPDATE carro SET marca_carro = ?, modelo_carro = ?, ano_carro = ? WHERE id_carro = ?";
		try {
			PreparedStatement pst;
			pst = con.prepareStatement(sqlcmd);
			pst.setInt(1, idcarro);
			pst.setString(2, marcacarro);
			pst.setString(3, modelocarro);
			pst.setInt(4, anocarro);
			
			int ret = pst.executeUpdate();
			if(ret > 0) {
				System.out.println(String.format("Linhas afetadas %d", ret));
				System.out.printf("\nRegistro alterado --- id :  %d //// marca : %s //// modelo : %s //// ano : %d", idcarro, marcacarro, modelocarro, anocarro);
			} else {
				System.out.println("Não foi possivel alterar o registro do carro");
			}
		
		}catch (SQLException se) {
			System.out.printf("Erro ao Atualizar o carro" + se);}
		}
		
		public void excluiCarro(int idcarro) {
			String sqlcmd = "DELETE FROM carro WHERE id_carro = ?";
			try {
				PreparedStatement pst;
				pst = con.prepareStatement(sqlcmd);
				pst.setInt(1, idcarro);
				int ret = pst.executeUpdate();
				if(ret > 0) {
					System.out.printf("/nCarro excluido : %d", idcarro);					
				}else {
					System.out.println("Não foi possivel excluir o registro do carro");
				}
			}catch (SQLException se) {
				System.out.println("Erro ao excluir o carro" + se);
			}
		}
}
