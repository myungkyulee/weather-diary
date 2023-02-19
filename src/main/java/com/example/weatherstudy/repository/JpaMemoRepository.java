package com.example.weatherstudy.repository;

import com.example.weatherstudy.domain.Memo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class JpaMemoRepository {
    private final EntityManager em;

    public void save(Memo memo) {
        em.persist(memo);
    }

    public Memo findById(int id) {
        return em.find(Memo.class, id);
    }
}
