package MuseumExhibition;

public class Sculpture extends Exhibit{
    private MaterialType material;

    /** Creates an sculpture with specified name, author, creationYear and material.
     * @param name The sculpture`s name
     * @param author The sculpture`s author
     * @param creationYear The sculpture`s year of creation
     * @param material The material of the sculpture
     */
    public Sculpture(String name, Author author, int creationYear, MaterialType material) {
        super(name, author, creationYear);
        this.material = material;
        this.setDescriptionPlate(this.getAuthor() + " - \"" + this.getName() + "\" (" + this.getCreationYear() + ") " +
                "(Material: " + this.material +")");
    }

    /** Get an sculpture`s material.
     * @return The sculpture material
     */
    public MaterialType getMaterial() {
        return material;
    }

    /** Set an sculpture`s material.
     * @param material sculpture material
     */
    public void setMaterial(MaterialType material) {
        this.material = material;
    }

}
