import java.util.Locale;
import java.util.Scanner;

public class app {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		int qtdAtletas, qtdHomens=0, qtdMulheres=0;
		double altura, maiorAltura=0, peso, pesoTotal=0, porcentagemHomens, alturaMulheres=0;
		String nome, atletaMaisAlto="", sexo;
		
		System.out.print("Qual a quantidade de atletas: ");
		qtdAtletas = sc.nextInt();
		sc.nextLine();
		
		for(int i=0; i < qtdAtletas; i++) {
			System.out.printf("Digite os dados do atleta numero %d: %n", i+1);
			
			System.out.print("Nome: ");
			nome = sc.nextLine();
			
			
			System.out.print("Sexo: ");
			sexo = sc.next();
			while (!(sexo.equals("M") || sexo.equals("F"))) {
				System.out.print("Valor invalido! Favor digitar F ou M: ");
				sexo = sc.next();
			}
			
			System.out.print("Altura: ");
			altura = sc.nextDouble();
			while (altura <= 0) {
				System.out.print("Valor invalido! Favor digitar um valor positivo: ");
				altura = sc.nextDouble();
			}
			
			System.out.print("Peso: ");
			peso = sc.nextDouble();
			sc.nextLine();
			while (peso <= 0) {
				System.out.print("Valor invalido! Favor digitar um valor positivo: ");
				peso = sc.nextDouble();
			}
			
			
			if (sexo.equals("M")) {
				qtdHomens ++;
			} else {
				qtdMulheres ++;
				alturaMulheres += altura;
			}
			
			//Somar o peso total dos atletas
			pesoTotal += peso;
			
			//Checar maior altura
			if (altura > maiorAltura) {
				maiorAltura = altura;
				atletaMaisAlto = nome;
			}
		}
		
		porcentagemHomens = (qtdHomens * 100.00) / qtdAtletas;
		
		System.out.println();
		System.out.println("RELATÓRIO");
		System.out.printf("Peso médio dos atletas: %.2f%n", pesoTotal / qtdAtletas);
		System.out.println("Atleta mais alto: " + atletaMaisAlto);
		System.out.printf("Porcentagem de homens: %.1f %%%n", porcentagemHomens);
		if(qtdMulheres > 0) {
			System.out.printf("Altura média das mulheres: %.2f", alturaMulheres / qtdMulheres);
		} else {
			System.out.println("Não há mulheres cadastradas");
		}
		
		sc.close();
	}

}
