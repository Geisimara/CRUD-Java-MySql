package agenda_main;

import agenda_dao.AgendaDao;
import pack_agenda.Contato;

public class Main {

	public static void main(String[] args) throws Exception  {
		// TODO Auto-generated method stub
		
		Contato contato = new Contato();
		
		/*contato.setNome("GG");
		contato.setIdade(34);
		contato.setDatacadastro(new Date());
		*/
		
		AgendaDao agendadao = new AgendaDao();
		agendadao.SalvarContato(contato);
		
		// exibir os dados do banco de dados
		
		for(Contato x: agendadao.ListarContatos()) {
			System.out.println("===== Contados =====");
			System.out.println("Nome: " + x.getNome());
			System.out.println("Idade: " + x.getIdade());
			System.out.println("Data Cadastro: " + x.getDatacadastro());
		}

	}

}
