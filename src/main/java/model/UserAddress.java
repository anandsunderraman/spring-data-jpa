package model;

import javax.persistence.*;

@Entity
public class UserAddress {

    @Id
    private Integer userId;

    @Column(name = "address")
    private String address;

    @OneToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
