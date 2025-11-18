package usuario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DadosUsuario {
    List<Map<String, Object>> usuarios = new ArrayList<>();

    private int gerarProximoId() {
        return usuarios.stream()
                .mapToInt(u -> (int) u.get("id"))
                .max()
                .orElse(0) + 1;
    }

    public Map<String, Object> criarUsuario(String nome, String email, String cpf, TipoUsuario tipo) {
        Map<String, Object> novoUsuario = new HashMap<>();

        novoUsuario.put("id", this.gerarProximoId());
        novoUsuario.put("nome", nome);
        novoUsuario.put("email", email);
        novoUsuario.put("cpf", cpf);
        novoUsuario.put("tipo", tipo);

        usuarios.add(novoUsuario);

        return novoUsuario;
    }

    public Map<String, Object> buscarPorId(int id) {
        return usuarios.stream()
                .filter(u -> ((int) u.get("id")) == id)
                .findFirst()
                .orElse(null);
    }

    public Map<String, Object> buscarPorCpf(String cpf) {
        return usuarios.stream()
                .filter(u -> u.get("cpf").equals(cpf))
                .findFirst()
                .orElse(null);
    }

    public Map<String, Object> buscarPorEmail(String email) {
        return usuarios.stream()
                .filter(u -> u.get("email").equals(email))
                .findFirst()
                .orElse(null);
    }

    public List<Map<String, Object>> listarUsuarios() {
        return usuarios;
    }

    public Map<String, Object> editarUsuarios(int id, String campo, String valor) {
        Map<String, Object> usuario = buscarPorId(id);

        usuario.put(campo, valor);

        return usuario;
    }
}
