package qualite_logiciel.exo_OCP2;

public class EventInterceptor {
	
	public void preLoad(Object entity) {
		System.out.println("preLoad de l'objet "+ entity);
	}
	public void postLoad(Object entity) {
		System.out.println("postLoad de l'objet "+ entity);		
	}
	public void prePersist(Object entity) {
		System.out.println("prePersist de l'objet"+ entity);		
	}
	public void preSave(Object entity) {
		System.out.println("preSave de l'objet "+ entity);
		
	}
	public void postPersist(Object entity) {
		System.out.println("postPersist de l'objet"+ entity);
		
	}
}
