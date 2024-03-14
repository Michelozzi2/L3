package qualite_logiciel.exo_OCP2;

public class PreSave extends Event {

	public PreSave() {
		super("preSave");
	}

	@Override
	public void handle(EventInterceptor ei, Object entity) {
		ei.preSave(entity);
	}

}
