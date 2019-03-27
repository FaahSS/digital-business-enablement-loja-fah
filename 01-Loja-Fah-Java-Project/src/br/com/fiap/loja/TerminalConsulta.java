package br.com.fiap.loja;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TerminalConsulta {
	public static void main(String[] args) {
		Scanner e = new Scanner(System.in);

		int codigo = 0;
		String nomeLoja="Loja: FaahSS Games";
		
		LocalDate hoje = LocalDate.now();
		DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		hoje.format(f);
		

		System.out.println("Informe o código do produto: ");
		codigo = e.nextInt();

		if (codigo == 401) {
			System.out.println("PlayStation 4");
		} else if (codigo == 402) {
			System.out.println("Xbox One");
		} else if (codigo == 403) {
			System.out.println("Nintendo Switch");
		} else {
			System.out.println("Produto não encontrado");
		}
		System.out.println(nomeLoja);
		System.out.println(hoje);
		
		
	}
}
