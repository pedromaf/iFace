package model;

import control.Input;
import model.geral.AtributoPerfil;
import model.geral.DadosPessoais;
import model.geral.Conversa;
import model.geral.SolicitacaoDeAmizade;
import view.Console;
import view.Erro;

import java.util.ArrayList;

public class Perfil {

    private int idConta = 0;
    private DadosPessoais dadosPessoais;

    private ArrayList<Perfil> listaAmigos;
    private ArrayList<SolicitacaoDeAmizade> listaSolicitacoesDeAmizade;
    private ArrayList<Comunidade> listaComunidadesAutorais;
    private ArrayList<Comunidade> listaComunidades;
    private ArrayList<Conversa> listaConversas;
    private ArrayList<AtributoPerfil> listaAtributos;


    public Perfil(DadosPessoais dadosPessoais) {

        this.dadosPessoais = dadosPessoais;
        this.listaAmigos = new ArrayList<>();
        this.listaSolicitacoesDeAmizade = new ArrayList<>();
        this.listaComunidadesAutorais = new ArrayList<>();
        this.listaComunidades = new ArrayList<>();
        this.listaConversas = new ArrayList<>();
        this.listaAtributos = new ArrayList<>();
    }


    //EDITAR
    public void editarPerfil() {

        int opcao;
        boolean voltar = false;

        do {
            Console.menuEditarPerfil();
            opcao = Input.validarOpcao(1,7);

            switch(opcao) {
                case 1:
                    this.dadosPessoais.alterarNome();
                    break;
                case 2:
                    this.dadosPessoais.alterarIdade();
                    break;
                case 3:
                    this.dadosPessoais.alterarEmail();
                    break;
                case 4:
                    alterarAtributo();
                    break;
                case 5:
                    adicionarAtributo();
                    break;
                case 6:
                    removerAtributo();
                    break;
                case 7:
                default:
                    voltar = true;
            }
        } while(!voltar);
    }

    private void alterarAtributo() {

        if(!this.listaAtributos.isEmpty()) {
            int lista = 0;
            int opcao;
            ArrayList<AtributoPerfil> listaAlterar = new ArrayList<>();

            for(AtributoPerfil atual: this.listaAtributos) {
                Console.listar(++lista, atual.toString());
                listaAlterar.add(atual);
            }

            Console.listar(++lista, "Voltar\n");
            Console.selecioneOpcao();
            opcao = Input.validarOpcao(1, lista);

            if(opcao != lista) {
                AtributoPerfil atributo = listaAlterar.remove(opcao - 1);
                atributo.alterar();
            }
        } else {
            Console.listaAtributosVazia();
        }
    }

    private void adicionarAtributo() {

        String titulo;
        String descricao;

        Console.solicitarTituloAtributo();
        titulo = Input.lerString();

        Console.solicitarDescricaoAtributo();
        descricao = Input.lerString();

        this.listaAtributos.add(new AtributoPerfil(titulo, descricao));
        Console.atributoAdicionado();
    }

