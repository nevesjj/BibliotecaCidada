public abstract class Usuario {
    private  int id;
    private String nome;
    private String documento;
    private int tipo;

    public static final int ALUNO = 1;
    public static final int SERVIDOR = 2;
    public static final int VISITANTE = 3;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }


    public String tpPrestador () {
        return switch (tipo) {
            case ALUNO -> "Usuário - Aluno";
            case SERVIDOR -> "Usuário - Servidor";
            case VISITANTE -> "Usuário - Visitante";
            default -> "Tipo desconhecido";
        };
    };
}
