package cat.itacademy.barcelonactiva.Pagliaruzza.Marcos.s05.t01.n02.S05T01N02PagliaruzzaMarcos.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Flower {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pk_FlowerId;
    private String nameFlower;
    private String countryFlower;

    public Flower() {

    }

    public Flower(String nameFlower, String countryFlower) {
        this.nameFlower = nameFlower;
        this.countryFlower = countryFlower;
    }

    public int getPk_FlowerId() {
        return pk_FlowerId;
    }

    public void setPk_FlowerId(int pk_FlowerId) {
        this.pk_FlowerId = pk_FlowerId;
    }

    public String getNameFlower() {
        return nameFlower;
    }

    public void setNameFlower(String nameFlower) {
        this.nameFlower = nameFlower;
    }

    public String getCountryFlower() {
        return countryFlower;
    }

    public void setCountryFlower(String countryFlower) {
        this.countryFlower = countryFlower;
    }

}
