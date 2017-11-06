package model;

import javax.persistence.*;

@Entity
public class UserDepartment {

    @Id
    private Integer userId;

    @Column(name = "department")
    private String department;

    @OneToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
