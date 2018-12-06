package control;

import model.Comunidade;
import model.geral.DadosPessoais;
import view.*;
import model.Conta;
import model.Perfil;
import java.util.ArrayList;

public class Iface {

    //CONSTANTES
    private final int MAX_CARACTERES = 6;

    private ArrayList<Conta> listaContas;
    private ArrayList<Perfil> listaPerfis;
    private ArrayList<Comunidade> listaComunidades;

    private Conta contaConectada;

    public Iface() {

        this.listaContas = new ArrayList<>();
        this.listaPerfis = new ArrayList<>();
        this.listaComunidades = new ArrayList<>();
    }

    //CADASTRO
    public void cadastrar() {

        String novoUsuario;
        String novaSenha;

        do {
            Console.solicitarNovoUsuario();
            novoUsuario = Input.lerStringTamanhoFixo(MAX_CARACTERES);
        } while(usuarioExiste(novoUsuario));

        do {
            Console.solicitarNovaSenha();
            novaSenha = Input.lerStringTamanhoFixo(MAX_CARACTERES);
        } while(!confirmarSenha(novaSenha));

        this.listaContas.add(new Conta(novoUsuario, novaSenha));
        Console.cadastroRealizado();
    }

    private boolean usuarioExiste(String usuario) {

        for(Conta atual: listaContas) {
            if(atual.validarUsuario(usuario)) {
                Erro.usuarioJaExiste();
                return true;
            }
        }
        return false;
    }

    private boolean confirmarSenha(String novaSenha) {

        Console.confirmeSenha();
        if(novaSenha.equals(Input.lerStringTamanhoFixo(MAX_CARACTERES))) {
            return true;
        } else {
            Erro.senhaNaoConfirmada();
            return false;
        }
    }

    private void criarPerfil() {

        String nome;
        int idade;
        String email;

        Console.solicitarNome();
        nome = Input.lerString();

        Console.solicitarIdade();
        idade = Input.lerInt();

        Console.solicitarEmail();
        email = Input.lerString();

        DadosPessoais dadosPessoais = new DadosPessoais(nome,idade,email);

        Perfil novoPerfil = new Perfil(dadosPessoais);
        this.contaConectada.associarPerfil(novoPerfil);
        listaPerfis.add(novoPerfil);
        Console.perfilCriado();
    }

    //ENTRAR
    public void entrar() {

        String usuario;
        String senha;

        Console.solicitarUsuario();
        usuario = Input.lerStringTamanhoFixo(MAX_CARACTERES);

        Console.solicitarSenha();
        senha = Input.lerStringTamanhoFixo(MAX_CARACTERES);

        for(Conta atual : this.listaContas) {
            if(atual.validarUsuario(usuario)) {
                if(atual.validarSenha(senha)) {
                    Console.logado();
                    this.contaConectada = atual;
                    if(this.contaConectada.perfilCriado()) {
                        menuPrincipal();
                    } else {
                        Console.criarPerfil();
                        criarPerfil();
                        menuPrincipal();
                    }
                    return;
                }
                break;
            }
        }
        Erro.loginInvalido();
    }

    private void menuPrincipal() {

        if(this.contaConectada != null) {

            Perfil perfil = this.contaConectada.getPerfil();
            boolean sair = false;
            int opcao;

            do {
                if(this.contaConectada != null) {
                    Console.menuPrincipal(perfil.getNumeroSolicitacoes());
                    opcao = Input.validarOpcao(1,6);

                    switch(opcao) {
                        case 1:
                            menuPerfil(perfil);
                            break;
                        case 2:
                            enviarSolicitacaoDeAmizade(perfil);
                            break;
                        case 3:
                            menuMensagens(perfil);
                            break;
                        case 4:
                            menuComunidade(perfil);
                            break;
                        case 5:
                            solicitacoesDeAmizade(perfil);
                            break;
                        case 6:
                        default:
                            sair = true;
                    }
                } else {
                    Console.contaRemovida();
                    sair = true;
                }
            } while(!sair);

            this.contaConectada = null;
        }

    }

    private void menuPerfil(Perfil perfil) {

        int opcao;
        boolean voltar = false;

        do {
            Console.mostrar("\n\t\t[Perfil]\n\n");
            perfil.mostrarPerfil();
            Console.menuPerfil();
            opcao = Input.validarOpcao(1, 5);

            switch(opcao) {
                case 1:
                    perfil.editarPerfil();
                    break;
                case 2:
                    perfil.listarAmigos();
                    break;
                case 3:
                    desfazerAmizade(perfil);
                    break;
                case 4:
                    if(!removerConta()) {
                        break;
                    }
                case 5:
                default:
                    voltar = true;
            }
        } while(!voltar);
    }


    //AMIGOS
    private void desfazerAmizade(Perfil perfil) {

        Perfil amigo = perfil.removerAmigo();
        if(amigo != null) {
            amigo.removerDaListaDeAmigos(perfil);
            Console.amigoRemovido();
        }
    }

