package entities;
import javax.persistence.*;

@Entity
@Table(name = "sklad")
public class Sklad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skladId", unique = true, nullable = false)
    private int skladId;

    @ManyToOne(fetch= FetchType.EAGER,cascade = {CascadeType.DETACH,CascadeType.PERSIST})
    @MapsId("StokaId")
    @JoinColumn(name = "StokaId")
    private Stoka StokaId;

    @Column(name = "razmer", nullable = false)
    private float razmer;

    @Column(name = "klim_usloviq")// int - gradusi
    private int klim_usloviq;

    @Column(name = "kategoriq", nullable = false)// a1,a2,b1,b2,c1,c2 : a1 -> pod 0 gradusa i pod 100kv/m, a2 -> pod 0 nad 100 kv/m
    private String kategoriq;

    @Column(name = "isused")
    private boolean isused;

    @Column(name = "address", nullable = false)
    private String address;

    public int getSkladId() {
        return skladId;
    }

    public void setSkladId(int skladId) {
        this.skladId = skladId;
    }

    public Stoka getStokaId() {
        return StokaId;
    }

    public void setStokaId(Stoka stokaId) {
        StokaId = stokaId;
    }

    public float getRazmer() {
        return razmer;
    }

    public void setRazmer(float razmer) {
        this.razmer = razmer;
    }

    public int getKlim_usloviq() {
        return klim_usloviq;
    }

    public void setKlim_usloviq(int klim_usloviq) {
        this.klim_usloviq = klim_usloviq;
    }

    public String getKategoriq() {
        return kategoriq;
    }

    public void setKategoriq(String kategoriq) {
        this.kategoriq = kategoriq;
    }

    public boolean isIsused() {
        return isused;
    }

    public void setIsused(boolean isused) {
        this.isused = isused;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
