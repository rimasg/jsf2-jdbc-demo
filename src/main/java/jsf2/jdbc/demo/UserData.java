package jsf2.jdbc.demo;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "userData", eager = true)
@SessionScoped
public class UserData implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * Get a list of Authors from PostgreSQL DB
	 */
	public List<Author> getAuthors() {
		List<Author> records = new ArrayList<Author>();
		Connection con = getConnection();
		String stm = "SELECT * FROM authors";
		ResultSet rs = null;
		PreparedStatement pst = null;
		
		try {
			pst = con.prepareStatement(stm);
			pst.execute();
			rs = pst.getResultSet();
			
			while (rs.next()) {
				Author author = new Author();
				author.setId(rs.getInt(1));
				author.setName(rs.getString(2));
				records.add(author);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return records;
	}

	/**
	 * Establish a connection to PostgreSQL.
	 */
	private Connection getConnection() {
		Connection conn = null;
		String url = "jdbc:postgresql://localhost/huser";
		String user = "huser";
		String password = "huser";

		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("Connection completed.");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return conn;
	}

	/**
	 * Testing access to PostgreSQL DB.
	 */
	public static void main(String[] args) {
		UserData userData = new UserData();
		userData.getAuthors()
			.stream()
			.map(author -> author.name)
			.forEach(System.out::println);
	}
}
