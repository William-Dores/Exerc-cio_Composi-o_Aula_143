package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.StatusPedido;

public class Pedidos {
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy HH:mm:ss");
	
	private Date momento;
	private StatusPedido statusPedidos;
	
	private Cliente cliente;
	List<ItemPedido> itemPedido = new ArrayList<>();
	
	public Pedidos() {
	
	}
	
	public Pedidos(Date momento, StatusPedido statusPedidos, Cliente cliente) {
		this.momento = momento;
		this.statusPedidos = statusPedidos;
		this.cliente = cliente;
	}
	
	public Date getMomento() {
		return momento;
	}
	
	public void setMomento(Date momento) {
		this.momento = momento;
	}
	
	public StatusPedido getStatusPedidos() {
		return statusPedidos;
	}
	
	public void setStatusPedidos(StatusPedido statusPedidos) {
		this.statusPedidos = statusPedidos;
	}
	
	public List<ItemPedido> getProdutos() {
		return itemPedido;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public List<ItemPedido> getItemPedido() {
		return itemPedido;
	}
	
	public void addItem(ItemPedido itemPedido) {
		this.itemPedido.add(itemPedido);
	}
	
	public void removerItem(ItemPedido itemPedido) {
		this.itemPedido.add(itemPedido);
	}
	
	public double total() {
		double soma = 0.0;
		for (ItemPedido itemPedido2 : itemPedido) {
			soma += itemPedido2.subTotal();
		}
		return soma;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Momento Pedido ");
		sb.append(sdf.format(momento) + " \n");
		sb.append("Status do Pedido");
		sb.append(statusPedidos + " \n");
		sb.append("CLiente: ");
		sb.append(cliente + " \n");
		sb.append("Itens pedidos: \n");
		for (ItemPedido itemPedido2 : itemPedido) {
			sb.append(itemPedido2 + "\n");
		}
		sb.append("Preço Total: $");
		sb.append(String.format("%.2f", total()));
		return sb.toString();
		
	}
	
		
}
