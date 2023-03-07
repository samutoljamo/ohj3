import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.Scanner;

public class MovieAnalytics {
    private ArrayList<Movie> movies;

    private Comparator<Movie> byYear = (Movie m1, Movie m2) -> {
        int diff = m1.getReleaseYear() - m2.getReleaseYear();
        if(diff == 0){
            return m1.getTitle().compareTo(m2.getTitle());
        }
        return diff;
    };
    public MovieAnalytics() {
        movies = new ArrayList<>();
    }

    public static Consumer<Movie> showInfo() {
        return movie -> System.out.format("%s (By %s, %d)%n", movie.getTitle(), movie.getDirector(), movie.getReleaseYear());
    }

    public void populateWithData(String filename) {
        try{
            File file = new File(filename);
            Scanner sc = new Scanner(file);


            while(sc.hasNextLine()){
                String line = sc.nextLine();
                String[] data = line.split(";");
                Movie movie = new Movie(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2]), data[3], Double.parseDouble(data[4]), data[5]);
                movies.add(movie);

            }
        } catch(IOException e){
            return;
        }
    }
    Stream<Movie> moviesAfter(int year){
        return movies.stream().filter(movie -> movie.getReleaseYear() >= year).sorted(byYear);
    }

    Stream<Movie> moviesBefore(int year){
        return movies.stream().filter(movie -> movie.getReleaseYear() <= year).sorted(byYear);
    }

    Stream<Movie> moviesBetween(int year1, int year2){
        return movies.stream().filter(movie -> movie.getReleaseYear() >= year1 && movie.getReleaseYear() <= year2).sorted(byYear);
    }

    Stream<Movie> moviesByDirector(String director){
        return movies.stream().filter(movie -> movie.getDirector().equals(director)).sorted(byYear);
    }
}
