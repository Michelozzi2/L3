package qualite_logiciel.exo_OCP2;

public class PreLoad extends Event {

	public PreLoad() {
		super("preLoad");
	}

	@Override
	public void handle(EventInterceptor ei, Object entity) {
		ei.preLoad(entity);
	}

}
