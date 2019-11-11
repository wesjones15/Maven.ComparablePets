package io.zipcoder;

abstract public class Pet implements Comparable {
    private String name;
    private String type;

    public Pet(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String getType() {
        return this.type;
    }

    abstract public String speak();


    public int compareTo(Object o) {
        return (this.getType().compareToIgnoreCase(((Pet) o).getType()));
    }
}

