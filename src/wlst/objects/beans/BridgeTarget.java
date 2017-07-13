package wlst.objects.beans;

public class BridgeTarget {

	private String name;
	private String userName;
	private String userPassword;
	private String destinationJNDIName;
	private String adapterJNDIName;
	private String connectionFactoryJNDIName;
	private String connectionURL;
	public BridgeTarget(String name, String userName, String userPassword, String destinationJNDIName,
			String adapterJNDIName, String connectionFactoryJNDIName, String connectionURL) {
		super();
		this.name = name;
		this.userName = userName;
		this.userPassword = userPassword;
		this.destinationJNDIName = destinationJNDIName;
		this.adapterJNDIName = adapterJNDIName;
		this.connectionFactoryJNDIName = connectionFactoryJNDIName;
		this.connectionURL = connectionURL;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getDestinationJNDIName() {
		return destinationJNDIName;
	}
	public void setDestinationJNDIName(String destinationJNDIName) {
		this.destinationJNDIName = destinationJNDIName;
	}
	public String getAdapterJNDIName() {
		return adapterJNDIName;
	}
	public void setAdapterJNDIName(String adapterJNDIName) {
		this.adapterJNDIName = adapterJNDIName;
	}
	public String getConnectionFactoryJNDIName() {
		return connectionFactoryJNDIName;
	}
	public void setConnectionFactoryJNDIName(String connectionFactoryJNDIName) {
		this.connectionFactoryJNDIName = connectionFactoryJNDIName;
	}
	public String getConnectionURL() {
		return connectionURL;
	}
	public void setConnectionURL(String connectionURL) {
		this.connectionURL = connectionURL;
	}
	
	
}
