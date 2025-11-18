package usuario;

import java.util.Map;

public class Visitante extends BaseUsuario {
    public Visitante(DadosUsuario dadosUsuario) {
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

        Map<String, Object> novoUsuario = this.dadosUsuario.criarUsuario(nome, email, cpf, TipoUsuario.VISITANTE);

        return "Novo usuário cadastrado com sucesso. ID: " + novoUsuario.get("id");
    }
}
