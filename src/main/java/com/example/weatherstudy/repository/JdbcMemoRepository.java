package com.example.weatherstudy.repository;

import com.example.weatherstudy.domain.Memo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Repository
public class JdbcMemoRepository {
    private final JdbcTemplate jdbcTemplate;

    public JdbcMemoRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Memo save(Memo memo) {
//        String sql = "insert into memo(text) values(?)";
        String sql = "insert into memo values(?, ?)";
        jdbcTemplate.update(sql, memo.getId(), memo.getText());
        return memo;
    }

    public List<Memo> findAll() {
        String sql = "select * from memo";


        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new Memo(
                        rs.getInt("id"),
                        rs.getString("text")
                ));
    }

    public Optional<Memo> findById(int id) {
        String sql = "select * from memo where id = ?";

        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new Memo(
                        rs.getInt("id"),
                        rs.getString("text")
                ), id).stream().findFirst();
    }

    private RowMapper<Memo> memoRowMapper() {
        // jdbc를 통해 데이터를 가져오면 ResultSet의 형태로 가져온다.
        // {id = 1, text = 'this is memo ~'}
        return (rs, rowNum) -> new Memo(
                rs.getInt("id"),
                rs.getString("text")
        );
    }
}
