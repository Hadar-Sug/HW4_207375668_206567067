/**
 * class that represents a pair that holds a string holding type of animal, and the amount of that type
 */
public class TypeAndCountPair {
    private final String animalType;
    private int count;

    /**
     * constructor for the pair
     * @param animalType animal type
     */
    public TypeAndCountPair(String animalType) {
        this.animalType = animalType;
        this.count = 1;
    }

    /**
     * getter for animal type
     * @return animal type
     */
    public String getAnimalType() {
        return animalType;
    }

    /**
     * getter for amount of animals per specific type
     * @return amount
     */
    public int getCount() {
        return count;
    }

    /**
     * in case an instance of specified animal was added
     */
    public void increaseCount() {
        this.count++;
    }

}
