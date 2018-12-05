package model.geral;

import model.Perfil;

public class SolicitacaoDeAmizade {

    private Perfil remetente;

    public SolicitacaoDeAmizade(Perfil remetente) {

        this.remetente = remetente;
    }

    public Perfil getRemetente() {

        return this.remetente;
    }

    public String toString() {

        return (this.remetente.getNome() + " quer ser seu amigo.");
    }
}
