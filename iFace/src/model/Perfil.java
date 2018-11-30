package model;

import model.geral.DadosPessoais;

public class Perfil {

    private int idConta = 0;
    private DadosPessoais dadosPessoais;

    public Perfil(int idConta, DadosPessoais dadosPessoais) {

        this.idConta = idConta;
        this.dadosPessoais = dadosPessoais;
    }
}
