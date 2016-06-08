package br.com.hedo;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author Hedo
 */
public class MeuCalendarioUtil {
    public static void main(String[] args) {
        
    }
    
    public String dayOfBirth(Date birthDate){
        Calendar cal = Calendar.getInstance();
        cal.setTime(birthDate);
        return cal.getDisplayName
        (Calendar.DAY_OF_WEEK,Calendar.LONG, Locale.forLanguageTag("pt-BR"));
    }
    
    public Date timeUntilNow(Date thenDate){
        Calendar cal = Calendar.getInstance();
        return new Date();
    }
}
