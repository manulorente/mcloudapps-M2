package mcloudapps.airport.entity;

import java.util.Objects;

import org.springframework.data.mongodb.core.mapping.Field;

public class ProvinceData {

    @Field(name = "Anyo")
    private Integer year;

    @Field(name = "Valor")
    private Integer value;

    public ProvinceData() {
    }

    public ProvinceData(Integer year, Integer value) {
        this.year = year;
        this.value = value;
    }

    public Integer getYear() {
        return this.year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getValue() {
        return this.value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public ProvinceData year(Integer year) {
        this.year = year;
        return this;
    }

    public ProvinceData value(Integer value) {
        this.value = value;
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " year='" + getYear() + "'" +
            ", value='" + getValue() + "'" +
            "}";
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ProvinceData)) {
            return false;
        }
        ProvinceData data = (ProvinceData) o;
        return Objects.equals(year, data.year) && Objects.equals(value, data.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, value);
    }
}
