package com.data.transform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.data.transform.entity.HistoryData;
@Repository("historyDataRepository")
public interface HistoryDataRepository extends JpaRepository<HistoryData, Integer> {

}
