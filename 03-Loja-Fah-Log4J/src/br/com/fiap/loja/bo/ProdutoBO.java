package br.com.fiap.loja.bo;

import org.apache.log4j.Logger;

import br.com.fiap.to.ProdutoTO;

public class ProdutoBO {
	private static Logger log = Logger.getLogger(ProdutoBO.class);
	public static ProdutoTO consultarProduto(int codigo) {
		if (codigo == 401) {
			log.debug(codigo + " - Playstation 4");
			return new ProdutoTO(codigo, 4000.00, 100, "PlayStation 4");
		} else if (codigo == 402) {
			log.debug(codigo + " - Xbox One");
			return new ProdutoTO(codigo, 3000.00, 100, "XboxOne");
		} else if (codigo == 403) {
			log.debug(codigo + " - Nintendo Switch");
			return new ProdutoTO(codigo, 3500.00, 100, "Nintendo Switch");
		} else {
			log.error(codigo + " - Produto não encontrado!");
			return new ProdutoTO(-1	, 0, 0, "Produto não encontrado!");
		}
	}

}
