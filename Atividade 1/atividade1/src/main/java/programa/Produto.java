package programa;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
	private String descricao;
	private Integer quantidade;
	private BigDecimal preco;
	@Column(name = "datacriacao")
	private LocalDate dataCriacao;
	@Column(name = "dataalteracao")
	private LocalDate dataAlteracao;

	public Produto() {}
	
	public Produto(String nome, String descricao, Integer quantidade, BigDecimal preco) {
		this.nome = nome;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.preco = preco;
		this.dataCriacao = LocalDate.now();
	}
	
	@Override
	public String toString() {
		return String.format("\n\nNome: %s\nDescri??o: %s\nQuantidade: %d\nPre?o: R$%.2f\nData de cria??o: %s\nData de Altera??o: %s\n\n",
							   getNome(), getDescricao(), getQuantidade(), getPreco(), getDataCriacao(), getDataAlteracao());
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	public LocalDate getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public LocalDate getDataAlteracao() {
		return dataAlteracao;
	}
	public void setDataAlteracao(LocalDate dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}	
}
