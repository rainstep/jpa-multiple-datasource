package com.example.jpamultipledatasource.dao;

import com.example.jpamultipledatasource.model.TableB1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableB1Dao extends JpaRepository<TableB1, Integer> {
}
