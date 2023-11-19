package s5.webfinal.exception;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(Class<?> entity) {
        super(entity.getSimpleName() + " no se encuentra en nuestros registros");
    }
}
