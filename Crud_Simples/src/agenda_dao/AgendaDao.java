package agenda_dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import agenda_conecction.Conecction_db_agenda;
import pack_agenda.Contato;

public class AgendaDao {

	// DAO = Objeto de acesso a dados
	// quandos e usa o acesso ao banco de dados pra fazer buscas CRUD
	
	// CRUD = C: create, R: read, U: update, Delete
	
	
	public void SalvarContato(Contato contato) throws SQLException {
		
		// salvar contato com o insert
		
		String sql = "INSERT INTO crud_agenda_java(nome,idade,datacadastro) VALUES (?,?,?)";
		
		Connection conn = null;
		
		// execução da query
		PreparedStatement execquery = null;
		
		// tentar se conectar ao bd
		
		try {
			
			// criar uma conexao com o bd
			conn = Conecction_db_agenda.ConexaoMysql();
			
			// executar a query
			execquery = conn.prepareStatement(sql);
			
			//passar os parametros do insert
			execquery.setString(1, contato.getNome());
			execquery.setInt(2, contato.getIdade());
			execquery.setDate(3, new Date(contato.getDatacadastro().getTime()));
			
			// executar a query
			execquery.execute();
			System.out.println("Contato salvo com sucesso !!");
			
			
		}catch (Exception e) {
			
			e.printStackTrace(); // exibir a exeption
			
		}finally {
			
			// fechar as conexoes caso estejam abertas
			if(execquery != null) {
				execquery.close();
			}
			if(conn != null) {
				conn.close();
			}			
		}
		
	}

	public List<Contato> ListarContatos() throws Exception{

		
		// instancia a lista 
		List<Contato> listaContatos = new ArrayList<Contato>();
		
		// busca no banco de dados
		String sql = "SELECT * FROM crud_agenda_java";
		
		Connection conn = null;
		PreparedStatement execquery = null;
		
		// vai retornar os dados do banco
		ResultSet retornadados = null;
		
		try {
			
			// criar uma conexao com o bd
			conn = Conecction_db_agenda.ConexaoMysql();
			
			// executar a query
			execquery = conn.prepareStatement(sql);
			
			// receber o que retornar do banco
			retornadados = execquery.executeQuery();
			
			// percorrer os dados com o while
			
			while (retornadados.next()) {
				
				// cria uma istancia da classe contato 
				Contato contato = new Contato();
				
				
				/*separa as informaçãos do banco de dados que vem como array
				 * para colocar dentro da lista
				 */
				
				//recuperar o id
				contato.setId(retornadados.getInt("id"));
				// recupera nome
				contato.setNome(retornadados.getString("nome"));
				//recupera idade
				contato.setIdade(retornadados.getInt("idade"));
				//recupera data cadastro
				contato.setDatacadastro(retornadados.getDate("datacadastro"));
				
				// adiciona o objeto criadao na lista
				listaContatos.add(contato);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			// fechar as conexoes caso estejam abertas
			if(execquery != null) {
				conn.close();
			}
			
			else if(retornadados !=null) {
				retornadados.close();
			}
			
			else if(conn != null) {
				conn.close();
			}
		}
		
		
					
		return listaContatos;
		
	}
	
	public void AtualizarContato(Contato contato) throws SQLException {
		
		// inserir a query 
		String sql = "UPDATE crud_agenda_java SET nome = ?, idade = ?, datacadastro = ?"+
		"WHERE id = ?";
		
		// CONEXOES
		Connection conn = null; // OBJ DE CONEXAO
		
		//É usado para criar um objeto que representa a instrução SQL 
		//que será executada, sendo que é invocado através do objeto Connetion.
		PreparedStatement execquery = null;
		
		
		
		// tentar fazer a conexao	
		
		try {
			
			// conexao com a classe 			
			conn = Conecction_db_agenda.ConexaoMysql();
			
			// criar a classe para execução da query
			execquery = conn.prepareStatement(sql);
			
			// setar os valores para o bd
			execquery.setString(1, contato.getNome());
			execquery.setInt(2, contato.getIdade());
			execquery.setDate(3, new Date(contato.getDatacadastro().getTime()));
			// WHERE condição do id
			execquery.setInt(4, contato.getId());
			
			// execução
			execquery.execute();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			// encerrar as conexoes abertas
			
			if(conn != null) {
				conn.close();
			}
			if(execquery != null) {
				execquery.close();
			}
		}
		
	}
	
}
