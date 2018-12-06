package model.geral;

import model.Perfil;

public class Publicacao {

    private boolean deletada;
    private Perfil autor;
    private Data data;
    private String titulo;
    private String texto;

    public Publicacao(Perfil autor, String titulo, String texto) {

        this.deletada = false;
        this.autor = autor;
        this.data = new Data();
        this.titulo = titulo;
        this.texto = texto;
    }

    public boolean eAutor(Perfil perfil) {

        return (autor.equals(perfil));
    }

    public Perfil getAutor() {

        return this.autor;
    }

    public boolean getDeletada() {

        return this.deletada;
    }

    public void apagar() {

        this.deletada = true;
        this.autor = null;
        this.data = null;
        this.titulo = null;
        this.texto = null;
    }

    public String toString() {

        if(this.deletada) {
            return null;
        }
        return (this.autor.getNome() + " [" + this.data.toString() + "]\n\n\t" + this.titulo + "\n\n " + this.texto + "\n\n" +
                "----------------------");
    }
}
