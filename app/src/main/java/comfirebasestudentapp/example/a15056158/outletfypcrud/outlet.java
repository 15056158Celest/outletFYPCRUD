package comfirebasestudentapp.example.a15056158.outletfypcrud;

/**
 * Created by 15056158 on 26/7/2017.
 */

public class outlet {

    private int id;
    private String outletName;
    private String outletLocation;



    public outlet(){
        super();
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getoutletName() {
        return outletName ;
    }
    public void setoutletName(String outletName) {
        this.outletName = outletName;
    }
    public String getoutletLocation() {
        return outletLocation;
    }
    public void setoutletLocation(String outletLocation) {
        this.outletLocation = outletLocation;
    }



    public String toString(){
        return getoutletName() + " " + getoutletLocation();
    }

}
