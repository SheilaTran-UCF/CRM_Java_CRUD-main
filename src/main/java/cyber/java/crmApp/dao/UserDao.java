package cyber.java.crmApp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;




import cyber.java.crmApp.dbconnection.MySqlConnection;
import cyber.java.crmApp.dto.UserCreateDto;
import cyber.java.crmApp.model.Role;
import cyber.java.crmApp.model.User;



public class UserDao {

	public List<User> findAll() throws SQLException {
		List<User> users = new LinkedList<>();
		List<Role> roles = new ArrayList<>();
		
		Connection connection = MySqlConnection.getConnection();
		String query = "SELECT u.id as id, u.name as name, u.email as email,u.address as address, "
				+ "u.phone as phone, r.id as role_id, r.name as role_name, r.description as role_description "
				+ "FROM user u, role r WHERE u.role_id = r.id";
		  
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				User user = new User();
				
				user.setId(resultSet.getInt("id"));
				user.setName(resultSet.getString("name"));
				user.setEmail(resultSet.getString("email"));
				user.setAddress(resultSet.getString("address"));
				user.setPhone(resultSet.getString("phone"));
				// role_id
				int roleId = resultSet.getInt("role_id");
				// role
				Role role = getRoleFromList(roles, roleId);
				
				if(role == null) {
					role = new Role();
					role.setId(resultSet.getInt("role_id"));
					role.setName(resultSet.getString("role_name"));
					role.setDescription(resultSet.getString("role_description"));
					
					roles.add(role);
				}
				
				user.setRole(role);
				
				users.add(user);
			}
			
		} catch (SQLException e) {
			System.out.println("Unable to connect to database.");
			e.printStackTrace();
		} finally {
			connection.close();
		}
		
		return users;
	}

	public void deleteById(int id) throws SQLException {
		String query = "DELETE FROM user WHERE id = ?";
		Connection connection = MySqlConnection.getConnection();
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			
			statement.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("Unable to connect to database.");
			e.printStackTrace();
		} finally {
			connection.close();
		}
		
	}
	
	private Role getRoleFromList(List<Role> roles, int roleId) {
		for(Role role : roles)
			if(role.getId() == roleId)
				return role;
		return null;
	}

	public void add(UserCreateDto dto) throws SQLException {
		String query = "INSERT INTO user(email, password, name, address, phone, role_id)"
				+ "VALUES(?,?,?,?,?,?)";
		
		Connection connection = MySqlConnection.getConnection();
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setNString(1, dto.getEmail());
			statement.setNString(2, dto.getPassword());
			statement.setNString(3, dto.getName());
			statement.setNString(4, dto.getAddress());
			statement.setNString(5, dto.getPhone());
			statement.setInt(6, dto.getRoleId());
			
			statement.executeUpdate();
			
		}catch (SQLException e) {
			System.out.println("Unable to connect to database.");
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}

	public void update(UserCreateDto dto) throws SQLException {
		
		
		String query = "UPDATE user set email =?, password =?,name=?, address=?, phone=?, role_id=? WHERE id=?";
				
		Connection connection = MySqlConnection.getConnection();
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setNString(1, dto.getEmail());
			statement.setNString(2, dto.getPassword());
			statement.setNString(3, dto.getName());
			statement.setNString(4, dto.getAddress());
			statement.setNString(5, dto.getPhone());
			statement.setInt(6, dto.getRoleId());
			statement.setInt(7, dto.getId());
			
			
			statement.executeUpdate();
			
		}catch (SQLException e) {
			System.out.println("Unable to connect to database.");
			e.printStackTrace();
		} finally {
			connection.close();
		}
		
	}

	public User findById(int id) {
		User user = new User();
		Connection connection = MySqlConnection.getConnection();
		String query ="SELECT * FROM user WHERE id=?";
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				
				user.setId(resultSet.getInt("id"));
				user.setName(resultSet.getString("name"));
				user.setEmail(resultSet.getString("email"));
				user.setPhone(resultSet.getString("phone"));
				user.setPassword(resultSet.getString("password"));
				user.setAddress(resultSet.getString("address"));
				
			}
			connection.close();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return user;
		
		
	}

	

	public User findByEmail(String email) {
		User user = new User();
		Connection connection = MySqlConnection.getConnection();
		String query ="SELECT * FROM user WHERE email=?";
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setString(1, email);
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				
				user.setId(resultSet.getInt("id"));
				user.setName(resultSet.getString("name"));
				user.setEmail(resultSet.getString("email"));
				user.setPhone(resultSet.getString("phone"));
				user.setPassword(resultSet.getString("password"));
				user.setAddress(resultSet.getString("address"));
				
			}
			connection.close();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return user;
	}

}
