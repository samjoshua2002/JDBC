import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Update {

    

    private static final String USERNAME = "root";
    private static final String PASSWORD = "8610866413";
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/movie_management";
    public static void updateMovies() {
        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Scanner sc = new Scanner(System.in)) {
    
            System.out.print("Enter the ID of the movie to update: ");
            int id = sc.nextInt();
            sc.nextLine(); // Consume the newline
    
            System.out.println("Select the column to update:");
            System.out.println("1. Title");
            System.out.println("2. Genre");
            System.out.println("3. Release Date");
            System.out.println("4. Director");
            System.out.println("5. Cast");
            System.out.println("6. Duration");
            System.out.println("7. Language");
            System.out.println("8. Country of Origin");
            System.out.println("9. Rating");
            System.out.println("10. Description");
            System.out.println("11. Poster Image URL");
            System.out.println("12. Trailer URL");
            System.out.println("13. Certification");
            System.out.println("14. IMDb Rating");
            System.out.println("15. Total Reviews");
    
            System.out.print("Enter your choice (1-15): ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume the newline
    
            String columnName = switch (choice) {
                case 1 -> "title";
                case 2 -> "genre";
                case 3 -> "release_date";
                case 4 -> "director";
                case 5 -> "cast";
                case 6 -> "duration";
                case 7 -> "language";
                case 8 -> "country";
                case 9 -> "rating";
                case 10 -> "description";
                case 11 -> "poster_image";
                case 12 -> "trailer_url";
                case 13 -> "certification";
                case 14 -> "imdb_rating";
                case 15 -> "total_reviews";
                default -> null;
            };
    
            if (columnName == null) {
                System.out.println("Invalid column choice. Please try again.");
                return;
            }
    
            System.out.print("Enter the new value: ");
            String newValue;
            if (choice == 6 || choice == 9 || choice == 14 || choice == 15) {
                // Numeric fields
                newValue = sc.nextLine();
                if (!newValue.matches("\\d+(\\.\\d+)?")) { // Ensure numeric input
                    System.out.println("Invalid numeric value. Update aborted.");
                    return;
                }
            } else {
                // Text fields
                newValue = sc.nextLine();
            }
    
            String query = "UPDATE Movies SET " + columnName + " = ? WHERE movie_id = ?";
            try (PreparedStatement pstmt = con.prepareStatement(query)) {
                if (choice == 6 || choice == 9 || choice == 14 || choice == 15) {
                    // Set numeric values
                    pstmt.setDouble(1, Double.parseDouble(newValue));
                } else {
                    // Set text values
                    pstmt.setString(1, newValue);
                }
                pstmt.setInt(2, id);
    
                int rowsUpdated = pstmt.executeUpdate();
                if (rowsUpdated > 0) {
                    System.out.println("Movie updated successfully!");
                } else {
                    System.out.println("No movie found with the given ID.");
                }
            }
        } catch (Exception e) {
            System.out.println("Error updating data in Movies table: " + e.getMessage());
        }
    }
    
    public static void updateGenres() {
        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Scanner sc = new Scanner(System.in)) {

            System.out.print("Enter the Genre ID to update: ");
            int genreId = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter the new Genre Name: ");
            String genreName = sc.nextLine();

            String query = "UPDATE Genres SET genre_name = ? WHERE genre_id = ?";
            try (PreparedStatement pst = con.prepareStatement(query)) {
                pst.setString(1, genreName);
                pst.setInt(2, genreId);

                int rowsAffected = pst.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Data updated in Genres table successfully.");
                } else {
                    System.out.println("No record found with the given Genre ID.");
                }
            }
        } catch (Exception e) {
            System.err.println("Error updating data in Genres table: " + e.getMessage());
        }
    }
    public static void updateMovieSimilarity() {
        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Scanner sc = new Scanner(System.in)) {
    
            System.out.print("Enter the Similarity ID to update: ");
            int similarityId = sc.nextInt();
            sc.nextLine(); 
    
            System.out.print("Enter the new similarity score: ");
            float newSimilarityScore = sc.nextFloat();
    
            String query = "UPDATE moviesimilarity SET similarity_score = ? WHERE similarity_id = ?";
    
            try (PreparedStatement pst = con.prepareStatement(query)) {
                pst.setFloat(1, newSimilarityScore);
                pst.setInt(2, similarityId);
    
                int rowsAffected = pst.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Similarity score updated successfully.");
                } else {
                    System.out.println("No record found with the given Similarity ID.");
                }
            }
    
        } catch (Exception e) {
            System.err.println("Error updating data in moviesimilarity table: " + e.getMessage());
        }
    }


    public static void updateNotifications() {
        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Scanner sc = new Scanner(System.in)) {
    
            System.out.print("Enter the Notification ID to update: ");
            int notificationId = sc.nextInt();
            sc.nextLine(); 
    
            System.out.print("Enter new Message: ");
            String newMessage = sc.nextLine();
    
            System.out.print("Enter new Notification Type (Email, SMS, Push): ");
            String newNotificationType = sc.nextLine();
    
            String query = "UPDATE notifications SET message = ?, notification_type = ? WHERE notification_id = ?";
    
            try (PreparedStatement pst = con.prepareStatement(query)) {
                pst.setString(1, newMessage);
                pst.setString(2, newNotificationType);
                pst.setInt(3, notificationId);
    
                int rowsAffected = pst.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Notification updated successfully.");
                } else {
                    System.out.println("No record found with the given Notification ID.");
                }
            }
    
        } catch (Exception e) {
            System.err.println("Error updating data in notifications table: " + e.getMessage());
        }
    }


    public static void updatePersons() {
        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Scanner sc = new Scanner(System.in)) {
    
            System.out.print("Enter Person ID to update: ");
            int personId = sc.nextInt();
            sc.nextLine(); 
    
            System.out.print("Enter new Full Name: ");
            String fullName = sc.nextLine();
    
            System.out.print("Enter new Role (Actor, Actress, Director): ");
            String role = sc.nextLine();
    
            System.out.print("Enter new Movies Involved (Comma separated): ");
            String moviesInvolved = sc.nextLine();
    
            System.out.print("Enter new Biography: ");
            String biography = sc.nextLine();
    
            System.out.print("Enter new Birth Date (YYYY-MM-DD): ");
            String birthDate = sc.nextLine();
    
            System.out.print("Enter new Awards Won: ");
            String awardsWon = sc.nextLine();
    
            String query = "UPDATE persons SET full_name = ?, role = ?, movies_involved = ?, biography = ?, birth_date = ?, awards_won = ? WHERE person_id = ?";
    
            try (PreparedStatement pst = con.prepareStatement(query)) {
                pst.setString(1, fullName);
                pst.setString(2, role);
                pst.setString(3, moviesInvolved);
                pst.setString(4, biography);
                pst.setString(5, birthDate);
                pst.setString(6, awardsWon);
                pst.setInt(7, personId);
    
                int rowsAffected = pst.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Person updated successfully.");
                } else {
                    System.out.println("No person found with the given ID.");
                }
            }
    
        } catch (Exception e) {
            System.err.println("Error updating data in persons table: " + e.getMessage());
        }
    }


    public static void updateRatings() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Rating ID to update: ");
        int ratingId = sc.nextInt();
        sc.nextLine(); 

        System.out.print("Enter new Rating Value (1-5): ");
        int ratingValue = sc.nextInt();
        sc.nextLine(); 

        System.out.print("Enter new Review Text: ");
        String reviewText = sc.nextLine();

        String query = "UPDATE ratings SET rating_value = ?, review_text = ? WHERE rating_id = ?";

        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setInt(1, ratingValue);
            pst.setString(2, reviewText);
            pst.setInt(3, ratingId);

            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Rating record updated successfully.");
            } else {
                System.out.println("Error updating record.");
            }

        } catch (SQLException e) {
            System.err.println("Error updating data: " + e.getMessage());
        }
        sc.close();
    }


    public static void updateRecommendations() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Recommendation ID to update: ");
        int recommendationId = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter new Recommendation Score: ");
        float recommendationScore = sc.nextFloat();
        sc.nextLine();

        System.out.print("Enter new Recommendation Date (YYYY-MM-DD): ");
        String recommendationDate = sc.nextLine();

        String query = "UPDATE recommendations SET recommendation_score = ?, recommendation_date = ? WHERE recommendation_id = ?";

        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setFloat(1, recommendationScore);
            pst.setString(2, recommendationDate);
            pst.setInt(3, recommendationId);

            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Recommendation record updated successfully.");
            } else {
                System.out.println("Error updating record.");
            }

        } catch (SQLException e) {
            System.err.println("Error updating data: " + e.getMessage());
        }
        sc.close();
    }


    public static void updateWatchlist() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateWatchlist'");
    }


    public static void updateViewingHistory() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateViewingHistory'");
    }


    public static void updateSubscriptions() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateSubscriptions'");
    }


  

    public static void updateReviews() {
        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Scanner sc = new Scanner(System.in)) {
    
            System.out.print("Enter the ID of the movie to update: ");
            int id = sc.nextInt();
            sc.nextLine();
    
            System.out.println("Select the column to update:");
            System.out.println("1. Title");
            System.out.println("2. Genre");
            System.out.println("3. Release Date");
            System.out.println("4. Director");
            System.out.println("5. Cast");
            System.out.println("6. Duration");
            System.out.println("7. Language");
            System.out.println("8. Country of Origin");
            System.out.println("9. Rating");
            System.out.println("10. Description");
            System.out.println("11. Poster Image URL");
            System.out.println("12. Trailer URL");
            System.out.println("13. Certification");
            System.out.println("14. IMDb Rating");
            System.out.println("15. Total Reviews");
    
            System.out.print("Enter your choice (1-15): ");
            int choice = sc.nextInt();
            sc.nextLine();
    
            String column = "";
            String newValue = "";
    
            switch (choice) {
                case 1 -> column = "title";
                case 2 -> column = "genre";
                case 3 -> column = "release_date";
                case 4 -> column = "director";
                case 5 -> column = "cast";
                case 6 -> column = "duration";
                case 7 -> column = "language";
                case 8 -> column = "country_of_origin";
                case 9 -> column = "rating";
                case 10 -> column = "description";
                case 11 -> column = "poster_image";
                case 12 -> column = "trailer_url";
                case 13 -> column = "certification";
                case 14 -> column = "imdb_rating";
                case 15 -> column = "total_reviews";
                default -> {
                    System.out.println("Invalid choice.");
                    return;
                }
            }
    
            System.out.print("Enter the new value: ");
            newValue = sc.nextLine();
    
            String query = "UPDATE Movies SET " + column + " = ? WHERE movie_id = ?";
            try (PreparedStatement pst = con.prepareStatement(query)) {
                pst.setString(1, newValue);
                pst.setInt(2, id);
    
                int rowsAffected = pst.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Data updated successfully.");
                } else {
                    System.out.println("No record found with the given ID.");
                }
            }
        } catch (Exception e) {
            System.err.println("Error updating data in Movies table: " + e.getMessage());
        }
    }


    public static void updateSearchHistory() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateSearchHistory'");
    }
    
    
    

   
          
       
}

