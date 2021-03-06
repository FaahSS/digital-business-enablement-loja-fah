package br.com.fiap.loja;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import br.com.fiap.loja.bo.ProdutoBO;
import br.com.fiap.loja.singleton.PropertySingleton;
import br.com.fiap.to.ProdutoTO;

public class TerminalConsulta {
	public static void main(String[] args) {
		Scanner e = new Scanner(System.in);

		int codigo = 0;
		String nomeLoja= PropertySingleton.getInstance().getProperty("nomeLoja");
		
		LocalDate hoje = LocalDate.now();
		DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		hoje.format(f);
		
		System.out.println(nomeLoja + " - Data: " + hoje.format(f));
		System.out.println("Informe o c�digo do produto: ");
		codigo = e.nextInt();
		e.close();
		
		ProdutoTO produto = ProdutoBO.consultarProduto(codigo);
		System.out.println(produto.getDescricao());
		
		
	}
}
