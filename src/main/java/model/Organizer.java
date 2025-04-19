package model;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class Organizer extends User {
    private String name;
    private String lastName;
    
    public Organizer(String username, String email, String password, String name, String lastName) {
        super(username, email, password);
        this.name = name;
        this.lastName = lastName;
    }

    
}
