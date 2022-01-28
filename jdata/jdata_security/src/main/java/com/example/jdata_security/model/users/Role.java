package com.example.jdata_security.model.users;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "roles")
public class Role implements GrantedAuthority {
    @Id
    @Column(columnDefinition = "varchar(50) default 'READ'")
    private String authority;
    @ManyToMany
    @JoinTable(name = "authorities",
            joinColumns = @JoinColumn(name = "authority"),
            inverseJoinColumns = @JoinColumn(name = "username"))
    private Set<User> users;

    public Role() {
    }

    public Role(String authority) {
        this.authority = authority;
    }

    public String getAuthority() {
        return authority;
    }

    public Role setAuthority(String authority) {
        this.authority = authority;
        return this;
    }

    @Override
    public String toString() {
        return "Role{" +
                "authority='" + authority + '\'' +
                '}';
    }
}
