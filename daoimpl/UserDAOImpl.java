package com.resume.daoimpl;

import java.sql.*;
import com.resume.bean.User;
import com.resume.dao.UserDAO;
import com.resume.util.ConnectionFactory;

public class UserDAOImpl implements UserDAO {

    @Override
    public boolean register(User user) {
        try (Connection con = ConnectionFactory.getConnection()) {

            String sql = "INSERT INTO users(username,password) VALUES(?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());

            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public User login(String username, String password) {
        User user = null;

        try (Connection con = ConnectionFactory.getConnection()) {

            String sql = "SELECT * FROM users WHERE username=? AND password=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setUserId(rs.getInt("user_id"));
                user.setUsername(rs.getString("username"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}