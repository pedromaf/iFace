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

        return (this.autor + " [" + this.data.toString() + "]\n\t" + this.titulo + "\n " + this.texto + "\n");
    }
}
