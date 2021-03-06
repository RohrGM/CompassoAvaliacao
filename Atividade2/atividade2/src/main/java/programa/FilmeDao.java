package programa;

import java.util.List;

import javax.persistence.EntityManager;

public class FilmeDao {
	
	private EntityManager em;
	
	public FilmeDao(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Filme filme) {
		this.em.persist(filme);
		System.out.printf("\nFilme criado criado: %s", filme.toString() );
	}
	
	public Filme buscarPorId(long id) {
		return em.find(Filme.class, id);
	}
	
	public List<Filme> getPaginaFilmes(int quantidade, int pagina){
		return em.createQuery("SELECT f FROM Filme f", Filme.class)
				.setMaxResults(quantidade)
				.setFirstResult((pagina-1) * quantidade )
				.getResultList();
		
	}
}
