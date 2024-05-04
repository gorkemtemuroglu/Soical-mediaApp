package com.socialmedia.socialmediaApp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="comment")
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(fetch = FetchType.LAZY) // ilgili user objesini getirmene gerek yok. Eager olsaydı gerek vardı.
    @JoinColumn(name = "user_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE) // Post silinirse ilgili user da silinmesini sağlar.
    @JsonIgnore
    User user;


    @ManyToOne(fetch = FetchType.LAZY) // ilgili user objesini getirmene gerek yok. Eager olsaydı gerek vardı.
    @JoinColumn(name = "post_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE) // Post silinirse ilgili user da silinmesini sağlar.
    @JsonIgnore
    Post post;

    @Lob
    @Column(columnDefinition = "text")
    String text;
}
