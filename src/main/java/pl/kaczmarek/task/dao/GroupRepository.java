package pl.kaczmarek.task.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kaczmarek.task.model.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group,Long> {


}
