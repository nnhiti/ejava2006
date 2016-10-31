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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "notes")
public class Note implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @NotNull
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id = 1;
    
    @NotNull
    @JoinColumn(name="userid")
    @ManyToOne
    private User user;
    
    @NotNull
    @JoinColumn(name="catid")
    @ManyToOne
    private Category category;
    
    @NotNull
    @Column(name = "note")
    @Size(max = 2000)
    private String note;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    
    public JsonObject toJSON() {
        return (Json.createObjectBuilder()
                .add("note_id", id)
		.add("note", note)
		.add("category_name", category.getCatName())
                .add("user_name", user.getUserId())
		.build());
    }
}
