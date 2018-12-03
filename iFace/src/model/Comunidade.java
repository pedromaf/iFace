package model;

import model.geral.Publicacao;

import java.util.ArrayList;

public class Comunidade {

    private Perfil criador;
    private ArrayList<Perfil> listaMembros;
    private ArrayList<Publicacao> listaPublicacoes;

    public Comunidade(Perfil criador) {

        this.criador = criador;
        this.listaMembros = new ArrayList<>();
        this.listaPublicacoes = new ArrayList<>();
    }
}
