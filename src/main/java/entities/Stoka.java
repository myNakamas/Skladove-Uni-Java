package entities;


import javax.persistence.*;

@Entity
@Table(name = "Stoka")
public class Stoka {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "StokaId" , unique = true, nullable = false)
    private int StokaId;

    @Column(name = "ime")
    private String ime;

    @Column(name = "preftype")
    private String preftype;

    public int getStokaId() {
        return StokaId;
    }

    public void setStokaId(int stokaId) {
        StokaId = stokaId;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPreftype() {
        return preftype;
    }

    public void setPreftype(String preftype) {
        this.preftype = preftype;
    }
}
