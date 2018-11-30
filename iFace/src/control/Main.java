package control;

import view.Console;

public class Main {

    public static void main(String[] args) {

        Iface iFace = new Iface();
        boolean fechar = false;
        int opcao;

        do {
            Console.menuLogin();
            opcao = Input.validarOpcao(1,3);

            switch(opcao) {
                case 1:
                    iFace.entrar();
                    break;
                case 2:
                    iFace.cadastrar();
                    break;
                case 3:
                    fechar = true;
            }
        } while(!fechar);
    }
}
