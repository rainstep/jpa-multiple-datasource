package com.example.jpamultipledatasource.dao;

import com.example.jpamultipledatasource.model.TableB2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableB2Dao extends JpaRepository<TableB2, Integer> {
}
