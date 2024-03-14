package qualite_logiciel.exo_OCP2;

public class PostLoad extends Event {

	public PostLoad() {
		super("PostLoad");
	}

	@Override
    public void handle(EventInterceptor ei, Object entity) {
        ei.preLoad(entity);
    }

}
