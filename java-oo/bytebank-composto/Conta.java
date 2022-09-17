public class Conta {
    private double saldo;
    int agencia;
    int numero;
    Cliente  titular;

    public void deposita(double valor) {
        saldo += valor;
    }

    public boolean saca(double valor){
        if(this.saldo >= valor) {
            this.saldo -= valor;
            return true;
        } else {
            return false;
        }
    }

    public boolean transfere(double valor, Conta destino){
        
        boolean sacou = this.saca(valor);
        if(sacou) {
            destino.saldo += valor;
            return true;
        } else {
            return false;
        }
        
    }

    public double getSaldo(){
        return saldo;
    }
}
