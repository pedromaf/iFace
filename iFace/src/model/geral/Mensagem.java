package model.geral;

import model.Perfil;

public class Mensagem {

    private Perfil remetente;
    private Data data;
    private String texto;

    public Mensagem(Perfil remetente, String texto) {

        this.remetente = remetente;
        this.data = new Data();
        this.texto = texto;
    }

    public String toString() {

        return (remetente.getNome() + " [" + this.data.toString() + "]:\n" + this.texto + "\n");
    }
}
