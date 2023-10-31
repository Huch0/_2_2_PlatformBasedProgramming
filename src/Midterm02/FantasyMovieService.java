package kr.pnu.cse.mid.movie;

public class FantasyMovieService extends MovieService{
    public FantasyMovieService(String name, String email) {
        super(name, email);
    }

    @Override
    public void printWelcome() {
        System.out.println("Welcome to join our service! " + this.name);
        System.out.println("How about these movies? Suzume, Avatar, Soul");
    }
}
