package dao;

import db.DBConnection;
import java.sql.*;

public class LibraryDao {

    public void addBook(String title, String author, int qty) {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO books (title, author, quantity) VALUES (?, ?, ?)"
            );
            ps.setString(1, title);
            ps.setString(2, author);
            ps.setInt(3, qty);
            ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

 public String getBooks() {
    StringBuilder data = new StringBuilder();

    try {
        Connection con = DBConnection.getConnection();

        if (con == null) {
            return "Database connection failed!";
        }

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM books");

        data.append("ID | Title | Author | Qty\n\n");

        boolean found = false;

        while (rs.next()) {
            found = true;
            data.append(rs.getInt("book_id")).append(" | ")
                .append(rs.getString("title")).append(" | ")
                .append(rs.getString("author")).append(" | ")
                .append(rs.getInt("available")).append("\n");
        }

        if (!found) {
            return "No books found!";
        }

        con.close();

    } catch (Exception e) {
        e.printStackTrace();  // 🔥 THIS IS KEY
        return "Error occurred. Check terminal.";
    }

    return data.toString();
}
    public String issueBook(int bookId, String userName) {
        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps1 = con.prepareStatement(
                "INSERT INTO users (name) VALUES (?)",
                Statement.RETURN_GENERATED_KEYS
                return "Book issued successfully to " + userName;
            );
            ps1.setString(1, userName);
            ps1.executeUpdate();

            ResultSet rs = ps1.getGeneratedKeys();
            rs.next();
            int userId = rs.getInt(1);

            PreparedStatement ps2 = con.prepareStatement(
                "INSERT INTO issued_books (book_id, user_id, issue_date) VALUES (?, ?, CURDATE())"
            );
            ps2.setInt(1, bookId);
            ps2.setInt(2, userId);
            ps2.executeUpdate();

            PreparedStatement ps3 = con.prepareStatement(
                "UPDATE books SET quantity = quantity - 1 WHERE id = ?"
            );
            ps3.setInt(1, bookId);
            ps3.executeUpdate();

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
            return "Error occured. Check terminal.";
        }
    }
}