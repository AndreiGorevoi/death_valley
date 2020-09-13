/*
@author Andrei Gorevoi
*/
package deathvalley.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {
    @Column
    private String name;

    @Column
    private String sureName;
}
