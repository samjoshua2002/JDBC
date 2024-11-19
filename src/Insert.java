import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Insert {

    private static final String USERNAME = "root";
    private static final String PASSWORD = "8610866413";
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/movie_management";

   
    public static  void insertMovies() {
        String query = "INSERT INTO Movies (title, genre, release_date, director, cast, duration, language, " +
                       "country_of_origin, rating, description, poster_image, trailer_url, certification, " +
                       "imdb_rating, total_reviews) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement pst = con.prepareStatement(query);
             Scanner sc = new Scanner(System.in)) {

            System.out.print("Enter Title: ");
            String title = sc.nextLine();
            System.out.print("Enter Genre: ");
            String genre = sc.nextLine();
            System.out.print("Enter Release Date (YYYY-MM-DD): ");
            String releaseDate = sc.nextLine();
            System.out.print("Enter Director: ");
            String director = sc.nextLine();
            System.out.print("Enter Cast: ");
            String cast = sc.nextLine();
            System.out.print("Enter Duration (minutes): ");
            int duration = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter Language: ");
            String language = sc.nextLine();
            System.out.print("Enter Country of Origin: ");
            String country = sc.nextLine();
            System.out.print("Enter Rating: ");
            float rating = sc.nextFloat();
            sc.nextLine();
            System.out.print("Enter Description: ");
            String description = sc.nextLine();
            System.out.print("Enter Poster Image URL: ");
            String posterImage = sc.nextLine();
            System.out.print("Enter Trailer URL: ");
            String trailerUrl = sc.nextLine();
            System.out.print("Enter Certification: ");
            String certification = sc.nextLine();
            System.out.print("Enter IMDb Rating: ");
            float imdbRating = sc.nextFloat();
            System.out.print("Enter Total Reviews: ");
            int totalReviews = sc.nextInt();

            pst.setString(1, title);
            pst.setString(2, genre);
            pst.setString(3, releaseDate);
            pst.setString(4, director);
            pst.setString(5, cast);
            pst.setInt(6, duration);
            pst.setString(7, language);
            pst.setString(8, country);
            pst.setFloat(9, rating);
            pst.setString(10, description);
            pst.setString(11, posterImage);
            pst.setString(12, trailerUrl);
            pst.setString(13, certification);
            pst.setFloat(14, imdbRating);
            pst.setInt(15, totalReviews);

            pst.executeUpdate();
            System.out.println("Data inserted into Movies table successfully.");

        } catch (Exception e) {
            System.err.println("Error inserting data into Movies table: " + e.getMessage());
        }
    }

  
    public static void insertGenres() {
        String query = "INSERT INTO Genres (genre_id, genre_name) VALUES (?, ?)";

        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement pst = con.prepareStatement(query);
             Scanner sc = new Scanner(System.in)) {

            System.out.print("Enter Genre ID: ");
            int genreId = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter Genre Name: ");
            String genreName = sc.nextLine();
            

            pst.setInt(1, genreId);
            pst.setString(2, genreName);
            

            pst.executeUpdate();
            System.out.println("Data inserted into Genres table successfully.");

        } catch (Exception e) {
            System.err.println("Error inserting data into Genres table: " + e.getMessage());
        }
    }


    public static void insertMovieSimilarity() {
        String query = "INSERT INTO moviesimilarity (similarity_id, movie_id_1, movie_id_2, similarity_score) VALUES (?, ?, ?, ?)";

        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement pst = con.prepareStatement(query);
             Scanner sc = new Scanner(System.in)) {

            System.out.print("Enter Similarity ID: ");
            int similarityId = sc.nextInt();
            System.out.print("Enter Movie ID 1: ");
            int movieId1 = sc.nextInt();
            System.out.print("Enter Movie ID 2: ");
            int movieId2 = sc.nextInt();
            System.out.print("Enter Similarity Score: ");
            float similarityScore = sc.nextFloat();

            pst.setInt(1, similarityId);
            pst.setInt(2, movieId1);
            pst.setInt(3, movieId2);
            pst.setFloat(4, similarityScore);

            pst.executeUpdate();
            System.out.println("Data inserted into moviesimilarity table successfully.");
        } catch (Exception e) {
            System.err.println("Error inserting data into moviesimilarity table: " + e.getMessage());
        }
       
    }


    public static void insertNotifications() {
        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Scanner sc = new Scanner(System.in)) {
    
            System.out.print("Enter User ID: ");
            int userId = sc.nextInt();
            sc.nextLine();  // Consume newline character
    
            System.out.print("Enter Message: ");
            String message = sc.nextLine();
    
            System.out.print("Enter Date Sent (YYYY-MM-DD): ");
            String dateSent = sc.nextLine();
    
            System.out.print("Enter Notification Type (Email, SMS, Push): ");
            String notificationType = sc.nextLine();
    
            String query = "INSERT INTO notifications (user_id, message, date_sent, notification_type) VALUES (?, ?, ?, ?)";
    
            try (PreparedStatement pst = con.prepareStatement(query)) {
                pst.setInt(1, userId);
                pst.setString(2, message);
                pst.setString(3, dateSent);
                pst.setString(4, notificationType);
    
                int rowsAffected = pst.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Notification inserted successfully.");
                } else {
                    System.out.println("Error inserting notification.");
                }
            }
    
        } catch (Exception e) {
            System.err.println("Error inserting data into notifications table: " + e.getMessage());
        }
    }


    public static void insertPersons() {
        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Scanner sc = new Scanner(System.in)) {
    
            System.out.print("Enter Full Name: ");
            String fullName = sc.nextLine();
    
            System.out.print("Enter Role (Actor, Actress, Director): ");
            String role = sc.nextLine();
    
            System.out.print("Enter Movies Involved (Comma separated): ");
            String moviesInvolved = sc.nextLine();
    
            System.out.print("Enter Biography: ");
            String biography = sc.nextLine();
    
            System.out.print("Enter Birth Date (YYYY-MM-DD): ");
            String birthDate = sc.nextLine();
    
            System.out.print("Enter Awards Won: ");
            String awardsWon = sc.nextLine();
    
            String query = "INSERT INTO persons (full_name, role, movies_involved, biography, birth_date, awards_won) VALUES (?, ?, ?, ?, ?, ?)";
    
            try (PreparedStatement pst = con.prepareStatement(query)) {
                pst.setString(1, fullName);
                pst.setString(2, role);
                pst.setString(3, moviesInvolved);
                pst.setString(4, biography);
                pst.setString(5, birthDate);
                pst.setString(6, awardsWon);
    
                int rowsAffected = pst.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Person inserted successfully.");
                } else {
                    System.out.println("Error inserting person.");
                }
            }
    
        } catch (Exception e) {
            System.err.println("Error inserting data into persons table: " + e.getMessage());
        }
    }


    public static void insertRatings() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Rating ID: ");
        int ratingId = sc.nextInt();
        sc.nextLine(); 

        System.out.print("Enter User ID: ");
        int userId = sc.nextInt();
        sc.nextLine(); 

        System.out.print("Enter Movie ID: ");
        int movieId = sc.nextInt();
        sc.nextLine(); 

        System.out.print("Enter Rating Value (1-5): ");
        int ratingValue = sc.nextInt();
        sc.nextLine(); 

        System.out.print("Enter Review Text: ");
        String reviewText = sc.nextLine();

        System.out.print("Enter Rating Date (YYYY-MM-DD): ");
        String ratingDate = sc.nextLine();

        String query = "INSERT INTO ratings (rating_id, user_id, movie_id, rating_value, review_text, rating_date) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setInt(1, ratingId);
            pst.setInt(2, userId);
            pst.setInt(3, movieId);
            pst.setInt(4, ratingValue);
            pst.setString(5, reviewText);
            pst.setString(6, ratingDate);

            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Rating record inserted successfully.");
            } else {
                System.out.println("Error inserting record.");
            }

        } catch (SQLException e) {
            System.err.println("Error inserting data: " + e.getMessage());
        }
        sc.close();
    }


    public static void insertRecommendations() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Recommendation ID: ");
        int recommendationId = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter User ID: ");
        int userId = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Movie ID: ");
        int movieId = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Recommendation Score: ");
        float recommendationScore = sc.nextFloat();
        sc.nextLine();

        System.out.print("Enter Recommendation Date (YYYY-MM-DD): ");
        String recommendationDate = sc.nextLine();

        String query = "INSERT INTO recommendations (recommendation_id, user_id, movie_id, recommendation_score, recommendation_date) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setInt(1, recommendationId);
            pst.setInt(2, userId);
            pst.setInt(3, movieId);
            pst.setFloat(4, recommendationScore);
            pst.setString(5, recommendationDate);

            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Recommendation record inserted successfully.");
            } else {
                System.out.println("Error inserting record.");
            }

        } catch (SQLException e) {
            System.err.println("Error inserting data: " + e.getMessage());
        }
        sc.close();
    }


    public static void insertReview() {
        String query = "INSERT INTO Reviews (review_id, user_id, movie_id, review_title, review_text, review_date, review_likes, review_dislikes) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    
        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement pst = con.prepareStatement(query);
             Scanner sc = new Scanner(System.in)) {
    
            System.out.print("Enter Review ID: ");
            int reviewId = sc.nextInt();
            sc.nextLine(); 
            System.out.print("Enter User ID: ");
            int userId = sc.nextInt();
            sc.nextLine();
    
            System.out.print("Enter Movie ID: ");
            int movieId = sc.nextInt();
            sc.nextLine(); 
    
            System.out.print("Enter Review Title: ");
            String reviewTitle = sc.nextLine();
    
            System.out.print("Enter Review Text: ");
            String reviewText = sc.nextLine();
    
            System.out.print("Enter Review Date (YYYY-MM-DD): ");
            String reviewDate = sc.nextLine();
    
            System.out.print("Enter Review Likes: ");
            int reviewLikes = sc.nextInt();
            sc.nextLine();
    
            System.out.print("Enter Review Dislikes: ");
            int reviewDislikes = sc.nextInt();
    
            pst.setInt(1, reviewId);
            pst.setInt(2, userId);
            pst.setInt(3, movieId);
            pst.setString(4, reviewTitle);
            pst.setString(5, reviewText);
            pst.setString(6, reviewDate);
            pst.setInt(7, reviewLikes);
            pst.setInt(8, reviewDislikes);
    
            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Review inserted successfully.");
            } else {
                System.out.println("Error inserting review.");
            }
    
        } catch (SQLException e) {
            System.err.println("Error inserting review: " + e.getMessage());
        }
    }
    


    public static Object insertSearchHistory() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertSearchHistory'");
    }


    public static Object insertSubscriptions() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertSubscriptions'");
    }


    public static Object insertViewingHistory() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertViewingHistory'");
    }


    public static Object insertWatchlist() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertWatchlist'");
    }
    
    

   
    
}


