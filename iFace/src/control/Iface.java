package control;

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

    private Conta contaConectada;

    public Iface() {

        this.listaContas = new ArrayList<>();
        this.listaPerfis = new ArrayList<>();
    }

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

    }

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

    public void menuPrincipal() {

        if(this.contaConectada != null) {

            Perfil perfil = this.contaConectada.getPerfil();
            boolean sair = false;
            int opcao;

            do {
                Console.menuPrincipal(perfil.getNumeroSolicitacoes());
                opcao = Input.validarOpcao(1,6);

                switch(opcao) {
                    case 1:
                        //TODO menuPerfil(perfil);
                        break;
                    case 2:
                        //TODO adicionarAmigo(perfil);
                        break;
                    case 3:
                        //TODO enviarMensagem(perfil);
                        break;
                    case 4:
                        //TODO menuComunidade(perfil);
                        break;
                    case 5:
                        //TODO solicitacoesDeAmizade(perfil);
                        break;
                    case 6:
                    default:
                        sair = true;
                }
            } while (!sair);

        }

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
        return(novaSenha.equals(Input.lerStringTamanhoFixo(MAX_CARACTERES)));
    }
}
