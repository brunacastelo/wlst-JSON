package wlst.objects.beans;

public class ConnectionPool {

	private String url;
	private String driverClassName;
	private String dbUserName;
	private String dbPassword;
	private String testTableName;
	private int inCapacity;
	private int maxCapacity;
	private int incrementCapacity;
	private boolean testConnReserve;
	private int shrinkFrequency;
	private int connCreationRetryFrequency;
	private int maxWaitingConn;
	private int connReserveTimeout;
	private long inactiveConnectionTimeoutSeconds;
	
    private int maxCapacityInit;
    private int minCapacityInit;
    private int statmentCache; 
    private int testFrequencySecons;
	
				 
	public ConnectionPool(String url, String driverClassName, String dbUserName, String dbPassword, String testTableName, int inCapacity, int maxcapacity, int incrementCapacity, boolean testConnReserve, int shrinkFrequency,
			int connCreationRetryFrequency, int maxWaitingConn, int connReserveTimeout, long inactiveConnectionTimeoutSeconds, int maxCapacityInit, int minCapacityInit, int statmentCache, int testFrequencySecons) {
		super();
		this.url = url;
		this.driverClassName = driverClassName;
		this.dbUserName = dbUserName;
		this.dbPassword = dbPassword;
		this.testTableName = testTableName;
		this.inCapacity = inCapacity;
		this.maxCapacity = maxcapacity;
		this.incrementCapacity = incrementCapacity;
		this.testConnReserve = testConnReserve;
		this.shrinkFrequency = shrinkFrequency;
		this.connCreationRetryFrequency = connCreationRetryFrequency;
		this.maxWaitingConn = maxWaitingConn;
		this.connReserveTimeout = connReserveTimeout;
		this.setInactiveConnectionTimeoutSeconds(inactiveConnectionTimeoutSeconds);	
		this.maxCapacityInit = maxCapacityInit;
		this.minCapacityInit = minCapacityInit;
		this.statmentCache = statmentCache; 
		this.testFrequencySecons = testFrequencySecons;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDriverClassName() {
		return driverClassName;
	}

	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}

	public String getDbUserName() {
		return dbUserName;
	}

	public void setDbUserName(String dbUserName) {
		this.dbUserName = dbUserName;
	}

	public String getDbPassword() {
		return dbPassword;
	}

	public void setDbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
	}

	public String getTestTableName() {
		return testTableName;
	}

	public void setTestTableName(String testTableName) {
		this.testTableName = testTableName;
	}

	public int getInCapacity() {
		return inCapacity;
	}

	public void setInCapacity(int inCapacity) {
		this.inCapacity = inCapacity;
	}

	public int getMaxcapacity() {
		return maxCapacity;
	}

	public void setMaxcapacity(int maxcapacity) {
		this.maxCapacity = maxcapacity;
	}

	public int getIncrementCapacity() {
		return incrementCapacity;
	}

	public void setIncrementCapacity(int incrementCapacity) {
		this.incrementCapacity = incrementCapacity;
	}

	public boolean isTestConnReserve() {
		return testConnReserve;
	}

	public void setTestConnReserve(boolean testConnReserve) {
		this.testConnReserve = testConnReserve;
	}

	public int getShrinkFrequency() {
		return shrinkFrequency;
	}

	public void setShrinkFrequency(int shrinkFrequency) {
		this.shrinkFrequency = shrinkFrequency;
	}

	public int getConnCreationRetryFrequency() {
		return connCreationRetryFrequency;
	}

	public void setConnCreationRetryFrequency(int connCreationRetryFrequency) {
		this.connCreationRetryFrequency = connCreationRetryFrequency;
	}

	public int getMaxWaitingConn() {
		return maxWaitingConn;
	}

	public void setMaxWaitingConn(int maxWaitingConn) {
		this.maxWaitingConn = maxWaitingConn;
	}

	public int getConnReserveTimeout() {
		return connReserveTimeout;
	}

	public void setConnReserveTimeout(int connReserveTimeout) {
		this.connReserveTimeout = connReserveTimeout;
	}

	public long getInactiveConnectionTimeoutSeconds() {
		return inactiveConnectionTimeoutSeconds;
	}

	final void setInactiveConnectionTimeoutSeconds(long inactiveConnectionTimeoutSeconds) {
		this.inactiveConnectionTimeoutSeconds = inactiveConnectionTimeoutSeconds;
	}
	
	public void setMaxCapacityInit(int maxCapacityInit) {
		this.maxWaitingConn = maxCapacityInit;
	}

	public int getMaxCapacityInit() {
		return maxCapacityInit;
	}
	
	public void setMinCapacityInit(int minCapacityInit) {
		this.maxWaitingConn = minCapacityInit;
	}

	public int getMinCapacityInit() {
		return minCapacityInit;
	}
	
	public void setStatmentCache(int statmentCache) {
		this.statmentCache = statmentCache;
	}

	public int getStatmentCache() {
		return statmentCache;
	}
	
	public void setTestFrequencySecon(int testFrequencySecons) {
		this.testFrequencySecons = testFrequencySecons;
	}

	public int getTestFrequencySecon() {
		return testFrequencySecons;
	}

}
