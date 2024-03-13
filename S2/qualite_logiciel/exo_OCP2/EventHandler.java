package qualite_logiciel.exo_OCP2;

public class EventHandler {

	private Object entity;
	private EventInterceptor ei;
	
	public EventHandler(Object entity, EventInterceptor ei) {
		this.entity = entity;
		this.ei = ei;
	}
	
	public void handleEvent(Event event) {
		if (event instanceof PreLoad) {
			ei.preLoad(entity);
		} else if (event instanceof PostLoad) {
			ei.postLoad(entity);
		} else if (event instanceof PrePersist) {
			ei.prePersist(entity);
		} else if (event instanceof PreSave) {
			ei.preSave(entity);
		} else if (event instanceof PostPersist) {
			ei.postPersist(entity);
		} 
	}

}
