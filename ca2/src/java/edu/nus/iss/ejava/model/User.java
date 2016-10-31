/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.nus.iss.ejava.model;

import java.io.Serializable;
import javax.json.JsonObject;
import javax.json.Json;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @NotNull
    @Id
    @Column(name = "userid")
    @Size(max = 32)
    private String userId;
    
    @NotNull
    @Column(name = "password")
    @Size(max = 128)
    private String password;
    
    @OneToOne(mappedBy = "user")
    private Group group;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
    
    public JsonObject toJSON() {
        return (Json.createObjectBuilder()
                .add("user_id", userId)
		.add("password", password)
		.build());
    }
}
