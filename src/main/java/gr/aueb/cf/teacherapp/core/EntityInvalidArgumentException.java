package gr.aueb.cf.teacherapp.core;

public class EntityInvalidArgumentException extends EntityGenericException{
    private static final String DEFAULT_CODE = "InvalidArgument";

    public EntityInvalidArgumentException(String message, String code) {
        super(message, code + DEFAULT_CODE);
    }
}
