package com.pelican.api.models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User extends BaseModel {

    private String username;
    private String password;
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_has_roles",
            joinColumns = @JoinColumn(name = "users_id"),
            inverseJoinColumns = @JoinColumn(name = "roles_id")
    )
    private Set<UserRole> roles;

    @OneToMany
    @JoinTable(name = "user_has_cards")
    private Set<Card> cards;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public Set<UserRole> getRoles() {
        return roles;
    }

    public Set<Card> getCards() {
        return cards;
    }
}
