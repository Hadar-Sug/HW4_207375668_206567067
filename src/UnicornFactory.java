public class UnicornFactory implements AnimalFactory{
    /**
     * empty constructor
     */
    public UnicornFactory() {}

    /**
     * creates Unicorn
     * @return a Unicorn
     */
    @Override
    public Unicorn createAnimal() {
        return new Unicorn();
    }
}
