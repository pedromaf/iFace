package control;

import view.Console;
import view.Erro;

import java.util.Scanner;

public class Input {

    private static Scanner input = new Scanner(System.in);

    //VALIDAR ENTRADAS
    public static int validarOpcao(int limite1, int limite2) {

        int operacao;

        do {
            operacao = lerInt();

            if(operacao < limite1 || operacao > limite2) {
               Erro.opcaoInvalida(limite1, limite2);
               Console.selecioneOpcao();
            }

        }while(operacao < limite1 || operacao > limite2);

        return operacao;
    }

    public static boolean validarOperacaoBinaria() {

        if(validarOpcao(1,2) == 1) {
            return true;
        }
        return false;
    }



    //LER TIPO DE DADO ESPECIFICO
    public static String lerStringTamanhoFixo(int tamanho) {

        String string;
        int tamanhoString;

        do {
            string = Input.lerString();
            tamanhoString = string.length();
            if(tamanhoString != tamanho) {
                Erro.stringTamanhoFixo(tamanho);
            }
        } while(tamanhoString != tamanho);

        return string;
    }

    public static String lerString() {

        return input.nextLine();
    }

    public static double lerDouble() {

        return Double.parseDouble(input.nextLine());
    }

    public static int lerInt() {

        return Integer.parseInt(input.nextLine());
    }
}