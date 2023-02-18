package com.example.weatherstudy.repository;

import com.example.weatherstudy.domain.Memo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@Transactional
class JdbcMemoRepositoryTest {
    @Autowired
    private JdbcMemoRepository jdbcMemoRepository;

    @Test
    void insertMemoTest() {
        // given
        Memo memo = Memo.builder().text("메모를 한다.").build();
        // when
        jdbcMemoRepository.save(memo);
        // then
        Optional<Memo> result = jdbcMemoRepository.findById(4);
        assertThat(result.get().getText()).isEqualTo("메모를 한다.");
    }

    @Test
    void findAllMemoTest() {
        List<Memo> memos = jdbcMemoRepository.findAll();
        System.out.println(memos);

        assertNotNull(memos);
    }
}