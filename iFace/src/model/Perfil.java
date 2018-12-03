package model;

import model.geral.DadosPessoais;
import model.geral.Mensagem;
import model.geral.SolicitacaoDeAmizade;
import view.Erro;

import java.util.ArrayList;

public class Perfil {

    private int idConta = 0;
    private DadosPessoais dadosPessoais;

    private ArrayList<Perfil> listaAmigos;
    private ArrayList<SolicitacaoDeAmizade> listaSolicitacoesDeAmizade;
    private ArrayList<Comunidade> listaComunidadesAutorais;
    private ArrayList<Comunidade> listaComunidades;
    private ArrayList<Mensagem> listaMensagens;


    public Perfil(DadosPessoais dadosPessoais) {

        this.dadosPessoais = dadosPessoais;
        this.listaAmigos = new ArrayList<>();
        this.listaSolicitacoesDeAmizade = new ArrayList<>();
        this.listaComunidadesAutorais = new ArrayList<>();
        this.listaComunidades = new ArrayList<>();
        this.listaMensagens = new ArrayList<>();
    }

    //SET
    public void setIdConta(int idConta) {

        if(this.idConta == 0) {
            this.idConta = idConta;
        } else {
            Erro.erroAoAssociarPerfil();
        }
    }

    //GET
    public int getNumeroSolicitacoes() {

        return this.listaSolicitacoesDeAmizade.size();
    }
    public String getNome() {

        return dadosPessoais.getNome();
    }
}
