package MuseumExhibition;

import java.util.ArrayList;

public class Author implements Person {
    private String name;
    private String surname;
    private int born_year;
    private int death_year;

    /** Creates an author using full_name.
     * @param full_name The author`s full_name
     */

    public Author(String full_name, int[] years_of_life) {
        String[] temp = full_name.split(" ");
        this.name = temp[0];

        // Surname can have its prefix or can be consist of two or more words
        // For example: Leonardo Da Vinci, Lars von Trier, etc.
        StringBuilder surname = new StringBuilder();
        for(int i = 1 ; i < temp.length; i++){
            surname.append(temp[i]);
            if(i != temp.length - 1) {
                surname.append(" ");
            }
        }

        this.surname = surname.toString();
        if(years_of_life.length == 2) {
            this.born_year = years_of_life[0];
            this.death_year = years_of_life[1];
        }
        else if(years_of_life.length == 1) {
            this.born_year = years_of_life[0];
        }
    }

    /** Creates an author with specified name and surname.
     * @param name The author`s name
     * @param surname The author`s surname
     */

    public Author(String name, String surname, int[] years_of_life) {
        this.name = name;
        this.surname = surname;

        if(years_of_life.length == 2) {
            this.born_year = years_of_life[0];
            this.death_year = years_of_life[1];
        }
        else if(years_of_life.length == 1) {
            this.born_year = years_of_life[0];
            this.death_year = 0;
        }
    }

    /** Get an author`s name.
     * @return The author`s name
     */
    public String getName() {
        return this.name;
    }

    /** Set an author`s name.
     * @param name an author`s name
     */
    public void setName(String name) {
        this.name = name;
    }

    /** Get an author`s surname.
     * @return The author`s surname
     */
    public String getSurname() {
        return this.surname;
    }

    /** Set an author`s surname.
     * @param surname an author`s surname
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /** Get an author`s full name.
     * @return The author`s surname
     */
    public String getFullName() {
        return this.name + ' ' + this.surname;
    }

    /** Get an author`s born year.
     * @return The author`s born year
     */
    public int getBorn_year() {
        return born_year;
    }

    /** Get an author`s death year.
     * @return The author`s death year
     */
    public int getDeath_year() {
        return death_year;
    }

    /** Override toString method
     * @return author`s full name
     */
    @Override
    public String toString() {
        String temp = getFullName() + " (" + getBorn_year() + "-";
        if (getDeath_year() != 0) {
            temp += getDeath_year();
        }
        else {
            temp += "...";
        }
        temp += ")";
        return temp;
    }

    /** Get authors` initials
     * @return authors` initials
     */
    public String getInitials() {
        String temp_surname;
        if (surname.split(" ").length > 1) {
            temp_surname = surname.split(" ")[1];

        }
        else {
            temp_surname  = surname.split(" ")[0];
        }

        return name.substring(0, 1).toUpperCase() + ". " + temp_surname.substring(0, 1).toUpperCase() + ".";
    }
}
