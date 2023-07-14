package source;

public class SingleUserData {
    private Integer id;
    private String email;
    private String name;
    private String group;
    private Boolean active;
    private String role;
    private String createdAt;
    private String updatedAt;

    public SingleUserData() {
    }

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    public Boolean getActive() {
        return active;
    }

    public String getRole() {
        return role;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }
}