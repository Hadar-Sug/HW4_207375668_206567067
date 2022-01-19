public class MonkeyFactory implements AnimalFactory{
    /**
     * empty constructor
     */
    public MonkeyFactory() {
    }

    /**
     * creates a Monkey
     * @return a monkey
     */
    @Override
    public Monkey createAnimal() {
        return new Monkey();
    }
}
