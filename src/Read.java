import java.sql.*;
import java.util.Scanner;

public class Read {

    private static final String USERNAME = "root";
    private static final String PASSWORD = "8610866413";
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/movie_management";

    public static void readMovies() {
        String query = "SELECT * FROM Movies";

        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            System.out.println("Movies Table Data:");
            System.out.println("-------------");

            while (rs.next()) {
               
                System.out.println("ID: " + rs.getInt("movie_id"));
                System.out.println("Title: " + rs.getString("title"));
                System.out.println("Genre: " + rs.getString("genre"));
                System.out.println("Release Date: " + rs.getString("release_date"));
                System.out.println("Director: " + rs.getString("director"));
                System.out.println("Cast: " + rs.getString("cast"));
                System.out.println("Duration: " + rs.getInt("duration"));
                System.out.println("Language: " + rs.getString("language"));
                System.out.println("Country: " + rs.getString("country_of_origin"));
                System.out.println("Rating: " + rs.getFloat("rating"));
                System.out.println("Description: " + rs.getString("description"));
                System.out.println("Poster Image: " + rs.getString("poster_image"));
                System.out.println("Trailer URL: " + rs.getString("trailer_url"));
                System.out.println("Certification: " + rs.getString("certification"));
                System.out.println("IMDb Rating: " + rs.getFloat("imdb_rating"));
                System.out.println("Total Reviews: " + rs.getInt("total_reviews"));
                System.out.println("-------------");
            }

        } catch (Exception e) {
            System.err.println("Error reading data from Movies table: " + e.getMessage());
        }
    }
    public static void readSpecificMovies() {
       
        String[] columns = {
            "movie_id", "title", "genre", "release_date", "director", "cast",
            "duration", "language", "country_of_origin", "rating", "description",
            "poster_image", "trailer_url", "certification", "imdb_rating", "total_reviews"
        };

      
        System.out.println("Choose a column to display:");
        for (int i = 0; i < columns.length; i++) {
            System.out.println((i + 1) + ". " + columns[i]);
        }

        
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

      
            if (choice < 1 || choice > columns.length) {
                System.out.println("Invalid choice. Please select a valid column number.");
                return;
            }

      
            String selectedColumn = columns[choice - 1];
            String query = "SELECT " + selectedColumn + " FROM Movies";

      
            try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                 Statement stmt = con.createStatement();
                 ResultSet rs = stmt.executeQuery(query)) {

                System.out.println("Data from column: " + selectedColumn);
                System.out.println("-------------");

                while (rs.next()) {
                    System.out.println(selectedColumn + ": " + rs.getString(selectedColumn));
                }

            } catch (Exception e) {
                System.err.println("Error reading data from Movies table: " + e.getMessage());
            }
        }
    }

    public static void readGenres() {
        String query = "SELECT * FROM Genres";

        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            System.out.println("Genres Table Data:");
            System.out.println("-------------");

            while (rs.next()) {
               
                System.out.println("Genre ID: " + rs.getInt("genre_id"));
                System.out.println("Genre Name: " + rs.getString("genre_name"));
                System.out.println("-------------");
            }

        } catch (Exception e) {
            System.err.println("Error reading data from Genres table: " + e.getMessage());
        }
    }

    public static void readMovieSimilarity() {
        String query = "SELECT * FROM moviesimilarity";
    
        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
    
            System.out.println("Movie Similarity Table Data:");
            System.out.println("-------------");
    
            while (rs.next()) {
                System.out.println("Similarity ID: " + rs.getInt("similarity_id"));
                System.out.println("Movie ID 1: " + rs.getInt("movie_id_1"));
                System.out.println("Movie ID 2: " + rs.getInt("movie_id_2"));
                System.out.println("Similarity Score: " + rs.getFloat("similarity_score"));
                System.out.println("-------------");
            }
    
        } catch (Exception e) {
            System.err.println("Error reading data from moviesimilarity table: " + e.getMessage());
        }
    }

    public static void readNotifications() {
        String query = "SELECT * FROM notifications";
    
        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
    
            System.out.println("Notifications Table Data:");
            System.out.println("-------------");
    
            while (rs.next()) {
                System.out.println("Notification ID: " + rs.getInt("notification_id"));
                System.out.println("User ID: " + rs.getInt("user_id"));
                System.out.println("Message: " + rs.getString("message"));
                System.out.println("Date Sent: " + rs.getString("date_sent"));
                System.out.println("Notification Type: " + rs.getString("notification_type"));
                System.out.println("-------------");
            }
    
        } catch (Exception e) {
            System.err.println("Error reading data from notifications table: " + e.getMessage());
        }
    }

    public static void readPersons() {
        String query = "SELECT * FROM persons";
    
        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
    
            System.out.println("Persons Table Data:");
            System.out.println("-------------");
    
            while (rs.next()) {
                System.out.println("Person ID: " + rs.getInt("person_id"));
                System.out.println("Full Name: " + rs.getString("full_name"));
                System.out.println("Role: " + rs.getString("role"));
                System.out.println("Movies Involved: " + rs.getString("movies_involved"));
                System.out.println("Biography: " + rs.getString("biography"));
                System.out.println("Birth Date: " + rs.getString("birth_date"));
                System.out.println("Awards Won: " + rs.getString("awards_won"));
                System.out.println("-------------");
            }
    
        } catch (Exception e) {
            System.err.println("Error reading data from persons table: " + e.getMessage());
        }
    }

    public static void readRatings() {
        String query = "SELECT * FROM ratings";

        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                int ratingId = rs.getInt("rating_id");
                int userId = rs.getInt("user_id");
                int movieId = rs.getInt("movie_id");
                int ratingValue = rs.getInt("rating_value");
                String reviewText = rs.getString("review_text");
                String ratingDate = rs.getString("rating_date");

                System.out.println("Rating ID: " + ratingId);
                System.out.println("User ID: " + userId);
                System.out.println("Movie ID: " + movieId);
                System.out.println("Rating Value: " + ratingValue);
                System.out.println("Review Text: " + reviewText);
                System.out.println("Rating Date: " + ratingDate);
                System.out.println("----------------------------------");
            }

        } catch (SQLException e) {
            System.err.println("Error reading data: " + e.getMessage());
        }
    }

    public static void readRecommendations() {
        String query = "SELECT * FROM recommendations";

        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                int recommendationId = rs.getInt("recommendation_id");
                int userId = rs.getInt("user_id");
                int movieId = rs.getInt("movie_id");
                float recommendationScore = rs.getFloat("recommendation_score");
                String recommendationDate = rs.getString("recommendation_date");

                System.out.println("Recommendation ID: " + recommendationId);
                System.out.println("User ID: " + userId);
                System.out.println("Movie ID: " + movieId);
                System.out.println("Recommendation Score: " + recommendationScore);
                System.out.println("Recommendation Date: " + recommendationDate);
                System.out.println("----------------------------------");
            }

        } catch (SQLException e) {
            System.err.println("Error reading data: " + e.getMessage());
        }
    
    }

    public static void readReviews() {
        String query = "SELECT * FROM Reviews";
   
        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
   
            while (rs.next()) {
                int reviewId = rs.getInt("review_id");
                int userId = rs.getInt("user_id");
                int movieId = rs.getInt("movie_id");
                String reviewTitle = rs.getString("review_title");
                String reviewText = rs.getString("review_text");
                Date reviewDate = rs.getDate("review_date");
                int reviewLikes = rs.getInt("review_likes");
                int reviewDislikes = rs.getInt("review_dislikes");
   
                System.out.println("Review ID: " + reviewId);
                System.out.println("User ID: " + userId);
                System.out.println("Movie ID: " + movieId);
                System.out.println("Review Title: " + reviewTitle);
                System.out.println("Review Text: " + reviewText);
                System.out.println("Review Date: " + (reviewDate != null ? reviewDate.toString() : "N/A"));
                System.out.println("Review Likes: " + reviewLikes);
                System.out.println("Review Dislikes: " + reviewDislikes);
                System.out.println("-------------");
            }
   
        } catch (SQLException e) {
            System.err.println("Error reading reviews: " + e.getMessage());
        }
    }
   

    public static Object readSearchHistory() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readSearchHistory'");
    }

    public static Object readSubscriptions() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readSubscriptions'");
    }

    public static Object readViewingHistory() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readViewingHistory'");
    }

    public static Object readWatchlist() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readWatchlist'");
    }
    
    
    
    
}
