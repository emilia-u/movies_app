package movies_app;

public class Movie {
    private String title;
    private int rating;
    public Movie(String title){
        this.title=title;
        this.rating=0;
    }
    public Movie(String title,int rating){
        this.title=title;
        this.rating=rating;
    }
    public String getTitle(){
        return title;
    }
    public int getRating(){
        return rating;
    }
    public void setRating(int rating){
        this.rating=rating;
    }
    @Override
    public String toString(){
        return title+(rating>0?" - "+ rating : "");
    }
}