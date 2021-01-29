package entities;

import javax.persistence.*;

@Entity
@Table(name = "connection")
public class connection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "conID", unique = true, nullable = false)
    private int conId;

    @ManyToOne(fetch= FetchType.EAGER,cascade = {CascadeType.DETACH,CascadeType.PERSIST})
    @MapsId("userId")
    @JoinColumn(name = "userId")
    private User userID;

    @ManyToOne(fetch= FetchType.EAGER,cascade = {CascadeType.DETACH,CascadeType.PERSIST})
    @MapsId("skladId")
    @JoinColumn(name = "skladId")
    private Sklad skladId;

    public int getConId() {
        return conId;
    }

    public void setConId(int conId) {
        this.conId = conId;
    }

    public User getUserID() {
        return userID;
    }

    public void setUserID(User userID) {
        this.userID = userID;
    }

    public Sklad getSkladId() {
        return skladId;
    }

    public void setSkladId(Sklad skladId) {
        this.skladId = skladId;
    }

}
