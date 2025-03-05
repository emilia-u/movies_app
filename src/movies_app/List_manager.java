package movies_app;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class List_manager {
    private List<Movie> Towatchlist;
    private List<Movie> Watchedlist;
    private final String TO_WATCH_FILE="data/to_watch.txt";
    private final String WATCHED_FILE="data/watched.txt";
    public List_manager(){//azwa konstruktora ma byc identyczna z nazwa klasy
        Towatchlist=new ArrayList<>();
        Watchedlist=new ArrayList<>();
        loadTowatchlist();
        loadWatchedlist();
    }
    private void loadTowatchlist(){
        try (BufferedReader br = new BufferedReader(new FileReader(TO_WATCH_FILE))) {
            String line;
            while((line=br.readLine())!=null){
                if(!line.trim().isEmpty()){
                    Towatchlist.add(new Movie(line.trim()));
                }
            }    
        }catch(IOException e){
            System.out.println("file loading unsuccessful");
        }
    }
    private void loadWatchedlist(){
        try(BufferedReader br=new BufferedReader(new FileReader(WATCHED_FILE))){
            String line;
            while((line=br.readLine())!=null){
                if(!line.trim().isEmpty()){
                    String[]parts=line.split(";");
                    if(parts.length==2){
                        String title=parts[0].trim();
                        int rating=Integer.parseInt(parts[1].trim());
                        Watchedlist.add(new Movie(title,rating));
                    }
                }
            }
        }catch(IOException e){
            System.out.println("file loading unsuccessful");
        }
    }
    public void savelists(){
        saveTowatchlist();
        saveWatchedlist();
    }
    private void saveTowatchlist(){
        try(BufferedWriter bw=new BufferedWriter(new FileWriter(TO_WATCH_FILE))){
            for(Movie movie:Towatchlist){
                bw.write(movie.getTitle());
                bw.newLine();
            }
        }catch(IOException e){
            System.out.println("file saving unsuccessful");
        }
    }
    private void saveWatchedlist(){
        try(BufferedWriter bw=new BufferedWriter(new FileWriter(WATCHED_FILE))){
            for(Movie movie:Watchedlist){
                bw.write(movie.getTitle()+";"+ movie.getRating());
                bw.newLine();
            }
        }catch(IOException e){
            System.out.println("file saving unsuccessful");
        }
    }
    public void markaswatched(String title,int rating){
        Movie found=null;
        for(Movie movie:Towatchlist){
            if(movie.getTitle().equalsIgnoreCase(title)){
                found=movie;
                break;
            }
        }
        if(found!=null){
            Towatchlist.remove(found);
            found.setRating(rating);
            Watchedlist.add(found);
        }else{
            Movie newmovie=new Movie(title,rating);
            Watchedlist.add(newmovie);
        }
        savelists();

    }
    public List<Movie> getTowatchList(){
        return Towatchlist;
    }
    public List<Movie> getWatchedList(){
        return Watchedlist;
    }
    
}