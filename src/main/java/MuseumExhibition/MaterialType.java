package MuseumExhibition;

public enum MaterialType {
    Wood(),
    Stone(1100f),
    Metal(),
    Plastic(930f),
    Clay(2560f);

    float weight;

    /** Constructor for material object
     *
     */
    MaterialType() {

    }

    /** Constructor for material object with weight
     * @param weight
     */
    MaterialType(float weight) {
        this.weight = weight;
    }

    /** Override toString method
     * @return String
     */
    @Override
    public String toString() {
        if(this.hasWeight())
            return this.name().toLowerCase() + " with weight " + this.weight + " kgs per square meter";
        else
            return this.name().toLowerCase();

    }

    /** Check if meterial has weight
     * @return bool
     */
    public boolean hasWeight() {
        return weight > 0;
    }

    /** Return weight
     * @return int
     */
    public float getWeight() {
        return this.weight;
    }
}
