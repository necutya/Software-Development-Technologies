package MuseumExhibition;

import java.util.Calendar;

public abstract class Exhibit {

    private String name;
    private Author author;
    private int creationYear;
    private DescriptionPlate descriptionPlate;

    /** Creates an exhibit with specified name, author, creationYear.
     * @param name The exhibit`s name
     * @param author The exhibit`s author
     * @param creationYear The exhibit`s year of creation
     */
    public Exhibit(String name, Author author, int creationYear) {
        this.name = name;
        this.author = author;
        try {
            this.setCreationYear(creationYear, author);
        }
        catch(YearValidationException err) {
            // Can mbe changed to logging
            System.out.println(err.getMessage());
            this.setCreationYear(Calendar.getInstance().get(Calendar.YEAR));
        }
        this.descriptionPlate = new DescriptionPlate(
                this.author + " - \"" + this.name + "\" (" + this.getCreationYear() + ")"
        );
    }

    /** Get an exhibit`s name.
     * @return The exhibit`s name
     */
    public String getName() {
        return name;
    }

    /** Set an exhibit`s name.
     * @param name exhibit`s name
     */
    public void setName(String name) {
        this.name = name;
    }

    /** Get an exhibit`s author.
     * @return The exhibit`s author
     */
    public Author getAuthor() {
        return author;
    }

    /** Set an exhibit`s author.
     * @param author exhibit`s author
     */
    public void setAuthor(Author author) {
        this.author = author;
    }

    /** Get an exhibit`s year of creation.
     * @return The exhibit`s year of creation
     */
    public int getCreationYear() {
        return creationYear;
    }

    /** Set an exhibit`s year of creation.
     * @param creationYear exhibit`s year of creation
     */
    public void setCreationYear(int creationYear) {
        this.creationYear = creationYear;
    }

    /** Set an exhibit`s year of creation comparing to authors` years of life.
     * @param creationYear exhibit`s year of creation
     */
    public void setCreationYear(int creationYear, Author author) throws YearValidationException{
        if(creationYear > author.getBorn_year()) {
            int death_year =author.getDeath_year();
            if(death_year != 0 && creationYear < death_year) {
                this.creationYear = creationYear;
                return;
            }
        }
        throw new YearValidationException("Incorrect creation year. Automatically set to current year: " +
                Calendar.getInstance().get(Calendar.YEAR) + ".");
    }


    /** Get a description plate.
     * @return description plateo object.
     */
    public DescriptionPlate getDescriptionPlate() {
        return descriptionPlate;
    }

    /** Set an description plate text.
     * @param text text to be set
     */
    public void setDescriptionPlate(String text) {
        descriptionPlate.setText(text);
    }

    /** Override toString method
     * @return text of description plate
     */
    @Override
    public String toString() {
        return descriptionPlate.getText();
    }

    /** Override hashcode method. Hashcode based on name, authors` initials and creation year.
     It means, that some objects can have the same hashcode.
     * @return hashCode ofthe object
     */
    @Override
    public int  hashCode() {
        int hash_code = 0;
        for (char ch: (name+author.getInitials()).toCharArray()) {
            hash_code += (int)ch;
        }
        return hash_code + getCreationYear();
    }

    /** Override equals method.
     * @return true or false
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        return hashCode() == obj.hashCode(); // main comparing
    }




    private class DescriptionPlate {
        private String text;

        /** Creates an description plate with specified text.
         * @param text The description plate`s name
         */
        public DescriptionPlate(String text) {
            this.text = text;
        }

        /** Get an description plate`s text.
         * @return The description plate`s text
         */
        public String getText() {
            return text;
        }

        /** Set an description plate`s text.
         * @param text The description plate`s text
         */
        public void setText(String text) {
            this.text = text;
        }
    }
}
