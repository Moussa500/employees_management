package com.projetLunar.projet.Employee;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
@RestController
public class EmployeController {
    EmployeService employeService;
    EmployeController(EmployeService employeService) {
        this.employeService = employeService;
    }
    @PostMapping
    public ResponseEntity addEmployee(@RequestBody EmployeeDto entity) {
        try {
            return new ResponseEntity<>(this.employeService.addEmployee(entity),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/{email}")
    public ResponseEntity deleteEmployee(@PathVariable String email){
        try {
            try {
                this.employeService.deleteEmployee(email);
                return new ResponseEntity<>("deleted successfully",HttpStatus.OK);
            } catch (NotFoundException e) {
                return new ResponseEntity<>("this employee doasn't exist",HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping
    public ResponseEntity findAllEmployees(){
        try {
            return new ResponseEntity<>(this.employeService.findAllEmployees(),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/{name}")
    public ResponseEntity findEmployeeByName(@PathVariable String name) {
        try {
            try {
                return new ResponseEntity<>(this.employeService.findByName(name),HttpStatus.OK);
            } catch (NotFoundException e) {
                return new ResponseEntity<>("This employee doasn't exist",HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/statisticsByPosition")
    public ResponseEntity getStatisticsByPosition() {
       try {
        return new ResponseEntity<>(employeService.getEmployeesNumberByPosition(),HttpStatus.OK);
       } catch (Exception e) {
        return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }
}
