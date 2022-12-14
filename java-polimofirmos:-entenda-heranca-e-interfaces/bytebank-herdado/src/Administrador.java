public class Administrador extends Funcionario implements Autenticavel{

    private Autenticador autenticador;

    public Administrador(){
        Autenticador autenticador = new Autenticador();
    }

    @Override
    public void setSenha(int senha) {
        autenticador.setSenha(senha);
    }

    @Override
    public boolean autentica(int senha) {
        return autenticador.autentica(senha);
    }

    @Override
    public double getbonificacao() {
        return 50;
    }
    
}
