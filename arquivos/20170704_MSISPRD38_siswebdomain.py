def CriarJdbcStore(name, prefixName, target, dataSource):
	print ('Criando JdbcStore: ' + name )
	cd('/')
	create(name,'JdbcStore')
	cd('JdbcStore/'+name)
	set('PrefixName',prefixName)
	set('Target',target)
	DataSource('Target',dataSource)

def CriarFila(type, moduleName, name, jndiName, subdeployment, priorityDestinationKey):
	print ('Criando Fila: ' + name )
	cd('/')
	cd('JMSSystemResources/' + moduleName + '/JMSResource/'+ moduleName)
	if (type == 'QUEUE'):
		myq=create(name,'Queue')
	else:
		myq=create(name,'UniformDistributedQueue')
	myq.setJNDIName(jndiName)
	myq.setSubDeploymentName(subdeployment)
	if (priorityDestinationKey != 'null'):
		myq.setDestinationKeys(jarray.array([String(priorityDestinationKey)],String))

def CriarDeliveryfailure(moduleName, type, queueName, destinationKey, redeliveryDelay, redeliveryLimit):
	print ('Criando Deliveryfailure para a fila: ' + queueName )
	if (type == 'QUEUE'):
		cd('Queues/' + queueName)
		cmo = cd('DeliveryFailureParams/' + queueName)
		cmo.setRedeliveryLimit(redeliveryLimit)
		cmo.setExpirationPolicy('Redirect')
		
		cmo.setErrorDestination(getMBean('/JMSSystemResources/'+moduleName+'/JMSResource/'+moduleName+'/Queues/'+destinationKey))
		cd('..')
		cd('..')
		cmo = cd('DeliveryParamsOverrides/' + queueName)
		cmo.setRedeliveryDelay(redeliveryDelay)
	else:
		cd('UniformDistributedQueues/' + queueName)
		cmo = cd('DeliveryFailureParams/' + queueName)
		cmo.setRedeliveryLimit(redeliveryLimit)
		cmo.setExpirationPolicy('Redirect')
		print ('cmo.setErrorDestination(getMBean(''/JMSSystemResources/'+moduleName+'/JMSResource/'+moduleName+'/UniformDistributedQueues/'+destinationKey+'))')
		cmo.setErrorDestination(getMBean('/JMSSystemResources/'+moduleName+'/JMSResource/'+moduleName+'/UniformDistributedQueues/'+destinationKey))
		cd('..')
		cd('..')
		cmo = cd('DeliveryParamsOverrides/' + queueName)
		cmo.setRedeliveryDelay(redeliveryDelay)
	

def CriarAdminServer(name, port, sslPort):
	print ('Criando AdminServer: ' + name )
	cd('Servers/'+name)
	set('ListenPort',port)
	cd('SSL/AdminServer')
	set('Enabled','True')
	set('ListenPort',sslPort)

def CriarCluster(name, multicastAddress, port, address):
	print ('Criando Cluster: ' + name )
	cd('/')
	create(name,'Cluster')
	cd('Clusters/'+name)
	if (multicastAddress != 'null'):
		set('MulticastAddress',multicastAddress)
	if (port != 0):
		set('MulticastPort',port)
	if (address != 'null'):
		set('ClusterAddress',address)

def CriarFileStore(name, path, target, targetType):
	print ('Criando FileStore: ' + name )
	cd('/')
	create(name,'FileStore')
	cd('FileStores/'+name)
	set('Directory',path)
	set('Targets',jarray.array([ObjectName('com.bea:Name='+target+',Type='+targetType)], ObjectName))

def CriarJmsServer(name, persistentStore, target, targetType):
	print ('Criando JmsServer: ' + name )
	cd('/')
	create(name,'JMSServer')
	cd('JMSServers/'+name)
	set('PersistentStore',ObjectName('com.bea:Name='+persistentStore+',Type=FileStore'))
	set('Targets',jarray.array([ObjectName('com.bea:Name='+target+',Type='+targetType)], ObjectName))

def CriarTopic(moduleName, name, subdeployment, redeliveryDelay, redeliveryLimit):
	print ('Criando Topic: ' + name )
	cd('/')
	cd('JMSSystemResources/' + moduleName + '/JMSResource/' + moduleName)
	top=create(name,'Topic')
	top.setJNDIName(name)
	top.setSubDeploymentName(subdeployment)
	cd('Topics/' + name)
	cd('DeliveryFailureParams/' + name)
	set('RedeliveryLimit',redeliveryLimit)
	cd('..')
	cd('..')
	cd('DeliveryParamsOverrides/' + name)
	set('RedeliveryDelay', redeliveryDelay)

