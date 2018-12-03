package view;

public class Console {

    //GERAL
    public static void selecioneOpcao() {

        System.out.println("\nDigite o numero da opcao:");
    }

    //LOGIN
    public static void menuLogin() {

        System.out.println("\n\t\t[iFace]\n");
        System.out.println("[1] Entrar");
        System.out.println("[2] Cadastrar");
        System.out.println("[3] Fechar");

        selecioneOpcao();
    }

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

    public static void solicitarNome() {

        System.out.println("Digite seu nome:");
    }

    public static void solicitarIdade() {

        System.out.println("Digite sua idade:");
    }

    public static void solicitarEmail() {

        System.out.println("Digite seu email:");
    }

    //MENUPRINCIPAL
    public static void menuPrincipal(int solicitacoes) {

        System.out.println("\n\t\t[Menu Principal]\n");
        System.out.println("[1] Perfil");
        System.out.println("[2] Adicionar Amigo");
        System.out.println("[3] Enviar Mensagem");
        System.out.println("[4] Comunidades");
        System.out.println("[5] Solicitacoes de amizade(" + solicitacoes + ")");
        System.out.println("[6] Sair");

        selecioneOpcao();
    }
}
