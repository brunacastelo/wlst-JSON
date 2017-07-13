package main.deprecated;

public class CreateJSON {
	
	final static String lineSeparator = System.getProperty("line.separator");
	
	private static final String[] QUEUES = {"NetworkConnectorOut","NetworkSupervisorDetail","ProvisioningSupervisorDetail"};
	private static final String[] DISTRIBUTED_QUEUES = {"db.ConnectorOut","EventHistory","expediter.OnlineConnectorIn","expediter.OnlineConnectorOut","expediter_velox.OnlineConnectorIn","expediter_velox.OnlineConnectorOut","gos.OnlineConnectorIn","gos.OnlineConnectorOut","loader.OnlineConnectorIn","loader.OnlineConnectorOut","m2m.OnlineConnectorIn","m2m.OnlineConnectorOut","mesox.OnlineConnectorIn","mesox.OnlineConnectorOut","mesox.OnlineConnectorOut_mesoxba","mesox.OnlineConnectorOut_mesoxce","mesox.OnlineConnectorOut_mesoxmg","mesox.OnlineConnectorOut_mesoxpe","mesox.OnlineConnectorOut_mesoxrj","NetworkIn","NetworkNalReturnProcessor","NetworkPendantBatchReplyItem","NetworkReceivedBatchReplyItem","NetworkReplyAlternativeAggregation","NetworkReplyAlternative","NetworkReplyDefaultAggregation","NetworkReplyDefault","NetworkReply","NetworkSupervisorDetail","oms.r2.OnlineConnectorIn","oms.r2.OnlineConnectorOut","ProvisionerInAlternative","ProvisionerInDefault","ProvisionerIn","ProvisionerOut","ProvisioningSupervisorDetail","sac.r2.OnlineConnectorIn","sac.r2.OnlineConnectorOut","sac-soa.OnlineConnectorIn","sac-soa.OnlineConnectorOut","soa.OnlineConnectorIn","soa.OnlineConnectorOut","som.OnlineConnectorIn","som.OnlineConnectorOut","vas.OnlineConnectorIn","vas.OnlineConnectorOut","wli.OnlineConnectorIn","wli.OnlineConnectorOut","wms.OnlineConnectorIn","wms.OnlineConnectorOut","WorkflowDefinition","xdsl.OnlineConnectorIn","xdsl.OnlineConnectorOut"};
	private static final String[] TOPICS = {"MonConnectors","SupervisorToMonitorNetwork","SupervisorToMonitorProvisioning"};


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StringBuilder queues =  new StringBuilder();
		createFileStoreJSON(queues, QUEUES);
		queues.append(lineSeparator).append(lineSeparator);
		createJMSServerJSON(queues, QUEUES);
		queues.append(lineSeparator).append(lineSeparator);
		createSubdeploymenJSON(queues, QUEUES);
		
		System.out.println(queues.toString());
		
		StringBuilder distributedQueues =  new StringBuilder();
		
