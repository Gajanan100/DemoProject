package com.example.demo.custum;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PracticeClassImp implements PracticeClassService {

	@Autowired
	private DataSource dataSource;

	@Override
	public int save(PracticesClass practice) {
		String query = "insert into practice(id,name,price) values(?,?,?);";

		try {
			Connection connection = dataSource.getConnection();
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, practice.getId());
			statement.setString(2, practice.getName());
			statement.setDouble(3, practice.getPrice());

			return statement.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeErrorException(null, "error");
		}

	}

	@Override
	public PracticesClass findById(int id) {
		String query = "select * from practice where id=? ";
		try (Connection connection = dataSource.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				PracticesClass prac = new PracticesClass();
				prac.setId(resultSet.getInt("id"));
				prac.setName(resultSet.getString("name"));
				prac.setPrice(resultSet.getDouble("price"));
				return prac;
			} else {
				return null;
			}
		} catch (SQLException e) {
			throw new RuntimeException("Error ");
		}
	}

	@Override
	public List<PracticesClass> findAll() {
		String query = "select * from practice";
		List<PracticesClass> list = new ArrayList<>();
		try (Connection connection = dataSource.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				PracticesClass prac = new PracticesClass();
				prac.setId(resultSet.getInt("id"));
				prac.setName(resultSet.getString("name"));
				prac.setPrice(resultSet.getDouble("price"));
				list.add(prac);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int delete(int id) {
		String query = "delete from practice where id=? ";
		try {
			Connection connection = dataSource.getConnection();
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			return statement.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeErrorException(null, "error");
		}
	}

	@Override
	public int update(PracticesClass practice) {
	    String query = "update practice set name = ?, price = ? where id = ?";
	    try (
	        Connection connection = dataSource.getConnection();
	        PreparedStatement statement = connection.prepareStatement(query)
	    ) {
	        statement.setString(1, practice.getName());  
	        statement.setDouble(2, practice.getPrice()); 
	        statement.setInt(3, practice.getId());       
	        return statement.executeUpdate();            
	    } catch (SQLException e) {
	        throw new RuntimeException("Error update data");
	    }
	}

	

}
