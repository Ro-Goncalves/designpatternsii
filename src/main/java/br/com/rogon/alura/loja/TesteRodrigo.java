package br.com.rogon.alura.loja;

import java.sql.Date;
import java.util.Calendar;

public class TesteRodrigo {
    public static void main(String[] args) {
        Calendar dataAtual = Calendar.getInstance();
        Calendar dataAlvo = DateToCalendar(Date.valueOf("2023-02-10")); 

        dataAtual.set(Calendar.HOUR, 0);
        dataAtual.set(Calendar.MINUTE,0);
        dataAtual.set(Calendar.SECOND,0);
        dataAtual.set(Calendar.MILLISECOND,0);


        System.out.println(dataAtual.toInstant());
        System.out.println(dataAlvo.toInstant());

        System.out.println(dataAlvo.compareTo(dataAtual));
    }

    private static Calendar DateToCalendar(Date date){		
		Calendar cal = Calendar.getInstance();
        cal.setTime(date);	
		return cal;
	}
}
