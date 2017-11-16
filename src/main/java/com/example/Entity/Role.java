package com.example.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "roles")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Role {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private @Getter @Setter Long id;

    @Column(name = "name")
    private @Getter @Setter String name;


    @JsonIgnore
    @ManyToMany(mappedBy = "roles")
    private @Getter @Setter List<User> users;


    public Role(){
    }


}