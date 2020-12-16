package MuseumExhibition;

import java.util.ArrayList;

public class Exhibition {
    private String name;
    private ArrayList<Exhibit> exhibits;

    /** Creates an exhibition with specified name.
     * @param name The exhibition name
     */
    public Exhibition(String name) {

        this.name = name;
        exhibits = new ArrayList<Exhibit>();
    }

    /** Get an exhibition name.
     * @return The exhibition name
     */
    public String getName() {
        return name;
    }

    /** Set an exhibition name.
     * @param name exhibition name
     */
    public void setName(String name) {
        this.name = name;
    }

    /** Get all exhibits of an exhibition.
     * @return related exhibits
     */
    public ArrayList<Exhibit> getExhibits() {
        return exhibits;
    }

    /** add an exhibit to the exhibition.
     * @param exhibit exhibit
     */
    public void addExhibit(Exhibit exhibit) {
        exhibits.add(exhibit);
    }

    /** Get amount of exhibits.
     * @return amount of exhibits
     */
    public int getExhibitsAmount() {
        return exhibits.size();
    }


}
