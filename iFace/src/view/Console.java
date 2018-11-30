package view;

public class Console {

    public static void selecioneOpcao() {

        System.out.println("\nDigite o numero da opcao:");
    }

    //LOGIN
    public static void menuLogin() {

        System.out.println("\t\t[iFace]");
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
}