    private void removerAtributo() {

        if(!this.listaAtributos.isEmpty()) {
            int lista = 0;
            int opcao;

            for(AtributoPerfil atual: this.listaAtributos) {
                Console.listar(++lista, atual.toString());
            }

            Console.listar(++lista, "Voltar\n");
            Console.selecioneOpcao();
            opcao = Input.validarOpcao(1, lista);

            if(opcao != lista) {
                this.listaAtributos.remove(opcao-1);
                Console.atributoRemovido();
            }
        } else {
            Console.listaAtributosVazia();
        }
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


    //SOLICITACAO DE AMIZADE
    public boolean receberSolicitacaoDeAmizade(Perfil remetente) {

        if(remetente != null) {
            for(SolicitacaoDeAmizade atual: this.listaSolicitacoesDeAmizade) {
                if(atual.getRemetente().idConta == remetente.idConta) {
                    return false;
                }
            }
            this.listaSolicitacoesDeAmizade.add(new SolicitacaoDeAmizade(remetente));
            return true;
        }
        return false;
    }

    public int listarSolicitacoesDeAmizade() {

        int lista = 0;
        if(!this.listaSolicitacoesDeAmizade.isEmpty()) {
            for(SolicitacaoDeAmizade atual: this.listaSolicitacoesDeAmizade) {
                Console.listar(++lista, atual.toString());
            }
        }
        return lista;
    }

    public void removerSolicitacao(int indice) {

        this.listaSolicitacoesDeAmizade.remove(indice);
    }

    public void removerSolicitacao(Perfil perfil) {

        for(SolicitacaoDeAmizade atual: this.listaSolicitacoesDeAmizade) {
            if(perfil.equals(atual.getRemetente())) {
                this.listaSolicitacoesDeAmizade.remove(atual);
                break;
            }
        }
    }

    public Perfil getRemetente(int indiceSolicitacao) {

        SolicitacaoDeAmizade solicitacao = this.listaSolicitacoesDeAmizade.get(indiceSolicitacao);

        return solicitacao.getRemetente();
    }


    //ADICIONAR AMIGO
    public void adicionarAmigo(Perfil amigo) {

        if(amigo != null) {
            for(Perfil atual: this.listaAmigos) {
                if(atual.idConta == amigo.idConta) {
                    return;
                }
            }
            this.listaAmigos.add(amigo);
        }
    }

    public boolean querTeAdicionar(Perfil perfil) {

        if(perfil != null) {
            for(SolicitacaoDeAmizade atual: this.listaSolicitacoesDeAmizade) {
                if(perfil.equals(atual.getRemetente())) {
                    return true;
                }
            }
        }
        return false;
    }


    //REMOVER AMIGO
    public Perfil removerAmigo() {

        if(!this.listaAmigos.isEmpty()) {
            int lista = 0;
            int opcao;

            for(Perfil atual: this.listaAmigos) {
                Console.listar(++lista, atual.toString());
            }

            Console.listar(++lista, "Voltar\n");
            Console.selecioneOpcao();
            opcao = Input.validarOpcao(1, lista);

            if(opcao != lista) {
                return this.listaAmigos.remove(opcao-1);
            }
        } else {
            Console.voceNaoTemAmigos();
        }
        return null;
    }

    public void removerDaListaDeAmigos(Perfil perfil) {

        if(perfil != null) {
            for(Perfil atual: this.listaAmigos) {
                if(perfil.equals(atual)) {
                    this.listaAmigos.remove(atual);
                    break;
                }
            }
        }
    }


    //MENSAGENS
    public void menuConversas() {

        if(temConversas()) {
            int lista = 0;
            int opcao;

            Console.mostrar("\n\t\t[Conversas]\n");
            for(Conversa atual: this.listaConversas) {
                Console.listar(++lista, atual.toString(this));
            }
            Console.listar(++lista, "Voltar");
            Console.selecioneOpcao();

            opcao = Input.validarOpcao(1, lista);

            if(opcao != lista) {
                Conversa conversaAtual = this.listaConversas.get(opcao-1);
                conversaAtual.entrar(this);
            }
        } else {
            Console.voceNaoTemConversas();
        }
    }

    public void criarConversa() {

        if(!this.listaAmigos.isEmpty()) {
            int lista = 0;
            int opcao;

            Console.mostrar("\n\t\t[Criar Conversa]\n");
            for(Perfil atual: this.listaAmigos) {
                Console.listar(++lista, atual.toString());
            }

            Console.listar(++lista, "Voltar\n");
            Console.selecioneOpcao();
            opcao = Input.validarOpcao(1, lista);

            if(opcao != lista) {
                Perfil amigo = this.listaAmigos.get(opcao-1);
                if(!conversaJaExiste(amigo)) {
                    Conversa novaConversa = new Conversa(this, amigo);
                    this.listaConversas.add(novaConversa);
                    amigo.listaConversas.add(novaConversa);
                    Console.conversaCriada();
                } else {
                    Erro.conversaJaExiste();
                }
            }
        } else {
            Console.voceNaoTemAmigos();
        }
    }

    private boolean conversaJaExiste(Perfil amigo) {

        if(!this.listaConversas.isEmpty()) {
            for(Conversa atual: this.listaConversas) {
                if(atual.eMembro(amigo)) {
                    return true;
                }
            }
        }
        return false;
    }


    //GERAL
    public void listarAmigos() {

        if(!this.listaAmigos.isEmpty()) {
            Console.mostrar("\n\t\t[Lista de Amigos]\n");
            for(Perfil atual: this.listaAmigos) {
                Console.mostrar(atual.toString());
            }
        } else {
            Console.voceNaoTemAmigos();
        }
    }

    public void mostrarPerfil() {

        Console.mostrar(toString() + "\n");
        if(this.listaAtributos != null) {
            for(AtributoPerfil atual: this.listaAtributos) {
                Console.mostrar(atual.toString() + "\n");
            }
        }
    }

    public boolean compararNome(String nome) {

        return (nome.equals(this.dadosPessoais.getNome()));
    }

    public boolean compararId(int id) {

        return (id == this.idConta);
    }

    public boolean eAmigo(Perfil perfil) {

        for(Perfil atual: this.listaAmigos) {
            if(atual.equals(perfil)) {
                return true;
            }
        }
        return false;
    }

    public boolean temConversas() {

        return (this.listaConversas.size() > 0);
    }

    public String toString() {

        return this.dadosPessoais.toString();
    }
}
