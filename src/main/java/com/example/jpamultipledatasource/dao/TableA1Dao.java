package com.example.jpamultipledatasource.dao;

import com.example.jpamultipledatasource.model.TableA1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableA1Dao extends JpaRepository<TableA1, Integer> {
}
