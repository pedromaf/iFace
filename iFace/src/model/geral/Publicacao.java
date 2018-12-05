package model.geral;

public class Publicacao {

    private String autor;
    private Data data;
    private String titulo;
    private String texto;

    public Publicacao(String autor, String titulo, String texto) {

        this.autor = autor;
        this.data = new Data();
        this.titulo = titulo;
        this.texto = texto;
    }

    public String toString() {

        return (this.autor + " [" + this.data.toString() + "]\n\t" + this.titulo + "\n " + this.texto + "\n");
    }
}
