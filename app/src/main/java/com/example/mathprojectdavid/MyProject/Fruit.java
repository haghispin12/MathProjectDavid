package com.example.mathprojectdavid.MyProject;

public class Fruit {
    private String name;
    private int weight;
    private int imageDrwable;

    public Fruit(String name, int imageDrwable){
        this.name=name;
        //this.weight=weight;
        this.imageDrwable=imageDrwable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getImageDrwable() {
        return imageDrwable;
    }

    public void setImageDrwable(int imageDrwable) {
        this.imageDrwable = imageDrwable;
    }
}
