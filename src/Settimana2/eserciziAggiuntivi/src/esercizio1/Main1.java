import static java.lang.String.valueOf;

import Settimana2.eserciziAggiuntivi.src.entities.*;

public static void main(String[] args) throws Exception {


    String treasureMap = """
                    ****TX**
                    *SXX*X**
                    ***X*X**
                    ***XXX**
                    ********
            """;

    System.out.println("Soluzione mappa a:");
    findTheTreasure(treasureMap);

    String treasureMap2 = """
                    *X***XXXX**
                    ***XXX**X**
                    **XS*XX*XX*
                    X**X*****X*
                    **XXX*XXXX*
                    **X**XX**XX
                    **XXXX**TX*
            """;

    System.out.println("Soluzione mappa b:");
    findTheTreasure(treasureMap2);

    String treasureMap3 = """
                    ****TX**
                    *S***XX*
                    *X**XX**
                    *X**XXXX
                    *XX*****
            """;

    System.out.println("Soluzione mappa c:");
    findTheTreasure(treasureMap3);

}

// metodo che delinea le soluzioni
private static void findTheTreasure(String geoMap) throws Exception {

    Utility<Path> util = new Utility();

    // verifico che tutte le righe abbiano lo stesso numero di elementi
    List<String> lines = new ArrayList<>();
    geoMap.lines().forEach(l -> lines.add(util.removeEmptySpaces(l)));
    int rows = lines.size();
    int columns = lines.get(0).length();
    for(int i=1; i<rows; i++){
        if(lines.get(i).length()!=columns){
            throw new Exception("Map passed invalid: map is not rectangular");
        }
    }

    // salvo gli elementi della mappa in una "matrice". Ogni elemento è identificato da una coppia(latitudine,longitudine)
    // inoltre mi assicuro che ci sia solo un punto di partenza S e un punto di arrivo T
    // conto il numero di caratteri di tipo se le S o le T sono un numero diverso da 1 oppure ci sono caratteri non compatibili, lancio un'eccezione
    Map<Character,Integer> charCount = new HashMap<>();
    char[][] coord = new char[rows][columns];
    List<Path> possibilities = new ArrayList<>();


    for(int i=0; i<rows; i++){
        char[] currentLine = lines.get(i).toCharArray();
        for(int j=0; j<columns; j++){

            char c = currentLine[j];

            coord[i][j] = c;

            if(charCount.containsKey(c)){
                charCount.put(c,charCount.get(c)+1);
            }
            else{
                charCount.put(c,1);
            }

            if(valueOf(c).equals("S")){
                possibilities.add(new Path(List.of(new Position(i,j))));
            }

        }
    }


    for(char c: charCount.keySet()){
        if(!valueOf(c).matches("[STX*]")){
            throw new Exception("Map passed invalid: "+c+" is not recognized");
        }
    }

    if(charCount.get('S')!=1){
        throw new Exception("Map passed invalid: There should be 1 starting point, not "+charCount.get('S'));
    }

    if(charCount.get('T')!=1){
        throw new Exception("Map passed invalid: There should be 1 treasure, not "+charCount.get('T'));
    }

    // possibilities tiene traccia delle strade ancora "aperte" ovvero che non hanno un vicolo cieco
    // checking è una variabile provvisoria, serve soltanto perché non sarà possibile iterare possibilities e modificarla contemporaneamente
    // solution è la lista di soluzione ovvero di strade che congiungono S e T
    // Path è un oggetto che indica una strada o un percorso, è una lista ordinata di Position adiacenti
    // Position è un oggetto che indica una coordinata geografica (x,y)
    List<Path> checking = List.of();
    List<Path> solution = new ArrayList<>(List.of());



    // continuo a setacciare i percorsi disponibili finché ce ne sono e quelli che portano alla soluzione li aggiungo a solution
    while(!possibilities.isEmpty()){

        checking = util.clone(possibilities);
        for(Path path: checking){
            if(path.searchTreasure(coord,'T')){
                solution.add(path.findPath(coord,'T').get());
                possibilities.remove(path);
            }
            else {
                possibilities.remove(path);
                possibilities.addAll(path.findPaths(coord,'X'));

            }
        }
    }

    // stampo le soluzioni iterando solution, se non ce sono stampo il contenuto del blocco else
    if(solution.size()>0){

        for(int i=0; i<solution.size(); i++){

            System.out.printf("Soluzione %d:\n",i+1);
            System.out.println(solution.get(i).theWay());
        }

    }
    else{
        System.out.println("Non ci sono soluzioni");
    }
}
