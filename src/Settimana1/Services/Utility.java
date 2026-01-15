package Settimana1.Services;

public class Utility {

    // rende il primo carattere della stringa maiuscolo (a prescindere che sia una lettera o meno) e il resto minuscolo
    public static String maiuscolize(String s){
        return s.substring(0,1).toUpperCase()+s.substring(1).toLowerCase();
    }

    // rende il primo carattere di ogni parola maiuscola
    public static String maiuscolizeAllFirst(String s){
        String[] words = s.split(" ");
        for(int i=0; i< words.length; i++){
            words[i] = maiuscolize(words[i]);
        }
        return stringRecomposer(words);
    }

    // rende il carattere centrale della stringa maiuscolo e gli altri minuscoli
    public static String maiuscolizeCentered(String s){
        int middle = Math.round(s.length()/2);
        return s.substring(0,middle).toLowerCase()
                + s.substring(middle,middle+1).toUpperCase()
                + s.substring(middle+1).toLowerCase();

    }

    // compone una stringa prendendo in input un'array di stringhe e lasciando uno spazio fra ogni coppia di elementi
    public static String stringRecomposer(String[] arr){
        String result = arr[0];
        for(int i=1; i<arr.length; i++){
            result += " "+arr[i];
        }
        return result;
    }

    // compone una stringa prendendo in input un'array di stringhe e lasciando una virgola e uno spazio fra ogni coppia di elementi
    public static String stringRecomposerWithCommas(String[] arr){
        String result = arr[0];
        for(int i=1; i<arr.length; i++){
            result += ", "+arr[i];
        }
        return result;
    }

    // estrae un numero intero a caso tra 0 ed n (n escluso)
    public static int randomized(int n){
        return (int)(Math.random()*n);
    }

    // modifico un'array di valori di enum in un'array di stringhe
    public static String[] enumToString(Enum[] arr){
        String[] result = new String[arr.length];
        for(int i=0; i<arr.length; i++){
            result[i] = arr[i].toString().toLowerCase();
        }

        return result;
    }

    // verifico se un'array contiene un determinato valore (simile al .contains delle liste)
    public static boolean containsArr(Object[] arr, Object o){
        for(Object obj: arr){
            if (o.equals(obj)){
                return true;
            }
        }
        return false;
    }
}
