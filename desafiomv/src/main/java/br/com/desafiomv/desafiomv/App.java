package br.com.desafiomv.desafiomv;

/**
 * Desafio CÉLULA FINANCEIRO E CONTROLADORIA
 *
 */
import br.com.desafiomv.desafiomv.dao.clienteDAO
import br.com.desafiomv.desafiomv.ConnectionFactory

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
	ConnectionFactory conn = new ConnectionFactory;
	System.out.println(conn.getConnection());
    }
}
