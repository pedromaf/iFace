package model.geral;

import control.Input;
import view.Console;

public class AtributoPerfil {

    private String titulo;
    private String descricao;

    public AtributoPerfil(String titulo, String descricao) {

        this.titulo = titulo;
        this.descricao = descricao;
    }

    public void alterar() {

        Console.solicitarTituloAtributo();
        this.titulo = Input.lerString();
        Console.solicitarDescricaoAtributo();
        this.descricao = Input.lerString();
        Console.atributoAlterado();
    }

    public String toString() {

        return (this.titulo + "\n\t" + this.descricao + "\n");
    }
}
