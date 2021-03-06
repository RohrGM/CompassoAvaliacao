package programa;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;

public class Atividade {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);		
		cadastrarFilmes();
		
		while(true) {
		
			System.out.printf("\n######## Digite o numero de filmes por pagina e o numero da pagina ou 0 e 0 para sair #########\n");
			
			try {
				int quantidade = sc.nextInt();
				int pagina = sc.nextInt();
				
				if(quantidade == 0 && pagina == 0) {
					sc.close();
					System.exit(0);
				}
				
				consultaPagina(quantidade, pagina);		
				
			}catch (InputMismatchException e) {
				System.out.println("######### Op??o invalida #########");
			}
		}		
	}
	
	private static void consultaPagina(int quantidade, int pagina) {
		
		EntityManager em = JPAUtil.getEntity();
		FilmeDao dao = new FilmeDao(em);
		
		List<Filme> filmes = dao.getPaginaFilmes(quantidade, pagina);
		
		if(filmes.size() > 0) {
			filmes.forEach(f -> System.out.println(f.toString()));
		}else {
			System.out.printf("\n######### Sem filmes nessa pagina #########");
		}		
		em.close();
	}	

	private static void cadastrarFilmes() {
		
		EntityManager em = JPAUtil.getEntity();
		FilmeDao dao = new FilmeDao(em);
		em.getTransaction().begin();
		
		for(int i = 0; i < 20; i ++) {
			Filme filme = new Filme("Filme " + (i + 1), "Descri??o " + (i + 1), 2000);
			dao.cadastrar(filme);
		}
		em.getTransaction().commit();
		em.close();
	}
}

