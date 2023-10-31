package kr.pnu.cse.mid.movie;

public class MovieService {
    protected String name;
    protected  String email;

    public MovieService(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public void printWelcome() {
        System.out.println("Welcome to join our service!!");
    }
}
