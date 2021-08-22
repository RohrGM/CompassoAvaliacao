package programa;

import java.util.Scanner;

public class Atividade {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);	
		
		System.out.println("Digite sua mensagem: ");
		
		String mensagem = sc.nextLine();
		
		contadorDePalavras ct = new contadorDePalavras();
		
		int divertido = ct.contador(mensagem, ":-)");
		int chateado = ct.contador(mensagem, ":-(");
		
		System.out.printf("\nDivertido: %d Chateado %d\n", divertido, chateado);
		
		if(divertido > chateado) {
			System.out.println("A mensagem expressa um sentimento dirverdito");
		}else if(divertido < chateado) {
			System.out.println("A mensagem expressa um sentimento chateado");
		}else {
			System.out.println("A mensagem expressa um sentimento neutro");
		}
		
	}
}
