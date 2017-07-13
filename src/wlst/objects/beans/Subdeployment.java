package wlst.objects.beans;

import java.util.List;

public class Subdeployment {

	private String name;
	private List<Target> targets;
	private List<JmsServer> jmsServers;

	public Subdeployment(String name, List<Target> targets, List<JmsServer> jmsServers) {
		super();
		this.name = name;
		this.targets = targets;
		this.jmsServers = jmsServers;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Target> getTargets() {
		return targets;
	}

	public void setTargets(List<Target> target) {
		this.targets = target;
	}

	public List<JmsServer> getJmsServers() {
		return jmsServers;
	}

	public void setJmsServers(List<JmsServer> jmsServer) {
		this.jmsServers = jmsServers;
	}

}
