package wlst.objects.beans;

import java.util.List;

public class Bridge {

	private String name;
	private String qualityOfService;
	private String started;
	private String targetOri;
	private String targetDest;
	private String selector;
	private String preserveMsgProperty;
	private List<Target> targets;
	private List<BridgeTarget> bridgeTargets;
	public Bridge(String name, String qualityOfService, String started, String selector, String targetOri, String targetDest,
			String preserveMsgProperty, List<Target> targets, List<BridgeTarget> bridgeTargets) {
		super();
		this.name = name;
		this.qualityOfService = qualityOfService;
		this.started = started;
		this.targetOri = targetOri;
		this.targetDest = targetDest;
		this.preserveMsgProperty = preserveMsgProperty;
		this.targets = targets;
		this.bridgeTargets = bridgeTargets;
		this.setSelector(selector);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getQualityOfService() {
		return qualityOfService;
	}
	public void setQualityOfService(String qualityOfService) {
		this.qualityOfService = qualityOfService;
	}
	public String getStarted() {
		return started;
	}
	public void setStarted(String started) {
		this.started = started;
	}
	public String getTargetOri() {
		return targetOri;
	}
	public void setTargetOri(String targetOri) {
		this.targetOri = targetOri;
	}
	public String getTargetDest() {
		return targetDest;
	}
	public void setTargetDest(String targetDest) {
		this.targetDest = targetDest;
	}
	public String getPreserveMsgProperty() {
		return preserveMsgProperty;
	}
	public void setPreserveMsgProperty(String preserveMsgProperty) {
		this.preserveMsgProperty = preserveMsgProperty;
	}
	public List<Target> getTargets() {
		return targets;
	}
	public void setTargets(List<Target> targets) {
		this.targets = targets;
	}
	public List<BridgeTarget> getBridgeTargets() {
		return bridgeTargets;
	}
	public void setBridgeTargets(List<BridgeTarget> bridgeTargets) {
		this.bridgeTargets = bridgeTargets;
	}
	public String getSelector() {
		return selector;
	}
	public void setSelector(String selector) {
		this.selector = selector;
	}
	
	
	
}
