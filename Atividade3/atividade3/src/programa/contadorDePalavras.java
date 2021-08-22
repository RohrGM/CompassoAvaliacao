package programa;

public class contadorDePalavras {




	public int contador(String frase, String alvo) {
		int cont = 0;

		while(true) {

			int index = frase.indexOf(alvo);

			if(index != -1) {
				cont++;
				frase = frase.substring(0, index)+ frase.substring(index + 3);
			}else {

				return cont;
			}
		}
	}
}
