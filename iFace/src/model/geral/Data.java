package model.geral;

import java.util.Calendar;

public class Data {

    private int dia = 0;
    private int mes = 0;
    private int ano = 0;

    private int hora = 0;
    private int minuto = 0;
    private int segundo = 0;

    public Data() {

        Calendar calendario = Calendar.getInstance();

        this.dia = calendario.get(Calendar.DAY_OF_MONTH);
        this.mes = calendario.get(Calendar.MONTH);
        this.ano = calendario.get(Calendar.YEAR);
        this.hora = calendario.get(Calendar.HOUR);
        this.minuto = calendario.get(Calendar.MINUTE);
        this.segundo = calendario.get(Calendar.SECOND);
    }

    public String toString() {

        return this.dia + "/" + this.mes + "/" + this.ano + " " + this.hora + ":" + this.minuto + ":" + this.segundo + ".";
    }
}
