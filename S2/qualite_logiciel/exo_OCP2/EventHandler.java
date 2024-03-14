package qualite_logiciel.exo_OCP2;

public class EventHandler {

	private Object entity;
	private EventInterceptor ei;
	
	public EventHandler(Object entity, EventInterceptor ei) {
		this.entity = entity;
		this.ei = ei;
	}
	
	public void handleEvent(Event event) {
		event.handle(ei, entity);
	}

}
