package view;

public class Erro {

    public static void loginInvalido() {

        System.out.println("Usuario ou senha invalidos! Tente novamente.");
    }

    public static void usuarioJaExiste() {

        System.out.println("Este nome de usuario ja esta em uso! Tente novamente.");
    }

    public static void senhaNaoConfirmada() {

        System.out.println("Senhas nao conferem! Tente novamente.\n");
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

    public static void nenhumPerfilEncontrado() {

        System.out.println("Nenhum perfil encontrado!\n");
    }

    public static void solicitacaoJaEnviada() {

        System.out.println("Erro! voce ja enviou uma solicitacao para esta pessoa, aguarde ela responder.");
    }

    public static void conversaJaExiste() {

        System.out.println("Uma conversa com este amigo ja existe.");
    }

    public static void erroAoEntrarComunidade() {

        System.out.println("Ocorreu um erro ao tentar entrar na comunidade!");
    }

    public static void jaConvidouEsteAmigo() {

        System.out.println("Erro! Voce ja enviou um convite para este amigo, aguarde ele responder.");
    }

    public static void voceJaEMembro() {

        System.out.println("Erro! Voce ja e membro desta comunidade.");
    }
}
