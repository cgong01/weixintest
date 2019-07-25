package com.test.weixin.dao;

import com.test.weixin.model.Guest;
import com.test.weixin.rowmapper.GuestRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
@Transactional
public class GuestDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public GuestDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Guest> getAllGuests() {
        List<Guest> res = new ArrayList<>();
        try {
            String sql = "select * from wedding_guest";
            RowMapper<Guest> rowMapper = new GuestRowMapper();
            res = this.jdbcTemplate.query(sql, rowMapper);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    public Integer insertInfo(Map<String, String> guestMap) {
        int res = 0;
        try {
            String friend_name = (String) guestMap.get("guestname");
            String join_wedding = (String) guestMap.get("joinans");
            String num_of_friend = (String) guestMap.get("sideans");
            String side_of_friend = (String) guestMap.get("guestnum");

            String sql = "insert into wedding_guest " +
                    "(friend_name, join_wedding, num_of_friend, side_of_friend) " +
                    "values(?,?,?,?)";

            res = this.jdbcTemplate.update(sql, friend_name, join_wedding, num_of_friend, side_of_friend);

//            res = this.jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {
//                @Override
//                public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
//                    ps.setString(1, friend_name);
//                    ps.setString(2, join_wedding);
//                    ps.setString(3, num_of_friend);
//                    ps.setString(4, side_of_friend);
//
//                    boolean result = ps.execute();
//                    return result;
//                }
//            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    public Guest getCurrentGuest(String friendName) {
        Guest guest = null;
        try {
            String sql = "select * from wedding_guest where friend_name = '" + friendName + "'";
            RowMapper<Guest> rowMapper = new GuestRowMapper();
            List<Guest> list = this.jdbcTemplate.query(sql, rowMapper);
            if (list != null && !list.isEmpty()) {
                guest = list.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return guest;
    }

}
