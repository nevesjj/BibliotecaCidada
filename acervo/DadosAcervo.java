package acervo;

import usuario.TipoUsuario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DadosAcervo {
    List<Map<String, Object>> acervo = new ArrayList<>();

    private int gerarProximoId() {
        return acervo.stream()
                .mapToInt(u -> (int) u.get("id"))
                .max()
                .orElse(0) + 1;
    }

    public Map<String, Object> criarItem(String titulo, String genero, String anoPublicacao, int capitulos, TipoItem tipo) {
        Map<String, Object> novoItem = new HashMap<>();

        novoItem.put("id", this.gerarProximoId());
        novoItem.put("titulo", titulo);
        novoItem.put("genero", genero);
        novoItem.put("capitulos", capitulos);
        novoItem.put("anoPublicacao", anoPublicacao);
        novoItem.put("tipo", tipo);

        acervo.add(novoItem);

        return novoItem;
    }

    public Map<String, Object> buscarPorId(int id) {
        return acervo.stream()
                .filter(u -> ((int) u.get("id")) == id)
                .findFirst()
                .orElse(null);
    }

    public Map<String, Object> buscarPorTitulo(String titulo) {
        return acervo.stream()
                .filter(u -> ((String) u.get("titulo")) == titulo)
                .findFirst()
                .orElse(null);
    }

    public List<Map<String, Object>> listarAcervo() {
        return acervo;
    }

    public Map<String, Object> editarItem(int id, String campo, String valor) {
        Map<String, Object> item = buscarPorId(id);

        item.put(campo, valor);

        return item;
    }
}