		StringBuilder topics =  new StringBuilder();
	}


	private static void createFileStoreJSON(StringBuilder queues, String[] objects) {
		for(String queue : objects){
			queues.append("{").append(lineSeparator);
			queues.append("\"name\":").append("\"FileStore_").append(queue.replaceAll("\\.", "_")).append("DLQ\"").append(",").append(lineSeparator);
			queues.append("\"path\":").append("./FileStore").append(",").append(lineSeparator);
			queues.append("\"target\":").append("\"sisdx02a\"").append(lineSeparator);
			queues.append("}").append(",").append(lineSeparator);
			queues.append("{").append(lineSeparator);
			queues.append("\"name\":").append("\"FileStore_").append(queue.replaceAll("\\.", "_")).append("Queue\"").append(",").append(lineSeparator);
			queues.append("\"path\":").append("./FileStore").append(",").append(lineSeparator);
			queues.append("\"target\":").append("\"sisdx02a\"").append(lineSeparator);
			queues.append("}").append(",").append(lineSeparator);
		}
	}
	
	private static void createJMSServerJSON(StringBuilder queues, String[] objects) {
		for(String queue : objects){
			queues.append("{").append(lineSeparator);
			queues.append("\"name\":").append("\"JMSServer_").append(queue.replaceAll("\\.", "_")).append("DLQ").append("\"").append(",").append(lineSeparator);
			queues.append("\"persistentStore\":").append("\"FileStore_").append(queue.replaceAll("\\.", "_")).append("DLQ").append("\"").append(",").append(lineSeparator);
			queues.append("\"target\":").append("\"sisdx02a\"").append(lineSeparator);
			queues.append("}").append(",").append(lineSeparator);
			queues.append("{").append(lineSeparator);
			queues.append("\"name\":").append("\"JMSServer_").append(queue.replaceAll("\\.", "_")).append("Queue").append("\"").append(",").append(lineSeparator);
			queues.append("\"persistentStore\":").append("\"FileStore_").append(queue.replaceAll("\\.", "_")).append("Queue").append("\"").append(",").append(lineSeparator);
			queues.append("\"target\":").append("\"sisdx02a\"").append(lineSeparator);
			queues.append("}").append(",").append(lineSeparator);
		}
	}
	
	private static void createSubdeploymenJSON(StringBuilder queues, String[] objects) {
		for(String queue : objects){
			queues.append("{").append(lineSeparator);
			queues.append("\"name\":").append("\"Sub_").append(queue.replaceAll("\\.", "_")).append("DLQ").append("\"").append(",").append(lineSeparator);
			queues.append("\"targets\": [{").append(lineSeparator);
			queues.append("\t\"name\":").append("\"sisdx02a\"").append(",").append(lineSeparator);
			queues.append("\t\"type\":").append("\"Server\"").append(lineSeparator);
			queues.append("}],").append(lineSeparator);
			queues.append("\"servers\": [{").append(lineSeparator);
			queues.append("\"name\":").append("\"JMSServer_").append(queue.replaceAll("\\.", "_")).append("DLQ").append("\"").append(lineSeparator);
			queues.append("}]").append(lineSeparator);
			queues.append("}").append(",").append(lineSeparator);
			queues.append("{").append(lineSeparator);
			queues.append("\"name\":").append("\"Sub_").append(queue.replaceAll("\\.", "_")).append("Queue").append("\"").append(",").append(lineSeparator);
			queues.append("\"targets\": [{").append(lineSeparator);
			queues.append("	\"name\":").append("\"sisdx02a\"").append(",").append(lineSeparator);
			queues.append("	\"type\":").append("\"Server\"").append(lineSeparator);
			queues.append("}],").append(lineSeparator);
			queues.append("\"servers\": [{").append(lineSeparator);
			queues.append("\"name\":").append("\"JMSServer_").append(queue.replaceAll("\\.", "_")).append("Queue").append("\"").append(lineSeparator);
			queues.append("}]").append(lineSeparator);
			queues.append("}").append(",").append(lineSeparator);
		}
	}
	
	private static void createQueueJSON(StringBuilder queues, String[] objects) {
		for(String queue : objects){
			queues.append("{").append(lineSeparator);
			queues.append("\"jndiName\":").append("\"sis.").append(queue).append("DLQ\"").append(",").append(lineSeparator);
			queues.append("\"subdeployment\":").append("\"Sub_").append(queue.replaceAll("\\.", "_")).append("DLQ").append("\"").append(",").append(lineSeparator);
			queues.append("\"targets\": [{").append(lineSeparator);
			queues.append("	\"name\":").append("\"sisdx02a\"").append(",").append(lineSeparator);
			queues.append("	\"type\":").append("\"Server\"").append(lineSeparator);
			queues.append("}],").append(lineSeparator);
			queues.append("\"servers\": [{").append(lineSeparator);
			queues.append("\"name\":").append("\"JMSServer_").append(queue.replaceAll("\\.", "_")).append("\"").append(lineSeparator);
			queues.append("}]").append(lineSeparator);
			queues.append("}").append(",").append(lineSeparator);
		}
	}
	
	/*
	
	{
		"jndiName": "placeholder",
		"subdeployment": "placeholder",
		"template": "placeholder",
		"destinationKeys": "placeholder",
		"deliveryFailure": {
			"redeliveryDelayOverride": 30000,
			"redeliveryLimit": 5,
			"expirationPolicy": "redirect",
			"errorDestination": "sis.wli.OnlineConnectorInDLQ",
			"ttlOverride": 0,
			"deliveryModeOverride": "Non-Persistent"
		}
	}
	
	*/
}
