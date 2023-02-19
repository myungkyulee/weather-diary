package com.example.weatherstudy.repository;

import com.example.weatherstudy.domain.Memo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@Transactional
class DataJpaMemoRepositoryTest {

    @Autowired
    private DataJpaMemoRepository dataJpaMemoRepository;

    @Test
    void insertMemoTest() {
        // given
        Memo memo = new Memo(10, "this is jpa memo");
        System.out.println("memo = " + memo.getId());
        // when
        Memo newMemo = dataJpaMemoRepository.save(memo);
        System.out.println("newMemo = " + newMemo.getId());
        // then
        Memo result = dataJpaMemoRepository.findById(newMemo.getId()).get();
        System.out.println("result = " + result.getId());
        // jpaMemoRepository에서 저장된 Memo객체가 반환된다.
        assertThat(result.getId()).isEqualTo(newMemo.getId());

        // Memo Entity Class 에서 @GeneratedValue(strategy = GenerationType.IDENTITY)로 주었기 때문에
        // 스프링이 Id를 알아서 생성한다.
        // 저장하기 위해 Memo객체를 생성할 때 넣어주었던 10은 의미가 없어진다.
        assertThat(memo.getId()).isNotEqualTo(newMemo.getId());
    }


}