import java.util.Scanner;

public class BibliotecaCidada {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao = 0;
        while (true) {
            System.out.println("*** Biblioteca Cidadã *** \n" +
                    "Digite a funcionalidade desejada: \n" +
                    "1. Menu Usuario\n" +
                    "2. Menu Acervo\n" +
                    "3. Menu Biblioteca\n" +
                    "4. Relatorio\n");
            opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("*** MENU USUÁRIO ***\n" +
                            "Digite a opcao desejada:\n" +
                            "1. Cadastrar \n" +
                            "2. Buscar \n " +
                            "3. Editar\n" +
                            "4. Remover \n"+
                            "5. Voltar\n");
                    break;
                case 2:
                    System.out.println("*** MENU ACERVO ***\n" +
                            "Digite a opcao desejada:\n" +
                            "1. Cadastrar livro, revista ou MidiaDigital\n"+
                            "2. Buscar Item por id\n"+
                            "3. Buscar todo o acerto\n"+
                            "4. Atualizar Item por id\n"+
                            "5. Remover Item por id\n"+
                            "6. Voltar\n"
                            );
                    break;
                case 3:
                    System.out.println("*** MENU BIBLIOTECA ***\n" +
                            "Digite a opcao desejada:\n" +
                            "1. Realizar emprestimo\n"+
                            "2. Realizar devolucao\n"+
                            "3. Calcular multa\n"+
                            "4. Voltar\n"
                    );
                    break;
                case 4:
                    System.out.println("*** RELATORIO ***\n" +
                            "Digite a opcao desejada:\n" +
                            "1. Itens disponíveis/emprestados\n" +
                            "2. Empréstimos em atraso\n"+
                            "2. Histórico por usuário\n"+
                            "3. Voltar\n"
                    );
                    break;
                default:
                    System.out.println("Opcao Invalida\n");
            }
        }
    }
}
