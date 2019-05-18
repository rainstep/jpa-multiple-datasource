package com.example.jpamultipledatasource.dao.a;

import com.example.jpamultipledatasource.model.a.TableA1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableA1Dao extends JpaRepository<TableA1, Integer> {
}
