package moedas;

public class Euro {

	public double cotacao = 5.91; //Cotação dia 11/07/2024
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

    public double getValorEuro() {
        return valor;
    }
    
    public double convertEuro() {
    	double convert = valor * cotacao;
        return convert;
    }

}
