package gr.aueb.cf.teacherapp.core;

public class EntityAlreadyExistsException extends EntityGenericException {

    private static final String DEFAULT_CODE = "AlreadyExists";

    public EntityAlreadyExistsException(String message, String code) {
        super(message, code + DEFAULT_CODE);
    }
}