def CriarPriorityDestinationKey(moduleName, name, sortKey, keyType, direction):
	print ('Criando Priority Destination Key: ' + name )
	cd('/')
	cd('JMSSystemResources/' + moduleName + '/JMSResource/' + moduleName)
	create(name,'DestinationKey')
	cd('DestinationKeys/' + name)
	set('Property',sortKey)
	set('KeyType',keyType)
	set('SortOrder',direction)

def CriarManagedServer(name, port, address, machine, cluster):
	print ('Criando Managed Server: ' + name )
	cd('/')
	create(name,'Server')
	cd('Servers/' + name)
	set('ListenPort',port)
	if (cluster != 'null'):
		cmo.setMachine (getMBean('/Machines/' + machine))
	set('ListenAddress',address)
	if (cluster != 'null'):
		cmo.setCluster (getMBean('/Clusters/' + cluster))

def CriarDatasource(jndiName):
	print ('Criando Datasource: ' + jndiName )
	cd('/')
	varDataSource=create(jndiName,'JDBCSystemResource')
	cd('JDBCSystemResources/' + jndiName + '/JDBCResource/' + jndiName)
	set('Name',jndiName)

def CriarJmsModule(name):
	print ('Criando JmsModulo: ' + name )
	cd('/')
	create(name,'JMSSystemResource')
	cd('JMSSystemResources/' + name)

def CriarConnectionfactory(moduleName, name, jndiName, reconnectPolicy, maxMessagesPerSession, isServerAffinityEnabled, isXAConnectionFactoryEnabled, sendTimeout):
	print ('Criando Connection Factory: ' + name )
	cd('/')
	cd('JMSSystemResources/' + moduleName + '/JMSResource/' + moduleName)
	create(name,'ConnectionFactory')
	cd('ConnectionFactories/' + jndiName)
	set('JNDIName',jndiName)
	set('DefaultTargetingEnabled','true')
	cd('ClientParams/' + jndiName)
	set('ReconnectPolicy',reconnectPolicy)
	set('MessagesMaximum',maxMessagesPerSession)
	cd('/')
	cd('JMSSystemResources/' + moduleName + '/JMSResource/' + moduleName)
	cd('ConnectionFactories/' + jndiName)
	cd('LoadBalancingParams/' + jndiName)
	set('ServerAffinityEnabled',isServerAffinityEnabled)
	cd('/')
	cd('JMSSystemResources/' + moduleName + '/JMSResource/' + moduleName)
	cd('ConnectionFactories/' + jndiName)
	cd('TransactionParams/' + jndiName)
	set('XAConnectionFactoryEnabled',isXAConnectionFactoryEnabled)
	cd('/')
	cd('JMSSystemResources/' + moduleName + '/JMSResource/' + moduleName)
	cd('ConnectionFactories/' + jndiName)
	cd('DefaultDeliveryParams/' + jndiName)
	set('SendTimeout',sendTimeout)

def CriarConnectionPool(datasourceName, driverClassName, url, dbPassword, dbUsername, inCapacity, maxCapacity, incrementCapacity, isTestConnReserve, testTableName, shrinkFrequency, connCreationRetryFrequency, incativeConnectionTimeoutSeconds, connReserveTimeout, maxCapacityInit, minCapacityInit, statementCache, testFrequency, supportsGlobal):
	print ('Criando Connection Pool para datasource: ' + datasourceName )
	cd('JDBCDriverParams/' + datasourceName)
	set('DriverName',driverClassName)
	set('Url',url)
	set('PasswordEncrypted',dbPassword)
	cd('Properties/' + datasourceName)
	create('user','Property')
	cd('Properties/user')
	cmo.setValue(dbUsername)
	cd('/JDBCSystemResources/' + datasourceName + '/JDBCResource/' + datasourceName)
	cd('JDBCDataSourceParams/' + datasourceName)
	set('JNDINames',jarray.array([String(datasourceName)], String))
	if (supportsGlobal == 'true'):
		set('GlobalTransactionsProtocol', java.lang.String('None'))
	else:
		set('GlobalTransactionsProtocol', java.lang.String('LoggingLastResource'))
	cd('/JDBCSystemResources/' + datasourceName + '/JDBCResource/' + datasourceName)
	cd('JDBCConnectionPoolParams/' + datasourceName)
	set('InitialCapacity',inCapacity)
	set('MaxCapacity',maxCapacity)
	set('MinCapacity',minCapacityInit)
	set('StatementCacheSize',statementCache)
	set('TestFrequencySeconds',testFrequency)
	set('HighestNumWaiters',maxCapacity)
	set('CapacityIncrement',incrementCapacity)
	set('TestConnectionsOnReserve',isTestConnReserve)
	set('TestTableName',testTableName)
	set('ShrinkFrequencySeconds',shrinkFrequency)
	set('ConnectionCreationRetryFrequencySeconds',connCreationRetryFrequency)
	if (incativeConnectionTimeoutSeconds != 0):
		set('InactiveConnectionTimeoutSeconds',incativeConnectionTimeoutSeconds)
	set('ConnectionReserveTimeoutSeconds',connReserveTimeout)
	if(datasourceName == 'sis.TempDataSource'):
		cd('/JDBCSystemResources/'+datasourceName+'/JDBCResource/'+datasourceName+'/JDBCXAParams/'+datasourceName)
		set('XaSetTransactionTimeout', 'true')
		cmo.setXaTransactionTimeout(600)

