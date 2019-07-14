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
        String sql = "select * from wedding_guest";
        RowMapper<Guest> rowMapper = new GuestRowMapper();
        return this.jdbcTemplate.query(sql, rowMapper);
    }

    public boolean insertInfo(Map<String, Object> guestMap) {
        String friend_name = (String) guestMap.get("guestname");
        String join_wedding = (String) guestMap.get("joinans");
        String num_of_friend = (String) guestMap.get("sideans");
        String side_of_friend = (String) guestMap.get("guestnum");

        String sql = "insert into wedding_guest " +
                "(friend_name, join_wedding, num_of_friend, side_of_friend) " +
                "values(?,?,?,?)";

        return this.jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {
            @Override
            public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                ps.setString(1, friend_name);
                ps.setString(2, join_wedding);
                ps.setString(3, num_of_friend);
                ps.setString(4, side_of_friend);

                return ps.execute();
            }
        });
    }

}
