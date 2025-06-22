package com.example.memovocab.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "vocabulary", schema = "memo-vocab")
public class Vocabulary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String type;
    private String description;

    // TODO: check LAZY fetch
    @ManyToMany(mappedBy = "vocabularies", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Set<User> users = new HashSet<>();
}
