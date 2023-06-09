import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);

        String separador = "\n**************************************\n";

        double saldo = 2500;
        double valorReceber = 0;
        double valorPagar = 0;
        int caso = 0;
        boolean loop = true;

        System.out.println(separador);

        String apresentacao = """
                Dados iniciais do cliente: 
                                            
                Nome:           Gabriel Machado
                Tipo conta:     Corrente
                Saldo inicial:  R$ %.2f
                """;

        System.out.print(apresentacao.formatted(saldo));

        System.out.println(separador);

        while (loop) {
            System.out.println("""
                    Operações
                                                
                    1- Consultar saldo
                    2- Receber valor
                    3- Transferir valor
                    4- Sair
                                                
                    """);

            System.out.println("Digite a opção desejada: ");
            caso = leitura.nextInt();

            switch (caso) {
                case 1:
                    System.out.println(String.format("\nO saldo atual é R$ %.2f\n", saldo));
                    break;

                case 2:
                    System.out.println("\nInforme o valor a receber: ");
                    valorReceber = leitura.nextDouble();
                    saldo += valorReceber;
                    System.out.println(String.format("\nSaldo atualizado: R$ %.2f\n", saldo));
                    break;

                case 3:
                    System.out.println("\nInforme o valor a ser transferido/sacado:");
                    valorPagar = leitura.nextDouble();
                    if(valorPagar > saldo){
                        System.out.println("Saldo insuficiente para realizar a transação");
                        break;
                    } else {
                        saldo -= valorPagar;
                        System.out.println(String.format("\nSaldo atualizado: R$ %.2f\n", saldo));
                        break;
                    }

                case 4:
                    System.out.println("\nPrograma encerrado!\n");
                    loop = false;
                    break;

                default:
                    System.out.println("\nOpção inválida!\n");
                    break;
            }
        }
    }
}