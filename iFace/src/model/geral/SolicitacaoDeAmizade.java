package model.geral;

import model.Perfil;

public class SolicitacaoDeAmizade {

    private Perfil remetente;
    private Perfil destinatario;

    public SolicitacaoDeAmizade(Perfil remetente, Perfil destinatario) {

        this.remetente = remetente;
        this.destinatario = destinatario;
    }
}
