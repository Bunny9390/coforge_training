public class MovieClass {

    private String movieName;
    private String director;
    private double rating;

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String toString() {

        return "Movie Name : " + movieName +
                "\nDirector : " + director +
                "\nRating : " + rating;
    }

    public static void main(String[] args) {

        MovieClass m = new MovieClass();

        m.setMovieName("Bahubali");
        m.setDirector("S.S.Rajamouli");
        m.setRating(9.5);

        System.out.println(m);
    }
}