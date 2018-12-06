package model;

import control.Input;
import model.geral.ConviteDeComunidade;
import model.geral.Publicacao;
import view.Console;
import view.Erro;

import java.util.ArrayList;

public class Comunidade {

    private Perfil criador;
    private String nome;
    private String descricao;

    private Perfil membroOnline;

    private ArrayList<Perfil> listaMembros;
    private ArrayList<Publicacao> listaPublicacoes;

    public Comunidade(Perfil criador, String nome, String descricao) {

        this.criador = criador;
        this.nome = nome;
        this.descricao = descricao;
        this.listaMembros = new ArrayList<>();
        this.listaPublicacoes = new ArrayList<>();
    }

    //ENTRAR
    public void entrar(Perfil perfil) {

        this.membroOnline = perfil;
        if(eCriador(perfil)) {
            menuPrincipalCriador();
        } else {
            menuPrincipalMembro();
        }
        this.membroOnline = null;
    }

    private void menuPrincipalCriador() {

        int opcao;
        boolean voltar = false;

        do {
            Console.mostrar(toString());
            Console.menuPrincipalComunidadeCriador();
            opcao = Input.validarOpcao(1, 6);

            switch(opcao) {
                case 1:
                    alterarDescricao();
                    break;
                case 2:
                    convidarAmigo();
                    break;
                case 3:
                    listarMembros();
                    break;
                case 4:
                    removerMembro();
                    break;
                case 5:
                    publicacoes();
                    break;
                case 6:
                default:
                    voltar = true;
            }
        } while(!voltar);
    }

    private void menuPrincipalMembro() {

        int opcao;
        boolean voltar = false;

        do {
            Console.menuPrincipalComunidadeMembro();
            opcao = Input.validarOpcao(1, 3);

            switch(opcao) {
                case 1:
                    listarMembros();
                    break;
                case 2:
                    publicacoes();
                    break;
                case 4:
                default:
                    voltar = true;
            }
        } while(!voltar);
    }


    //EDITAR
    private void alterarDescricao() {

        Console.solicitarDescricaoComunidade();
        this.descricao = Input.lerString();
        Console.descricaoAlterada();
    }


    //MEMBROS
    private void convidarAmigo() {

        if(this.criador.temAmigos()) {
            Perfil amigo = this.criador.buscarAmigo();
            if(amigo.receberConviteDeComunidade(new ConviteDeComunidade(this))) {
               Console.conviteEnviado();
            } else {
                Erro.jaConvidouEsteAmigo();
            }
        } else {
            Console.voceNaoTemAmigos();
        }
    }

    private void listarMembros() {

        Console.mostrar("\n\t\t[Lista de Membros]\n");
        Console.mostrar("Criador:\n" + this.criador.toString() + "\n");
        if(!this.listaMembros.isEmpty()) {
            for(Perfil atual: this.listaMembros) {
                Console.mostrar(atual.toString() + "\n");
            }
        } else {
            Console.comunidadeNaoPossuiMembros();
        }
    }

    private void removerMembro() {

        if(!this.listaMembros.isEmpty()) {
            int lista = 0;
            int opcao;

            for(Perfil atual: this.listaMembros) {
                Console.listar(++lista, atual.toString());
            }

            Console.listar(++lista, "Voltar");
            Console.selecioneOpcao();
            opcao = Input.validarOpcao(1, lista);

            if(opcao != lista) {
                this.listaMembros.remove(opcao-1).removerComunidade(this);
                Console.membroRemovido();
            }
        } else {
            Console.comunidadeNaoPossuiMembros();
        }
    }

    public void adicionarMembro(Perfil novoMembro) {

        if(novoMembro != null) {
            if(!eMembro(novoMembro)) {
                this.listaMembros.add(novoMembro);
            } else {
                Erro.voceJaEMembro();
            }
        }
    }


    //PUBLICACOES
    private void publicacoes() {

        if(!this.listaPublicacoes.isEmpty()) {
            listarPublicacoes();
        } else {
            Console.comunidadeSemPublicacoes();
        }

        Console.menuPublicacoes();
        if(Input.validarOperacaoBinaria()) {
            String tituloPublicacao;
            String textoPublicacao;

            Console.solicitarTituloPublicacao();
            tituloPublicacao = Input.lerString();

            Console.solicitarTextoPublicacao();
            textoPublicacao = Input.lerString();

            this.listaPublicacoes.add(new Publicacao(this.membroOnline, tituloPublicacao, textoPublicacao));
            Console.publicacaoCriada();
        }
    }

    private void listarPublicacoes() {

        if(!this.listaPublicacoes.isEmpty()) {
            Console.mostrar("\n\t\t[Publicacoes]\n\n");
            for(Publicacao atual: this.listaPublicacoes) {
                Console.mostrar(atual.toString() + "\n");
            }
        }
    }

    public void removerPublicacoesPorMembro(Perfil membro) {

        if(eMembro(membro)) {
            for(Publicacao atual: this.listaPublicacoes) {
                if(atual.eAutor(membro)) {
                    atual.apagar();
                    this.listaPublicacoes.remove(atual);
                    removerPublicacoesPorMembro(membro);
                }
            }
        }
    }


    //GERAL
    public String getNome() {

        return this.nome;
    }

    private boolean eCriador(Perfil perfil) {

        return this.criador.equals(perfil);
    }

    private boolean eMembro(Perfil membro) {

        for(Perfil atual: this.listaMembros) {
            if(atual.equals(membro)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {

        return ("\t{" + this.nome + "}\n" + this.descricao + "\n");
    }
}
