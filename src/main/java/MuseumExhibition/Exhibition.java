package MuseumExhibition;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exhibition {
    private String name;
    private ArrayList<Exhibit> exhibits;

    /**
     * Creates an exhibition with specified name.
     *
     * @param name The exhibition name
     */
    public Exhibition(String name) {

        this.name = name;
        exhibits = new ArrayList<Exhibit>();
    }

    /**
     * Get an exhibition name.
     *
     * @return The exhibition name
     */
    public String getName() {
        return name;
    }

    /**
     * Set an exhibition name.
     *
     * @param name exhibition name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get all exhibits of an exhibition.
     *
     * @return related exhibits
     */
    public ArrayList<Exhibit> getExhibits() {
        return exhibits;
    }

    /**
     * add an exhibit to the exhibition.
     *
     * @param exhibit exhibit
     */
    public void addExhibit(Exhibit exhibit) {
        exhibits.add(exhibit);
    }

    /**
     * Get amount of exhibits.
     *
     * @return amount of exhibits
     */
    public int getExhibitsAmount() {
        return exhibits.size();
    }


    /**
     * Find min perimeter of a hall via width
     *
     * @return min required perimeter of a hall
     */
    public int findMinPerimeterOfHall() {
        return exhibits.stream()
                .filter(exhibit -> exhibit instanceof Painting)
                .mapToInt(exhibit -> ((Painting) exhibit).getWidth()).sum();
    }


    /**
     * Find the biggest painting in the exhibition
     *
     * @return area
     */
    public Exhibit findTheBiggestPainting() {
        return exhibits.stream()
                .filter(exhibit -> exhibit instanceof Painting)
                .max(Comparator.comparing(exhibit -> ((Painting) exhibit).getArea()))
                .orElseThrow();
    }

    /**
     * Find average area of paintings
     *
     * @return average area
     */
    public double findAverageAreaOfPaintings() {
        return exhibits.stream()
                .filter(exhibit -> exhibit instanceof Painting)
                .mapToInt(exhibit -> ((Painting) exhibit).getWidth()).average().orElse(0);
    }


    public Map<String, List<Exhibit>> getExhibitByType(Object clazz) {
        return exhibits.stream().collect(Collectors.groupingBy(exhibit -> exhibit.getClass().equals(clazz) ?
                "Paintings" : "Sculptures"));
    }


    public Optional<Map.Entry<Integer, Long>> getMostCommonMarkOfExhibit() {
        Stream<Integer> temp = exhibits.stream()
                .map(Exhibit::getMarkList)
                .flatMap(List<Integer>::stream);
        System.out.print("Marks: ");
        temp.forEach(x -> System.out.print(x + " "));
        System.out.println();
        return exhibits.stream()
                .map(Exhibit::getMarkList)
                .flatMap(List<Integer>::stream)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue());

    }


}