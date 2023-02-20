package mcloudapps.airport.dto;

import java.util.Objects;

import org.springframework.data.mongodb.core.mapping.Field;

public class ProvinceDTO{

    @Field(name = "_id")
    private String ca;

    private Integer numOfProvinces;

    public ProvinceDTO() {
    }

    public ProvinceDTO(String ca, Integer numOfProvinces) {
        this.ca = ca;
        this.numOfProvinces = numOfProvinces;
    }

    public String getCa() {
        return this.ca;
    }

    public void setCa(String ca) {
        this.ca = ca;
    }

    public Integer getNumOfProvinces() {
        return this.numOfProvinces;
    }

    public void setNumOfProvinces(Integer numOfProvinces) {
        this.numOfProvinces = numOfProvinces;
    }

    public ProvinceDTO ca(String ca) {
        this.ca = ca;
        return this;
    }

    public ProvinceDTO numOfProvinces(Integer numOfProvinces) {
        this.numOfProvinces = numOfProvinces;
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " ca='" + getCa() + "'" +
            ", numOfProvinces='" + getNumOfProvinces() + "'" +
            "}";
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ProvinceDTO)) {
            return false;
        }
        ProvinceDTO provinceDTO = (ProvinceDTO) o;
        return Objects.equals(ca, provinceDTO.ca) && Objects.equals(numOfProvinces, provinceDTO.numOfProvinces);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ca, numOfProvinces);
    }

}