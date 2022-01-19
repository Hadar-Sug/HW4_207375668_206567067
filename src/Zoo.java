import java.util.ArrayList;

public class Zoo { //is subject
    private static Zoo mainZoo; // main zoo
    private ArrayList<TypeAndCountPair> animalTypes;
    private ArrayList<Animal> animalList;
    private ArrayList<ZooObserver> observes;
    private int hungerLevels;
    public int happinessLevel;
    private static final int MAX_LEVELS = 5;
    public static final int MIN_LEVELS = 1;


    /**
     * constructor for Zoo
     */
    private Zoo() {
        this.animalList = new ArrayList<>();
        this.animalTypes = new ArrayList<>();
        this.observes = new ArrayList<>();
        this.happinessLevel = 2;
        this.hungerLevels = 3;
    }

    /**
     * returns the only instance of Zoo, as its is a singleton
     *
     * @return the only instance of the zoo
     */
    public static Zoo getInstance() {
        if (mainZoo == null) {
            mainZoo = new Zoo();
            System.out.println("Creating zoo...");
        } else {
            System.out.println("The zoo already exists...");
        }
        return mainZoo;
    }

    /**
     * puts on a show
     * increases happiness level by one, and hunger level
     * notifies observers
     */
    public void watchAnimals() {
        for (Animal animal: mainZoo.animalList) {
            animal.performAction();
        }
        mainZoo.notifyObservers(Updates.WATCHING);
        //adjust happiness and hunger levels accordingly
        if (mainZoo.happinessLevel< MAX_LEVELS)
            mainZoo.happinessLevel++;
        if (mainZoo.hungerLevels< MAX_LEVELS)
            mainZoo.hungerLevels++;
    }

    /**
     * feed animals
     * decreases hunger level by one
     * notify observers
     */
    public void feedAnimals() {
        for (Animal animal: mainZoo.animalList) {
            animal.eat();
        }
        mainZoo.notifyObservers(Updates.FEEDING);
        if (mainZoo.hungerLevels> MIN_LEVELS)
            mainZoo.hungerLevels--;
    }

    /**
     * returns number of total animals, number of instances of each animal, and hunger and happiness level.
     * sort alphabetically
     * plus show message based on hunger and happiness levels
     */
    public void showAnimalsInfo() {
       int total = mainZoo.animalList.size();
        System.out.println("The zoo contains total of " +total + " animals:");
        for (TypeAndCountPair pair: mainZoo.animalTypes) {
            System.out.println("- " + pair.getAnimalType() + ": " + pair.getCount());
        }
            System.out.println("Happiness level: " + happinessLevel);
            if (happinessLevel<3)
                System.out.println("The animals are not happy, you should watch them...");
            else System.out.println("The animals are very happy, keep working hard...");
            System.out.println("Hunger level: " + hungerLevels);
            if (hungerLevels>3)
                System.out.println("The animals are hungry, you should feed them...");


    }

    /**
     * adds an observer to the list
     *
     * @param subscriber person to be added
     */
    public void addObserver(ZooObserver subscriber) {
        mainZoo.observes.add(subscriber);
    }

    /**
     * removes and observer
     *
     * @param unsubscriber person to be removed
     */
    public void removeObserver(ZooObserver unsubscriber) {
        mainZoo.observes.remove(unsubscriber);
    }

    /**
     * notifies observers in case of feeding or watching
     * @param update feeding or watching
     */
    private void notifyObservers(Updates update){
        System.out.println("Notifying observers:");
        for (ZooObserver observer:mainZoo.observes){
            observer.update(update);
        }
    }

    /**
     * notifies observers in case of adding
     * @param animal animal were adding
     */
    private void notifyObservers(Animal animal){
        System.out.println("Notifying observers:");
            for (ZooObserver observer : mainZoo.observes) {
                observer.update(Updates.ADDING, animal);
            }
    }

    /**
     * adds an animal to the zoo
     *
     * @param newAnimal animal to be added
     */
    public void addAnimal(Animal newAnimal) {
        mainZoo.animalList.add(newAnimal);
        String thisType = newAnimal.getClass().getSimpleName(); //hope this gives the actual name
        for (TypeAndCountPair pair : mainZoo.animalTypes) {
            if (thisType.equals(pair.getAnimalType())) { // if we already have this type of animal, just increase count
                pair.increaseCount();
                mainZoo.notifyObservers(newAnimal); //notify everyone
                return;
            }
        }//otherwise, we gotta add the new type
        int spot = mainZoo.findSpot(thisType); //find the spot, to keep the list in alphabetical order
        mainZoo.animalTypes.add(spot, new TypeAndCountPair(thisType)); // insert in correct spot
        mainZoo.notifyObservers(newAnimal); //notify everyone

    }

    /**
     * finds the correct spot to insert the new type of animal
     * @param addMe animal type were adding
     * @return the index were gonna add the new type into
     */
    private int findSpot(String addMe){
        for (int i = 0; i < animalTypes.size(); i++) {
            if(addMe.compareToIgnoreCase(animalTypes.get(i).getAnimalType()) <= 0)
                return i;
        }
        return animalTypes.size();
    }

}
