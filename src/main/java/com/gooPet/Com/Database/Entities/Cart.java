package com.gooPet.Com.Database.Entities;

import com.gooPet.Auth.Database.Entities.User;
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
    
    @Column(name = "isClosed")
    private int isClosed;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CloseDate")
    private Date closeDate;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "InsertDate")
    private Date insertDate;

    public Cart() {
        
    }

    public Cart(User user, int isClosed, Date closeDate, Date insertDate) {
        this.user = user;
        this.isClosed = isClosed;
        this.closeDate = closeDate;
        this.insertDate = insertDate;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    public int getIsClosed() {
        return isClosed;
    }

    public void setIsClosed(int isClosed) {
        this.isClosed = isClosed;
    }

    public Date getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(Date closeDate) {
        this.closeDate = closeDate;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    @Override
    public String toString() {
        return "Cart{" + "user=" + user + ", isClosed=" + isClosed + ", closeDate=" + closeDate + ", insertDate=" + insertDate + '}';
    }

}
