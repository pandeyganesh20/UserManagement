package JDBC_Advance.dao;

import JDBC_Advance.model.User;
import JDBC_Advance.util.QueryUtil;
import JDBC_Advance.util.dbUtil;


import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImplementation implements UserDao {


    @Override
    public int saveUser(User user) {
        int saved = 0;

        try (
                PreparedStatement ps = dbUtil.getConnection().prepareStatement(QueryUtil.SAVE_SQL);
        ) {
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getPassword());
            ps.setLong(3, user.getMobileNo());
            ps.setDate(4, Date.valueOf(user.getDob()));
            ps.setBoolean(5, user.isEnable());
            ps.setDouble(6, user.getSalary());
            saved = ps.executeUpdate();


        } catch (Exception e) {
            System.out.println(e);
        }
        return saved;
    }

    @Override
    public int updateUser(User user) {
        int updated = 0;

        try (
                PreparedStatement ps = dbUtil.getConnection().prepareStatement(QueryUtil.UPDATE_SQL);
        ) {
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getPassword());
            ps.setLong(3, user.getMobileNo());
            ps.setDate(4, Date.valueOf(user.getDob()));
            ps.setBoolean(5, user.isEnable());
            ps.setDouble(6, user.getSalary());
            ps.setInt(7, user.getId());
            updated = ps.executeUpdate();


        } catch (Exception e) {
            System.out.println(e);
        }
        return updated;


    }

    @Override
    public int deleteUser(int id) {
        int deleted = 0;

        try (
                PreparedStatement ps = dbUtil.getConnection().prepareStatement(QueryUtil.DELETE_SQL);
        ) {
            ps.setInt(1, id);
            deleted = ps.executeUpdate();


        } catch (Exception e) {
            System.out.println(e);
        }


        return deleted;
    }

    @Override
    public User getUserById(int id) {
        User user = new User();

        try (
                PreparedStatement ps = dbUtil.getConnection().prepareStatement(QueryUtil.GET_BY_ID_SQL);
        ) {
ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                user.setId(rs.getInt("id"));
                user.setUserName(rs.getString("user_name"));
                user.setPassword(rs.getString("password"));
                user.setEnable(rs.getBoolean("enable"));
                user.setMobileNo(rs.getLong("mobile_no"));
                user.setSalary(rs.getDouble("salary"));
                 user.setDob(rs.getDate("dob").toLocalDate());



            }


        } catch (Exception e) {
            System.out.println(e);
        }
        return user;
    }


    @Override
    public List<User> getAllUser() {
        List<User> userList = new ArrayList<>();

        try (
                PreparedStatement ps = dbUtil.getConnection().prepareStatement(QueryUtil.LIST_SQL);
        ) {

            ResultSet rs = ps.executeQuery();

            while(rs.next())
            {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUserName(rs.getString("user_name"));
                user.setPassword(rs.getString("password"));
                user.setEnable(rs.getBoolean("enable"));
                user.setMobileNo(rs.getLong("mobile_no"));
                user.setSalary(rs.getDouble("salary"));
                user.setDob(rs.getDate("dob").toLocalDate());

                userList.add(user);

            }



        } catch (Exception e) {
            System.out.println(e);
        }
return userList;
    }
}
