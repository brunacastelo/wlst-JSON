package wlst.objects.beans;

import java.util.List;

public class Topic implements JmsModuleItem{

	private String name;
	private String subdeployment;
	private FileStore fileStore;
	private int messagingPerformancePreference;
	private int ttlOverride;
	private String deliveryModeOverride;
	private int redeliveryLimit;
	private List<Target> targets;

	public Topic(String name, String subdeployment, FileStore fileStore,int messagingPerformancePreference, int ttlOverride, String deliveryModeOverride,
			int redeliveryLimit, List<Target> targets) {
		this.name = name;
		this.subdeployment = subdeployment;
		this.setFileStore(fileStore);
		this.messagingPerformancePreference = messagingPerformancePreference;
		this.ttlOverride = ttlOverride;
		this.deliveryModeOverride = deliveryModeOverride;
		this.redeliveryLimit = redeliveryLimit;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubdeployment() {
		return subdeployment;
	}

	public void setSubdeployment(String subdeployment) {
		this.subdeployment = subdeployment;
	}

	public int getMessagingPerformancePreference() {
		return messagingPerformancePreference;
	}

	public void setMessagingPerformancePreference(int messagingPerformancePreference) {
		this.messagingPerformancePreference = messagingPerformancePreference;
	}

	public int getTtlOverride() {
		return ttlOverride;
	}

	public void setTtlOverride(int ttlOverride) {
		this.ttlOverride = ttlOverride;
	}

	public String getDeliveryModeOverride() {
		return deliveryModeOverride;
	}

	public void setDeliveryModeOverride(String deliveryModeOverride) {
		this.deliveryModeOverride = deliveryModeOverride;
	}

	public int getRedeliveryLimit() {
		return redeliveryLimit;
	}

	public void setRedeliveryLimit(int redeliveryLimit) {
		this.redeliveryLimit = redeliveryLimit;
	}

	public List<Target> getTargets() {
		return targets;
	}

	public void setTargets(List<Target> targets) {
		this.targets = targets;
	}

	public FileStore getFileStore() {
		return fileStore;
	}

	public void setFileStore(FileStore fileStore) {
		this.fileStore = fileStore;
	}
}
