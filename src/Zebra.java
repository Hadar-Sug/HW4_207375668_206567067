public class Zebra implements Animal{
    private final int zebraID;
    private static int count = 0;

    /**
     * constructor
     */
    public Zebra(){
        this.zebraID = count++;
    }

    /**
     * perform action
     */
    @Override
    public void performAction() {
        System.out.println("The zebra is running...");
    }

    /**
     * eat
     */
    @Override
    public void eat() {
        System.out.println("The zebra is eating grass...");
    }
}
