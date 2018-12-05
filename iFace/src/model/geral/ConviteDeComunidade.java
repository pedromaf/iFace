package model.geral;

import model.Comunidade;

public class ConviteDeComunidade {

    private Comunidade comunidade;

    public ConviteDeComunidade(Comunidade comunidade) {

        this.comunidade = comunidade;
    }

    public Comunidade getComunidade() {

        return this.comunidade;
    }

    public String toString() {

        return ("Voce foi convidado para entrar na " + this.comunidade.getNome() + "!\n");
    }
}
