package ua.training.spring.foodtrackingsystem.model.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Please, fill the user name field")
    private String username;
    @NotBlank(message = "Please, fill the password field")
    private String password;
    @Email(message = "Email is not correct")
    @NotBlank(message = "Please, fill the email field")
    private String email;
    private boolean accountStatus;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;

    @Transient
    @NotBlank(message = "Password confirmation can't be empty")
    private String password2;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    public User() {
    }

    public User(@NotBlank(message = "Please, fill the user name field") String username,
                @NotBlank(message = "Please, fill the password field") String password,
                @Email(message = "Email is not correct")
                @NotBlank(message = "Please, fill the email field") String email,
                Client client,
                @NotBlank(message = "Password confirmation can't be empty") String password2) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.client = client;
        this.password2 = password2;
    }

    public User(@NotBlank(message = "Please, fill the user name field") String username,
                @NotBlank(message = "Please, fill the password field") String password,
                @Email(message = "Email is not correct")
                @NotBlank(message = "Please, fill the email field") String email,
                @NotBlank(message = "Password confirmation can't be empty") String password2) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.password2 = password2;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isAccountStatus();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public boolean isAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(boolean accountStatus) {
        this.accountStatus = accountStatus;
    }

    @Override
    public String toString(){
        return "User name: " + getUsername() +
                "\nPassword: " + getPassword() +
                "\nEmail: " + getEmail() +
                "\nRole: " + getRoles() +
                "\nUser Id: " + getId();
    }
}