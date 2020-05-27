package gf.progettoesame.SpringBootApp.utility;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Classe che permette di filtrare gli oggetti 
 * in base ai parametri che saranno specificati
 * @param <T> Tipo generico
 */
public class Filtriut<T> {
    /**
     * Metodo che dopo aver passato un filtro
     * mi dice se l'oggetto considerato va incluso o meno nella risposta
     * @param value Oggetto che viene considerato nel test
     * @param operator Condizione del filtro
     * @param th Oggetti che caratterizzano il filtro
     * @return Un booleano che determina se l'oggetto deve essere tenuto o meno
     */
    public static boolean controllo(Object valore, String operatoreLogico, Object... twe) {
        if (twe.length == 1 && twe[0] instanceof Number && valore instanceof Number) {
            Double twe1 = ((Number)twe[0]).doubleValue();
            Double valore1 = ((Number)valore).doubleValue();
            if (operatoreLogico.equals("$eq"))
                return valore.equals(twe[0]);
            else if (operatoreLogico.equals("$not"))
                return !valore.equals(twe[0]);
            else if (operatoreLogico.equals("$gt"))
                return valore1 > twe1;
            else if (operatoreLogico.equals("$lt"))
                return valore1 < twe1;
        } else if(twe.length == 1 && twe[0] instanceof String && valore instanceof String) {
            if(operatoreLogico.equals("$eq") || operatoreLogico.equals("$in")) return valore.equals(twe[0]);
            else if(operatoreLogico.equals("$not") || operatoreLogico.equals("$nin")) return !valore.equals(twe[0]);
        } else if(twe.length > 1) {
            if (operatoreLogico.equals("$bt")) {
                if(twe.length == 2 && twe[0] instanceof Number && twe[1] instanceof Number) {
                    Double min = ((Number)twe[0]).doubleValue();
                    Double max = ((Number)twe[1]).doubleValue();
                    Double valore1 = ((Number)valore).doubleValue();
                    return valore1 >= min && valore1 <= max;
                }
            }
            else if (operatoreLogico.equals("$in"))
                return Arrays.asList(twe).contains(valore);
            else if (operatoreLogico.equals("$nin"))
                return !Arrays.asList(twe).contains(valore);
        }
        return false;
    }
    //controlla bene sopra
    //sotto da cambiare
    /**
     * Metodo che riceve l'intera collezione di oggetti ed il filtro e restituisce una collezione parziale con gli
     * oggetti selezionati
     * @param src L'intera collezione di oggetti
     * @param fieldName Campo su cui opera il filtro
     * @param operator Condizione del filtro
     * @param value Oggetti che caratterizzano il filtro
     * @return Collezione risultante
     */
    public Collection<T> select(Collection<T> tml, String nomeCampo, String operatoreLogico, Object... valore) {
        Collection<T> out = new ArrayList<T>();
        for(T twt:tml) {
            try {
                Method m = null;
                if(isInteger(nomeCampo)) {
                    m = twt.getClass().getMethod("getYear", int.class);
                } else {
                    m = twt.getClass().getMethod("get"+nomeCampo.substring(0, 1).toUpperCase()+nomeCampo.substring(1),null);
                }
                try {
                    Object tmp = null;
                    if(isInteger(nomeCampo)) {
                        tmp = m.invoke(twt, Integer.parseInt(nomeCampo));
                    } else {
                        tmp = m.invoke(twt);
                    }
                    if(Filtriut.controllo(tmp, operatoreLogico, valore))
                        out.add(twt);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (SecurityException e) {
                e.printStackTrace();
            }
        }
        return out;
    }

    /**
     * Metodo che stabilisce se l'argomento in ingresso può essere parsato come intero
     * @param fieldName Stringa sui testare il parse
     * @return Restituisce un booleano per esprimere l'esito del test
     */
    private static boolean isInteger(String nomeCampo) {
        try {
            Integer.parseInt(nomeCampo);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}


	