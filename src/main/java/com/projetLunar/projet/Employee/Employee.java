package com.projetLunar.projet.Employee;
import java.time.LocalDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
@Document("Employee")
public class Employee {
    @Id
    private String id;
    private String Name;
    @Indexed(unique = true)
    private String email;
    private LocalDate hiringDate;
    private String position;
    public LocalDate getHiringDate() {
        return hiringDate;
    }
    public void setHiringDate(LocalDate hiringDate) {
        this.hiringDate = hiringDate;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public String getPosition() {
        return position;
    }
    public String getEmail() {
        return email;
    }
    public String getId() {
        return id;
    }
    public String getName() {
        return Name;
    }
    public void sethiringDate(LocalDate hiringDate) {
        this.hiringDate = hiringDate;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setName(String Name) {
        this.Name = Name;
    }  
}
