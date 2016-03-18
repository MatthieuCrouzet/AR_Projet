package jus.aor.mobilagent.kernel;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

import com.sun.corba.se.impl.io.ObjectStreamClass;

public class AgentInputStream extends ObjectInputStream {

	public AgentInputStream(InputStream in, BAMAgentClassLoader classLoader) throws IOException {
		super(in);
		// TODO Auto-generated constructor stub
	}
	
	Class<_Agent> resolveClass(ObjectStreamClass osc){
		Class<_Agent> cl = null;
		
		// TODO 
		
		return cl;
	}
	
}
