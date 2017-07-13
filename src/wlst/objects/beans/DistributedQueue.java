package wlst.objects.beans;

import java.util.List;

public class DistributedQueue extends Queue {

	public DistributedQueue(String jndiName, String subdeployment,
			String template, DeliveryFailure deliveryFailure,
			String destinationKeys, PriorityDestinationKey priorityDestinationKey,  List<Target> targets, String name) {
		super(jndiName, subdeployment, template, destinationKeys, deliveryFailure, priorityDestinationKey, targets, name);
	}
}
