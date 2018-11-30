package control;

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

        //TODO
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
                        // TODO menuPrincipal();
                    } else {
                        // TODO criarPerfil();
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
            boolean sair = false;

            do {

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
