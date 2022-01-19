public class ZebraFactory implements AnimalFactory{
    /**
     * empty constructor
     */
    public ZebraFactory() {
    }

    /**
     * creates a Zebra
     * @return a Zebra
     */
    @Override
    public Zebra createAnimal() {
        return new Zebra();
    }
}
