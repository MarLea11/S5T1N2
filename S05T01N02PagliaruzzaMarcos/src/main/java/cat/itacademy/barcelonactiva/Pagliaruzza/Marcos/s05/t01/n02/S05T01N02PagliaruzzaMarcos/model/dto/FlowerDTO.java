package cat.itacademy.barcelonactiva.Pagliaruzza.Marcos.s05.t01.n02.S05T01N02PagliaruzzaMarcos.model.dto;

import java.util.Arrays;
import java.util.List;

public class FlowerDTO {

    private int pk_FlowerId;
    private String nameFlower;
    private String countryFlower;
    private String typeFlower;
    private final List<String> COUNTRIES_UE = Arrays.asList("AUSTRIA, BELGIUM, BULGARIA, CROATIA, CYPRUS, CZECH_REPUBLIC, DENMARK, ESTONIA, SPAIN, FINLAND, FRANCE, GERMANY, GREECE, HUNGARY, IRELAND, ITALY, LATVIA, LITHUANIA, LUXEMBOURG, MALTA, NETHERLANDS, POLAND, PORTUGAL, ROMANIA, SLOVAKIA, SLOVENIA, SWEDEN, SWITZERLAND, TURKEY");

    public FlowerDTO() {

    }

    public FlowerDTO(String nameFlower, String countryFlower, String typeFlower) {
        this.nameFlower = nameFlower;
        this.countryFlower = countryFlower;
        this.typeFlower = typeFlower;
    }

    public String determinateFlowerType() {
        return COUNTRIES_UE.contains(countryFlower) ? "Inside UE" : "Outside UE";
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

    public String getTypeFlower() {
        return typeFlower;
    }

    public void setTypeFlower(String typeFlower) {
        this.typeFlower = typeFlower;
    }
}
