package com.cartservice.com.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.HashMap;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "cart_table")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false, unique = true)
    @NotNull
    private Long userId;

    @Column(name = "Books_Set")
    @ElementCollection
    private HashMap<Long , Integer> books_set;

    public String addItem(Long id) {
        if(books_set.containsKey(id)) {
            int value = books_set.get(id);
            books_set.replace(id , value , value+1);
        }
        else
            books_set.put(id , 1);
        return "Items Added!";
    }

    public String removeItem(Long id) {
        if(books_set.get(id)>1) {
            int value = books_set.get(id);
            books_set.replace(id , value , value-1);
            return "Items Removed";
        }
        else
            return "Item is Not Present in Cart";
    }
}
