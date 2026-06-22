package dal;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBContext {
	protected Connection connection;

	public DBContext() {
		String name = "root";
		String pass = "";
		String url = "jdbc:mysql://localhost:3306/qltttt?useUnicode=yes&characterEncoding=UTF-8";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, name, pass);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
