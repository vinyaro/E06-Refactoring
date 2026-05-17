public abstract class Operacao {
    private double valor;

    public Operacao(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return this.valor;
    }

    public abstract String getTipo();

    @Override
    public String toString() {
        return this.getTipo() + ":\t" + this.valor;
    }
}