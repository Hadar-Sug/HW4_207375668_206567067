public class Monkey implements Animal{
    private final int monkeyID;
    private static int count = 0;

    /**
     * constructor
     */
    public Monkey(){
        this.monkeyID = count++;
    }

    /**
     * perform action
     */
    @Override
    public void performAction() {
        System.out.println("The monkey is hanging on trees...");
    }

    /**
     * eat
     */
    @Override
    public void eat() {
        System.out.println("The monkey is eating a banana...");
    }
}
