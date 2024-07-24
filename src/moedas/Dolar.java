package moedas;

public class Dolar {

	public double cotacao = 5.44; //Cotação dia 11/07/2024
	public double valor;
	
	public void saldo() {
		this.valor += valor;
	}

	public void adicionar(double quantity) {
		this.valor += quantity;
	}

	public void remover(double quantity) {
		this.valor -= quantity;
	}
	
    public double getValorDolar() {
        return valor;
    }
    
    public double convertDolar() {
    	double convert = valor * cotacao;
        return convert;
    }

}
