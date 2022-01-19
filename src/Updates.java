/**
 * enum for types of updates that can be sent to observers
 */
public enum Updates {
    FEEDING("The animals are being fed"),
    WATCHING("The animals are being watched"),
    ADDING(" has been added to the zoo!");

    private final String message;

    /**
     * constructor
     * @param message message for update
     */
    private Updates (String message){
        this.message = message;
    }

    /**
     * getter
     * @return message
     */
    public String getMessage() {
        return message;
    }
}
