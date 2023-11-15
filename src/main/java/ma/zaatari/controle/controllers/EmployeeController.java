package ma.zaatari.controle.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.zaatari.controle.entities.Employee;
import ma.zaatari.controle.services.EmployeeService;

@RestController
@RequestMapping("/api/Employee")
public class EmployeeController {
    @Autowired
    private EmployeeService EmployeeSer;

    @PostMapping("/save")
    public Employee ajouterEmployee(@RequestBody Employee Employee) {
        Employee.setId(0);
        return EmployeeSer.create(Employee);
    }

    @GetMapping("/all")
    public List<Employee> getAllEmployee() {
        return EmployeeSer.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findEmployeeById(@PathVariable int id) {
        Employee Employee = EmployeeSer.findById(id);
        if (Employee == null) {
            return new ResponseEntity<Object>("la Employee avec id " + id + " n'esxiste pas", HttpStatus.BAD_REQUEST);

        } else {
            return ResponseEntity.ok(Employee);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateEmployee(@PathVariable int id, @RequestBody Employee Employee) {
        Employee oldEmployee = EmployeeSer.findById(id);
        if (oldEmployee == null) {
            return new ResponseEntity<Object>("Employee avec id " + id + " n'exsiste pas", HttpStatus.BAD_REQUEST);
        } else {
            Employee.setId(id);
            return ResponseEntity.ok(EmployeeSer.update(Employee));
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteEmployee(@PathVariable int id) {
        Employee Employee = EmployeeSer.findById(id);
        if (Employee == null) {
            return new ResponseEntity<Object>("Employee avec id " + id + " n'exsiste pas ", HttpStatus.BAD_REQUEST);
        } else {
            EmployeeSer.delete(Employee);
            return ResponseEntity.ok("Employee supprimé");

        }

    }

    @GetMapping("/services/{id}")
    public List<Employee> findByservice(@PathVariable long id) {
        return EmployeeSer.getByService(id);
    }

}
