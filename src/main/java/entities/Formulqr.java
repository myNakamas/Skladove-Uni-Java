package entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "formulqr")
public class Formulqr {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "formulqrId", unique = true, nullable = false)
    private int formulqrId;

    @ManyToOne(fetch= FetchType.EAGER,cascade = {CascadeType.DETACH,CascadeType.PERSIST})
    @MapsId("userId")
    @JoinColumn(name = "userId")
    private User userId;

    @ManyToOne(fetch= FetchType.EAGER,cascade = {CascadeType.DETACH,CascadeType.PERSIST})
    @MapsId("SkladId")
    @JoinColumn(name = "SkladId")
    private Sklad SkladId;

    @Column(name = "Bname")
    private String Bname;

    @Column(name = "address")
    private String addresss;

    @Column(name = "cena")
    private float currency;

    @Column(name = "data")
    private Date Data;

    @Column(name = "period")
    private Date period;

    public int getFormulqrId() {
        return formulqrId;
    }

    public void setFormulqrId(int formulqrId) {
        this.formulqrId = formulqrId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Sklad getSkladId() {
        return SkladId;
    }

    public void setSkladId(Sklad skladId) {
        SkladId = skladId;
    }

    public String getBname() {
        return Bname;
    }

    public void setBname(String bname) {
        Bname = bname;
    }

    public String getAddresss() {
        return addresss;
    }

    public void setAddresss(String addresss) {
        this.addresss = addresss;
    }

    public float getCurrency() {
        return currency;
    }

    public void setCurrency(float currency) {
        this.currency = currency;
    }

    public Date getData() {
        return Data;
    }

    public void setData(Date data) {
        Data = data;
    }

    public Date getPeriod() {
        return period;
    }

    public void setPeriod(Date period) {
        this.period = period;
    }
}
