package by.gsu.asoilab;

public class UniformMaterial {
    private String name;
    private Material material;
    private double volume;

    public UniformMaterial(){
        this("", new Material(), 0);
    }

    public UniformMaterial(String name, Material material, double volume) {
        this.name = name;
        this.material = material;
        this.volume = volume;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return name + ';' + material + ';' + volume + ':' + getMass();
    }

    public double getMass(){
        return material.getDensity() * volume;
    }
}
