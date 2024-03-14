package qualite_logiciel.exo_OCP2;

public class PostPersist extends Event {

	public PostPersist() {
		super("postPersist");
	}

	@Override
	public void handle(EventInterceptor ei, Object entity) {
		ei.postPersist(entity);
	}

}
