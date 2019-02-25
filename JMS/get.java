import javax.jms.*;
import javax.naming.*;
import java.util.Hashtable;

class Get{
	public static void main(String[] args) throws Exception{
		// create hashtable connection with jndi
		Hashtable<Object,String> ht = new Hashtable<Object,String>();
		ht.put(Context.INITIAL_CONTEXT_FACTORY,"weblogic.jndi.WLInitialContextFactory");
		ht.put(Context.PROVIDER_URL,"t3://localhost:7001");
		
		//create context for accessing lookups in server
		Context ctx = new InitialContext(ht);
		QueueConnectionFactory qcf = (QueueConnectionFactory)ctx.lookup("MY_CF");
		Queue queue = (Queue)ctx.lookup("MY_Q");
		
		QueueConnection con = qcf.createQueueConnection(); //like Connection in JDBC
		
		// compulsory while receiving messages
		con.start();
		
		// create session
		// false if no transaction
		// true if any transaction
		QueueSession session = con.createQueueSession(false,Session.AUTO_ACKNOWLEDGE); // PreparedStatement
		
		// create sender/receiver from session to send receive messages
		QueueReceiver rcv = session.createReceiver(queue); 
		
		// TextMessage stores the message from QueueReceiver while waiting for 3000ms max 
		TextMessage msg = (TextMessage)rcv.receive(3000);
		System.out.println(msg.getText());		
		
		session.close();
		con.close();
	}
}