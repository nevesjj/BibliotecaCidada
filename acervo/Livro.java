package acervo;

import java.util.Map;

public class Livro extends BaseAcervo {
    public Livro(DadosAcervo dadosAcervo) {
        super(dadosAcervo);
    }

    @Override
    public String cadastrarItem(String titulo, String genero, int capitulos, String anoPublicacao) {
        if (capitulos < 3) {
            return "Livro deve ter no minímo 3 capitulos";
        }

        Map<String, Object> itemTitulo = this.dadosAcervo.buscarPorTitulo(titulo);

        if (itemTitulo != null) {
            return "Título já cadastrado";
        }

        Map<String, Object> novoItem = this.dadosAcervo.criarItem(titulo, genero, anoPublicacao, capitulos, TipoItem.LIVRO);

        return "Novo livro cadastrado com sucesso. ID: " + novoItem.get("id");
    }

    @Override
    public Map<String, Object> atualizarItem(int id, String campo, String valor) {
        if (campo.equals("capitulos") && Integer.parseInt(valor) < 3) {
            System.out.println("Livro deve ter no minímo 3 capitulos");
            return null;
        }

        if (campo.equals("titulo")) {
            Map<String, Object> itemTitulo = this.dadosAcervo.buscarPorTitulo(valor);

            if (itemTitulo != null) {
                System.out.println("Título já cadastrado");
                return null;
            }
        }

        return this.dadosAcervo.editarItem(id, campo, valor);
    }
}
