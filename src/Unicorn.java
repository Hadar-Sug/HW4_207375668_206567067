public class Unicorn implements Animal {
    private final int unicornID;
    private static int count = 0;

    /**
     * constructor
     */
    public Unicorn(){
        this.unicornID = count++;
    }

    /**
     * perform action
     */
    @Override
    public void performAction() {
        System.out.println("The unicorn is flying...");
    }

    /**
     * eat
     */
    @Override
    public void eat() {
        System.out.println("The unicorn is eating rainbow cakes...");
    }
}
