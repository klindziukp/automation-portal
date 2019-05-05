package com.dandelion.automationportal.model.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "users")
@JsonIgnoreProperties(ignoreUnknown = true)
public class User implements Comparable<User> {

    @Id
    private String id;
    @Indexed(unique = true)
    private String name;
    private Position position;
    private UserRole role;
    private List<String> mentees = new ArrayList<>();

    public User(){
    }

    public User(String name, Position position, UserRole role) {
        this.name = name;
        this.position = position;
        this.role = role;
    }

    public void addMentee(String menteeName){
        mentees.add(menteeName);
    }

    @Override
    public int compareTo(User user) {
        return this.name.compareTo(user.getName());
    }

    public String getListOfMentees(){
        return mentees.isEmpty() ? "-" : String.join(" ,", mentees);
    }

    public boolean isAdmin(){
        return getRole().equals(UserRole.ADMIN);
    }

    public String toString(){
        return String.format("name: %s, role: %s, position: %s", name, position, role);
    }
}
