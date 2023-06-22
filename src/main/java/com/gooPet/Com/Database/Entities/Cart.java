package com.gooPet.Com.Database.Entities;

import com.gooPet.Auth.Database.Entities.User;
import com.gooPet.Auth.Database.Entities.UserType;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author mauricio.rodrigues
 */
@Entity
@Table(name = "[com].[Cart]")
public class Cart {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "uniqueidentifier")
    private UUID id;
    
    @ManyToOne
    @JoinColumn(name = "UserId")
    private User user;
    
    @OneToMany
    @JoinTable(
        name = "[com].[CartProduct]", // Nome da tabela intermediária
        joinColumns = @JoinColumn(name = "CartId"), // Coluna que relaciona com o carrinho
        inverseJoinColumns = @JoinColumn(name = "ProductId") // Coluna que relaciona com o produto
    )
    private List<Product> listaProdutos;
    
    @Column(name = "isClosed")
    private int isClosed;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CloseDate")
    private Date closeDate;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "InsertDate")
    private Date insertDate;
    
}
