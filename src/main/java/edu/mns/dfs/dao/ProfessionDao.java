package edu.mns.dfs.dao;

import edu.mns.dfs.model.Profession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessionDao extends JpaRepository<Profession,Integer> {
}
