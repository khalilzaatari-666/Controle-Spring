package ma.zaatari.controle.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ma.zaatari.controle.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("select s from Employee s  where s.service.id = ?1")
    public List<Employee> getByService(long id);

}