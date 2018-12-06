package model.geral;

import model.Perfil;

public class Publicacao {

    private Perfil autor;
    private Data data;
    private String titulo;
    private String texto;

    public Publicacao(Perfil autor, String titulo, String texto) {

        this.autor = autor;
        this.data = new Data();
        this.titulo = titulo;
        this.texto = texto;
    }

    public boolean eAutor(Perfil perfil) {

        return (autor.equals(perfil));
    }

    public void apagar() {

        this.autor = null;
        this.data = null;
        this.titulo = null;
        this.texto = null;
    }

    public String toString() {

        return (this.autor.getNome() + " [" + this.data.toString() + "]\n\n\t" + this.titulo + "\n\n " + this.texto + "\n\n" +
                "----------------------");
    }
}
