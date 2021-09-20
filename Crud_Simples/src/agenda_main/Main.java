package agenda_main;

import java.util.Date;

import agenda_dao.AgendaDao;
import pack_agenda.Contato;

public class Main {

	public static void main(String[] args) throws Exception  {
		// TODO Auto-generated method stub
		
		Contato contato = new Contato();
		AgendaDao agendadao = new AgendaDao();
		
		contato.setNome("Luci");
		contato.setIdade(18);
		contato.setDatacadastro(new Date());
		
		/*
		agendadao.SalvarContato(contato);
		*/
		
		
		
		
		// atualizar contato
		Contato contato2 = new Contato();
		contato2.setNome("Geraldo");
		contato2.setIdade(76);
		contato2.setDatacadastro(new Date());
		contato2.setId(8);// id do banco de tados
		
		
		//agendadao.AtualizarContato(contato2);
		
		// deletar contato pelo numero do id
		agendadao.DeletarById(7);
		
		
		// exibir os dados do banco de dados
		
		for(Contato x: agendadao.ListarContatos()) {
			System.out.println("===== Contados =====");
			System.out.println("Nome: " + x.getNome());
			System.out.println("Idade: " + x.getIdade());
			System.out.println("Data Cadastro: " + x.getDatacadastro());
		}

	}

}
