import javax.jms.*;
import javax.naming.*;
import java.util.Hashtable;

class Put{
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
		
		// create session
		// false if no transaction
		// true if any transaction
		QueueSession session = con.createQueueSession(false,Session.AUTO_ACKNOWLEDGE); // PreparedStatement
		
		// create sender/receiver from session to send receive messages
		QueueSender sender = session.createSender(queue); 
		
		// type of message to send/receive
		TextMessage msg = session.createTextMessage();
		
		msg.setText(args[0]);
		
		sender.send(msg);		
		
		session.close();
		con.close();
	}
}