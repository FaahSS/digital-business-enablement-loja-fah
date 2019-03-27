package br.com.fiap.loja.bo;

import org.apache.axis2.AxisFault;

import br.com.fiap.to.ProdutoTO;

public class ProdutoBO {
	public static ProdutoTO consultarProduto(int codigo) throws AxisFault {
		if (codigo == 401) {
			return new ProdutoTO(codigo, 4000.00, 100, "PlayStation 4");
		} else if (codigo == 402) {
			return new ProdutoTO(codigo, 3000.00, 100, "XboxOne");
		} else if (codigo == 403) {
			return new ProdutoTO(codigo, 3500.00, 100, "Nintendo Switch");
		} else {
			throw new AxisFault("Produto não encontrado!");
		}
	}

}
