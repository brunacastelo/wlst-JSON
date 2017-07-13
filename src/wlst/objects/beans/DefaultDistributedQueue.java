package wlst.objects.beans;

import java.util.List;

public class DefaultDistributedQueue extends DefaultQueue {
	public DefaultDistributedQueue(List<String> queues, String subdeployment, String template,
			String destinationKeys, DeliveryFailure deliveryFailure, PriorityDestinationKey priorityDestinationKey,  List<Target> targets) {
		super(queues, subdeployment, template, destinationKeys, deliveryFailure, priorityDestinationKey, targets);
	}
}
