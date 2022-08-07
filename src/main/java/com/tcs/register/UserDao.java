package com.tcs.register;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDao {

	static Connection connection = TestConn.createConnection();

	public static int save(String username, String password, String finalQual, String gender, String finalTech,
			String country, String finaladdrs, String review) {
		int rowcount = 0;
		System.out.println("save method executed");
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("insert into user_details values(?,?,?,?,?,?,?,?)");
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);

			preparedStatement.setString(3, finalQual);
			preparedStatement.setString(4, gender);

			preparedStatement.setString(5, finalTech);
			preparedStatement.setString(6, country);

			preparedStatement.setString(7, finaladdrs);
			preparedStatement.setString(8, review);

			rowcount = preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowcount;
	}

	public static String loginCheck(String username, String password) {
		try {
			
			Statement statement = connection.createStatement();

			ResultSet set = statement.executeQuery("select * from user_details");

			while (set.next()) {
				String uname = set.getString(1);
				String pword = set.getString(2);
				System.out.println(uname+" "+pword);
				if (uname.equals(username) && pword.equals(password)) {
					return "success";
				}
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return "fail";

	}

	public static ResultSet search(String username, String password) {
		ResultSet set = null;
		try {
			Statement statement = connection.createStatement();
			set = statement.executeQuery(
					"select * from user_details where username='" + username + "'and password='" + password + "'");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return set;
	}

	public static boolean delete(String username, String password) {
		int count = 0;
		try {
			Statement statement = connection.createStatement();
			count = statement.executeUpdate(
					"delete from user_details where username='" + username + "'and password='" + password + "'");

			if (count != 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public static boolean resetPassword(String username, String password) {
		int count = 0;
		try {
			Statement statement = connection.createStatement();
			System.out.println("reset Password methd.");
			count = statement.executeUpdate(
					"update user_details set password='" + password + "' where username='" + username + "'");
			if (count != 0) {
				return true;
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static ResultSet allUsers() {
		ResultSet set = null;
		try {
			Statement statement = connection.createStatement();
			set = statement.executeQuery("select * from user_details");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return set;
	}
}
