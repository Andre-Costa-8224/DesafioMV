package br.com.desafiomv.desafiomv.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO{
	
	private Connection conexao = null;
	
	public ClienteDAO(Connection conexao) {
		this.conexao = conexao;
	}
}
