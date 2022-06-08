package desafiomv.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import desafiomv.model.Cliente;


public class ClientepjDAO {
	
	private Connection conexao = null;
	private String createtable = "create table if not exists clientespj( id int primary key not null auto_increment, nome varchar(100) not null, cnpj char(14) unique key not null, telefone varchar(11) not null, email varchar(100) not null);";
	
	public ClientepjDAO(Connection conexao) throws SQLException {
		this.conexao = conexao;
		PreparedStatement ps = this.conexao.prepareStatement(this.createtable);
		ps.execute();
		ps.close();
	}
	
	public List<String> findByCnpj(String cnpj) {
		
		try {
			
			List<String> cliente = new ArrayList<String>();
			
			PreparedStatement ps = this.conexao.prepareStatement("select * from clientespj where cnpj=?");
			
			ps.setString(1, cnpj);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				cliente.add(rs.getString("nome").toString());
				cliente.add(rs.getString("cnpj").toString());
				cliente.add(rs.getString("telefone").toString());
				cliente.add(rs.getString("email").toString());
				
			}
			
			ps.close();
			
			return cliente;
			
		} catch (Exception e) {
			System.out.println("Erro: "+e.getMessage());
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	public void cadastrar(Cliente cliente) {
		try {
			
			PreparedStatement ps = this.conexao.prepareStatement("insert into clientespj(nome, cnpj, email, telefone) values(?,?,?,?)");
			
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getCnpj());
			ps.setString(3, cliente.getEmail());
			ps.setString(4, cliente.getTelefone());
			
			ps.execute();
			ps.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<String> verdados() {
		
		try {
			
			List<String> clientes = new ArrayList<String>();
			
			PreparedStatement ps = this.conexao.prepareStatement("select * from clientespj");
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				clientes.add(rs.getString("nome").toString());
				clientes.add(rs.getString("cnpj").toString());
				clientes.add(rs.getString("telefone").toString());
				clientes.add(rs.getString("email").toString());
				
			}
			
			ps.close();
			
			return clientes;
			
		} catch (Exception e) {
			System.out.println("Erro: "+e.getMessage());
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	public void deletar(String cnpj) {
		
		try {
			
			PreparedStatement ps = this.conexao.prepareStatement("delete from clientespj where cnpj=?");
			
			ps.setString(1, cnpj);
			
			ps.execute();
			
			ps.close();
			
		} catch (Exception e) {
			
			System.out.println("Erro: "+e.getMessage());
			
		}
		
	}

}
