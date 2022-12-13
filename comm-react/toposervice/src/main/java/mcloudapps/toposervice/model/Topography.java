package mcloudapps.toposervice.model;

import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.mapping.Document;

//@Document(collection = "topographies")
public class Topography {

    @Id
    private String id;

    private String landscape;

    public Topography() {
    }

    public Topography(String id, String landscape) {
        super();
        this.id = id;
        this.landscape = landscape;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLandscape() {
        return landscape;
    }

    public void setLandscape(String landscape) {
        this.landscape = landscape;
    }
    
}
