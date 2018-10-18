package ru.innopolis.stc13.student_test.pojo;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Objects;
import java.util.Set;

@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank
    private String login;
    @NotBlank
    private String password;
    @NotBlank
    private String name;

    @ManyToMany
    @JoinTable(
            name = "user_group",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "group_id")})
    private Set<Group> groups;

    @OneToOne
    private Specialization specialization;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "roles", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.ORDINAL)
    private Set<Role> roles;

    public User() {
    }

    public User(String login, String password, String name, Set<Group> groups, Specialization specialization, Set<Role> roles) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.groups = groups;
        this.specialization = specialization;
        this.roles = roles;
    }

    public User(Integer id, String login, String password, String name, Set<Group> groups, Specialization specialization, Set<Role> roles) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.groups = groups;
        this.specialization = specialization;
        this.roles = roles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(login, user.login) &&
                Objects.equals(password, user.password) &&
                Objects.equals(name, user.name) &&
                Objects.equals(groups, user.groups) &&
                Objects.equals(specialization, user.specialization) &&
                Objects.equals(roles, user.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, name, groups, specialization, roles);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", groups=" + groups +
                ", specialization='" + specialization + '\'' +
                ", roles=" + roles +
                '}';
    }
}