package Application;

import Entities.Cliente;
import Entities.Conta;
import Entities.ContaCorrente;
import Entities.ContaPoupanca;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos clientes deseja adicionar? ");
        int numCliente = sc.nextInt();

        Conta[] contas = new Conta[numCliente];

        for (int i = 0; i < numCliente; i++) {
            System.out.println("Cadastro do cliente " + (i + 1));

            System.out.print("Digite o nome do cliente: ");
            sc.nextLine();  // Consumir a nova linha
            String nome = sc.nextLine();

            Cliente cliente = new Cliente();
            cliente.setNome(nome);

            System.out.print("Qual tipo de conta deseja criar? (1: Corrente, 2: Poupança): ");
            int tipoConta = sc.nextInt();

            if (tipoConta == 1) {
                contas[i] = new ContaCorrente(cliente);
            } else if (tipoConta == 2) {
                contas[i] = new ContaPoupanca(cliente);
            } else {
                System.out.println("Opção inválida. Será criada uma Conta Corrente por padrão.");
                contas[i] = new ContaCorrente(cliente);
            }
        }

        System.out.println("\nOperações nas contas:");

        // Exemplo de operações
        for (Conta conta : contas) {
            System.out.println("\nOperações para a conta de " + conta.getCliente().getNome());

            // Depositar
            System.out.print("Digite o valor para depositar: ");
            double valorDeposito = sc.nextDouble();
            conta.depositar(valorDeposito);
            System.out.println("Saldo após depósito: " + conta.getSaldo());

            // Sacar
            System.out.print("Digite o valor para sacar: ");
            double valorSaque = sc.nextDouble();
            conta.sacar(valorSaque);
            System.out.println("Saldo após saque: " + conta.getSaldo());

            // Imprimir Extrato
            conta.imprimirInfosComuns();
        }

        sc.close();
    }
}
