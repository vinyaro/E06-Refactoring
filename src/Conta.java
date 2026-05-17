import java.util.ArrayList;
import java.util.List;

public class Conta {

    // Composição com as classes que eu extraí
    private Cliente cliente;
    private Agencia agencia;

    // Field renomeado de 'valor' para 'saldo'
    private double saldo;
    private List<Operacao> operacoes;

    public Conta(String nomeCliente, String cpfCliente, String telefoneCliente, int numAgencia, int numConta, String gerente, double valor) {
        this.cliente = new Cliente(nomeCliente, cpfCliente, telefoneCliente);
        this.agencia = new Agencia(numAgencia, numConta, gerente);
        this.saldo = valor;
        this.operacoes = new ArrayList<>();
    }

    public Conta() {
        this(null, null, null, 0, 0, null, 0);
    }

    // Método simplificado usando polimorfismo e extração de método
    public void realizarOperacao(char tipo, int valor) {
        Operacao op = criarOperacao(tipo, valor);
        if (op != null) {
            this.operacoes.add(op);
            this.atualizarSaldo(tipo, valor);
        }
    }

    // Fábrica interna simples para instanciar as subclasses corretas
    private Operacao criarOperacao(char tipo, int valor) {
        if (tipo == 'd') return new Deposito(valor);
        if (tipo == 's') return new Saque(valor);
        return null;
    }

    // Método extraído para isolar a atualização do saldo bancário
    private void atualizarSaldo(char tipo, int valor) {
        if (tipo == 'd') {
            this.saldo += valor;
        } else if (tipo == 's') {
            this.saldo -= valor;
        }
    }

    // Método extraído para isolar a montagem textual do extrato
    public String gerarExtrato() {
        StringBuilder dadosExtrato = new StringBuilder();
        for (Operacao op : this.operacoes) {
            dadosExtrato.append(op.toString()).append("\n");
        }
        return dadosExtrato.toString();
    }

    @Override
    public String toString() {
        // Delegação de formatação para as classes responsáveis
        String dadosClienteStr = this.cliente.toString();
        String dadosContaStr = this.agencia.toString() + String.format("\nSaldo: %.2f", this.saldo);
        String dadosExtratoStr = this.gerarExtrato();

        return dadosClienteStr + "\n\n" + dadosContaStr + "\n\n" + dadosExtratoStr;
    }
}