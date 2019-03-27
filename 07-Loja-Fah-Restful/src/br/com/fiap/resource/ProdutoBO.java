package br.com.fiap.resource;

import java.util.ArrayList;
import java.util.List;

public class ProdutoBO {
	private static ProdutoBO produtoBo;
	private static ArrayList<ProdutoTO> lista = null;

	//Singleton
	public static ProdutoBO getInstance() {
		if (produtoBo == null) {
			produtoBo = new ProdutoBO();
		}
		return produtoBo;
	}
	public ProdutoBO() {
		lista = new ArrayList<ProdutoTO>();
		lista.add(new ProdutoTO(401, 3000, 100, "Playstation 4"));
		lista.add(new ProdutoTO(402, 2000, 100, "Xbox One"));
		lista.add(new ProdutoTO(403, 1500, 100, "Nintendo Switch"));
		System.out.println("Construiu!");
	}
	
	//Pesquisar
	public static ProdutoTO consultarProduto(int codigo) {
		for (ProdutoTO produto : lista) {
			if (produto.getCodigo() == codigo) {
				return produto;
			}
		}
		return null;
	}
	
	public List<ProdutoTO> listar(){
		return lista;
	}
	
	//Cadastrar
	public void cadastrar(ProdutoTO produto) {
		System.out.println("Gravou!");
		lista.add(produto);
	}
	
	//Remover
	public void remover(int codigo) {
		for (ProdutoTO produto : lista) {
			if(produto.getCodigo() == codigo) {
				lista.remove(produto);
				break;
			}
		}
	}
	
	//Atualizar
	public void atualizar(ProdutoTO produto) {
		for (ProdutoTO produto2 : lista) {
			produto2.setDescricao(produto.getDescricao());
			produto2.setPreco(produto.getPreco());
			produto2.setQuantidade(produto2.getQuantidade());
			break;
		}
	}

}
