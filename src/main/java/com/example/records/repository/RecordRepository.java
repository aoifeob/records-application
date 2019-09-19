package com.example.records.repository;

import com.example.records.model.Record;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordRepository extends JpaRepository<Record, Integer> {

  List<Record> findAllByPpsn(String ppsn);

}
