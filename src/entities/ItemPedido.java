package entities;

public class ItemPedido {
	private Integer quantidade;
	private Double preco;
	
	private Produtos produtos;
	
	public ItemPedido() {
		
	}

	public ItemPedido(Integer quantidade, Double preco, Produtos produtos) {
		this.quantidade = quantidade;
		this.preco = preco;
		this.produtos = produtos;
		
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	public Produtos getProdutos() {
		return produtos;
	}

	public void setProdutos(Produtos produtos) {
		this.produtos = produtos;
	}
	
	public double subTotal() {
		return quantidade * preco;
	}

	@Override
	public String toString() {
		return produtos.getNome()
				+", $"
				+String.format("%.2f", preco)
				+", quantidade: "
				+quantidade
				+", SubTotal: $"
				+String.format("%.2f", subTotal());
	}
	


}
