package testes.telas.modelos;

public class Vaga {

    private int id;
    private String place;
    private String street;
    private String nbhood;
    private String zone;
    private int cep;
    private float lat;
    private float lon;

    public Vaga() {

    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNbhood() {
        return nbhood;
    }

    public void setNbhood(String nbhood) {
        this.nbhood = nbhood;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public void setLatLong(int cep){
        float ltd = 0;
        float lng = 0;
        // Usar GEOCODER para converter o cep para LatLong
        this.lat = ltd;
        this.lon = lng;
    }

    public float getLat() {
        return lat;
    }

    public float getLon() {
        return lon;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }
}
