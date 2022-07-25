package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Cliente;
import entities.ItemPedido;
import entities.Pedidos;
import entities.Produtos;
import entities.enums.StatusPedido;

public class Program {
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("ENTRE COM OS DADOS DO CLIENTE");
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Data de Nascimento: (DD/MM/YYY)");
		Date dataNascimento = sdf.parse(sc.next());
		
		Cliente cliente = new Cliente(nome, email, dataNascimento);	
		
		System.out.println();
		System.out.println("Dados do Produdo:");
		System.out.print("Status: ");
		StatusPedido statusPedidos = StatusPedido.valueOf(sc.next());
		
		Pedidos pedidos = new Pedidos(dataNascimento, statusPedidos, cliente); 
		
		System.out.print("Quantos itens para este pedido? ");
		int quantPedido = sc.nextInt();
		
		for (int i = 01; i <= quantPedido; i++) {
			System.out.println("Entre com os dados do "+i+"# pedido:");
			System.out.print("Nome do Produto: ");
			String nomeProduto = sc.next();
			System.out.print("Preço do produto: ");
			double precoProduto = sc.nextDouble();
			
			Produtos produtos = new Produtos(nomeProduto, precoProduto);
			
			System.out.print("Quantidade do produto: ");
			int quantProduto = sc.nextInt();
			
			ItemPedido itemPedido = new ItemPedido(quantProduto, precoProduto, produtos);
			
			pedidos.addItem(itemPedido);
			
		}
		
		System.out.println();
		System.out.println("Resumo do pedido: ");
		System.out.println(pedidos);
		
		sc.close();
		

	}

}
