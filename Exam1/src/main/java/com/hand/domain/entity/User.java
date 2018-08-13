package com.hand.domain.entity;

import com.hand.infra.util.AddressTypeHandler;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import tk.mybatis.mapper.annotation.ColumnType;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "customer")
public class User {

    @Id
    @Column(name = "customer_id")
    private Integer uid;

    private Integer storeId = 1;

    @NotBlank(message = "first name 不能为空")
    private String firstName;

    @NotBlank(message = "last name 不能为空")
    private String lastName;

    @Email(message = "邮箱格式错误")
    private String email;

    @ColumnType(typeHandler = AddressTypeHandler.class)
    @Column(name = "address_id")
    private Address address;

    private Integer active = 1;

    private Date createDate;

    private Date lastUpdate;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
