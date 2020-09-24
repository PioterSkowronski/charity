package pl.coderslab.charity.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy =
            GenerationType.IDENTITY)
    private long id;
    @Email(message = "Email nieprawidłowy")
    @NotBlank(message = "Email jest wymagany")
    private String email;
    @NotBlank(message = "Podaj hasło")
    @Length(min = 5, message = "Hasło musi składać się z co najmniej 5 znaków")
    private String password;
    @ManyToMany
    private Set<Role> roles;
    private String status;

    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
