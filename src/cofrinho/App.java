package cofrinho;

import java.util.Locale;
import java.util.Scanner;
import javax.swing.JOptionPane;

import moedas.Dolar;
import moedas.Euro;
import moedas.Real;

public class App {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US); // Locale define qual será o separador decimal de acordo com a região.
		Scanner sc = new Scanner(System.in); // Método Scanner utilizado para o input de dados via teclado.

		int resp = 0;
		
		// Construtores instanciados a variaveis.
		Dolar dolar = new Dolar();
		Euro euro = new Euro();
		Real real = new Real();

		while (true) {
			
			// Menu com as operações que podem ser executadas
			String textoMenu = "1 - Adicionar moeda\n"
							 + "2 - Remover moeda \n"
							 + "3 - Listar moedas \n"
							 + "4 - Total em Reais \n"
							 + "0 - Sair";

			resp = Integer.parseInt(JOptionPane.showInputDialog(textoMenu));

			if (resp == 0) 
			{
				JOptionPane.showMessageDialog(null, "Cofre fechado");
				break;
			}
			
			/*
			 * Nesta parte está a lógica para adicionar moedas, sendo solicitado qual moeda
			 * será guardada e seu valor.
			 */
			if (resp == 1) 
			{
				String moedaEscolhida = JOptionPane.showInputDialog("Informe qual moeda irá guardar sendo Dolar|Euro|Real");

				double valor = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor a adicionar:"));

				if (moedaEscolhida.equals("real")) {
					
					real.adicionar(valor);
					JOptionPane.showMessageDialog(null, "Seu saldo atual é de R$ " + real.getValorReal());
				}

				else if (moedaEscolhida.equals("dolar")) {

					dolar.adicionar(valor);
					JOptionPane.showMessageDialog(null, "Seu saldo atual é de US$ " + dolar.getValorDolar());
				}

				else if (moedaEscolhida.equals("euro")) {
					euro.adicionar(valor);
					JOptionPane.showMessageDialog(null, "Seu saldo atual é de € " + euro.getValorEuro());
				}

			}

			/*
			 * Nesta parte está a lógica para remover moedas, sendo solicitado qual moeda
			 * será guardada e seu valor.
			 */
			else if (resp == 2) 
			{
				String moedaEscolhida = JOptionPane.showInputDialog("Informe qual moeda irá ser removida sendo Dolar|Euro|Real");

				double valor = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor a ser removido:"));

				if (moedaEscolhida.equals("real")) 
				{
					
					/* Regra simples para que não seja retirado mais do que se tem no cofre. */
					if(real.getValorReal() - valor >= 0) 
					{
						real.remover(valor);	
						JOptionPane.showMessageDialog(null, "Moeda removida.");
					}
					else 
					{
						JOptionPane.showMessageDialog(null, "Não é possivel retirar mais valores");
					}
					
					JOptionPane.showMessageDialog(null, "Seu saldo atual é de R$ " + real.getValorReal());
				}

				else if (moedaEscolhida.equals("dolar")) 
				{
					
					/* Regra simples para que não seja retirado mais do que se tem no cofre. */
					if(dolar.getValorDolar() - valor >= 0) 
					{
						dolar.remover(valor);	
						JOptionPane.showMessageDialog(null, "Moeda removida.");
					}
					else 
					{
						JOptionPane.showMessageDialog(null, "Não é possivel retirar mais valores");
					}

					JOptionPane.showMessageDialog(null, "Seu saldo atual é de US$ " + dolar.getValorDolar());
				}

				else if (moedaEscolhida.equals("euro")) 
				{
					
					/* Regra simples para que não seja retirado mais do que se tem no cofre. */
					if(euro.getValorEuro() - valor >= 0) 
					{
						euro.remover(valor);	
						JOptionPane.showMessageDialog(null, "Moeda removida.");
					}
					else 
					{
						JOptionPane.showMessageDialog(null, "Não é possivel retirar mais valores");
					}
					
					JOptionPane.showMessageDialog(null, "Seu saldo atual é de € " + euro.getValorEuro());
				}

			}
			
			// Lista as moedas sem converte-las.
			else if (resp == 3) 
			{
				JOptionPane.showMessageDialog(null, "Saldo atual é de R$ " + real.getValorReal() + "\n"
												  + "Saldo atual é de US$ " + dolar.getValorDolar() + "\n"
												  + "Saldo atual é de € " + euro.getValorEuro());

			}
			
			// Lista as moedas convertendo as com cotação consultada em 11/07/2024
			else if (resp == 4) 
			{
				JOptionPane.showMessageDialog(null, "Saldo atual é de R$ " + real.getValorReal() + "\n"
												  + "Saldo convertido em R$ " + dolar.convertDolar() + "\n"
												  + "Saldo convertido em R$" + euro.convertEuro());
			}

			//Caso seja digitado alguma opção errada, o programa irá alertar e retornar ao loop.
			else 
			{
				JOptionPane.showMessageDialog(null, "Opção inválida!");
			}

		}
		
		sc.close();
	}
}
