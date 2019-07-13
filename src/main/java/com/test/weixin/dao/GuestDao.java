package com.test.weixin.dao;

import com.test.weixin.model.Guest;
import com.test.weixin.rowmapper.GuestRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
        String sql = "select * from wedding_record";
        RowMapper<Guest> rowMapper = new GuestRowMapper();
        return this.jdbcTemplate.query(sql, rowMapper);
    }

}
