import acervo.DadosAcervo;
import acervo.Livro;
import usuario.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BibliotecaCidada {
    public static void main(String[] args) {
        DadosUsuario dadosUsuario = new DadosUsuario();
        Aluno aluno = new Aluno(dadosUsuario);
        Servidor servidor = new Servidor(dadosUsuario);
        Visitante visitante = new Visitante(dadosUsuario);

        DadosAcervo dadosAcervo = new DadosAcervo();
        Livro livro = new Livro(dadosAcervo);

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
                    int opcaoUsuario = sc.nextInt();
                    sc.nextLine();

                    switch (opcaoUsuario) {
                        // FUNCIONALIDADES DE USUÁRIOS
                        case 1:
                            System.out.println("*** CADASTRAR NOVO USUÁRIO ***");
                            System.out.println("*** MENU USUÁRIO ***\n" +
                                    "Digite o tipo de usuário para cadastro:\n" +
                                    "1. ALUNO \n" +
                                    "2. SERVIDOR \n " +
                                    "3. VISITANTE \n ");
                            int tipoCadastro = sc.nextInt();
                            sc.nextLine();

                            if (tipoCadastro < 1 || tipoCadastro > 3) {
                                System.out.println("*** USUARIO INVALIDO ***");
                                continue;
                            }

                            System.out.println("Digite nome do novo usuário: ");
                            String nome = sc.next();
                            sc.nextLine();

                            System.out.println("Digite email do novo usuário: ");
                            String email = sc.next();
                            sc.nextLine();

                            System.out.println("Digite CPF do novo usuário (ex: 12345678910): ");
                            String cpf = sc.next();
                            sc.nextLine();

                            if (tipoCadastro == 1) System.out.println(aluno.cadastrarUsuario(nome, email, cpf));
                            if (tipoCadastro == 2) System.out.println(servidor.cadastrarUsuario(nome, email, cpf));
                            if (tipoCadastro == 3) System.out.println(visitante.cadastrarUsuario(nome, email, cpf));
                            break;
                        case 2:
                            System.out.println("Digite ID: ");
                            int id = sc.nextInt();
                            sc.nextLine();

                            Map<String, Object> usuario = dadosUsuario.buscarPorId(id);

                            if (usuario == null) {
                                System.out.println("Usuário não encontrado!");
                            } else {
                                System.out.println("*** BUSCA DE USUÁRIO POR ID ***\n" +
                                        "ID: " + usuario.get("id") + "\n" +
                                        "Nome: " + usuario.get("nome") + "\n" +
                                        "Email: " + usuario.get("email") + "\n" +
                                        "CPF: " + usuario.get("cpf") + "\n" +
                                        "Tipo: " + usuario.get("tipo") + "\n"
                                );
                            }
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

                            break;
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

                            Map<String, Object> usuarioEditado = new HashMap<>();
                            if (usuarioEdit.get("tipo") == TipoUsuario.ALUNO) usuarioEditado = aluno.editarAluno(idEdit, campo, novoValor);
                            if (usuarioEdit.get("tipo") == TipoUsuario.SERVIDOR) usuarioEditado = servidor.editarServidor(idEdit, campo, novoValor);
                            if (usuarioEdit.get("tipo") == TipoUsuario.VISITANTE) usuarioEditado = visitante.editarVisitante(idEdit, campo, novoValor);

                            System.out.println("*** USUÁRIO EDITADO ***\n" +
                                    "1. Nome: " + usuarioEditado.get("nome") + "\n" +
                                    "2. Email: " + usuarioEditado.get("email") + "\n" +
                                    "3. CPF: " + usuarioEditado.get("cpf") + "\n"
                            );

                            break;
                        case 5:
                            System.out.println("*** REMOVER USUÁRIO ***");
                            System.out.println("Digite ID: ");
                            int idRemove = sc.nextInt();
                            sc.nextLine();

                            System.out.println(dadosUsuario.removerUsuario(idRemove));
                            break;
                        default:
                            System.out.println("Opção inválida!");
                    }
                    break;

                // FUNCIONALIDADES DE ACERVO
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
                    int opcaoAcervo = sc.nextInt();
                    sc.nextLine();

                    switch (opcaoAcervo) {
                        case 1:
                            System.out.println("*** CADASTRAR ITEM NO ACERVO ***");
                            System.out.println(
                                    "SELECIONE O TIPO DE ITEM\n" +
                                    "1. LIVRO\n" +
                                    "2. REVISTA\n" +
                                    "3. MIDIA DIGITAL\n"
                                    );
                            int tipo = sc.nextInt();
                            sc.nextLine();

                            if (tipo < 1 || tipo > 3) {
                                System.out.println("Opção inválida");
                            }

                            System.out.println("Digite o título do novo item: ");
                            String titulo = sc.next();
                            sc.nextLine();

                            System.out.println("Digite o gênero do novo item: ");
                            String genero = sc.next();
                            sc.nextLine();

                            System.out.println("Digite a quantidade de capitulos do novo item: ");
                            int capitulos = sc.nextInt();
                            sc.nextLine();

                            System.out.println("Digite o ano de publicação (ex: 01/01/2020): ");
                            String anoPublicacao = sc.next();
                            sc.nextLine();

                            if (tipo == 1) System.out.println(livro.cadastrarItem(titulo, genero, capitulos, anoPublicacao));

                            break;
                        case 2:
                            System.out.println("*** BUSCAR ITEM POR ID ***");
                            System.out.println("Digite ID: ");
                            int id = sc.nextInt();
                            sc.nextLine();

                            Map<String, Object> item = dadosAcervo.buscarPorId(id);

                            if (item == null) {
                                System.out.println("Usuário não encontrado!");
                            } else {
                                System.out.println("*** BUSCA DE USUÁRIO POR ID ***\n" +
                                        "ID: " + item.get("id") + "\n" +
                                        "Título: " + item.get("titulo") + "\n" +
                                        "Gênero: " + item.get("genero") + "\n" +
                                        "Capítulos: " + item.get("capitulos") + "\n" +
                                        "Ano de Publicação: " + item.get("anoPublicacao") + "\n" +
                                        "Tipo: " + item.get("tipo") + "\n"
                                );
                            }
                            break;
                        case 3:
                            List<Map<String, Object>> acervo = dadosAcervo.listarAcervo();

                            System.out.println("*** LISTAR TODO O ACERVO ***");

                            for (int i = 0; i < acervo.size(); i++) {
                                Map<String, Object> itemAcervo = acervo.get(i);

                                System.out.println(
                                        "ID: " + itemAcervo.get("id") + "\n" +
                                                "Título: " + itemAcervo.get("titulo") + "\n" +
                                                "Gênero: " + itemAcervo.get("genero") + "\n" +
                                                "Capítulos: " + itemAcervo.get("capitulos") + "\n" +
                                                "Ano de Publicação: " + itemAcervo.get("anoPublicacao ") + "\n" +
                                                "Tipo: " + itemAcervo.get("tipo") + "\n" +
                                                "*************************"
                                );
                            }

                            break;
                    }

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
