package wlst.objects.beans;

import java.util.List;

public interface JmsModuleItem {

	Object getSubdeployment();
	List<Target> getTargets();
	String getName();
	void setSubdeployment(String subdeployment);

}
