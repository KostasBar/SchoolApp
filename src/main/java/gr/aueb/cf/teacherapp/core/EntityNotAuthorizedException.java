package gr.aueb.cf.teacherapp.core;

public class EntityNotAuthorizedException extends EntityGenericException{
    private static final String DEFAULT_CODE = "NotAuthorized";

    public EntityNotAuthorizedException(String message, String code) {
        super(message, code + DEFAULT_CODE);
    }
}
