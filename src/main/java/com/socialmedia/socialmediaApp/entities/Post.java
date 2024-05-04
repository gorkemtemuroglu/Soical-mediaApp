package com.socialmedia.socialmediaApp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="post")
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(fetch = FetchType.EAGER) // ilgili user objesini getirmene gerek yok. Lazy olsaydı gerek yoktu.
    @JoinColumn(name = "user_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE) // Post silinirse ilgili user da silinmesini sağlar.
    User user;


    String title;
    @Lob
    @Column(columnDefinition = "text")
    String text;
}
