package com.example.jpamultipledatasource.dao.a;

import com.example.jpamultipledatasource.model.a.TableA2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableA2Dao extends JpaRepository<TableA2, Integer> {
}
