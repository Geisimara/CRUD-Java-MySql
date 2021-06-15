package agenda_conecction;

// ctrl + shift + O = elimina os imports desnecessarios

import java.sql.Connection;
import java.sql.DriverManager;

public class Conecction_db_agenda {

	// configura��es pra o bd
	
	// nome do usuario do mysql
	private static final String USERNAME = "root";
	
	// senha do bd 
	private static final String PASSWORD = "";
	
	// caminho do bando de dados, porta, padrao, nome banco de dados
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/db_java";
	
	
	
	
	/* conexao com bd 	
	   criar o metodo de conexao
	*/
	
	public static Connection ConexaoMysql() throws Exception {
		// faz com que a classe seja carregada pela jvm
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// usa os atributos de conexao 
		Connection conexao = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		return conexao;
		
	}
	
	// verifica��o de conexao, cada usuario s� pode ter uma conexao no bd
	
	public static void main(String[] args) throws Exception {
		
		// recupera uma conexao com o bd se ja tiver uma
		Connection con = ConexaoMysql();
		
		// Testar se a conexao � nula
		if(con != null) {
			System.out.println("Conexao obtida com sucesso");
			con.close();
		}
	}
	
	
}
