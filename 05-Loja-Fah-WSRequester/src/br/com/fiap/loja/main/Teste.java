package br.com.fiap.loja.main;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import br.com.fiap.loja.bo.ProdutoBOStub;
import br.com.fiap.loja.bo.ProdutoBOStub.ConsultarProduto;
import br.com.fiap.loja.bo.ProdutoBOStub.ConsultarProdutoResponse;
import br.com.fiap.loja.bo.ProdutoBOStub.ProdutoTO;

public class Teste {
	public static void main(String[] args) throws RemoteException {
		Scanner e = new Scanner(System.in);
		int codigo = 0;
		String nomeLoja="Loja: FaahSS Games";
		
		LocalDate hoje = LocalDate.now();
		DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		hoje.format(f);
		System.out.println(nomeLoja + " " + "Data: " + hoje.format(f));

		System.out.println("Informe o código do produto: ");
		codigo = e.nextInt();
		
		ProdutoBOStub stub = new ProdutoBOStub();
		ConsultarProduto consulta = new ConsultarProduto();
		consulta.setCodigo(codigo);
		stub.consultarProduto(consulta);
		ConsultarProdutoResponse response = stub.consultarProduto(consulta);
		ProdutoTO produto = response.get_return();
		
		System.out.println();
		System.out.println("Produto: " + produto.getDescricao());
	}

}
