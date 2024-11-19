import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Delete {

    private static final String USERNAME = "root";
    private static final String PASSWORD = "8610866413";
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/movie_management";
    
    
    public static void deleteMovieById() {
        try (Scanner sc = new Scanner(System.in); 
             Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            
            System.out.print("Enter the Movie ID to delete: ");
            int movieId = sc.nextInt();
            String query = "DELETE FROM Movies WHERE movie_id = ?";
            
            try (PreparedStatement pst = con.prepareStatement(query)) {
                pst.setInt(1, movieId);
                int rowsAffected = pst.executeUpdate();
                
                if (rowsAffected > 0) {
                    System.out.println("Movie with ID " + movieId + " deleted successfully.");
                } else {
                    System.out.println("No movie found with ID " + movieId + ". Nothing was deleted.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error during deletion: " + e.getMessage());
        }
    }

    // Delete Genre by ID
    public static void deleteGenreById() {
        try (Scanner sc = new Scanner(System.in); 
             Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            
            System.out.print("Enter the Genre ID to delete: ");
            int genreId = sc.nextInt();
            String query = "DELETE FROM Genres WHERE genre_id = ?";
            
            try (PreparedStatement pst = con.prepareStatement(query)) {
                pst.setInt(1, genreId);
                int rowsAffected = pst.executeUpdate();
                
                if (rowsAffected > 0) {
                    System.out.println("Genre with ID " + genreId + " deleted successfully.");
                } else {
                    System.out.println("No genre found with ID " + genreId + ". Nothing was deleted.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error during deletion: " + e.getMessage());
        }
    }

    // Delete Movie Similarity by ID
    public static void deleteMovieSimilarity() {
        try (Scanner sc = new Scanner(System.in); 
             Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            
            System.out.print("Enter the Similarity ID to delete: ");
            int similarityId = sc.nextInt();
            String query = "DELETE FROM moviesimilarity WHERE similarity_id = ?";
            
            try (PreparedStatement pst = con.prepareStatement(query)) {
                pst.setInt(1, similarityId);
                int rowsAffected = pst.executeUpdate();
                
                if (rowsAffected > 0) {
                    System.out.println("Record deleted successfully.");
                } else {
                    System.out.println("No record found with the given Similarity ID.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error deleting data from moviesimilarity table: " + e.getMessage());
        }
    }

    // Delete Notification by ID
    public static void deleteNotifications() {
        try (Scanner sc = new Scanner(System.in); 
             Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            
            System.out.print("Enter the Notification ID to delete: ");
            int notificationId = sc.nextInt();
            String query = "DELETE FROM notifications WHERE notification_id = ?";
            
            try (PreparedStatement pst = con.prepareStatement(query)) {
                pst.setInt(1, notificationId);
                int rowsAffected = pst.executeUpdate();
                
                if (rowsAffected > 0) {
                    System.out.println("Notification deleted successfully.");
                } else {
                    System.out.println("No record found with the given Notification ID.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error deleting data from notifications table: " + e.getMessage());
        }
    }

    // Delete Person by ID
    public static void deletePersons() {
        try (Scanner sc = new Scanner(System.in); 
             Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            
            System.out.print("Enter Person ID to delete: ");
            int personId = sc.nextInt();
            String query = "DELETE FROM persons WHERE person_id = ?";
            
            try (PreparedStatement pst = con.prepareStatement(query)) {
                pst.setInt(1, personId);
                int rowsAffected = pst.executeUpdate();
                
                if (rowsAffected > 0) {
                    System.out.println("Person deleted successfully.");
                } else {
                    System.out.println("No person found with the given ID.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error deleting data from persons table: " + e.getMessage());
        }
    }

    // Delete Rating by ID
    public static void deleteRatings() {
        try (Scanner sc = new Scanner(System.in); 
             Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            
            System.out.print("Enter Rating ID to delete: ");
            int ratingId = sc.nextInt();
            String query = "DELETE FROM ratings WHERE rating_id = ?";
            
            try (PreparedStatement pst = con.prepareStatement(query)) {
                pst.setInt(1, ratingId);
                int rowsAffected = pst.executeUpdate();
                
                if (rowsAffected > 0) {
                    System.out.println("Rating record deleted successfully.");
                } else {
                    System.out.println("Error deleting record.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error deleting data: " + e.getMessage());
        }
    }

    // Delete Recommendation by ID
    public static void deleteRecommendations() {
        try (Scanner sc = new Scanner(System.in); 
             Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            
            System.out.print("Enter Recommendation ID to delete: ");
            int recommendationId = sc.nextInt();
            String query = "DELETE FROM recommendations WHERE recommendation_id = ?";
            
            try (PreparedStatement pst = con.prepareStatement(query)) {
                pst.setInt(1, recommendationId);
                int rowsAffected = pst.executeUpdate();
                
                if (rowsAffected > 0) {
                    System.out.println("Recommendation record deleted successfully.");
                } else {
                    System.out.println("Error deleting record.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error deleting data: " + e.getMessage());
        }
    }

    // Delete Review by ID
    public static void deleteReview() {
        try (Scanner sc = new Scanner(System.in); 
             Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            
            System.out.print("Enter Review ID to delete: ");
            int reviewId = sc.nextInt();
            String query = "DELETE FROM Reviews WHERE review_id = ?";
            
            try (PreparedStatement pst = con.prepareStatement(query)) {
                pst.setInt(1, reviewId);
                int rowsAffected = pst.executeUpdate();
                
                if (rowsAffected > 0) {
                    System.out.println("Review deleted successfully.");
                } else {
                    System.out.println("No review found with the given ID.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error deleting data from Reviews table: " + e.getMessage());
        }
    }

    // Placeholder methods
    public static void deleteWatchlistById() {
        // Placeholder: Implement this method
    }

    public static void deleteViewingHistoryById() {
        // Placeholder: Implement this method
    }

    public static void deleteSubscriptionById() {
        // Placeholder: Implement this method
    }

    public static void deleteSearchHistoryById() {
        // Placeholder: Implement this method
    }

    
    
    public static void main(String[] args) {
        // Test a delete function
        deleteMovieById();
    }
}
