package MuseumExhibition;

public class Painting extends Exhibit {
    private int width;
    private int height;

    /** Creates an painting with specified name, author, creationYear, width and height.
     * @param name The painting`s name
     * @param author The painting`s author
     * @param creationYear The painting`s year of creation
     * @param width The painting`s width
     * @param height The material`s heigh
     */
    public Painting(String name, Author author, int creationYear, int width, int height) {
        super(name, author, creationYear);
        this.width = width;
        this.height = height;
        this.setDescriptionPlate(this.getAuthor() + " - \"" + this.getName() + "\" (" + this.getCreationYear() + ") " +
                "(Size: " + this.width + "x" + this.height + ")");
    }

    /** Get an painting`s width.
     * @return The painting`s width
     */
    public int getWidth() {
        return width;
    }

    /** Set an painting`s width.
     * @param width painting`s width
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /** Get an painting`s height.
     * @return The painting`s height
     */
    public int getHeight() {
        return height;
    }

    /** Set an painting`s height.
     * @param height painting`s height
     */
    public void setHeight(int height) {
        this.height = height;
    }

}
