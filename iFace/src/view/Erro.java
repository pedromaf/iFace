package view;

public class Erro {

    public static void loginInvalido() {

        System.out.println("Usuario ou senha invalidos! Tente novamente.");
    }

    public static void usuarioJaExiste() {

        System.out.println("Este nome de usuario ja esta em uso! Tente novamente.");
    }

    public static void erroAoAssociarPerfil() {

        System.out.println("Erro ao associar perfil a conta!");
    }

    public static void stringTamanhoFixo(int tamanho) {

        System.out.println("A entrada deve ter " + tamanho + " caracteres! Tente novamente.");
    }

    public static void opcaoInvalida(int limite1, int limite2) {

        System.out.println("Opcao invalida! digite valores entre " + limite1 + " e " + limite2 + ".");
    }
}
