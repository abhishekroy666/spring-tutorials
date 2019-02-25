import javax.jms.*;
import javax.naming.*;
import java.util.Hashtable;

class Pub{
	public static void main(String[] args) throws Exception{
		// create hashtable connection with jndi
		Hashtable<Object,String> ht = new Hashtable<Object,String>();
		ht.put(Context.INITIAL_CONTEXT_FACTORY,"weblogic.jndi.WLInitialContextFactory");
		ht.put(Context.PROVIDER_URL,"t3://localhost:7001");
		
		//create context for accessing lookups in server
		Context ctx = new InitialContext(ht);
		TopicConnectionFactory tcf = (TopicConnectionFactory)ctx.lookup("MY_CF");
		Topic topic = (Topic)ctx.lookup("MY_T");
		
		TopicConnection con = tcf.createTopicConnection(); //like Connection in JDBC
		
		// create session
		// false if no transaction
		// true if any transaction
		TopicSession session = con.createTopicSession(false,Session.AUTO_ACKNOWLEDGE); // PreparedStatement
		
		// create publisher from session to send receive messages
		TopicPublisher pub = session.createPublisher(topic); 
		
		// type of message to send/receive
		TextMessage msg = session.createTextMessage();
		
		msg.setText(args[0]);
		
		pub.publish(msg);	
		
		session.close();
		con.close();
	}
}