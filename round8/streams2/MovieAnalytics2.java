import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.Scanner;
import java.util.Map;
import java.util.stream.Collectors;


public class MovieAnalytics2 {
    private ArrayList<Movie> movies;

    public MovieAnalytics2() {
        movies = new ArrayList<>();
    }

    public void populateWithData(String filename) {
        try{
            File file = new File(filename);

            BufferedReader br = new BufferedReader(new java.io.FileReader(file));

            br.lines().forEach(line -> {
                String[] data = line.split(";");
                Movie movie = new Movie(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2]), data[3], Double.parseDouble(data[4]), data[5]);
                movies.add(movie);
            });
        } catch(IOException e){
            return;
        }
    }

    public static Comparator<Movie> byTitle(){
        return Comparator.comparing(Movie::getTitle);
    }

    public void printCountByDirector(int n){
        movies.stream().collect(Collectors.groupingBy(Movie::getDirector, Collectors.counting())).entrySet().stream().sorted((o1, o2) -> {
            int diff = (int) (o2.getValue() - o1.getValue());
            if(diff == 0){
                return o1.getKey().compareTo(o2.getKey());
            }
            return diff;
        }).limit(n).forEach(entry -> System.out.format("%s: %d movies%n", entry.getKey(), entry.getValue()));
    }

    public void printAverageDurationByGenre(){
        movies.stream().collect(Collectors.groupingBy(Movie::getGenre, Collectors.averagingInt(Movie::getDuration))).entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(entry -> System.out.format("%s: %.2f%n", entry.getKey(), entry.getValue()));
    }

    public void printAverageScoreByGenre(){
        movies.stream().collect(Collectors.groupingBy(Movie::getGenre, Collectors.averagingDouble(Movie::getScore))).entrySet().stream().sorted((o1, o2) -> {
            double diff = (double) (o2.getValue() - o1.getValue());
            if(diff == 0){
                return o1.getKey().compareTo(o2.getKey());
            }
            if (diff > 0) {
                return 1;
            }
            return -1;
        }).forEach(entry -> System.out.format("%s: %.2f%n", entry.getKey(), entry.getValue()));
    }
}
