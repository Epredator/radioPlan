package pl.etroya.radioplan.model;

public class RadioStation {
    Long id;
    String name;
    String description;
    Integer startYear;

    public RadioStation(){

    }

    public RadioStation(Long id, String name, String description, Integer startYear){
        this.id = id;
        this.name = name;
        this.description = description;
        this.startYear = startYear;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStartYear() {
        return startYear;
    }

    public void setStartYear(Integer startYear) {
        this.startYear = startYear;
    }
}
