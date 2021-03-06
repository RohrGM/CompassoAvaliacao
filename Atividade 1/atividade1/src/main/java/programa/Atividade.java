package programa;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;
import javax.persistence.EntityManager;

public class Atividade {
	private static long execucoes = 0;
	
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);

		while(true) {			
			printMenu();
			
			String opcao = sc.nextLine();

			switch(opcao) {
			case "1":
				cadastroDeProdutos();
				break;
			case "2":
				AtualizaProduto();
				break;
			case "3":
				RemoverProduto();
				break;
			case "0":
				sc.close();
				System.exit(0);

			default:
				System.out.println("Op??o invalida");

			}
		}	
	}

	private static void printMenu() {
		System.out.println("1 - Cadastrar 3 produtos automaticamente");
		System.out.println("2 - Atualizar primeiro produto cadastrado");
		System.out.println("3 - Excluir segundo produto cadastrado");
		System.out.println("0 - Finalizar");		
	}

	private static void RemoverProduto() {
		EntityManager em = JPAUtil.getEntity();
		ProdutoDao dao = new ProdutoDao(em);

		Produto p = dao.buscarPorId((execucoes * 3l) - 1l);	
		em.getTransaction().begin();
		dao.remove(p);
		em.getTransaction().commit();
		em.close();
	}

	private static void AtualizaProduto() {
		EntityManager em = JPAUtil.getEntity();
		ProdutoDao dao = new ProdutoDao(em);

		Produto p = dao.buscarPorId((execucoes * 3l) - 2l);

		p.setPreco(new BigDecimal("1000"));
		p.setQuantidade(4);
		p.setDataAlteracao(LocalDate.now());

		em.getTransaction().begin();
		dao.atualizar(p);
		em.getTransaction().commit();
		em.close();
	}

	private static void cadastroDeProdutos() {
		Produto tv = new Produto("Televis?o", "Tv Smart 32 Polegadas", Integer.valueOf(5), new BigDecimal("3000"));
		Produto celular = new Produto("Celular LG", "Celular Lg K50", Integer.valueOf(2), new BigDecimal("2000"));
		Produto cadeira = new Produto("Cadeira tela", "Cadeira tela 90Kg Preta", Integer.valueOf(2), new BigDecimal("250"));
		execucoes += 1;

		EntityManager em = JPAUtil.getEntity();
		ProdutoDao dao = new ProdutoDao(em);

		em.getTransaction().begin();
		dao.cadastrar(tv);
		dao.cadastrar(celular);
		dao.cadastrar(cadeira);
		em.getTransaction().commit();
		em.close();
	}
}
