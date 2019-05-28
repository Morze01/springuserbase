package springapp.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "login", unique = true)
    private String login;

    @Column(name = "role")
    private String role;

    @ManyToMany(fetch = FetchType.EAGER, targetEntity = Role.class)
    @JoinTable(name = "USERS_ROLE",
            joinColumns = {@JoinColumn(name = "USER_ID")},
            inverseJoinColumns = {@JoinColumn(name = "ROLE_ID")})
    private Set<Role> roleSet = new HashSet<>();


    public User() {
    }

    public User (String name, String pass, String login, String role) {
        this.name = name;
        this.password = pass;
        this.login = login;
        this.role = role;
    }


    public Set<Role> getRoleSet() {
        return roleSet;
    }

    public void setRoleSet(Set<Role> roleSet) {
        this.roleSet = roleSet;
    }

    public void addRoleToUser (Role role) {
        if (!this.roleSet.contains(role)) {
            this.roleSet.add(role);
        }
    }

    public void removeRoleFromUser (Role role) {
        if (this.roleSet.contains(role)) {
            this.roleSet.remove(role);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roleSet;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }




    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User [id = " + id + ", Name = " + name + ", Login = " + login + ", Password = " + password + "]";
    }

    public boolean updateUser(User newUser) {
        if (id != newUser.getId()) {
            return false;
        }
        this.login = newUser.getLogin();
        this.name = newUser.getName();
        this.password = newUser.getPassword();
        this.role = newUser.getRole();
        return true;
    }

}
