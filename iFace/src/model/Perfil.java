package model;

import control.Input;
import model.geral.*;
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
    private ArrayList<ConviteDeComunidade> listaConvitesDeComunidade;
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
        this.listaConvitesDeComunidade = new ArrayList<>();
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
            Console.mostrar("\n\t\t[Solicitacoes de Amizade]\n\n");
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


    //AMIGOS
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

    public void listarAmigos() {

        if(!this.listaAmigos.isEmpty()) {
            Console.mostrar("\n\t\t[Lista de Amigos]\n\n");
            for(Perfil atual: this.listaAmigos) {
                Console.mostrar(atual.toString());
            }
        } else {
            Console.voceNaoTemAmigos();
        }
    }

    public boolean temAmigos() {

        return (!this.listaAmigos.isEmpty());
    }

    public Perfil buscarAmigo() {

        if(!this.listaAmigos.isEmpty()) {
            int lista = 0;
            int opcao;

            for(Perfil atual: this.listaAmigos) {
                Console.listar(++lista, atual.toString());
            }

            Console.listar(++lista, "Voltar");

            Console.selecioneOpcao();
            opcao = Input.validarOpcao(1, lista);

            if(opcao != lista) {
                return this.listaAmigos.get(opcao-1);
            }
        }
        return null;
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

    public boolean temConversas() {

        return (this.listaConversas.size() > 0);
    }

    public void apagarConversa(Conversa conversa) {

        if(conversa != null) {
            this.listaConversas.remove(conversa);
        }
    }


    //COMUNIDADE
    public void adicionarComunidadeAutoral(Comunidade comunidade) {

        if(comunidade != null) {
            this.listaComunidadesAutorais.add(comunidade);
        }
    }

    public boolean participaDeComunidade() {

        return (!this.listaComunidades.isEmpty());
    }

    public void menuComunidadesQueParticipa() {

        if(participaDeComunidade()) {
            Console.mostrar("\n\t\t[Comunidades]\n");
            Comunidade comunidade = listarComunidades();
            if(comunidade != null) {
                comunidade.entrar(this);
            } else {
                Erro.erroAoEntrarComunidade();
            }
        } else {
            Console.voceNaoParticipaDeComunidades();
        }
    }

    private Comunidade listarComunidades() {

        if(!this.listaComunidades.isEmpty()) {
            int lista = 0;
            int opcao;

            for(Comunidade atual: this.listaComunidades) {
                if(atual.getCriador() != null) {
                    Console.listar(++lista, atual.toString());
                }
            }

            Console.listar(++lista, "Voltar");
            Console.selecioneOpcao();
            opcao = Input.validarOpcao(1, lista);

            if(opcao != lista) {
                return this.listaComunidades.get(opcao-1);
            }
        }
        return null;
    }

    public boolean receberConviteDeComunidade(ConviteDeComunidade conviteDeComunidade) {

        if(conviteDeComunidade != null) {
            for(ConviteDeComunidade atual: this.listaConvitesDeComunidade) {
                if(atual.getComunidade().equals(conviteDeComunidade.getComunidade())) {
                    return false;
                }
            }
            this.listaConvitesDeComunidade.add(conviteDeComunidade);
            return true;
        }
        return false;
    }

    public void menuSuasComunidades() {

        if(!this.listaComunidadesAutorais.isEmpty()) {
            int lista = 0;
            int opcao;

            Console.mostrar("\n\t\t[Suas Comunidades]\n\n");
            for(Comunidade atual: this.listaComunidadesAutorais) {
                Console.listar(++lista, atual.toString());
            }

            Console.listar(++lista, "Voltar");
            Console.selecioneOpcao();
            opcao = Input.validarOpcao(1, lista);

            if(opcao != lista) {
                this.listaComunidadesAutorais.get(opcao-1).entrar(this);
            }
        } else {
            Console.voceNaoTemComunidadesAutorais();
        }
    }

    public void removerComunidade(Comunidade comunidade) {

        if(comunidade != null) {
            for(Comunidade atual: this.listaComunidades){
                if(comunidade.equals(atual)) {
                    this.listaComunidades.remove(atual);
                }
            }
        }
    }

    public void convitesDeComunidade() {

        if(!this.listaConvitesDeComunidade.isEmpty()) {
            int lista = 0;
            int opcao;

            ArrayList<ConviteDeComunidade> convitesInvalidos = new ArrayList<>();

            Console.mostrar("\n\t\t[Convites de Comunidade]\n");
            for(ConviteDeComunidade atual: this.listaConvitesDeComunidade) {
                if(atual.getComunidade().getCriador() != null) {
                    Console.listar(++lista, atual.toString());
                } else {
                    convitesInvalidos.add(atual);
                }
            }

            for(ConviteDeComunidade atual: convitesInvalidos) {
                this.listaConvitesDeComunidade.remove(atual);
            }

            convitesInvalidos.clear();

            Console.listar(++lista, "Voltar");
            Console.selecioneOpcao();
            opcao = Input.validarOpcao(1, lista);

            if(opcao != lista) {
                Console.menuConviteDeComunidade();

                if(Input.validarOperacaoBinaria()) {
                    Comunidade comunidade = this.listaConvitesDeComunidade.get(opcao-1).getComunidade();
                    comunidade.adicionarMembro(this);
                    adicionarComunidade(comunidade);
                    Console.conviteAceito();
                }
                this.listaConvitesDeComunidade.remove(opcao-1);
            }
        } else {
            Console.voceNaoPossuiConvites();
        }
    }

    private void adicionarComunidade(Comunidade comunidade) {

        if(comunidade != null) {
            for(Comunidade atual: this.listaComunidades) {
                if(atual.equals(comunidade)) {
                    return;
                }
            }
            this.listaComunidades.add(comunidade);
        }
    }


    //REMOVER CONTA
    public void apagar() {
        this.dadosPessoais.apagar();
        this.dadosPessoais = null;
        this.listaSolicitacoesDeAmizade.clear();
        this.listaSolicitacoesDeAmizade = null;
        this.listaConvitesDeComunidade.clear();
        this.listaConvitesDeComunidade = null;
        this.listaAtributos.clear();
        this.listaAtributos = null;

        apagarAmizades();
        apagarConversas();
        sairComunidades();
    }

    private void apagarAmizades() {

        if(!this.listaAmigos.isEmpty()) {
            for(Perfil atual: this.listaAmigos) {
                atual.removerDaListaDeAmigos(this);
            }
        }
        this.listaAmigos = null;
    }

    private void apagarConversas() {

        if(!this.listaConversas.isEmpty()) {
            for(Conversa atual: this.listaConversas) {
                atual.apagar();
            }
            this.listaConversas.clear();
            this.listaConversas = null;
        }
    }

    private void sairComunidades() {

        if(!this.listaComunidades.isEmpty()) {
            for(Comunidade atual: this.listaComunidades) {
                atual.sair(this);
            }
            this.listaComunidades.clear();
            this.listaComunidades = null;
        }
    }


    //GERAL
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

    public String toString() {

        return this.dadosPessoais.toString();
    }

    public void setIdConta(int idConta) {

        if(this.idConta == 0) {
            this.idConta = idConta;
        } else {
            Erro.erroAoAssociarPerfil();
        }
    }

    public int getNumeroSolicitacoes() {

        return this.listaSolicitacoesDeAmizade.size();
    }

    public int getNumeroConvites() {

        return this.listaConvitesDeComunidade.size();
    }

    public String getNome() {

        return dadosPessoais.getNome();
    }
}
