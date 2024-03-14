package qualite_logiciel.exo_OCP2;

public class PrePersist extends Event {

	public PrePersist() {
		super("prePersist");
	}

	@Override
	public void handle(EventInterceptor ei, Object entity) {
		ei.prePersist(entity);
	}

}
