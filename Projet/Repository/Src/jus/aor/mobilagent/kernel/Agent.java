package jus.aor.mobilagent.kernel;

import java.net.URI;

public class Agent implements _Agent {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4052850661849944954L;
	protected Route route;
	protected AgentServer agentServer;
	private String serverName;
	protected BAMAgentClassLoader bamA;
	protected Jar jar;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		if(this.route.hasNext()){
			Etape next = this.route.next();
			next.execute();
			if(this.route.hasNext()){
				this.move(this.route.get().server);
			}
		}
	}

	protected void move(URI destination) {
		
	}

	@Override
	public void addEtape(Etape etape) {
		// TODO Auto-generated method stub
		route.add(etape);
	}

	@Override
	public void init(AgentServer agentServer, String serverName) {
		// TODO Auto-generated method stub
		this.agentServer = agentServer;
		this.setName(serverName);
	}

	@Override
	public void reInit(AgentServer server, String serverName) {
		// TODO Auto-generated method stub
		this.agentServer = server;
		this.setName(serverName);
	}

	public String getName() {
		return serverName;
	}

	public void setName(String serverName) {
		this.serverName = serverName;
	}

	
}
