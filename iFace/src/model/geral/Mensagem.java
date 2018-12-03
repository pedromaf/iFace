package model.geral;

import model.Perfil;
import model.geral.Data;

public class Mensagem {

    private Perfil remetente;
    private Perfil destinatario;
    private Data data;
    private String texto;

    public Mensagem(Perfil remetente, Perfil destinatario, String texto) {

        this.remetente = remetente;
        this.destinatario = destinatario;
        this.data = new Data();
        this.texto = texto;
    }

    public String toString() {

        return (remetente.getNome() + "[" + this.data.toString() + "]:\n" + this.texto + "\n");
    }
}
