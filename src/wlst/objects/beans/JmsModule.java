package wlst.objects.beans;

import java.util.List;

public class JmsModule {

	private String name;
	private List<Target> targets;
	private List<ConnectionFactory> connectionFactories;
	private List<Subdeployment> subdeployments;
	private PriorityDestinationKey priorityDestinationKey;
	private List<Topic> topics;
	private List<DistributedQueue> distributedQueues;
	private List<Queue> queues;
	private Template template;
	private List<DefaultQueue> defaultQueues;
	private List<DefaultDistributedQueue> defaultDistributedQueues;

	public JmsModule(String name, List<Target> targets, List<ConnectionFactory> connectionFactories, List<Subdeployment> subdeployments, PriorityDestinationKey priorityDestinationKey, List<Topic> topics, List<DistributedQueue> distributedQueues,
			List<Queue> queues, Template template, List<DefaultQueue> defaultQueues, List<DefaultDistributedQueue> defaultDistributedQueues) {
		super();
		this.name = name;
		this.targets = targets;
		this.connectionFactories = connectionFactories;
		this.subdeployments = subdeployments;
		this.priorityDestinationKey = priorityDestinationKey;
		this.topics = topics;
		this.distributedQueues = distributedQueues;
		this.queues = queues;
		this.template = template;
		this.setDefaultQueues(defaultQueues);
		this.setDefaultDistributedQueues(defaultDistributedQueues);
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

	public List<ConnectionFactory> getConnectionFactories() {
		return connectionFactories;
	}

	public void setConnectionFactories(List<ConnectionFactory> connectionFactories) {
		this.connectionFactories = connectionFactories;
	}

	public List<Subdeployment> getSubdeployments() {
		return subdeployments;
	}

	public void setSubdeployments(List<Subdeployment> subdeployments) {
		this.subdeployments = subdeployments;
	}

	public PriorityDestinationKey getPriorityDestinationKey() {
		return priorityDestinationKey;
	}

	public void setPriorityDestinationKey(PriorityDestinationKey priorityDestinationKey) {
		this.priorityDestinationKey = priorityDestinationKey;
	}

	public List<Topic> getTopics() {
		return topics;
	}

	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}

	public List<DistributedQueue> getDistributedQueues() {
		return distributedQueues;
	}

	public void setDistributedQueues(List<DistributedQueue> distributedQueues) {
		this.distributedQueues = distributedQueues;
	}

	public List<Queue> getQueues() {
		return queues;
	}

	public void setQueues(List<Queue> queues) {
		this.queues = queues;
	}

	public Template getTemplate() {
		return template;
	}

	public void setTemplate(Template template) {
		this.template = template;
	}

	public List<DefaultQueue> getDefaultQueues() {
		return defaultQueues;
	}

	public void setDefaultQueues(List<DefaultQueue> defaultQueues) {
		this.defaultQueues = defaultQueues;
	}

	public List<DefaultDistributedQueue> getDefaultDistributedQueues() {
		return defaultDistributedQueues;
	}

	public void setDefaultDistributedQueues(List<DefaultDistributedQueue> defaultDistributedQueues) {
		this.defaultDistributedQueues = defaultDistributedQueues;
	}
}
