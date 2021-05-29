package cn.zhh;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.UUID;

@SpringBootTest
public class ApplicationTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testInsert() {
        for (int i = 0; i < 10; i++) {
            String sql = String.format("insert into t_user (name) values ('%s')", UUID.randomUUID().toString());
            jdbcTemplate.execute(sql);
        }
    }

    @Test
    public void testSelect() {
        for (int i = 0; i < 10; i++) {
            int userId = i + 1;
            String sql = String.format("select name from t_user where user_id = %s", userId);
            String name = jdbcTemplate.queryForObject(sql, String.class);
            System.out.printf("userId: %s, name: %s%n", userId, name);
        }
    }
}