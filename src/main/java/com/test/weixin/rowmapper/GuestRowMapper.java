package com.test.weixin.rowmapper;

import com.test.weixin.model.Guest;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GuestRowMapper implements RowMapper<Guest> {


    @Override
    public Guest mapRow(ResultSet resultSet, int i) throws SQLException {
        Guest guest = new Guest();
        guest.setRecordId(resultSet.getInt("record_id"));
        guest.setName(resultSet.getString("friend_name"));
        guest.setJoinWedding(resultSet.getString("join_wedding"));
        guest.setNumOfFriend(resultSet.getString("num_of_friend"));
        guest.setSideOfFriend(resultSet.getString("side_of_friend"));

        return guest;
    }
}
