package usuario;

public abstract class BaseUsuario {
    private int id;
    private String nome;
    private String email;
    private String cpf;
    private TipoUsuario tipo;
    protected DadosUsuario dadosUsuario;

    public BaseUsuario(DadosUsuario dadosUsuario) {
        this.dadosUsuario = dadosUsuario;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public String getCpf() {
        return this.cpf;
    }

    public String getEmail() {
        return this.email;
    }

    public abstract String cadastrarUsuario(String nome, String email, String cpf);
    public abstract String buscarUsuarioPorId(int id);
}