def CriarSubDeployment(name, subName):
	print ('Criando SubDeployment: ' + name )
	cd('/')
	cd('JMSSystemResources/' + name)
	create(subName,'SubDeployment')
	cd('SubDeployments/' + subName)

def CriarTemplate(moduleName, templateName, templateDestinationKey):
	print ('Criando Template: ' + moduleName )
	cd('/')
	cd('JMSSystemResources/' + moduleName + '/JMSResource/'+ moduleName)
	create(templateName,'Template')
	cd('Templates/' + templateName)
	set('DestinationKeys',jarray.array([String(templateDestinationKey)], String))

def CriarWorkManager(workManagerName, domainName):
	print ('Criando WorkManager: ' + workManagerName )
	cd('/')
	name = get('Name')
	cd('SelfTuning/' + name)
	create(workManagerName,'WorkManager')
	cd('WorkManagers/' + workManagerName)
	cmo.setMinThreadsConstraint(getMBean('/SelfTuning/' + name + '/MinThreadsConstraints/' + workManagerName + 'MinThreads'))
	cmo.setMaxThreadsConstraint(getMBean('/SelfTuning/' + name + '/MaxThreadsConstraints/' + workManagerName + 'MaxThreads'))

def CriarWorkManagerMinThread(workManagerName, domainName, minCount):
	print ('Criando WorkManager: ' + workManagerName + 'MinThreads' )
	cd('/')
	name = get('Name')
	cd('SelfTuning/' + name)
	create(workManagerName+'MinThreads','MinThreadsConstraint')
	cd('MinThreadsConstraints/' + workManagerName+'MinThreads')
	cmo.setCount(int(minCount))

def CriarWorkManagerMaxThread(workManagerName, domainName, maxCount):
	print ('Criando WorkManager: ' + workManagerName + 'MaxThreads' )
	cd('/')
	name = get('Name')
	cd('SelfTuning/' + name)
	create(workManagerName+'MaxThreads','MaxThreadsConstraint')
	cd('MaxThreadsConstraints/' + workManagerName+'MaxThreads')
	cmo.setCount(int(maxCount))

def CriarBridgeTarget(name, adapterJNDIName, connectionFactoryJNDIName, connectionURL, userName, userPassword, destinationJNDIName):
	print ('Criando CriarBridgeTarget: ' + name )
	cd('/')
	cd('JMSBridgeDestinations')
	create(name)
	cd(name)
	set('AdapterJNDIName', adapterJNDIName)
	set('ConnectionFactoryJNDIName', connectionFactoryJNDIName)
	set('ConnectionURL', connectionURL)
	set('DestinationJNDIName', destinationJNDIName)
	if (userName != 'null'):
		set('UserName', userName)
	if (userPassword != 'null'):
		set('UserPassword', userPassword)

def CriarBridge(name, qualityOfService, started, selector, targetOri, targetDest, preserveMsgProperty):
	print ('Criando CriarBridge: ' + name )
	cd('/')
	cd('MessagingBridges')
	create(name)
	cd(name)
	set('QualityOfService', qualityOfService)
	set('Started', started)
	if (selector != 'null'):
		set('Selector', selector)
	set('PreserveMsgProperty', preserveMsgProperty)
	cmo.setSourceDestination(getMBean('/JMSBridgeDestinations/' + targetOri))
	cmo.setTargetDestination(getMBean('/JMSBridgeDestinations/' + targetDest))

connect('weblogic', 'welcome1', 'localhost:7001')
edit()
startEdit()
save()
activate()
exit()
