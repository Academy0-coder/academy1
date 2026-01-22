package Settimana2.eserciziAggiuntivi.src.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.lang.String.valueOf;

public class Path {

    Utility<Position> util = new Utility<>();
    List<Position> path;

    public Path(List<Position> path) {
        this.path = path;
    }


    public List<Position> getPath(){
        return path;
    }



    public Position getLast(){
        return path.getLast();
    }


    // metodo che serve a stampare il messaggio finale
    // prende le coppie di Position consecutive e verifica la rispettiva posizione
    // andando a inserire nella stringa finale il punto cardinale che identifica il movimento avvenuto
    public String theWay(){
        String message = "";
        for(int i=0; i<path.size()-1; i++){
            if(path.get(i+1).isNorthOf(path.get(i))){
                message += "passo "+(i+1)+": nord\n";
            }
            else if(path.get(i+1).isSouthOf(path.get(i))){
                message += "passo "+(i+1)+": sud\n";
            }
            else if(path.get(i+1).isEastOf(path.get(i))){
                message += "passo "+(i+1)+": est\n";
            }
            else if(path.get(i+1).isWestOf(path.get(i))){
                message += "passo "+(i+1)+": ovest\n";
            }
            else{
                message += "miscalculations\n";
            }
        }

        return message;
    }

    @Override
    public String toString() {
        String message = "";
        for(Position p: path){
            message += p.toString()+"\n";
        }
        return message;
    }

    // metodo di utility che verifica se una Position è già presente
    // viene richiamato in findPaths in modo da evitare di ripercorrere le stesse posizioni
    public boolean containsPosition(Position p){
        for(Position q: path){
            if(q.samePosition(p)){
                return true;
            }
        }
        return false;
    }

    // metodo che partendo da un path verifica se ci sono delle strade percorribili
    // serve a verificare se le 4 posizioni adiacenti all'ultimo punto raggiunto fanno ancora parte della strada e non sono ancora state percorse
    // oppure se sono proprio il tesoro
    public List<Path> findPaths(char[][] matrix, char Symbol){

        int length = matrix.length;
        int width = matrix[0].length;

        List<Path> exploring = new ArrayList<>();
        Position lastStep = getLast();
        Position stepNorth = lastStep.northOf();
        Position stepSouth = lastStep.southOf();
        Position stepEast = lastStep.eastOf();
        Position stepWest = lastStep.westOf();


        if(stepNorth.getX()!=-1&&!containsPosition(stepNorth)&&valueOf(matrix[stepNorth.getX()][stepNorth.getY()]).equals(valueOf(Symbol))){

            List<Position> northPath = util.clone(getPath());
            northPath.add(stepNorth);

            exploring.add(new Path(northPath));
        }

        if(stepSouth.getX()<length&&!containsPosition(stepSouth)&&valueOf(matrix[stepSouth.getX()][stepSouth.getY()]).equals(valueOf(Symbol))){

            List<Position> southPath = util.clone(getPath());
            southPath.add(stepSouth);

            exploring.add(new Path(southPath));
        }

        if(stepEast.getY()<width&&!containsPosition(stepEast)&&valueOf(matrix[stepEast.getX()][stepEast.getY()]).equals(valueOf(Symbol))){

            List<Position> eastPath = util.clone(getPath());
            eastPath.add(stepEast);

            exploring.add(new Path(eastPath));
        }

        if(stepWest.getY()!=-1&&!containsPosition(stepWest)&&valueOf(matrix[stepWest.getX()][stepWest.getY()]).equals(valueOf(Symbol))){

            List<Position> westPath = util.clone(getPath());
            westPath.add(stepWest);

            exploring.add(new Path(westPath));
        }

        return exploring;
    }

    // verifica se una strada porta a un determinato valore (T nella fattispecie, verrà infatti richiamato da searchTreasure)
    public Optional<Path> findPath(char[][] matrix, char Symbol){

        if(findPaths(matrix,Symbol).size()==1){
            return Optional.ofNullable(findPaths(matrix, Symbol).getFirst());
        }
        else{
            return Optional.ofNullable(null);
        }


    }

    // metodo che verrà richiamato per verificare se un determinato path è arrivato al tesoro
    public boolean searchTreasure(char[][] matrix, char Symbol){

        Optional<Path> treasure = findPath(matrix, Symbol);
        if(treasure.isPresent()){
            return true;
        }
        else{
            return false;
        }

    }

}
