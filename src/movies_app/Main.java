package movies_app;
import java.util.Scanner;

public class Main{
    public static void main(String []args){
        List_manager manager=new List_manager();
        Scanner scanner=new Scanner(System.in);
        System.out.println("do you want to see the list of films to be watched?(yes/no)");
        String show=scanner.nextLine();
        if(show.equals("yes")){
            for(Movie movie:manager.getTowatchList()){
                System.out.println(movie.getTitle());
            }
        }
        System.out.println("what film did you watch?");
        String title=scanner.nextLine();

        System.out.println("how do you rate it?(1-10)");
        int rating=scanner.nextInt();
        manager.markaswatched(title, rating);
        scanner.close();
    }
}