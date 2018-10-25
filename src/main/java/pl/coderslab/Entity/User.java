package pl.coderslab.Entity;

public class User {

    private Integer id;
    private String username;
    private String email;
    private String password;
    private Group group;

    public User() {
    }

    public User(String name, String email, String password, Group group){
        setUsername(name);
        setEmail(email);
        setPassword(password);
        setGroup(group);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String name) {
        this.username = name;
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

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
