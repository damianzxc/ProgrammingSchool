package pl.coderslab.Entity;

public class User {

    private Integer id;
    private String name;
    private String email;
    private String password;
    private Group group;

    public User() {
    }

    public User(String name, String email, String password, Group group){
        setName(name);
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
