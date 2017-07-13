package wlst.objects.beans;

import java.util.List;

public class Queue implements JmsModuleItem {

	private String jndiName;
	private String subdeployment;
	private String template;
	private DeliveryFailure deliveryFailure;
	private String destinationKeys;
	private PriorityDestinationKey priorityDestinationKey;
	private List<Target> targets;
	private String name;
	
	public Queue(String jndiName, String subdeployment, String template,
			String destinationKeys, DeliveryFailure deliveryFailure, PriorityDestinationKey priorityDestinationKey,  List<Target> targets, String name) {
		super();
		this.jndiName = jndiName;
		this.subdeployment = subdeployment;
		this.template = template;
		this.deliveryFailure = deliveryFailure;
		this.destinationKeys = destinationKeys;
		this.priorityDestinationKey = priorityDestinationKey;
		this.targets = targets;
		this.name = name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getJndiName() {
		return jndiName;
	}

	public void setJndiName(String jndiName) {
		this.jndiName = jndiName;
	}

	public String getSubdeployment() {
		return subdeployment;
	}

	public void setSubdeployment(String subdeployment) {
		this.subdeployment = subdeployment;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public PriorityDestinationKey getPriorityDestinationKey() {
		return priorityDestinationKey;
	}

	public void setPriorityDestinationKey(PriorityDestinationKey priorityDestinationKey) {
		this.priorityDestinationKey = priorityDestinationKey;
	}

	public String getDestinationKeys() {
		return destinationKeys;
	}

	public void setDestinationKeys(String destinationKeys) {
		this.destinationKeys = destinationKeys;
	}
	
	public DeliveryFailure getDeliveryFailure() {
		return deliveryFailure;
	}

	public void setDeliveryFailure(DeliveryFailure deliveryFailure) {
		this.deliveryFailure = deliveryFailure;
	}

	@Override
	public List<Target> getTargets() {
		return this.targets;
	}

	@Override
	public String getName() {
		if (this.name != null) {
			return this.name;
		}
		return this.getJndiName();
	}

}
