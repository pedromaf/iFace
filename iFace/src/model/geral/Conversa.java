package model.geral;

import control.Input;
import model.Perfil;
import view.Console;

import java.util.ArrayList;

public class Conversa {

    private Perfil amigo1;
    private Perfil amigo2;
    private ArrayList<Mensagem> listaMensagens;

    public Conversa(Perfil amigo1, Perfil amigo2) {

        this.amigo1 = amigo1;
        this.amigo2 = amigo2;
        this.listaMensagens = new ArrayList<>();
    }

    public boolean eMembro(Perfil perfil) {

        return (perfil.equals(this.amigo1) || perfil.equals(amigo2));
    }

    public void entrar(Perfil atual) {

        if(!this.listaMensagens.isEmpty()) {
            Console.mostrar("\n\t\t[Conversa com " + (atual.equals(this.amigo1)?this.amigo2.getNome():this.amigo1.getNome()) + "]\n\n");
            listarMensagens();
        } else {
            Console.conversaVazia();
        }

        Console.menuConversa();
        if(Input.validarOperacaoBinaria()) {
            String textoMensagem;

            Console.solicitarMensagem();
            textoMensagem = Input.lerString();

            this.listaMensagens.add(new Mensagem(atual, textoMensagem));
            Console.mensagemEnviada();
        }
    }

    public void apagar() {

        this.listaMensagens.clear();
        this.amigo1 = null;
        this.amigo2 = null;
    }

    public void listarMensagens() {

        for(Mensagem atual: this.listaMensagens) {
            Console.mostrar(atual.toString() + "\n");
        }
    }

    public String toString(Perfil atual) {

        if(atual != null) {
            String nomeAmigo;
            if(amigo1.equals(atual)) {
                nomeAmigo = this.amigo2.getNome();
            } else {
                nomeAmigo = this.amigo1.getNome();
            }

            return (nomeAmigo + " (" + this.listaMensagens.size() +")");
        }
        return null;
    }
}
