public class Book {
    public String author;
    public String title;
    public Genre genre;

    Book(String author, String title, Genre genre){
        this.author=author;
        this.title=title;
        this.genre=genre;
    }

    public String toString(){
        return  author+ " " + title + " " + genre.name();
    }


}
