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
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "groups")
public class Group implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @NotNull
    @Id
    @Column(name = "groupid")
    @Size(max = 32)
    private String groupId;
    
    @OneToOne
    @JoinColumn(name = "userid", referencedColumnName = "userid")
    private User user;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    public JsonObject toJSON() {
        return (Json.createObjectBuilder()
                .add("group_id", groupId)
		.add("user_id", user.getUserId())
		.build());
    }
}
