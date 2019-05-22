package ComparableAndComparator;

import java.util.*;

class Movie implements Comparable<Movie>{
    private int age;
    private int year;

    public Movie(int age, int year){
        this.age = age;
        this.year = year;
    }

    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return this.age;
    }

    public void setYear(int year){
        this.year = year;
    }
    public int getYear(){
        return this.year;
    }

    @Override
    public int compareTo(Movie o){
        return this.age - o.age;
    }

}

class MovieComparator implements Comparator<Movie>{
    @Override
    public int compare(Movie m1, Movie m2){
        return m1.getAge() - m2.getAge();
    }
}


public class demo {
    public static void main(String[] args){
        Movie[] movies = new Movie[]{
                new Movie(20, 1990),
                new Movie(60, 1980),
                new Movie(50, 1970),
                new Movie(40, 1960)
        };
        //using comparable
//        Arrays.sort(movies);
//        for (int i = 0; i < movies.length; i++){
//            System.out.println(movies[i].getAge());
//        }
        //using comparator
        List<Movie> movieList = Arrays.asList(movies);
        System.out.println("Before sorting: ");
        for (int i = 0; i < movieList.size(); i++){
            System.out.print(movieList.get(i).getAge() + " ");
        }
        System.out.println("");
        Collections.sort(movieList, new MovieComparator());
        System.out.println("After sorting: ");
        for (int i = 0; i < movieList.size(); i++){
            System.out.print(movieList.get(i).getAge() + " ");
        }
    }
}
