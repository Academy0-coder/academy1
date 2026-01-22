package Settimana2.eserciziAggiuntivi.src.entities;

import java.util.ArrayList;
import java.util.List;

public class Utility<T> {

    public String removeEmptySpaces(String s){
        s = s.replace(" ","");
        return s;
    }

    // metodo che serve a "clonare" il contenuto di una lista salvandola in un'altra variabile
    public List<T> clone(List<T> l){

        List<T> result = new ArrayList<T>();

        for(T t:l){
            result.add(t);
        }

        return result;
    }

}