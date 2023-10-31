package kr.pnu.cse.mid.movie;

import java.util.Scanner;

public class Registration {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        String email = "";

        boolean validEmail = false;
        while (!validEmail) {
            System.out.print("Enter your email: ");
            email = sc.nextLine();
            // YOur code
            String[] subStrings = email.split("@");

            // id가 2자 이상이어야 함
            if (subStrings[0].length() >= 2 && subStrings[1].equals("pusan.ac.kr"))
                validEmail = true;
        }

        System.out.print("Choose your favorite genre (1: Comedy, 2: Fantasy): ");
        int genre = sc.nextInt();
        MovieService movieService;

        switch (genre) {
            case 1:
                //YOur code
                movieService = new ComedyMovieService(name, email);
                break;
            case 2:
                // YOur code
                movieService = new FantasyMovieService(name, email);
                break;
            default:
                movieService = new MovieService(name, email);
                break;
        }
        movieService.printWelcome();
        sc.close();
    }
}
