package acervo;

import java.util.Map;

public abstract class BaseAcervo {
    private int id;
    private String titulo;
    private String genero;
    private int capitulos;
    private String anoPublicacao;
    private Boolean disponibilidade;
    private TipoItem tipo;
    protected DadosAcervo dadosAcervo;

    public BaseAcervo(DadosAcervo dadosAcervo) {
        this.dadosAcervo = dadosAcervo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public abstract String cadastrarItem(String titulo, String genero, int capitulos, String anoPublicacao);
    public abstract Map<String, Object> atualizarItem(int id, String campo, String valor);
}
