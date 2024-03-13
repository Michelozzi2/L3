package qualite_logiciel.exo_OCP2;

public class testOcp2 {

	public static void main(String[] args) {
		String objetTest="Bonjour";
		EventInterceptor ei=new EventInterceptor();
		EventHandler eh=new  EventHandler(objetTest, ei);
		eh.handleEvent(new PreLoad());
		eh.handleEvent(new PostLoad());
	}

}
