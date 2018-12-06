package model;

import view.Erro;

public class Conta {

    private static int idGeral = 0;

    private int id;
    private String usuario;
    private String senha;

    private Perfil perfil;

    public Conta(String usuario, String senha) {

        this.id = ++idGeral;
        this.usuario = usuario;
        this.senha = senha;
    }

    public int getId() {

        return this.id;
    }

    public void associarPerfil(Perfil perfil) {

        if(this.perfil == null && perfil != null) {
            this.perfil = perfil;
            this.perfil.setIdConta(this.id);
        } else {
            Erro.erroAoAssociarPerfil();
        }
    }

    public boolean validarUsuario(String usuario) {

        return (this.usuario.equals(usuario));
    }

    public boolean validarSenha(String senha) {

        return (this.senha.equals(senha));
    }

    public boolean perfilCriado() {

        return (this.perfil != null);
    }

    public Perfil getPerfil() {

        return this.perfil;
    }

    public Perfil apagar() {

        this.perfil.apagar();
        return this.perfil;
    }
}
