/*
@author Andrei Gorevoi
*/
package deathvalley.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account extends BaseEntity {
    @Column
    private int account;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

}
