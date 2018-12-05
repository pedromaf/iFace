package view;

public class Console {

    //GERAL
    public static void selecioneOpcao() {

        System.out.println("\nDigite o numero da opcao:");
    }

    public static void mostrar(String informacao) {

        System.out.print(informacao);
    }

    public static void listar(int posicao, String informacao) {

        System.out.println("[" + posicao + "] " + informacao);
    }


    //LOGIN
    public static void solicitarUsuario() {

        System.out.println("Digite seu usuario:");
    }

    public static void solicitarSenha() {

        System.out.println("Digite sua senha:");
    }

    public static void logado() {

        System.out.println("Login efetuado! Bem vindo.");
    }


    //CADASTRO
    public static void solicitarNovoUsuario() {

        System.out.println("Digite seu novo usuario [6 caracteres]:");
    }

    public static void solicitarNovaSenha() {

        System.out.println("Digite sua nova senha [6 caracteres]:");
    }

    public static void confirmeSenha() {

        System.out.println("Confirme sua senha:");
    }

    public static void cadastroRealizado() {

        System.out.println("Cadastro realizado com sucesso!");
    }


    //CRIAR PERFIL
    public static void criarPerfil() {

        System.out.println("\n\t\t[Criar Perfil]\n");
    }

    public static void perfilCriado() {

        System.out.println("Perfil criado!");
    }


    //PERFIL
    public static void voceNaoTemAmigos() {

        System.out.println("Voce nao possui amigos adicionados!\n");
    }

    public static void listaDePerfis() {

        System.out.println("\n\t\t[Buscar Perfil]\n");
    }


    //EDITAR PERFIL
    public static void nomeAlterado() {

        System.out.println("Nome alterado!\n");
    }

    public static void idadeAlterada() {

        System.out.println("Idade alterada!\n");
    }

    public static void emailAlterado() {

        System.out.println("Email alterado!\n");
    }

    public static void listaAtributosVazia() {

        System.out.println("No seu perfil nao ha atributos.\n");
    }

    public static void solicitarTituloAtributo() {

        System.out.println("Digite o titulo do atributo:\n");
    }

    public static void solicitarDescricaoAtributo() {

        System.out.println("Digite a descricao do atributo:\n");
    }

    public static void atributoAlterado() {

        System.out.println("Atributo alterado!\n");
    }

    public static void atributoAdicionado() {

        System.out.println("Atributo adicionado!\n");
    }

    public static void atributoRemovido() {

        System.out.println("Atributo removido!\n");
    }


    //SOLICITAR DADO
    public static void solicitarNome() {

        System.out.println("Digite seu nome:");
    }

    public static void solicitarIdade() {

        System.out.println("Digite sua idade:");
    }

    public static void solicitarEmail() {

        System.out.println("Digite seu email:");
    }


    //ADICIONAR AMIGO
    public static void solicitarNomeBuscar() {

        System.out.println("Pesquisar pessoa por nome:");
    }

    public static void solicitacaoDeAmizadeEnviada() {

        System.out.println("Solicitacao de amizade enviada!\n");
    }

    public static void amigoAdicionado() {

        System.out.println("Amigo adicionado!\n");
    }


    //REMOVER AMIGO
    public static void amigoRemovido() {

        System.out.println("Amigo removido!");
    }


    //REMOVER CONTA
    public static void confirmarRemoverConta() {

        System.out.println("Tem certeza que deseja remover sua conta? Todos os seus dados serao apagados do iFace.");
        System.out.println("[1] Sim");
        System.out.println("[2] Nao");

        selecioneOpcao();
    }

    public static void contaRemovida() {

        System.out.println("Sua conta foi removida do iFace! :(");
    }


    //MENSAGENS
    public static void conversaCriada() {

        System.out.println("Conversa criada!");
    }

    public static void voceNaoTemConversas() {

        System.out.println("Voce nao possui conversas!\n");
    }

    public static void conversaVazia() {

        System.out.println("Esta conversa ainda nao possui mensagens.\n");
    }

    public static void solicitarMensagem() {

        System.out.println("Digite a mensagem que deseja enviar:");
    }

    public static void mensagemEnviada() {

        System.out.println("Mensagem enviada!");
    }


    //MENUS
    public static void menuLogin() {

        System.out.println("\n\t\t[iFace]\n");
        System.out.println("[1] Entrar");
        System.out.println("[2] Cadastrar");
        System.out.println("[3] Fechar");

        selecioneOpcao();
    }

    public static void menuPrincipal(int solicitacoes) {

        System.out.println("\n\t\t[Menu Principal]\n");
        System.out.println("[1] Perfil");
        System.out.println("[2] Adicionar amigo");
        System.out.println("[3] Mensagens");
        System.out.println("[4] Comunidades");
        System.out.println("[5] Solicitacoes de amizade(" + solicitacoes + ")");
        System.out.println("[6] Sair");

        selecioneOpcao();
    }

    public static void menuPerfil() {

        System.out.println("\n[1] Editar perfil");
        System.out.println("[2] Lista de amigos");
        System.out.println("[3] Remover amigo");
        System.out.println("[4] Remover conta");
        System.out.println("[5] Voltar");

        selecioneOpcao();
    }

    public static void menuEditarPerfil() {

        System.out.println("\n\t\t[Editar Perfil]\n");
        System.out.println("[1] Alterar nome");
        System.out.println("[2] Alterar idade");
        System.out.println("[3] Alterar email");
        System.out.println("[4] Alterar atributo");
        System.out.println("[5] Adicionar atributo");
        System.out.println("[6] Remover atributo");
        System.out.println("[7] Voltar");

        selecioneOpcao();
    }

    public static void menuSolicitacaoDeAmizade() {

        System.out.println("\n[1] Aceitar");
        System.out.println("[2] Recusar");

        selecioneOpcao();
    }

    public static void menuMensagens() {

        System.out.println("\n\t\t[Mensagens]\n");
        System.out.println("[1] Conversas");
        System.out.println("[2] Criar nova conversa");
        System.out.println("[3] Voltar");

        selecioneOpcao();
    }

    public static void menuConversa() {

        System.out.println("Deseja enviar mensagem?");
        System.out.println("[1] Sim");
        System.out.println("[2] Nao");

        selecioneOpcao();
    }
}
