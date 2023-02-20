package mcloudapps.airport.entity;

import java.util.List;
import java.util.Objects;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import jakarta.persistence.Id;

@Document(collection = "provincia")
public class Province {
    
    @Id
    @Field(name = "_id")
    private String id;

    @Field(name = "Nombre")
    private String name;

    @Field(name = "CA")
    private String ca;

    @Field(name = "Superficie")
    private String area;

    @Field(name = "Datos")
    private List<ProvinceData> data;

    public Province() {
    }

    public Province(String name, String ca, String area, List<ProvinceData> data) {
        this.name = name;
        this.ca = ca;
        this.area = area;
        this.data = data;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCa() {
        return this.ca;
    }

    public void setCa(String ca) {
        this.ca = ca;
    }

    public String getArea() {
        return this.area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public List<ProvinceData> getData() {
        return this.data;
    }

    public void setData(List<ProvinceData> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", ca='" + getCa() + "'" +
            ", area='" + getArea() + "'" +
            ", data='" + getData() + "'" +
            "}";
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Province)) {
            return false;
        }
        Province province = (Province) o;
        return Objects.equals(id, province.id) && Objects.equals(name, province.name) && Objects.equals(ca, province.ca) && Objects.equals(area, province.area) && Objects.equals(data, province.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, ca, area, data);
    }
}
