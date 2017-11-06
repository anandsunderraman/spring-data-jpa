package model;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;


@Entity
@NamedEntityGraphs({
        @NamedEntityGraph(name = "userWithDepartment", attributeNodes = {
                @NamedAttributeNode("userDepartment")
        }),
        @NamedEntityGraph(name = "userWithAddress", attributeNodes = {
                @NamedAttributeNode("userAddress")
        })

})
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class User {

    @Id
    private Integer id;


    private String name;


    private String email;


    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY, optional = false)
    private UserDepartment userDepartment;

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY, optional = false)
    private UserAddress userAddress;

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

    public void setUserDepartment(UserDepartment userDepartment) {
        this.userDepartment = userDepartment;
    }

    public UserDepartment getUserDepartment() {
        return userDepartment;
    }

    public UserAddress getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(UserAddress userAddress) {
        this.userAddress = userAddress;
    }
}
