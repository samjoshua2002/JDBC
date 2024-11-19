import java.util.Scanner;

public class Main {

    public static void displayTables() {
        System.out.println("Choose a table:");
        System.out.println("1. Movies");
        System.out.println("2. Genres");
        System.out.println("3. Movie Similarity");
        System.out.println("4. Notifications");
        System.out.println("5. Persons");
        System.out.println("6. Ratings");
        System.out.println("7. Recommendations");
        System.out.println("8. Reviews");
        System.out.println("9. Search History");
        System.out.println("10. Subscriptions");
        System.out.println("11. Viewing History");
        System.out.println("12. Watchlist");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\nChoose an operation:");
        System.out.println("1. Insert");
        System.out.println("2. Delete");
        System.out.println("3. Update");
        System.out.println("4. Read");
        System.out.println("5. Exit");

        System.out.print("Enter your choice: ");
        int operationChoice = sc.nextInt();
        sc.nextLine();
        if (operationChoice == 5) {
            System.out.println("Thankyou.");
            sc.close();
            return;
        }
        if (operationChoice < 1 || operationChoice > 4) {
            System.out.println("Invalid operation choice. Please try again.");
            sc.close();
            return;
        } 

        displayTables();
        System.out.print("Enter your table choice: ");
        int tableChoice = sc.nextInt();
        sc.nextLine();

        switch (operationChoice) {
case 1 -> {
                switch (tableChoice) {
                    case 1 -> Insert.insertMovies();
                    case 2 -> Insert.insertGenres();
                    case 3 -> Insert.insertMovieSimilarity();
                    case 4 -> Insert.insertNotifications();
                    case 5 -> Insert.insertPersons();
                    case 6 -> Insert.insertRatings();
                    case 7 -> Insert.insertRecommendations();
                    case 8 -> Insert.insertReview();
                    case 9 -> Insert.insertSearchHistory();
                    case 10 -> Insert.insertSubscriptions();
                    case 11 -> Insert.insertViewingHistory();
                    case 12 -> Insert.insertWatchlist();
                    default -> System.out.println("Invalid table choice.");
                }
            }

            case 2 -> { 
                switch (tableChoice) {
                    case 1 -> {
                        Read.readMovies();
                        Delete.deleteMovieById();
                    }
                    case 2 -> {
                        Read.readGenres();
                        Delete.deleteGenreById();
                    }
                    case 3 -> {
                        Read.readMovieSimilarity();
                        Delete.deleteMovieSimilarity();
                    }
                    case 4 -> {
                        Read.readNotifications();
                        Delete.deleteNotifications();
                    }
                    case 5 -> {
                        Read.readPersons();
                        Delete.deletePersons();
                    }
                    case 6 -> {
                        Read.readRatings();
                        Delete.deleteRatings();
                    }
                    case 7 -> {
                        Read.readRecommendations();
                        Delete.deleteRecommendations();
                    }
                    case 8 -> {
                        Read.readReviews();
                        Delete.deleteReview();
                    }
                    case 9 -> {
                        Read.readSearchHistory();
                        Delete.deleteSearchHistoryById();
                    }
                    case 10 -> {
                        Read.readSubscriptions();
                        Delete.deleteSubscriptionById();
                    }
                    case 11 -> {
                        Read.readViewingHistory();
                        Delete.deleteViewingHistoryById();
                    }
                    case 12 -> {
                        Read.readWatchlist();
                        Delete.deleteWatchlistById();
                    }
                    default -> System.out.println("Invalid table choice.");
                }
            }

            case 3 -> { 
                switch (tableChoice) {
                    case 1 -> {
                        Read.readMovies();
                        Update.updateMovies();
                    }
                    case 2 -> {
                        Read.readGenres();
                        Update.updateGenres();
                    }
                    case 3 -> {
                        Read.readMovieSimilarity();
                        Update.updateMovieSimilarity();
                    }
                    case 4 -> {
                        Read.readNotifications();
                        Update.updateNotifications();
                    }
                    case 5 -> {
                        Read.readPersons();
                        Update.updatePersons();
                    }
                    case 6 -> {
                        Read.readRatings();
                        Update.updateRatings();
                    }
                    case 7 -> {
                        Read.readRecommendations();
                        Update.updateRecommendations();
                    }
                    case 8 -> {
                        Read.readReviews();
                        Update.updateReviews();
                    }
                    case 9 -> {
                        Read.readSearchHistory();
                        Update.updateSearchHistory();
                    }
                    case 10 -> {
                        Read.readSubscriptions();
                        Update.updateSubscriptions();
                    }
                    case 11 -> {
                        Read.readViewingHistory();
                        Update.updateViewingHistory();
                    }
                    case 12 -> {
                        Read.readWatchlist();
                        Update.updateWatchlist();
                    }
                    default -> System.out.println("Invalid table choice.");
                }
            }

            case 4 -> { 
                switch (tableChoice) {
                    case 1 -> Read.readSpecificMovies();
                    case 2 -> Read.readGenres();
                    case 3 -> Read.readMovieSimilarity();
                    case 4 -> Read.readNotifications();
                    case 5 -> Read.readPersons();
                    case 6 -> Read.readRatings();
                    case 7 -> Read.readRecommendations();
                    case 8 -> Read.readReviews();
                    case 9 -> Read.readSearchHistory();
                    case 10 -> Read.readSubscriptions();
                    case 11 -> Read.readViewingHistory();
                    case 12 -> Read.readWatchlist();
                    default -> System.out.println("Invalid table choice.");
                }
            }

        default -> System.out.println("Invalid operation choice. Please try again.");
        }
        

        sc.close();
    }
}
