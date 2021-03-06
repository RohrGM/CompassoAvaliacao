package programa;

import javax.persistence.EntityManager;

public class ProdutoDao {
	
	private EntityManager em;
	
	public ProdutoDao(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Produto produto) {
		this.em.persist(produto);
		System.out.printf("\nProduto criado: %s", produto.toString() );
	}
	
	public void atualizar(Produto produto) {
		this.em.merge(produto);
		System.out.printf("\n\nProduto alterado para: %s\n\n", produto.toString() );
	}
	
	public void remove(Produto produto) {
		try {
			produto = em.merge(produto);
			System.out.printf("\n\nProduto %s removido\n\n", produto.getNome());
			this.em.merge(produto);
			this.em.remove(produto);
		}catch (IllegalArgumentException e) {
			System.out.println("Produto n?o encontrado para ser removido");
		}
	}
	
	public Produto buscarPorId(long id) {
		return em.find(Produto.class, id);
	}

}
