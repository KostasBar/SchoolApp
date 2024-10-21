package gr.aueb.cf.teacherapp.core;

public class EntityNotFoundException extends EntityGenericException {

    private static final String DEFAULT_CODE = "nOTfOUND";

    public EntityNotFoundException(String message, String code) {
        super(message, code + DEFAULT_CODE);
    }
}