    private void enviarSolicitacaoDeAmizade(Perfil perfil) {

        Perfil destinatario = buscarPerfil();

        if(destinatario != null) {

            if(perfil.querTeAdicionar(destinatario)) {
                criarAmizade(perfil, destinatario);
                perfil.removerSolicitacao(destinatario);
                Console.amigoAdicionado();
            } else {
                if(destinatario.receberSolicitacaoDeAmizade(perfil)) {
                    Console.solicitacaoDeAmizadeEnviada();
                } else {
                    Erro.solicitacaoJaEnviada();
                }
            }
        }
    }

    private void solicitacoesDeAmizade(Perfil perfil) {

        if(perfil.getNumeroSolicitacoes() > 0) {
            int lista = perfil.listarSolicitacoesDeAmizade();
            int opcao;

            Console.listar(++lista, "Voltar");
            Console.selecioneOpcao();
            opcao = Input.validarOpcao(1, lista);

            if(opcao != lista) {
                Console.menuSolicitacaoDeAmizade();

                if(Input.validarOperacaoBinaria()) {
                    Perfil novoAmigo = perfil.getRemetente(opcao-1);
                    criarAmizade(perfil, novoAmigo);
                    Console.amigoAdicionado();
                }
                perfil.removerSolicitacao(opcao-1);
            }
        } else {
            Console.voceNaoPossuiSolicitacoes();
        }
    }

    private void criarAmizade(Perfil perfil1, Perfil perfil2) {

        if(perfil1 != null && perfil2 != null) {
            perfil1.adicionarAmigo(perfil2);
            perfil2.adicionarAmigo(perfil1);
        }
    }


    //MENSAGEM
    private void menuMensagens(Perfil perfil) {

        int opcao;
        boolean voltar = false;

        do {
            Console.menuMensagens();
            opcao = Input.validarOpcao(1,3);

            switch(opcao) {
                case 1:
                    perfil.menuConversas();
                    break;
                case 2:
                    perfil.criarConversa();
                    break;
                case 3:
                default:
                    voltar = true;
            }
        } while(!voltar);
    }


    //COMUNIDADE
    private void menuComunidade(Perfil perfil) {

        int opcao;
        boolean voltar = false;

        do {
            Console.menuComunidade(perfil.getNumeroConvites());
            opcao = Input.validarOpcao(1,5);

            switch(opcao) {
                case 1:
                    criarComunidade(perfil);
                    break;
                case 2:
                    perfil.menuSuasComunidades();
                    break;
                case 3:
                    perfil.menuComunidadesQueParticipa();
                    break;
                case 4:
                    perfil.convitesDeComunidade();
                    break;
                case 5:
                default:
                    voltar = true;

            }
        } while(!voltar);
    }

    private void criarComunidade(Perfil perfil) {

        String nomeComunidade;
        String descricaoComunidade;
        boolean confirmarNome = false;

        do {
            Console.solicitarNomeComunidade();
            nomeComunidade = Input.lerString();

            Console.confirmarNomeComunidade(nomeComunidade);
            if(Input.validarOperacaoBinaria()) {
                confirmarNome = true;
            }
        } while(!confirmarNome);

        Console.solicitarDescricaoComunidade();
        descricaoComunidade = Input.lerString();

        Comunidade novaComunidade = new Comunidade(perfil, nomeComunidade, descricaoComunidade);
        this.listaComunidades.add(novaComunidade);
        perfil.adicionarComunidadeAutoral(novaComunidade);
        Console.comunidadeCriada();
    }


    //GERAL
    private Perfil buscarPerfil() {

        String nomeBuscar;
        int lista = 0;
        int opcao;
        ArrayList<Perfil> listaOpcoes = new ArrayList<>();

        Console.solicitarNomeBuscar();
        nomeBuscar = Input.lerString();

        for(Perfil atual: this.listaPerfis) {
            if(atual.compararNome(nomeBuscar) && !atual.compararId(this.contaConectada.getId()) && !atual.eAmigo(this.contaConectada.getPerfil())) {
                if(lista == 0) {
                    Console.listaDePerfis();
                }
                lista++;
                listaOpcoes.add(atual);
                Console.listar(lista, atual.toString());
            }
        }

        if(lista == 0) {
            Erro.nenhumPerfilEncontrado();
            return null;
        }

        Console.listar(++lista, "Voltar\n");

        Console.selecioneOpcao();
        opcao = Input.validarOpcao(1, lista);

        if(opcao == lista) {
            return null;
        }

        return listaOpcoes.remove(opcao-1);
    }

    private boolean removerConta() {

        Console.confirmarRemoverConta();
        if(Input.validarOperacaoBinaria()) {
            Perfil perfil = this.contaConectada.apagar();
            apagarComunidades(perfil);
            this.listaPerfis.remove(perfil);
            this.listaContas.remove(this.contaConectada);
            this.contaConectada = null;
            return true;
        }
        return false;
    }

    private void apagarComunidades(Perfil perfil) {

        if(perfil != null) {
            ArrayList<Comunidade> removerComunidades = new ArrayList<>();
            for(Comunidade atual: this.listaComunidades) {
                if(perfil.equals(atual.getCriador())) {
                    atual.apagar();
                    removerComunidades.add(atual);
                }
            }

            for(Comunidade atual: removerComunidades) {
                this.listaComunidades.remove(atual);
            }

            removerComunidades.clear();
        }
    }
}
