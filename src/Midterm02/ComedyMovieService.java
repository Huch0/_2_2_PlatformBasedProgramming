package kr.pnu.cse.mid.movie;

public class ComedyMovieService extends MovieService {
    public ComedyMovieService(String name, String email) {
        super(name, email);
    }

    @Override
    public void printWelcome() {
        System.out.println("Welcome to join our service! " + this.name);
        System.out.println("How about these movies? Elemental, Don't Look Up, Barbie");
    }
}
