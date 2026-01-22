import Settimana2.eserciziAggiuntivi.src.entities.*;

import static Settimana2.eserciziAggiuntivi.src.esercizio2.MovieStream.*;

public static void main(String[] args) {

    // creo delle persone, il primo blocco lo uso come utenti, il secondo come registi
    Persona p1 = new Persona("Pippo","Rossi",LocalDate.of(1991,10,3));
    Persona p2 = new Persona("Pippo","Bianchi",LocalDate.of(1977,9,30));
    Persona p3 = new Persona("Pluto","Gialli",LocalDate.of(1984,3,2));
    Persona p4 = new Persona("Topolino","Rossi",LocalDate.of(2000,10,5));
    Persona p5 = new Persona("Minnie","Verdi",LocalDate.of(2009,6,14));
    Persona p6 = new Persona("Gambadilegno","Rossi",LocalDate.of(1957,8,9));
    Persona p7 = new Persona("Paperina","Blu",LocalDate.of(1984,1,20));
    Persona p8 = new Persona("Paperone","Arancioni",LocalDate.of(1942,1,14));
    Persona p9 = new Persona("Paperino","Neri",LocalDate.of(1969,12,18));


    Persona r1 = new Persona("Francis Ford","Coppola",LocalDate.of(1939,4,7));
    Persona r2 = new Persona("Christopher","Nolan",LocalDate.of(1970,7,30));
    Persona r3 = new Persona("Peter","Jackson",LocalDate.of(1961,10,31));
    Persona r4 = new Persona("Alfred","Hitchcock",LocalDate.of(1899,8,13));
    Persona r5 = new Persona("Steven","Spielberg",LocalDate.of(1946,12,18));
    Persona r6 = new Persona("Kenneth","Branagh",LocalDate.of(1960,12,10));
    Persona r7 = new Persona("David","Frankel",LocalDate.of(1959,4,2));
    Persona r8 = new Persona("Quentin","Tarantino",LocalDate.of(1963,3,27));
    Persona r9 = new Persona("James","Cameron",LocalDate.of(1954,8,16));
    Persona r10 = new Persona("Ridley","Scott",LocalDate.of(1937,11,30));


    // creo degli film
    Movie m1 = new Movie(1,"Il Padrino",r1,175,Year.of(1972),false,Tipologia.DRAMMATICO);
    Movie m2 = new Movie(2,"Oppenheimer",r2,180,Year.of(2023),true,Tipologia.STORICO);
    Movie m3 = new Movie(3,"La Compagnia dell'Anello",r3,178,Year.of(2001),false,Tipologia.FANTASY);
    Movie m4 = new Movie(4,"Intrigo internazionale",r4,136,Year.of(1959),false,Tipologia.AZIONE);
    Movie m5 = new Movie(5,"Salvate il soldato Ryan",r5,169,Year.of(1998),true,Tipologia.GUERRA);
    Movie m6 = new Movie(6,"Interstellar",r2,169,Year.of(2014),false,Tipologia.FANTASCIENZA);
    Movie m7 = new Movie(7, "La finestra sul cortile", r4,112,Year.of(1954),false,Tipologia.THRILLER);
    Movie m8 = new Movie(8,"Schindler's List",r5,195,Year.of(1993),true,Tipologia.STORICO);
    Movie m9 = new Movie(9,"Assassinio sull'Orient Express",r6,114,Year.of(2017),false,Tipologia.GIALLO);
    Movie m10 = new Movie(10,"Il diavolo veste Prada",r7,109,Year.of(2006),true,Tipologia.COMMEDIA);
    Movie m11 = new Movie(11,"Django Unchained",r8,165,Year.of(2012),false,Tipologia.WESTERN);
    Movie m12 = new Movie(12,"Titanic",r9,195,Year.of(1997),false,Tipologia.SENTIMENTALE);
    Movie m13 = new Movie(13,"Blade Runner",r10,117,Year.of(1982),false,Tipologia.FANTASCIENZA);


    // creo degli utenti
    MovieWatcher mw1 = new MovieWatcher(p1,5,Map.of(2,1,3,2,5,5,7,2,8,1,10,1,11,1,13,1));
    MovieWatcher mw2 = new MovieWatcher(p2,9,Map.of(1,1,2,1,3,1,4,2,5,2,6,1,7,2,9,3,10,1,11,2));
    MovieWatcher mw3 = new MovieWatcher(p3,11,Map.of(1,2,3,1,7,1,8,1,11,3,13,1));
    MovieWatcher mw4 = new MovieWatcher(p4,6,Map.of(2,1,4,1,6,12,9,2,11,1,12,2));
    MovieWatcher mw5 = new MovieWatcher(p5,1,Map.of(1,4,2,1,4,1,5,1,6,3,9,1,11,2,13,1));
    MovieWatcher mw6 = new MovieWatcher(p6,5,Map.of(4,1,5,2,8,1,9,1,12,1));
    MovieWatcher mw7 = new MovieWatcher(p7,13,Map.of(2,1,3,1,6,1,9,1,10,3,13,2));
    MovieWatcher mw8 = new MovieWatcher(p8,8,Map.of(1,2,3,2,4,1,5,1,7,1,8,1,9,2,10,3,11,1,13,1));
    MovieWatcher mw9 = new MovieWatcher(p9,3,Map.of(3,1,4,1,5,2,6,2,7,2,8,1,10,1,12,2,13,3));

    Set<MovieWatcher> mws = Set.of(mw1,mw2,mw3,mw4,mw5,mw6,mw7,mw8,mw9);
    Set<Movie> movieSet = Set.of(m1,m2,m3,m4,m5,m6,m7,m8,m9,m10,m11,m12,m13);
    List<Persona> directors = List.of(r1,r2,r3,r4,r5,r6,r7,r8,r9,r10);
    Map<Integer,Movie> movieMapper = new HashMap<>();
    movieSet.stream().forEach(m -> movieMapper.put(m.getId(),m));
    Scanner scanner = new Scanner(System.in);

    // metodo che dato un utente stampa il numero di minuti che ha passato a vedere film
    printTimeSpent(mw1, movieMapper);
    printTimeSpent(mw2, movieMapper);

    System.out.println();

    // metodo che data una lista di utenti stampa il film più visto dal gruppo
    // in caso di parità ne stampa solo 1 (Si potrebbe migliorare)
    printMostSeen(List.of(mw3,mw4,mw5), movieMapper, movieSet);
    printMostSeen(List.of(mw6,mw7,mw8), movieMapper, movieSet);

    System.out.println();

    // metodo che data una lista di utenti e un'età minima (in anni) stampa il nome della persona
    // che ha almeno quell'età che ha visto più film
    // Se non ci sono utenti con almeno quell'età, stampa una stringa apposita
    System.out.println(getMovieWatcher(mws.stream().toList(),movieMapper,10));
    System.out.println(getMovieWatcher(mws.stream().toList(),movieMapper,50));
    System.out.println(getMovieWatcher(mws.stream().toList(),movieMapper,90));

    // stessa cosa, ma si può inserire l'età come input
    System.out.println("Inserisci un'età");
    String inputS = scanner.nextLine();

    try{
        int input = Integer.parseInt(inputS);
        System.out.println(getMovieWatcher(mws.stream().toList(),movieMapper,input));
    }
    catch (NumberFormatException nfe){

        nfe.printStackTrace();
    }

    scanner.close();


    System.out.println();

    // metodo che printa il regista preferito da una lista di utenti
    // in caso di parità ne stampa solo 1 (Si potrebbe migliorare)
    printDirector(mws,movieSet,directors);



}









