package wlst.objects.beans;

import java.util.List;

public class DefaultQueue {

	private List<String> queues;
	private String subdeployment;
	private String template;
	private DeliveryFailure deliveryFailure;
	private String destinationKeys;
	private PriorityDestinationKey priorityDestinationKey;
	private List<Target> targets;
	
	public DefaultQueue(List<String> queues, String subdeployment, String template,
			String destinationKeys, DeliveryFailure deliveryFailure, PriorityDestinationKey priorityDestinationKey,  List<Target> targets) {
		this.queues = queues;
		this.subdeployment = subdeployment;
		this.template = template;
		this.deliveryFailure = deliveryFailure;
		this.destinationKeys = destinationKeys;
		this.priorityDestinationKey = priorityDestinationKey;
		this.targets = targets;
	}

	public List<String> getQueues() {
		return queues;
	}

	public void setQueues(List<String> queues) {
		this.queues = queues;
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

	public List<Target> getTargets() {
		return this.targets;
	}
}
