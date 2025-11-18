import usuario.Aluno;
import usuario.DadosUsuario;
import usuario.TipoUsuario;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BibliotecaCidada {
    public static void main(String[] args) {
        DadosUsuario dadosUsuario = new DadosUsuario();
        Aluno aluno = new Aluno(dadosUsuario);

        Scanner sc = new Scanner(System.in);
        int opcao = 0;
        int opcaoUsuario = 0;
        while (true) {
            System.out.println("*** Biblioteca Cidadã *** \n" +
                    "Digite a funcionalidade desejada: \n" +
                    "1. Menu Usuario\n" +
                    "2. Menu Acervo\n" +
                    "3. Menu Biblioteca\n" +
                    "4. Relatorio\n");
            opcao = sc.nextInt();
            sc.nextLine();
            switch (opcao) {
                case 1:
                    System.out.println("*** MENU USUÁRIO ***\n" +
                            "Digite a opcao desejada:\n" +
                            "1. Cadastrar \n" +
                            "2. Buscar por ID \n " +
                            "3. Listar usuários \n " +
                            "4. Editar\n" +
                            "5. Remover \n"+
                            "6. Voltar\n");
                    opcaoUsuario = sc.nextInt();
                    sc.nextLine();

                    switch (opcaoUsuario) {
                        case 1:
                            System.out.println("*** CADASTRAR NOVO USUÁRIO ***");
                            System.out.println("Digite nome do novo usuário: ");
                            String nome = sc.next();
                            sc.nextLine();

                            System.out.println("Digite email do novo usuário: ");
                            String email = sc.next();
                            sc.nextLine();

                            System.out.println("Digite CPF do novo usuário (ex: 12345678910): ");
                            String cpf = sc.next();
                            sc.nextLine();

                            System.out.println(aluno.cadastrarUsuario(nome, email, cpf));
                            break;
                        case 2:
                            System.out.println("Digite ID: ");
                            int id = sc.nextInt();
                            sc.nextLine();

                            Map<String, Object> usuario = dadosUsuario.buscarPorId(id);
                            System.out.println("*** BUSCA DE USUÁRIO POR ID ***\n" +
                                "ID: " + usuario.get("id") + "\n" +
                                "Nome: " + usuario.get("nome") + "\n" +
                                "Email: " + usuario.get("email") + "\n" +
                                "CPF: " + usuario.get("cpf") + "\n" +
                                "Tipo: " + usuario.get("tipo") + "\n"
                            );
                            break;
                        case 3:
                            List<Map<String, Object>> usuarios = dadosUsuario.listarUsuarios();

                            System.out.println("*** LISTAR USUÁRIOS ***");

                            for (int i = 0; i < usuarios.size(); i++) {
                                Map<String, Object> usuarioAux = usuarios.get(i);

                                System.out.println(
                                        "ID: " + usuarioAux.get("id") + "\n" +
                                        "Nome: " + usuarioAux.get("nome") + "\n" +
                                        "Email: " + usuarioAux.get("email") + "\n" +
                                        "CPF: " + usuarioAux.get("cpf") + "\n" +
                                        "Tipo: " + usuarioAux.get("tipo") + "\n" +
                                        "*************************"
                                );
                            }
                        case 4:
                            System.out.println("*** EDITAR USUÁRIO ***");
                            System.out.println("Digite ID: ");
                            int idEdit = sc.nextInt();
                            sc.nextLine();

                            Map<String, Object> usuarioEdit = dadosUsuario.buscarPorId(idEdit);
                            System.out.println("*** SELECIONE QUAL CAMPO EDITAR ***\n" +
                                    "1. Nome: " + usuarioEdit.get("nome") + "\n" +
                                    "2. Email: " + usuarioEdit.get("email") + "\n" +
                                    "3. CPF: " + usuarioEdit.get("cpf") + "\n"
                            );
                            int campoUsuario = sc.nextInt();
                            sc.nextLine();

                            String campo;
                            switch (campoUsuario) {
                                case 1: campo = "nome"; break;
                                case 2: campo = "email"; break;
                                case 3: campo = "cpf"; break;
                                default: campo = "";
                            }

                            if (campo.equals("")) {
                                System.out.println("Opção inválida");
                                continue;
                            }

                            System.out.println("Digite novo valor para " + campo + " :");
                            String novoValor = sc.next();
                            sc.nextLine();

                            Map<String, Object> usuarioEditado = aluno.editarAluno(idEdit, campo, novoValor);
//                            if (usuarioEdit.get("tipo") == TipoUsuario.ALUNO)

                            System.out.println("*** USUÁRIO EDITADO ***\n" +
                                    "1. Nome: " + usuarioEditado.get("nome") + "\n" +
                                    "2. Email: " + usuarioEditado.get("email") + "\n" +
                                    "3. CPF: " + usuarioEditado.get("cpf") + "\n"
                            );

                            break;
                    }
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
