package pl.kaczmarek.task.dao;


import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kaczmarek.task.model.Group;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<Group,Long> {

}
