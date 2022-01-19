public class ZooObserver {
    private final String name;

    /**
     * constructor for observer
     * @param name name of observer
     */
    public ZooObserver(String name) {
        this.name = name;
    }

    /**
     * update in case of new animal added
     *ex: [name] 'ANIMAL' has been added to the zoo!
     * @param update type of update
     */
    public void update(Updates update, Animal animal){
        System.out.println("[" + name + "] " + animal.getClass().getSimpleName() + update.getMessage());

    }

    /**
     * update in case of feeding or show
     * ex: [name] The animals are being watched
     * @param update the type of update that occurred
     */
    public void update(Updates update) {
        System.out.println("[" + name + "] " + update.getMessage());
    }

}
