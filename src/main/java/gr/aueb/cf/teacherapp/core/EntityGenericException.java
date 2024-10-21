package gr.aueb.cf.teacherapp.core;

public class EntityGenericException extends Exception{
    private final String code;

    public EntityGenericException(String message, String code) {
        super(message);
        this.code = code;
    }
}
