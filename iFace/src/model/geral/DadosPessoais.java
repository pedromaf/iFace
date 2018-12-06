package model.geral;

import control.Input;
import view.Console;

public class DadosPessoais {

    private String nome;
    private int idade;
    private String email;

    public DadosPessoais(String nome, int idade, String email) {

        this.nome = nome;
        this.idade = idade;
        this.email = email;
    }

    public String getNome() {

        return this.nome;
    }

    public void alterarNome() {

        String novoNome;
        Console.solicitarNome();
        novoNome = Input.lerString();
        this.nome = novoNome;
        Console.nomeAlterado();
    }

    public void alterarIdade() {

        int novaIdade;
        Console.solicitarIdade();
        novaIdade = Input.lerInt();
        this.idade = novaIdade;
        Console.idadeAlterada();
    }

    public void alterarEmail() {

        String novoEmail;
        Console.solicitarEmail();
        novoEmail = Input.lerString();
        this.nome = novoEmail;
        Console.emailAlterado();
    }

    public void apagar() {

        this.nome = null;
        this.idade = 0;
        this.email = null;
    }

    public String toString() {

        return (this.nome + ", " + this.idade + "\n[" +
                this.email + "]\n");
    }
}
