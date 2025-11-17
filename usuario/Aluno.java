package usuario;

import java.util.Map;

public class Aluno extends BaseUsuario {
    private int id;
    private String nome;
    private String email;
    private String cpf;
    private TipoUsuario tipo;

    public Aluno(DadosUsuario dadosUsuario) {
        super(dadosUsuario);
    }

    @Override
    public String cadastrarUsuario(String nome, String email, String cpf) {
        Map<String, Object> usuarioCpf = this.dadosUsuario.buscarPorCpf(cpf);

        if (usuarioCpf != null) {
            return "Usuário com CPF " + cpf + " já cadastrado";
        }

        Map<String, Object> usuarioEmail = this.dadosUsuario.buscarPorEmail(email);

        if (usuarioEmail != null) {
            return "Email " + email + " já cadastrado";
        }

        Map<String, Object> novoUsuario = this.dadosUsuario.criarUsuario(nome, email, cpf, TipoUsuario.ALUNO);

        return "Novo usuário cadastrado com sucesso. ID: " + novoUsuario.get("id");
    }
}
