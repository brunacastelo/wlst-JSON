package main.deprecated;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;

import weblogic.WLST;
import wlst.WLSTCommands;
import wlst.objects.beans.Address;
import wlst.objects.beans.AdminServer;
import wlst.objects.beans.Cluster;
import wlst.objects.beans.ConnectionFactory;
import wlst.objects.beans.ConnectionPool;
import wlst.objects.beans.DataSource;
import wlst.objects.beans.DeliveryFailure;
import wlst.objects.beans.DistributedQueue;
import wlst.objects.beans.Domain;
import wlst.objects.beans.Enviroment;
import wlst.objects.beans.FileStore;
import wlst.objects.beans.JdbcStore;
import wlst.objects.beans.JmsModule;
import wlst.objects.beans.JmsServer;
import wlst.objects.beans.Machine;
import wlst.objects.beans.ManagedServer;
import wlst.objects.beans.PriorityDestinationKey;
import wlst.objects.beans.Queue;
import wlst.objects.beans.Subdeployment;
import wlst.objects.beans.Target;
import wlst.objects.beans.Template;
import wlst.objects.beans.Topic;
import wlst.objects.beans.Transaction;
import wlst.objects.beans.WorkManager;

public class ConfigureAux {
//	
//	private static LinkedHashMap<String, List<String>> sisModuleDistributedQueuesAndServers = null;
//	
//	private static final String[] QUEUES = {"NetworkConnectorOut","NetworkSupervisorDetail","ProvisioningSupervisorDetail"};
//	private static final String[] DISTRIBUTED_QUEUES = {"db.ConnectorOut","EventHistory","expediter.OnlineConnectorIn","expediter.OnlineConnectorOut","expediter_velox.OnlineConnectorIn","expediter_velox.OnlineConnectorOut","gos.OnlineConnectorIn","gos.OnlineConnectorOut","loader.OnlineConnectorIn","loader.OnlineConnectorOut","m2m.OnlineConnectorIn","m2m.OnlineConnectorOut","mesox.OnlineConnectorIn","mesox.OnlineConnectorOut","mesox.OnlineConnectorOut_mesoxba","mesox.OnlineConnectorOut_mesoxce","mesox.OnlineConnectorOut_mesoxmg","mesox.OnlineConnectorOut_mesoxpe","mesox.OnlineConnectorOut_mesoxrj","NetworkIn","NetworkNalReturnProcessor","NetworkPendantBatchReplyItem","NetworkReceivedBatchReplyItem","NetworkReplyAlternativeAggregation","NetworkReplyAlternative","NetworkReplyDefaultAggregation","NetworkReplyDefault","NetworkReply","oms.r2.OnlineConnectorIn","oms.r2.OnlineConnectorOut","ProvisionerInAlternative","ProvisionerInDefault","ProvisionerIn","ProvisionerOut","sac.r2.OnlineConnectorIn","sac.r2.OnlineConnectorOut","sac-soa.OnlineConnectorIn","sac-soa.OnlineConnectorOut","soa.OnlineConnectorIn","soa.OnlineConnectorOut","som.OnlineConnectorIn","som.OnlineConnectorOut","vas.OnlineConnectorIn","vas.OnlineConnectorOut","wli.OnlineConnectorIn","wli.OnlineConnectorOut","ogs.OnlineConnectorIn","ogs.OnlineConnectorOut", "wms.OnlineConnectorIn","wms.OnlineConnectorOut","WorkflowDefinition","xdsl.OnlineConnectorIn","xdsl.OnlineConnectorOut"};
//	private static final String[] TOPICS = {"MonConnectors","SupervisorToMonitorNetwork","SupervisorToMonitorProvisioning"};
//	private static final String[] NETWORK_DISTRIBUTED_QUEUES = {"EMA01","EPAP01","EPAP02","EPAP03","EPAP04","EPAP05","EPAP06","HLR01","HLR02","HLR03","HLR09","HLR11","HLR12","HLR13","HLR14","HLR19","HLR20","HLR22","HLR23","HLR29","HLR30","HLR31","HLR32","HLR33","HLR39","HLR40","HLR41","HLR42","HLR43","HLR44","HLR45","HLR46","HLR49","HLR50","HLR51","HLR52","HLR53","HLR64","HLR65","HLR69","HLR70","HLR71","HLR72","HLR73","HLR74","HLR75","HLR76","HLR77","HLR78","HLR79","HLR80","HLR81","HLR90","HLR99","LSMS01","MASC01","NAPTI01","NPS01","OTA01","PMS01","PMS02","PMS03","PMS04","PMS05","PMS06","PMS07","PMS08","PMS09","PMS10","PMSFIXA","PPM01","PTS01","PTS02","PTS03","RIM01","SMSC03","SMSC04","SMSC05","SMSC06","SMSC07", "SMSC08", "UDR01","UDR02","UDR03","VMP01","VMP02","VMP03","VMP04","VMP05","VMP06","VMP07","VMP08","VMP09","VMS01","VMS02","VMS03", "VMS04"};
//	private static final String[] PROVISIONING_DISTRIBUTED_QUEUES = {"Mno", "Sisgen"};
//	private static final String[] DATA_SOURCE = {"AggregationDataSource", "CadastroDataSource", "ConnectorBatchDataSource", "DomainDataSource", "DomainDataSource.Provisioning", "HistoryDataSource", "HistoryViewerDataSource", "TempDataSource", "TempLLRDataSource" };
//	private static final String[] SISPROVISIONING = {"sisprovisioninghx06", "sisprovisioninghx07"};
//	private static final String[] CONNECTION_FACTORY = {"sis.ExternalSystemJMSConnectionFactory", "sis.HistoryJMSConnectionFactory" , "sis.JMSConnectionFactory", "sis.JMSConnectionFactoryNonXA", "sis.NetworkJMSConnectionFactory"};
//	private static final String[] MODULES = {"sismodule", "sisnetworkmodule", "sisprovisioningmodule"};
//	private static final String[] WORK_MANAGER = {"DBConnectorReply", "BatchReply", "BatchReplyValidator", "Aggregator", "AggregatorAlternative", "ConnectorJms", "ConnectorJmsReply", "ProvisionerDefault", "ProvisionerIn", "NetworkReply", "NetworkIn", "HistoryEvent", "Supervisor", "Provisioner", "Network", "History", "Connector", "NetworkActivatorResponse", "ConnectorReply", "ConnectorJmsWorkManager", "NetworkReplyDefault", "NetworkReplyAlternative"};
//
//	/**
//	 * @param args
//	 * @throws Exception 
//	 */
//	
//
//	public static void main(String[] args) throws Exception {
//
//		distributedQueuesAndServersSimodule();
//		
//		List<Address> addressesSisconnector = new ArrayList<Address>();
//		List<Address> addressesSishistory = new ArrayList<Address>();
//		List<Address> addressesSisnetwork = new ArrayList<Address>();
//		List<Address> addressesSisprovisioning = new ArrayList<Address>();
//		List<Cluster> clusters = new ArrayList<Cluster>();
//		List<Topic> topics = new ArrayList<Topic>();
//		List<DataSource> dataSources = new ArrayList<DataSource>();
//		List<WorkManager> workManagers = new ArrayList<WorkManager>();
//		List<ConnectionFactory> connectionFactories = new ArrayList<ConnectionFactory>();
//		List<ManagedServer> managedServeres = new ArrayList<ManagedServer>();
//		List<Machine> machines = new ArrayList<Machine>();
//		
//		/* Criando deliveryFailure */
//		DeliveryFailure deliveryFailure = new DeliveryFailure(-1, -1, "discard", "", -1, "No-Delivery");
//
//		/* Criando PriorityDestinationKey */
//		PriorityDestinationKey priorityDestinationKey = new PriorityDestinationKey("PriorityDestinationKey", "JMSPriority", "long", "descending");
//				
//		/* Criando topic */
//		for(String topicEach: TOPICS){		
//			List<Target> targets = new ArrayList<Target>();
//			List<FileStore> fileStores = new ArrayList<FileStore>();
//			List<JmsServer> jmsServers = new ArrayList<JmsServer>();
//			List<Target> targetsJsmModuleSismoduleTopic = new ArrayList<Target>();
//			
//			String target = "sismomhx05";
//			String targetType = "Server";
//			
//			Target targetes = new Target(target, Target.TargetType.Server);
//			targets.add(targetes);
//			
//			Target targetJmsTopic = new Target("JMSServer_"+topicEach+"_"+target, Target.TargetType.JMSServer);
//			targetsJsmModuleSismoduleTopic.add(targetJmsTopic);
//			
//			FileStore fileStore = new FileStore("FileStore_"+topicEach+"_"+target, "./FileStore/FileStore_"+topicEach+"_"+target, target, targetType);
//			fileStores.add(fileStore);
//			
//			JmsServer jmsServer = new JmsServer("JMSServer_"+topicEach+"_"+target, "FileStore_"+topicEach+"_"+target, target, targetType, 200000, 0);
//			jmsServers.add(jmsServer);
//			
//			Subdeployment subdeployment = new Subdeployment("Sub_"+topicEach, targetsJsmModuleSismoduleTopic, jmsServers);
//				
//			Topic topic = new Topic("sis."+topicEach+"Topic", subdeployment.getName(), fileStore, 0, -1, "Delivery", -1, targets);
//			topics.add(topic);
//		}
//		
//		/* Criando Address */
//		//Cluster sisconnector	
//		Address addressSishx06 = new Address("sisconnectorhx06", 7003);
//		addressesSisconnector.add(addressSishx06);
//		Address addressSishx07 = new Address("sisconnectorhx07", 7003);
//		addressesSisconnector.add(addressSishx07);
//
//		//Cluster sishistory		
//		Address addressSishx10P05 = new Address("sishistoryhx10a", 7005);
//		addressesSishistory.add(addressSishx10P05);
//		Address addressSishx10P07 = new Address("sishistoryhx10b", 7007);
//		addressesSishistory.add(addressSishx10P07);
//
//		//Cluster sisnetwork		
//		Address addressSishx08P03 = new Address("sisnetworkhx08a", 7003);
//		addressesSisnetwork.add(addressSishx08P03);
//		Address addressSishx08P05 = new Address("sisnetworkhx08b", 7005);
//		addressesSisnetwork.add(addressSishx08P05);
//		Address addressSishx09P09 = new Address("sisnetworkhx09a", 7003);
//		addressesSisnetwork.add(addressSishx09P09);
//		Address addressSishx09P05 = new Address("sisnetworkhx09b", 7005);
//		addressesSisnetwork.add(addressSishx09P05);
//
//		//Cluster sisprovisioning		
//		Address addressSishx06P05 = new Address("sisprovisioninghx06", 7005);
//		addressesSisprovisioning.add(addressSishx06P05);
//		Address addressSishx07P05 = new Address("sisprovisioninghx07", 7005);
//		addressesSisprovisioning.add(addressSishx07P05);
//		
//		/* Criando Cluster */
//		Cluster clusterSisconnector = new Cluster("sisconnector", "239.192.000.100", 7001, addressesSisconnector);
//		clusters.add(clusterSisconnector);
//		Cluster clusterSishistory = new Cluster("sishistory", "239.192.000.100", 7001, addressesSishistory);
//		clusters.add(clusterSishistory);
//		Cluster clusterSisnetwork = new Cluster("sisnetwork", "239.192.000.100", 7001, addressesSisnetwork);
//		clusters.add(clusterSisnetwork);
//		Cluster clusterSisprovisioning = new Cluster("sisprovisioning", "239.192.000.100", 7001, addressesSisprovisioning);
//		clusters.add(clusterSisprovisioning);
//		
//		/* Criando AdminServer */
//		AdminServer adminServer = new AdminServer("AdminServer", 7001, 7002);
//		
//		/* Criando ManagedServer */
//		ManagedServer managedServerSisWeb01= new ManagedServer("serverconnhx06", "address", 7007, "sishx06", null);
//		managedServeres.add(managedServerSisWeb01);
//		ManagedServer managedServerSisWeb02= new ManagedServer("sisconnectorhx06", "address", 7003, "sishx06", "sisconnector");
//		managedServeres.add(managedServerSisWeb02);
//		ManagedServer managedServerSisWeb03= new ManagedServer("sisconnectorhx07", "address", 7003, "sishx07", "sisconnector");
//		managedServeres.add(managedServerSisWeb03);
//		ManagedServer managedServerSisWeb04= new ManagedServer("sishistoryhx10a", "address", 7005, "sishx10", "sishistory");
//		managedServeres.add(managedServerSisWeb04);
//		ManagedServer managedServerSisWeb05= new ManagedServer("sishistoryhx10b", "address", 7007, "sishx10", "sishistory");
//		managedServeres.add(managedServerSisWeb05);
//		ManagedServer managedServerSisWeb06= new ManagedServer("sismomhx05", "address", 7003, "sishx05", null);
//		managedServeres.add(managedServerSisWeb06);
//		ManagedServer managedServerSisWeb07= new ManagedServer("sisnetworkhx08a", "address", 7003, "sishx08", "sisnetwork");
//		managedServeres.add(managedServerSisWeb07);
//		ManagedServer managedServerSisWeb08= new ManagedServer("sisnetworkhx08b", "address", 7005, "sishx08", "sisnetwork");
//		managedServeres.add(managedServerSisWeb08);
//		ManagedServer managedServerSisWeb09= new ManagedServer("sisnetworkhx09a", "address", 7003, "sishx09", "sisnetwork");
//		managedServeres.add(managedServerSisWeb09);
//		ManagedServer managedServerSisWeb10= new ManagedServer("sisnetworkhx09b", "address", 7005, "sishx09", "sisnetwork");
//		managedServeres.add(managedServerSisWeb10);
//		ManagedServer managedServerSisWeb11= new ManagedServer("sisprovisioninghx06", "address", 7005, "sishx06", "sisprovisioning");
//		managedServeres.add(managedServerSisWeb11);
//		ManagedServer managedServerSisWeb12= new ManagedServer("sisprovisioninghx07", "address", 7005, "sishx07", "sisprovisioning");
//		managedServeres.add(managedServerSisWeb12);
//		ManagedServer managedServerSisWeb13= new ManagedServer("siswebhx10", "address", 7003, "sishx10", null);
//		managedServeres.add(managedServerSisWeb13);
//		
//		/* Criando Machine */
//		Machine machineSishx05 = new Machine("sishx05");
//		machines.add(machineSishx05);
//		Machine machineSishx06 = new Machine("sishx06");
//		machines.add(machineSishx06);
//		Machine machineSishx07 = new Machine("sishx07");
//		machines.add(machineSishx07);
//		Machine machineSishx08 = new Machine("sishx08");
//		machines.add(machineSishx08);
//		Machine machineSishx09 = new Machine("sishx09");
//		machines.add(machineSishx09);
//		Machine machineSishx10 = new Machine("sishx10");
//		machines.add(machineSishx10);
//		
//		/* Criando Domain */
//		Domain domain = new Domain("sisdevdomain", "weblogic", "welcome1", "t3://localhost:7001", machines, adminServer, managedServeres, clusters);
//		
//		for (String nameDataSource : DATA_SOURCE) {
//			if(nameDataSource.equals("AggregationDataSource")){
//				
//				/* Criando ConnectionPool */
//				String password = "{AES}kxZfyAQzJ7BzxH1QzXhsy5h5LhKkc8FYIKA9A2zRAB4=";
//				
//				ConnectionPool connectionPool = new ConnectionPool("jdbc:oracle:thin:@10.32.204.191:1550:sishom", "oracle.jdbc.OracleDriver","sistem", password, "SQL BEGIN NULL; END;", 15, 30, 50, false, 300, 600, 600000, 180, 120, 30, 16, 1024, 180);
//				
//				/* Criando Transaction */
//				Transaction transaction  = new Transaction(true, true, 600, true);
//				
//				
//				List<Target> targets = new ArrayList<Target>();
//				String target = "sisprovisioning";
//				
//				Target targetes = new Target(target, Target.TargetType.Cluster);
//				targets.add(targetes);
//				
//				DataSource dataSource = new DataSource("sis."+nameDataSource, targets, connectionPool, transaction);
//				dataSources.add(dataSource);
//			}
//			else if(nameDataSource.equals("CadastroDataSource")){
//				
//				/* Criando ConnectionPool */
//				String password = "{AES}kxZfyAQzJ7BzxH1QzXhsy5h5LhKkc8FYIKA9A2zRAB4=";
//				
//				ConnectionPool connectionPool = new ConnectionPool("jdbc:oracle:thin:@10.32.204.191:1550:sishom", "oracle.jdbc.OracleDriver","sistem", password, "SQL BEGIN NULL; END;", 5, 30, 50, true, 300, 150, 2147483647, 10, 5, 15, 5, 10, 20);
//				
//				/* Criando Transaction */
//				Transaction transaction  = new Transaction(false, true, 600, true);
//				
//				List<Target> targets = new ArrayList<Target>();
//				
//				String targetCl = "sishistory";
//				Target targetesCluster = new Target(targetCl, Target.TargetType.Cluster);
//				targets.add(targetesCluster);
//				
//				String targetSer = "siswebhx10";
//				Target targetesServer = new Target(targetSer, Target.TargetType.Server);
//				targets.add(targetesServer);
//				
//				DataSource dataSource = new DataSource("sis."+nameDataSource, targets, connectionPool, transaction);
//				dataSources.add(dataSource);
//			}
//			else if(nameDataSource.equals("ConnectorBatchDataSource")){
//				
//				/* Criando ConnectionPool */
//				String password = "{AES}kxZfyAQzJ7BzxH1QzXhsy5h5LhKkc8FYIKA9A2zRAB4=";
//				
//				ConnectionPool connectionPool = new ConnectionPool("jdbc:oracle:thin:@10.32.204.191:1550:sishom", "oracle.jdbc.OracleDriver","sistem", password, "SQL BEGIN NULL; END;", 10, 40, 50, true, 300, 600, 600000, 180, 120, 40, 10, 10, 120);
//				
//				/* Criando Transaction */
//				Transaction transaction  = new Transaction(true, true, 600, true);
//				
//				List<Target> targets = new ArrayList<Target>();
//				String targetSer = "serverconnhx06";
//				Target targetesServer = new Target(targetSer, Target.TargetType.Server);
//				targets.add(targetesServer);
//				
//				DataSource dataSource = new DataSource("sis."+nameDataSource, targets, connectionPool, transaction);
//				dataSources.add(dataSource);
//			}
//			else if(nameDataSource.equals("DomainDataSource")){
//				
//				/* Criando ConnectionPool */
//				String password = "{AES}kxZfyAQzJ7BzxH1QzXhsy5h5LhKkc8FYIKA9A2zRAB4=";
//				
//				ConnectionPool connectionPool = new ConnectionPool("jdbc:oracle:thin:@10.32.204.191:1550:sishom", "oracle.jdbc.OracleDriver","sistem", password, "SQL BEGIN NULL; END;", 5, 40, 50, true, 300, 150, 600000, 15, 5, 30, 5, 10, 20);
//				
//				/* Criando Transaction */
//				Transaction transaction  = new Transaction(false, true, 600, true);
//				
//				List<Target> targets = new ArrayList<Target>();
//				
//				String targetSer01 = "siswebhx10";
//				Target targetesServer01 = new Target(targetSer01, Target.TargetType.Server);
//				targets.add(targetesServer01);
//				
//				String targetSer03 = "sismomhx05";
//				Target targetesServer03 = new Target(targetSer03, Target.TargetType.Server);
//				targets.add(targetesServer03);
//				
//				String targetClus04 = "sisconnector";
//				Target targetesCluster04 = new Target(targetClus04, Target.TargetType.Cluster);
//				targets.add(targetesCluster04);
//				
//				String targetClus05 = "sisnetwork";
//				Target targetesCluster05 = new Target(targetClus05, Target.TargetType.Cluster);
//				targets.add(targetesCluster05);
//				
//				String targetClus06 = "sishistory";
//				Target targetestargetesCluster06 = new Target(targetClus06, Target.TargetType.Cluster);
//				targets.add(targetestargetesCluster06);
//				
//				String targetSer07 = "serverconnhx06";
//				Target targetesServer07 = new Target(targetSer07, Target.TargetType.Server);
//				targets.add(targetesServer07);
//				
//				DataSource dataSource = new DataSource("sis."+nameDataSource, targets, connectionPool, transaction);
//				dataSources.add(dataSource);
//			}
//			else if(nameDataSource.equals("DomainDataSource.Provisioning")){
//				
//				/* Criando ConnectionPool */
//				String password = "{AES}kxZfyAQzJ7BzxH1QzXhsy5h5LhKkc8FYIKA9A2zRAB4=";
//				
//				ConnectionPool connectionPool = new ConnectionPool("jdbc:oracle:thin:@10.32.204.191:1550:sishom", "oracle.jdbc.OracleDriver","sistem", password, "SQL BEGIN NULL; END;", 16, 40, 50, true, 300, 0, 2147483647, 15, 120, 30, 5, 10, 180);
//				
//				/* Criando Transaction */
//				Transaction transaction  = new Transaction(false, true, 600, true);
//				
//				List<Target> targets = new ArrayList<Target>();
//				String target = "sisprovisioning";
//				
//				Target targetes = new Target(target, Target.TargetType.Cluster);
//				targets.add(targetes);
//				
//				DataSource dataSource = new DataSource("sis."+nameDataSource, targets, connectionPool, transaction);
//				dataSources.add(dataSource);
//			}
//			else if(nameDataSource.equals("HistoryDataSource")){
//				
//				/* Criando ConnectionPool */
//				String password = "{AES}kxZfyAQzJ7BzxH1QzXhsy5h5LhKkc8FYIKA9A2zRAB4=";
//				
//				ConnectionPool connectionPool = new ConnectionPool("jdbc:oracle:thin:@10.32.204.191:1550:sishom", "oracle.jdbc.OracleDriver","sistem", password, "SQL BEGIN NULL; END;", 12, 40, 50, false, 300, 180, 600000, 10, 60, 30, 12, 100, 20);
//				
//				/* Criando Transaction */
//				Transaction transaction  = new Transaction(false, true, 600, true);
//				
//				List<Target> targets = new ArrayList<Target>();
//				
//				String targetCl = "sishistory";
//				Target targetesCluster = new Target(targetCl, Target.TargetType.Cluster);
//				targets.add(targetesCluster);
//				
//				String targetSer = "siswebhx10";
//				Target targetesServer = new Target(targetSer, Target.TargetType.Server);
//				targets.add(targetesServer);
//				
//				DataSource dataSource = new DataSource("sis."+nameDataSource, targets, connectionPool, transaction);
//				dataSources.add(dataSource);
//			}
//			else if(nameDataSource.equals("HistoryViewerDataSource")){
//				
//				/* Criando ConnectionPool */
//				String password = "{AES}kxZfyAQzJ7BzxH1QzXhsy5h5LhKkc8FYIKA9A2zRAB4=";
//				
//				ConnectionPool connectionPool = new ConnectionPool("jdbc:oracle:thin:@10.32.204.191:1550:sishom", "oracle.jdbc.OracleDriver","sistem", password, "SQL BEGIN NULL; END;", 5, 40, 50, true, 300, 150, 2147483647, 10, 5, 15, 5, 10, 20);
//				
//				/* Criando Transaction */
//				Transaction transaction  = new Transaction(false, true, 600, true);
//				
//				List<Target> targets = new ArrayList<Target>();
//				
//				String targetSer = "siswebhx10";
//				Target targetesServer = new Target(targetSer, Target.TargetType.Server);
//				targets.add(targetesServer);
//				
//				DataSource dataSource = new DataSource("sis."+nameDataSource, targets, connectionPool, transaction);
//				dataSources.add(dataSource);
//			}
//			else if(nameDataSource.equals("TempDataSource")){
//				
//				/* Criando ConnectionPool */
//				String password = "{AES}kxZfyAQzJ7BzxH1QzXhsy5h5LhKkc8FYIKA9A2zRAB4=";
//				
//				ConnectionPool connectionPool = new ConnectionPool("jdbc:oracle:thin:@10.32.204.191:1550:sishom", "oracle.jdbc.xa.client.OracleXADataSource","sistem", password, "SQL BEGIN NULL; END;", 10, 60, 5, true, 300, 600, 600000, 180, 120, 60, 10, 10, 120);
//				
//				/* Criando Transaction */
//				Transaction transaction  = new Transaction(true, true, 600, true);
//				
//				List<Target> targets = new ArrayList<Target>();
//				String target = "sisnetwork";
//				
//				Target targetes = new Target(target, Target.TargetType.Cluster);
//				targets.add(targetes);
//				
//				DataSource dataSource = new DataSource("sis."+nameDataSource, targets, connectionPool, transaction);
//				dataSources.add(dataSource);
//			}
//			else if(nameDataSource.equals("TempLLRDataSource")){
//				
//				/* Criando ConnectionPool */
//				String password = "{AES}kxZfyAQzJ7BzxH1QzXhsy5h5LhKkc8FYIKA9A2zRAB4=";
//				
//				ConnectionPool connectionPool = new ConnectionPool("jdbc:oracle:thin:@10.32.204.191:1550:sishom", "oracle.jdbc.OracleDriver","sistem", password, "SQL BEGIN NULL; END;", 12, 25, 50, true, 300, 600, 600000, 180, 120, 25, 12, 10, 180);
//				
//				/* Criando Transaction */
//				Transaction transaction  = new Transaction(true, true, 600, true);
//				
//				List<Target> targets = new ArrayList<Target>();
//				String target = "sisnetwork";
//				
//				Target targetes = new Target(target, Target.TargetType.Cluster);
//				targets.add(targetes);
//				
//				DataSource dataSource = new DataSource("sis."+nameDataSource, targets, connectionPool, transaction);
//				dataSources.add(dataSource);
//			}
//		}
//	
//		List<Queue> queues = new ArrayList<Queue>();
//		List<FileStore> fileStores = new ArrayList<FileStore>();
//		List<JmsServer> jmsServers = new ArrayList<JmsServer>();
//		List<Subdeployment> subdeployments = new ArrayList<Subdeployment>();
//		List<Subdeployment> subdeploymentsNetworking = new ArrayList<Subdeployment>();
//		List<Subdeployment> subdeploymentsProvisioning = new ArrayList<Subdeployment>();
//		List<JmsModule> jmsModules = new ArrayList<JmsModule>();
//						
//		for (String module : MODULES) {
//			if(module.equals("sismodule")){
//				List<DistributedQueue> distributedSismodule = new ArrayList<DistributedQueue>();
//				List<Target> targetsJsmModuleSisModule = new ArrayList<Target>();
//				
//				Template templateProvisioningModule = new Template("TEMPLATE_PLATAFORMAS", null);
//				
//				List<String> sisprovisioning = new ArrayList<String>();
//
//				sisprovisioning.add("sisprovisioninghx06");
//				sisprovisioning.add("sisprovisioninghx07");
//				
//				//Criando ConnectionFactory
//				for (String connectionFactory : CONNECTION_FACTORY) {
//					
//					if(connectionFactory.equals("sis.ExternalSystemJMSConnectionFactory")){
//						ConnectionFactory connectFactory = new ConnectionFactory(connectionFactory, connectionFactory, 10000, 1, "all", false, false);
//						connectionFactories.add(connectFactory);
//					} else if(connectionFactory.equals("sis.HistoryJMSConnectionFactory")){
//						ConnectionFactory connectFactory = new ConnectionFactory(connectionFactory, connectionFactory, 10000, 25, "all", false, false);
//						connectionFactories.add(connectFactory);						
//					} else if(connectionFactory.equals("sis.JMSConnectionFactory")){
//						ConnectionFactory connectFactory = new ConnectionFactory(connectionFactory, connectionFactory, 10000, 1, "all", false, true);
//						connectionFactories.add(connectFactory);						
//					} else if(connectionFactory.equals("sis.JMSConnectionFactoryNonXA")){
//						ConnectionFactory connectFactory = new ConnectionFactory(connectionFactory, connectionFactory, 10000, 1, "all", false, false);
//						connectionFactories.add(connectFactory);						
//					} else if(connectionFactory.equals("sis.NetworkJMSConnectionFactory")){
//						ConnectionFactory connectFactory = new ConnectionFactory(connectionFactory, connectionFactory, 10000, 1, "all", false, true);
//						connectionFactories.add(connectFactory);						
//					}
//
//				}
//			
//				for(String queue : QUEUES) {
//					if(queue.equals("ProvisioningSupervisorDetail")){
//						String target = "sismomhx05";
//						String targetType = "Server";
//						
//						List<Target> targetsJsmModuleSismoduleQueue = new ArrayList<Target>();
//						Target targetJmsQueue = new Target("JMSServer_ProvisioningSupervisorDetail"+"_"+target, Target.TargetType.JMSServer);
//						targetsJsmModuleSismoduleQueue.add(targetJmsQueue);
//						
//						FileStore fileStore = new FileStore("FileStore_"+queue+"_"+target, "./FileStore/FileStore_"+queue+"_"+target, target, targetType);
//						fileStores.add(fileStore);
//						
//						List<JmsServer> auxJmsServers = new ArrayList<JmsServer>();
//						
//						JmsServer jmsServer = new JmsServer("JMSServer_"+queue+"_"+target, "FileStore_"+queue+"_"+target, target, targetType, 200000, 0);
//						jmsServers.add(jmsServer);
//						auxJmsServers.add(jmsServer);
//						
//						Subdeployment subdeployment = new Subdeployment("Sub_"+queue, targetsJsmModuleSismoduleQueue, auxJmsServers);
//						subdeployments.add(subdeployment);	
//
//						Queue queueQueue = new Queue("sis."+queue, "Sub_"+queue, "TEMPLATE_PLATAFORMAS", "sis."+queue+"DLQ", deliveryFailure, priorityDestinationKey, null);
//						queues.add(queueQueue);
//					}
//					
//					else if(queue.equals("NetworkConnectorOut")){
//						String target = "sisnetworkhx08a";
//						String targetType = "Server";
//						
//						List<Target> targetsJsmModuleSismoduleQueue = new ArrayList<Target>();
//						Target targetJmsQueue = new Target("JMSServer_NetworkConnectorOut"+"_"+target, Target.TargetType.JMSServer);
//						targetsJsmModuleSismoduleQueue.add(targetJmsQueue);
//						
//						FileStore fileStore = new FileStore("FileStore_"+queue+"_"+target, "./FileStore/FileStore_"+queue+"_"+target, target, targetType);
//						fileStores.add(fileStore);
//						
//						List<JmsServer> auxJmsServers = new ArrayList<JmsServer>();
//						
//						JmsServer jmsServer = new JmsServer("JMSServer_"+queue+"_"+target, "FileStore_"+queue+"_"+target, target, targetType, 200000, 0);
//						jmsServers.add(jmsServer);
//						auxJmsServers.add(jmsServer);
//						
//						Subdeployment subdeployment = new Subdeployment("Sub_"+queue, targetsJsmModuleSismoduleQueue, auxJmsServers);
//						subdeployments.add(subdeployment);	
//
//						Queue queueQueue = new Queue("sis."+queue, "Sub_"+queue, "TEMPLATE_PLATAFORMAS", "sis."+queue+"DLQ", deliveryFailure, priorityDestinationKey, null);
//						queues.add(queueQueue);
//					}
//					
//					else if (queue.equals("NetworkSupervisorDetail")){
//						String target = "sismomhx05";
//						String targetType = "Server";
//						
//						List<Target> targetsJsmModuleSismoduleQueue = new ArrayList<Target>();
//						Target targetJmsQueue = new Target("JMSServer_NetworkSupervisorDetail"+"_"+target, Target.TargetType.JMSServer);
//						targetsJsmModuleSismoduleQueue.add(targetJmsQueue);
//						
//						FileStore fileStore = new FileStore("FileStore_"+queue+"_"+target, "./FileStore/FileStore_"+queue+"_"+target, target, targetType);
//						fileStores.add(fileStore);
//						
//						List<JmsServer> auxJmsServers = new ArrayList<JmsServer>();
//						
//						JmsServer jmsServer = new JmsServer("JMSServer_"+queue+"_"+target, "FileStore_"+queue+"_"+target, target, targetType, 200000, 0);
//						jmsServers.add(jmsServer);
//						auxJmsServers.add(jmsServer);
//						
//						Subdeployment subdeployment = new Subdeployment("Sub_"+queue, targetsJsmModuleSismoduleQueue, auxJmsServers);
//						subdeployments.add(subdeployment);	
//
//						Queue queueQueue = new Queue("sis."+queue, "Sub_"+queue, "TEMPLATE_PLATAFORMAS", "sis."+queue+"DLQ", deliveryFailure, priorityDestinationKey, null);
//						queues.add(queueQueue);
//					}
//				}
//								
//				for(String distributedQueues : DISTRIBUTED_QUEUES) {
//					List<JmsServer> auxNetwork = new ArrayList<JmsServer>();
//					List<JmsServer> listnetwork = new ArrayList<JmsServer>();
//					List<Target> targetsJsmModule = new ArrayList<Target>();
//					String targetType = null;
//					
//					ArrayList<String> targetsProvision = new ArrayList<String>();
//					
//					targetType = "Server";	
//					if(distributedQueues.equals("db.ConnectorOut")){
//						String target = "serverconnhx06";
//						targetsProvision.add(target);
//					} else if(distributedQueues.equals("EventHistory")){
//						String targeta = "sishistoryhx10a";
//						targetsProvision.add(targeta);
//						String targetb = "sishistoryhx10b";
//						targetsProvision.add(targetb);
//					} else if(distributedQueues.equals("expediter.OnlineConnectorIn")){
//						String targeta = "sisconnectorhx06";
//						targetsProvision.add(targeta);
//						String targetb = "sisconnectorhx07";
//						targetsProvision.add(targetb);
//					}  else if(distributedQueues.equals("expediter.OnlineConnectorOut")){
//						String targeta = "sisconnectorhx06";
//						targetsProvision.add(targeta);
//						String targetb = "sisconnectorhx07";
//						targetsProvision.add(targetb);
//					}  else if(distributedQueues.equals("expediter_velox.OnlineConnectorIn")){
//						String target = "sisconnectorhx06";
//						targetsProvision.add(target);
//						String targetb = "sisconnectorhx07";
//						targetsProvision.add(targetb);
//					}  else if(distributedQueues.equals("expediter_velox.OnlineConnectorOut")){
//						String target = "sisconnectorhx06";
//						targetsProvision.add(target);
//						String targetb = "sisconnectorhx07";
//						targetsProvision.add(targetb);
//					}  else if(distributedQueues.equals("gos.OnlineConnectorIn")){
//						String target = "sisconnectorhx06";
//						targetsProvision.add(target);
//						String targeta = "sisconnectorhx07";
//						targetsProvision.add(targeta);
//					}  else if(distributedQueues.equals("gos.OnlineConnectorOut")){
//						String target = "sisconnectorhx06";
//						targetsProvision.add(target);
//						String targeta = "sisconnectorhx07";
//						targetsProvision.add(targeta);
//					}  else if(distributedQueues.equals("loader.OnlineConnectorIn")){
//						String target = "sisconnectorhx06";
//						targetsProvision.add(target);
//						String targetb = "sisconnectorhx07";
//						targetsProvision.add(targetb);
//					}  else if(distributedQueues.equals("loader.OnlineConnectorOut")){
//						String target = "sisconnectorhx06";
//						targetsProvision.add(target);
//						String targetb = "sisconnectorhx07";
//						targetsProvision.add(targetb);
//					}  else if(distributedQueues.equals("m2m.OnlineConnectorIn")){
//						String target = "sisconnectorhx06";
//						targetsProvision.add(target);
//						String targetb = "sisconnectorhx07";
//						targetsProvision.add(targetb);
//					}  else if(distributedQueues.equals("m2m.OnlineConnectorOut")){
//						String target = "sisconnectorhx06";
//						targetsProvision.add(target);
//						String targetb = "sisconnectorhx07";
//						targetsProvision.add(targetb);
//					}  else if(distributedQueues.equals("mesox.OnlineConnectorIn")){
//						String target = "sisconnectorhx06";
//						targetsProvision.add(target);
//						String targetb = "sisconnectorhx07";
//						targetsProvision.add(targetb);
//					}  else if(distributedQueues.equals("mesox.OnlineConnectorOut")){
//						String target = "sisconnectorhx06";
//						targetsProvision.add(target);
//						String targetb = "sisconnectorhx07";
//						targetsProvision.add(targetb);
//					}  else if(distributedQueues.equals("mesox.OnlineConnectorOut_mesoxba")){
//						String target = "sisconnectorhx06";
//						targetsProvision.add(target);
//						String targetb = "sisconnectorhx07";
//						targetsProvision.add(targetb);
//					}  else if(distributedQueues.equals("mesox.OnlineConnectorOut_mesoxce")){
//						String target = "sisconnectorhx06";
//						targetsProvision.add(target);
//						String targetb = "sisconnectorhx07";
//						targetsProvision.add(targetb);
//					}  else if(distributedQueues.equals("mesox.OnlineConnectorOut_mesoxmg")){
//						String target = "sisconnectorhx06";
//						targetsProvision.add(target);
//						String targetb = "sisconnectorhx07";
//						targetsProvision.add(targetb);
//					}  else if(distributedQueues.equals("mesox.OnlineConnectorOut_mesoxpe")){
//						String target = "sisconnectorhx06";
//						targetsProvision.add(target);
//						String targetb = "sisconnectorhx07";
//						targetsProvision.add(targetb);
//					}  else if(distributedQueues.equals("mesox.OnlineConnectorOut_mesoxrj")){
//						String target = "sisconnectorhx06";
//						targetsProvision.add(target);
//						String targetb = "sisconnectorhx07";
//						targetsProvision.add(targetb);
//					}  else if(distributedQueues.equals("NetworkIn")){
//						String target = "sisnetworkhx08a";
//						targetsProvision.add(target);
//						String targetb = "sisnetworkhx08b";
//						targetsProvision.add(targetb);
//						String targetc = "sisnetworkhx09a";
//						targetsProvision.add(targetc);
//						String targetd = "sisnetworkhx09b";
//						targetsProvision.add(targetd);
//					}  else if(distributedQueues.equals("NetworkNalReturnProcessor")){
//						String target = "sisnetworkhx08a";
//						targetsProvision.add(target);
//						String targetb = "sisnetworkhx08b";
//						targetsProvision.add(targetb);
//						String targetc = "sisnetworkhx09a";
//						targetsProvision.add(targetc);
//						String targetd = "sisnetworkhx09b";
//						targetsProvision.add(targetd);
//					}  else if(distributedQueues.equals("NetworkPendantBatchReplyItem")){
//						String target = "sisnetworkhx08a";
//						targetsProvision.add(target);
//						String targetb = "sisnetworkhx08b";
//						targetsProvision.add(targetb);
//						String targetc = "sisnetworkhx09a";
//						targetsProvision.add(targetc);
//						String targetd = "sisnetworkhx09b";
//						targetsProvision.add(targetd);
//					}  else if(distributedQueues.equals("NetworkReceivedBatchReplyItem")){
//						String target = "sisnetworkhx08a";
//						targetsProvision.add(target);
//						String targetb = "sisnetworkhx08b";
//						targetsProvision.add(targetb);
//						String targetc = "sisnetworkhx09a";
//						targetsProvision.add(targetc);
//						String targetd = "sisnetworkhx09b";
//						targetsProvision.add(targetd);
//					}  else if(distributedQueues.equals("NetworkReplyAlternativeAggregation")){
//						String target = "sisprovisioninghx06";
//						targetsProvision.add(target);
//						String targetb = "sisprovisioninghx07";
//						targetsProvision.add(targetb);
//					}  else if(distributedQueues.equals("NetworkReplyAlternative")){
//						String target = "sisprovisioninghx06";
//						targetsProvision.add(target);
//						String targetb = "sisprovisioninghx07";
//						targetsProvision.add(targetb);
//					}  else if(distributedQueues.equals("NetworkReplyDefaultAggregation")){
//						String target = "sisprovisioninghx06";
//						targetsProvision.add(target);
//						String targetb = "sisprovisioninghx07";
//						targetsProvision.add(targetb);
//					}  else if(distributedQueues.equals("NetworkReplyDefault")){
//						String target = "sisprovisioninghx06";
//						targetsProvision.add(target);
//						String targetb = "sisprovisioninghx07";
//						targetsProvision.add(targetb);
//					}  else if(distributedQueues.equals("NetworkReply")){
//						String target = "sisnetworkhx08a";
//						targetsProvision.add(target);
//						String targetb = "sisnetworkhx08b";
//						targetsProvision.add(targetb);
//						String targetc = "sisnetworkhx09a";
//						targetsProvision.add(targetc);
//						String targetd = "sisnetworkhx09b";
//						targetsProvision.add(targetd);
//					}  else if(distributedQueues.equals("oms.r2.OnlineConnectorIn")){
//						String target = "sisconnectorhx06";
//						targetsProvision.add(target);
//						String targetb = "sisconnectorhx07";
//						targetsProvision.add(targetb);
//					}  else if(distributedQueues.equals("oms.r2.OnlineConnectorOut")){
//						String target = "sisconnectorhx06";
//						targetsProvision.add(target);
//						String targetb = "sisconnectorhx07";
//						targetsProvision.add(targetb);
//					}  else if(distributedQueues.equals("ProvisionerInAlternative")){
//						String target = "sisprovisioninghx06";
//						targetsProvision.add(target);
//						String targetb = "sisprovisioninghx07";
//						targetsProvision.add(targetb);
//					}  else if(distributedQueues.equals("ProvisionerInDefault")){
//						String target = "sisprovisioninghx06";
//						targetsProvision.add(target);
//						String targetb = "sisprovisioninghx07";
//						targetsProvision.add(targetb);
//					}  else if(distributedQueues.equals("ProvisionerIn")){
//						String target = "sisprovisioninghx06";
//						targetsProvision.add(target);
//						String targetb = "sisprovisioninghx07";
//						targetsProvision.add(targetb);
//					}  else if(distributedQueues.equals("ProvisionerOut")){
//						String target = "sisprovisioninghx06";
//						targetsProvision.add(target);
//						String targetb = "sisprovisioninghx07";
//						targetsProvision.add(targetb);
//					}  else if(distributedQueues.equals("sac-soa.OnlineConnectorIn")){
//						String target = "sisconnectorhx06";
//						targetsProvision.add(target);
//						String targetb = "sisconnectorhx07";
//						targetsProvision.add(targetb);
//					}  else if(distributedQueues.equals("sac-soa.OnlineConnectorOut")){
//						String target = "sisconnectorhx06";
//						targetsProvision.add(target);
//						String targetb = "sisconnectorhx07";
//						targetsProvision.add(targetb);
//					}  else if(distributedQueues.equals("sac.r2.OnlineConnectorIn")){
//						String target = "sisconnectorhx06";
//						targetsProvision.add(target);
//						String targetb = "sisconnectorhx07";
//						targetsProvision.add(targetb);
//					}  else if(distributedQueues.equals("sac.r2.OnlineConnectorOut")){
//						String target = "sisconnectorhx06";
//						targetsProvision.add(target);
//						String targetb = "sisconnectorhx07";
//						targetsProvision.add(targetb);
//					}  else if(distributedQueues.equals("soa.OnlineConnectorIn")){
//						String target = "sisconnectorhx06";
//						targetsProvision.add(target);
//						String targetb = "sisconnectorhx07";
//						targetsProvision.add(targetb);
//					}  else if(distributedQueues.equals("soa.OnlineConnectorOut")){
//						String target = "sisconnectorhx06";
//						targetsProvision.add(target);
//						String targetb = "sisconnectorhx07";
//						targetsProvision.add(targetb);
//					}  else if(distributedQueues.equals("som.OnlineConnectorIn")){
//						String target = "sisconnectorhx06";
//						targetsProvision.add(target);
//						String targetb = "sisconnectorhx07";
//						targetsProvision.add(targetb);
//					}  else if(distributedQueues.equals("som.OnlineConnectorOut")){
//						String target = "sisconnectorhx06";
//						targetsProvision.add(target);
//						String targetb = "sisconnectorhx07";
//						targetsProvision.add(targetb);
//					}  else if(distributedQueues.equals("vas.OnlineConnectorIn")){
//						String target = "sisconnectorhx06";
//						targetsProvision.add(target);
//						String targetb = "sisconnectorhx07";
//						targetsProvision.add(targetb);
//					}  else if(distributedQueues.equals("vas.OnlineConnectorOut")){
//						String target = "sisconnectorhx06";
//						targetsProvision.add(target);
//						String targetb = "sisconnectorhx07";
//						targetsProvision.add(targetb);
//					}  else if(distributedQueues.equals("wli.OnlineConnectorIn")){
//						String target = "sisconnectorhx06";
//						targetsProvision.add(target);
//						String targetb = "sisconnectorhx07";
//						targetsProvision.add(targetb);
//					}  else if(distributedQueues.equals("wli.OnlineConnectorOut")){
//						String target = "sisconnectorhx06";
//						targetsProvision.add(target);
//						String targetb = "sisconnectorhx07";
//						targetsProvision.add(targetb);
//					}  else if(distributedQueues.equals("ogs.OnlineConnectorIn")){
//						String target = "sisconnectorhx06";
//						targetsProvision.add(target);
//						String targetb = "sisconnectorhx07";
//						targetsProvision.add(targetb);
//					}  else if(distributedQueues.equals("ogs.OnlineConnectorOut")){
//						String target = "sisconnectorhx06";
//						targetsProvision.add(target);
//						String targetb = "sisconnectorhx07";
//						targetsProvision.add(targetb);
//					}  	else if(distributedQueues.equals("wms.OnlineConnectorIn")){
//						String target = "sisconnectorhx06";
//						targetsProvision.add(target);
//						String targetb = "sisconnectorhx07";
//						targetsProvision.add(targetb);
//					}  else if(distributedQueues.equals("wms.OnlineConnectorOut")){
//						String target = "sisconnectorhx06";
//						targetsProvision.add(target);
//						String targetb = "sisconnectorhx07";
//						targetsProvision.add(targetb);
//					}  else if(distributedQueues.equals("WorkflowDefinition")){
//						String target = "sisprovisioninghx06";
//						targetsProvision.add(target);
//						String targetb = "sisprovisioninghx07";
//						targetsProvision.add(targetb);
//					}  else if(distributedQueues.equals("xdsl.OnlineConnectorIn")){
//						String target = "sisconnectorhx06";
//						targetsProvision.add(target);
//						String targetb = "sisconnectorhx07";
//						targetsProvision.add(targetb);
//					}  else if(distributedQueues.equals("xdsl.OnlineConnectorOut")){
//						String target = "sisconnectorhx06";
//						targetsProvision.add(target);
//						String targetb = "sisconnectorhx07";
//						targetsProvision.add(targetb);
//					}
//					
//					for(String target : targetsProvision)
//					{
//						FileStore fileStore = new FileStore("FileStore_"+distributedQueues+"_"+target, "./FileStore/FileStore_"+distributedQueues+"_"+target, target, targetType);
//						fileStores.add(fileStore);
//						
//						JmsServer jmsServert = new JmsServer("JMSServer_"+distributedQueues+"_"+target, "FileStore_"+distributedQueues+"_"+target, target, targetType, 200000, 0);
//						jmsServers.add(jmsServert);
//						auxNetwork.add(jmsServert);
//						
//						Target targetJms = new Target("JMSServer_"+distributedQueues+"_"+target, Target.TargetType.JMSServer);
//						targetsJsmModuleSisModule.add(targetJms);
//
//						for (JmsServer jmsServer : auxNetwork) {
//							if(jmsServer.getName().equals("JMSServer_"+distributedQueues+"_"+target)){
//							//if(jmsServer.getName().contains(distributedQueues)){
//								listnetwork.add(jmsServer);
//							}
//						}
//						
//						for (Target targets : targetsJsmModuleSisModule) {
//							if(targets.getName().equals("JMSServer_"+distributedQueues+"_"+target)){
//							//if(targets.getName().contains(distributedQueues)){
//								targetsJsmModule.add(targets);
//							}
//						}
//						
//
//					}
//					Subdeployment subdeployment = new Subdeployment("Sub_"+distributedQueues, targetsJsmModule, listnetwork);			
//					subdeployments.add(subdeployment);	
//					
//					DistributedQueue distributedQueue = new DistributedQueue("sis."+distributedQueues, "Sub_"+distributedQueues, "TEMPLATE_SISTEMAS_EXTERNOS", deliveryFailure, "sis."+distributedQueues+"DLQ", priorityDestinationKey, null);
//					distributedSismodule.add(distributedQueue);
//					
//				}
//								
//				List<Target> targets = new ArrayList<Target>();
//								
//				String targetesSisconnector = "sisconnector";
//				Target targetesConnector = new Target(targetesSisconnector, Target.TargetType.Cluster);
//				targets.add(targetesConnector);
//				String targetesSishistory = "sishistory";
//				Target targetesHistory = new Target(targetesSishistory, Target.TargetType.Cluster);
//				targets.add(targetesHistory);
//				String targetesSisnetwork = "sisnetwork";
//				Target targetesNetwork = new Target(targetesSisnetwork, Target.TargetType.Cluster);
//				targets.add(targetesNetwork);
//				String targetesSisprovisioning = "sisprovisioning";
//				Target targetesProvisioning = new Target(targetesSisprovisioning, Target.TargetType.Cluster);
//				targets.add(targetesProvisioning);
//				
//				
//				String targetesSisserverconnhx06 = "serverconnhx06";
//				Target targetesServerconnhx06 = new Target(targetesSisserverconnhx06, Target.TargetType.Server);
//				targets.add(targetesServerconnhx06);
//				
//				String targetesSishistoryhx10a = "sishistoryhx10a";
//				Target targetesServerhistoryhx10a = new Target(targetesSishistoryhx10a, Target.TargetType.Server);
//				targets.add(targetesServerhistoryhx10a);
//				
//				String targetessismomhx05 = "sismomhx05";
//				Target targetesServersismomhx05 = new Target(targetessismomhx05, Target.TargetType.Server);
//				targets.add(targetesServersismomhx05);
//				
//				JmsModule jmsModule = new JmsModule(module, targets, connectionFactories, subdeployments, priorityDestinationKey, topics, distributedSismodule, queues, templateProvisioningModule, null, null);
//				jmsModules.add(jmsModule);
//
//			} 
//			else if(module.equals("sisnetworkmodule")){
//				List<DistributedQueue> distributedNetwork = new ArrayList<DistributedQueue>();
//				Template templateProvisioningModule = new Template("TEMPLATE_PLATAFORMAS", null);
//
//				List<Target> targetsJsmModuleSisNetwork = new ArrayList<Target>();
//	
//				List<String> sisnetwork = new ArrayList<String>();
//	
//				sisnetwork.add("sisnetworkhx08a");
//				sisnetwork.add("sisnetworkhx08b");
//				sisnetwork.add("sisnetworkhx09a");
//				sisnetwork.add("sisnetworkhx09b");
//				
//				for(String distributedQueuesNetwork : NETWORK_DISTRIBUTED_QUEUES) {
//					List<JmsServer> auxNetwork = new ArrayList<JmsServer>();
//					List<JmsServer> listnetwork = new ArrayList<JmsServer>();
//					List<Target> targetsJsmModule = new ArrayList<Target>();
//					
//					Random gerador = new Random();
//					int pos = gerador.nextInt(4);
//					
//					String sisnetework = sisnetwork.get(pos);
//												
//					String target = sisnetework;
//					String targetType = "Server";
//					
//					FileStore fileStore = new FileStore("FileStore_"+distributedQueuesNetwork+"_"+sisnetework, "./FileStore/FileStore_"+distributedQueuesNetwork+"_"+sisnetework, target, targetType);
//					fileStores.add(fileStore);
//					
//					JmsServer jmsServert = new JmsServer("JMSServer_"+distributedQueuesNetwork+"_"+sisnetework, "FileStore_"+distributedQueuesNetwork+"_"+sisnetework, target, targetType, 200000, 0);
//					jmsServers.add(jmsServert);
//					auxNetwork.add(jmsServert);
//					
//					Target targetJms = new Target("JMSServer_"+distributedQueuesNetwork+"_"+sisnetework, Target.TargetType.JMSServer);
//					targetsJsmModuleSisNetwork.add(targetJms);
//
//					for (JmsServer jmsServer : auxNetwork) {
//						if(jmsServer.getName().contains(distributedQueuesNetwork)){
//							listnetwork.add(jmsServer);
//						}
//					}
//					
//					for (Target targets : targetsJsmModuleSisNetwork) {
//						if(targets.getName().contains(distributedQueuesNetwork)){
//							targetsJsmModule.add(targets);
//						}
//					}
//					
//					Subdeployment subdeployment = new Subdeployment("Sub_"+distributedQueuesNetwork, targetsJsmModule, listnetwork);			
//					subdeploymentsNetworking.add(subdeployment);	
//					
//					DistributedQueue distributedQueue = new DistributedQueue(distributedQueuesNetwork, "Sub_"+distributedQueuesNetwork, "TEMPLATE_SISTEMAS_EXTERNOS", deliveryFailure, distributedQueuesNetwork+"_DLQ", priorityDestinationKey, null);
//					distributedNetwork.add(distributedQueue);
//					
//					
//				}
//				
//				List<Target> targets = new ArrayList<Target>();
//				
//				String targetesSisnetwork = "sisnetwork";
//				Target targetesNetwork = new Target(targetesSisnetwork, Target.TargetType.Cluster);
//				targets.add(targetesNetwork);
//				
//				JmsModule jmsModule = new JmsModule(module, targets, null, subdeploymentsNetworking, priorityDestinationKey, null, distributedNetwork, null, templateProvisioningModule, null, null);			
//				jmsModules.add(jmsModule);
//			
//			}
//			else if(module.equals("sisprovisioningmodule")){
//				List<DistributedQueue> distributedProvisioning = new ArrayList<DistributedQueue>();						
//				Template templateProvisioningModule = new Template("TEMPLATE_SISTEMAS_EXTERNOS", null);
//
//				List<Target> targetsJsmModuleSisprovisioning = new ArrayList<Target>();
//				
//				for(String distributedQueuesProvisioning : PROVISIONING_DISTRIBUTED_QUEUES) {
//					List<JmsServer> auxProvisioning = new ArrayList<JmsServer>();
//					List<JmsServer> listprovisioning = new ArrayList<JmsServer>();
//					List<Target> targetsJsmModule = new ArrayList<Target>();
//	
//					for(String sisprovis : SISPROVISIONING){
//						
//						String target = sisprovis;
//						String targetType = "Server";
//						
//						FileStore fileStore = new FileStore("FileStore_"+distributedQueuesProvisioning+"_"+sisprovis, "./FileStore/FileStore_"+distributedQueuesProvisioning+"_"+sisprovis, target, targetType);
//						fileStores.add(fileStore);
//						
//						JmsServer jmsServert = new JmsServer("JMSServer_"+distributedQueuesProvisioning+"_"+sisprovis, "FileStore_"+distributedQueuesProvisioning+"_"+sisprovis, target, targetType, 200000, 0);
//						jmsServers.add(jmsServert);
//						auxProvisioning.add(jmsServert);
//						
//						Target targetJms = new Target("JMSServer_"+distributedQueuesProvisioning+"_"+sisprovis, Target.TargetType.JMSServer);
//						targetsJsmModuleSisprovisioning.add(targetJms);
//						
//					}
//
//					for (JmsServer jmsServer : auxProvisioning) {
//						if(jmsServer.getName().contains(distributedQueuesProvisioning)){
//							listprovisioning.add(jmsServer);
//						}
//					}
//					
//					for (Target targets : targetsJsmModuleSisprovisioning) {
//						if(targets.getName().contains(distributedQueuesProvisioning)){
//							targetsJsmModule.add(targets);
//						}
//					}
//					
//					Subdeployment subdeployment = new Subdeployment("Sub_"+distributedQueuesProvisioning, targetsJsmModule, listprovisioning);			
//					subdeploymentsProvisioning.add(subdeployment);	
//					
//					DistributedQueue distributedQueue = new DistributedQueue("sis."+distributedQueuesProvisioning, "Sub_"+distributedQueuesProvisioning, "TEMPLATE_SISTEMAS_EXTERNOS", deliveryFailure, "sis."+distributedQueuesProvisioning+"DLQ", priorityDestinationKey, null);
//					distributedProvisioning.add(distributedQueue);
//					
//				}
//
//				List<Target> targets = new ArrayList<Target>();
//				
//				String targetesSisprovisioning = "sisprovisioning";
//				Target targetesProvisioning = new Target(targetesSisprovisioning, Target.TargetType.Cluster);
//				targets.add(targetesProvisioning);
//
//				
//				
//				JmsModule jmsModule = new JmsModule(module, targets, null, subdeploymentsProvisioning, priorityDestinationKey, null, distributedProvisioning, null, templateProvisioningModule, null, null);			
//				jmsModules.add(jmsModule);
//			}
//		}
//
//		List<JdbcStore> jdbcStores = new ArrayList<JdbcStore>();
//		
//
//		for (String workManagerName : WORK_MANAGER) {
//			if(workManagerName.equals("DBConnectorReply")){
//				List<Target> targetWorkManager = new ArrayList<Target>();
//				String targetName = "sisconnectorhx07";
//				Target target = new Target(targetName, Target.TargetType.Server); 
//				targetWorkManager.add(target);
//				
//				WorkManager workManager = new WorkManager(workManagerName, targetWorkManager, 8, 4);
//				workManagers.add(workManager);
//			} 
//			else if(workManagerName.equals("BatchReply")){
//				List<Target> targetWorkManager = new ArrayList<Target>();
//				String targetName = "sisnetwork";
//				Target target = new Target(targetName, Target.TargetType.Cluster); 
//				targetWorkManager.add(target);
//				
//				WorkManager workManager = new WorkManager(workManagerName, targetWorkManager, 16, 4);
//				workManagers.add(workManager);
//			}
//			else if(workManagerName.equals("BatchReplyValidator")){
//				List<Target> targetWorkManager = new ArrayList<Target>();
//				String targetName = "sisnetwork";
//				Target target = new Target(targetName, Target.TargetType.Cluster); 
//				targetWorkManager.add(target);
//				
//				WorkManager workManager = new WorkManager(workManagerName, targetWorkManager, 8, 4);
//				workManagers.add(workManager);
//			}
//			else if(workManagerName.equals("Aggregator")){
//				List<Target> targetWorkManager = new ArrayList<Target>();
//				String targetName = "sisprovisioning";
//				Target target = new Target(targetName, Target.TargetType.Cluster); 
//				targetWorkManager.add(target);
//				
//				WorkManager workManager = new WorkManager(workManagerName, targetWorkManager, 3, 12);
//				workManagers.add(workManager);
//			}
//			else if(workManagerName.equals("AggregatorAlternative")){
//				List<Target> targetWorkManager = new ArrayList<Target>();
//				String targetName = "sisprovisioning";
//				Target target = new Target(targetName, Target.TargetType.Cluster); 
//				targetWorkManager.add(target);
//				
//				WorkManager workManager = new WorkManager(workManagerName,  targetWorkManager, 3, 6);
//				workManagers.add(workManager);
//			}
//			else if(workManagerName.equals("ConnectorJms")){
//				List<Target> targetWorkManager = new ArrayList<Target>();
//				String targetName = "sisconnector";
//				Target target = new Target(targetName, Target.TargetType.Cluster); 
//				targetWorkManager.add(target);
//				
//				WorkManager workManager = new WorkManager(workManagerName, targetWorkManager, 8, 8);
//				workManagers.add(workManager);
//			}
//			else if(workManagerName.equals("ConnectorJmsReply")){
//				List<Target> targetWorkManager = new ArrayList<Target>();
//				String targetName = "sisconnector";
//				Target target = new Target(targetName, Target.TargetType.Cluster); 
//				targetWorkManager.add(target);
//				
//				WorkManager workManager = new WorkManager(workManagerName, targetWorkManager, 16, 16);
//				workManagers.add(workManager);
//			}
//			else if(workManagerName.equals("ProvisionerDefault")){
//				List<Target> targetWorkManager = new ArrayList<Target>();
//				String targetName = "sisprovisioning";
//				Target target = new Target(targetName, Target.TargetType.Cluster); 
//				targetWorkManager.add(target);
//				
//				WorkManager workManager = new WorkManager(workManagerName, targetWorkManager, 3, 2);
//				workManagers.add(workManager);				
//			}
//			else if(workManagerName.equals("ProvisionerIn")){
//				List<Target> targetWorkManager = new ArrayList<Target>();
//				String targetName = "sisprovisioning";
//				Target target = new Target(targetName, Target.TargetType.Cluster); 
//				targetWorkManager.add(target);
//				
//				WorkManager workManager = new WorkManager(workManagerName, targetWorkManager, 20, 1);
//				workManagers.add(workManager);
//			}
//			else if(workManagerName.equals("NetworkReply")){
//				List<Target> targetWorkManager = new ArrayList<Target>();
//				String targetName = "sisprovisioning";
//				Target target = new Target(targetName, Target.TargetType.Cluster); 
//				targetWorkManager.add(target);
//				
//				WorkManager workManager = new WorkManager(workManagerName, targetWorkManager, 10, 4);
//				workManagers.add(workManager);
//			}
//			else if(workManagerName.equals("NetworkIn")){
//				List<Target> targetWorkManager = new ArrayList<Target>();
//				String targetName = "sisnetwork";
//				Target target = new Target(targetName, Target.TargetType.Cluster); 
//				targetWorkManager.add(target);
//				
//				WorkManager workManager = new WorkManager(workManagerName, targetWorkManager, 3, 1);
//				workManagers.add(workManager);
//			}
//			else if(workManagerName.equals("HistoryEvent")){
//				List<Target> targetWorkManager = new ArrayList<Target>();
//				String targetName = "sishistory";
//				Target target = new Target(targetName, Target.TargetType.Cluster); 
//				targetWorkManager.add(target);
//				
//				WorkManager workManager = new WorkManager(workManagerName, targetWorkManager, 8, 4);
//				workManagers.add(workManager);
//			}
//			else if(workManagerName.equals("Supervisor")){
//				List<Target> targetWorkManager = new ArrayList<Target>();
//				String targetName = "sismomhx05";
//				Target target = new Target(targetName, Target.TargetType.Server); 
//				targetWorkManager.add(target);
//				
//				WorkManager workManager = new WorkManager(workManagerName, targetWorkManager, 200, 20);
//				workManagers.add(workManager);
//			}
//			else if(workManagerName.equals("Provisioner")){
//				List<Target> targetWorkManager = new ArrayList<Target>();
//				String targetNameS = "sismomhx05";
//				Target targetS = new Target(targetNameS, Target.TargetType.Server); 
//				targetWorkManager.add(targetS);
//				
//				String targetNameC = "sisprovisioning";
//				Target targetC = new Target(targetNameC, Target.TargetType.Cluster); 
//				targetWorkManager.add(targetC);
//				
//				WorkManager workManager = new WorkManager(workManagerName, targetWorkManager, 200, 20);
//				workManagers.add(workManager);
//			}
//			else if(workManagerName.equals("Network")){
//				List<Target> targetWorkManager = new ArrayList<Target>();
//				String targetNameS = "sismomhx05";
//				Target targetS = new Target(targetNameS, Target.TargetType.Server); 
//				targetWorkManager.add(targetS);
//				
//				String targetNameC = "sisnetwork";
//				Target targetC = new Target(targetNameC, Target.TargetType.Cluster); 
//				targetWorkManager.add(targetC);
//				
//				WorkManager workManager = new WorkManager(workManagerName, targetWorkManager, 200, 20);
//				workManagers.add(workManager);				
//			}
//			else if(workManagerName.equals("History")){
//				List<Target> targetWorkManager = new ArrayList<Target>();
//				String targetName = "sismomhx05";
//				Target target = new Target(targetName, Target.TargetType.Server); 
//				targetWorkManager.add(target);
//				
//				String targetNameC = "sishistory";
//				Target targetC = new Target(targetNameC, Target.TargetType.Cluster); 
//				targetWorkManager.add(targetC);
//				
//				WorkManager workManager = new WorkManager(workManagerName, targetWorkManager, 16, 8);
//				workManagers.add(workManager);
//			}
//			else if(workManagerName.equals("Connector")){
//				List<Target> targetWorkManager = new ArrayList<Target>();
//				String targetName = "sisconnector";
//				Target target = new Target(targetName, Target.TargetType.Cluster); 
//				targetWorkManager.add(target);
//				
//				String targetNameS = "sisconnectorhx07";
//				Target targetS = new Target(targetNameS, Target.TargetType.Server); 
//				targetWorkManager.add(targetS);
//				
//				
//				WorkManager workManager = new WorkManager(workManagerName, targetWorkManager, 40, 2);
//				workManagers.add(workManager);
//			}
//			else if(workManagerName.equals("NetworkActivatorResponse")){
//				List<Target> targetWorkManager = new ArrayList<Target>();
//				String targetName = "sisnetwork";
//				Target target = new Target(targetName, Target.TargetType.Cluster); 
//				targetWorkManager.add(target);
//				
//				WorkManager workManager = new WorkManager(workManagerName, targetWorkManager, 20, 2);
//				workManagers.add(workManager);
//			}
//			else if(workManagerName.equals("ConnectorReply")){
//				List<Target> targetWorkManager = new ArrayList<Target>();
//				String targetName = "sisconnector";
//				Target target = new Target(targetName, Target.TargetType.Cluster); 
//				targetWorkManager.add(target);
//				
//				String targetNameS = "sisconnectorhx07";
//				Target targetS = new Target(targetNameS, Target.TargetType.Server); 
//				targetWorkManager.add(targetS);
//				
//				WorkManager workManager = new WorkManager(workManagerName, targetWorkManager, 8, 4);
//				workManagers.add(workManager);
//			}
//			else if(workManagerName.equals("ConnectorJmsWorkManager")){
//				List<Target> targetWorkManager = new ArrayList<Target>();
//				String targetName = "sisconnector";
//				Target target = new Target(targetName, Target.TargetType.Cluster); 
//				targetWorkManager.add(target);
//				
//				WorkManager workManager = new WorkManager(workManagerName, targetWorkManager, 20, 20);
//				workManagers.add(workManager);
//			}
//			else if(workManagerName.equals("NetworkReplyDefault")){
//				List<Target> targetWorkManager = new ArrayList<Target>();
//				String targetName = "sisprovisioning";
//				Target target = new Target(targetName, Target.TargetType.Cluster); 
//				targetWorkManager.add(target);
//				
//				WorkManager workManager = new WorkManager(workManagerName, targetWorkManager, 3, 2);
//				workManagers.add(workManager);
//			}
//			else if(workManagerName.equals("NetworkReplyAlternative")){
//				List<Target> targetWorkManager = new ArrayList<Target>();
//				String targetName = "sisprovisioning";
//				Target target = new Target(targetName, Target.TargetType.Cluster); 
//				targetWorkManager.add(target);
//				
//				WorkManager workManager = new WorkManager(workManagerName, targetWorkManager, 20, 2);
//				workManagers.add(workManager);
//			}
//
//		}
//		
//		Enviroment enviroment = new Enviroment("TEMPLATE_PLATAFORMAS", null, domain, dataSources, fileStores, jdbcStores, jmsServers, jmsModules, "welcome1", "localhost:7001", "weblogic", workManagers, null, null);
//																	
//		createPyFile(enviroment);
//		
//	}
//
//	private static void distributedQueuesAndServersSimodule() {
//		sisModuleDistributedQueuesAndServers.put("db.ConnectorOut", Arrays.asList("serverconnhx06"));
//		sisModuleDistributedQueuesAndServers.put("EventHistory", Arrays.asList("sishistoryhx10a", "sishistoryhx10b"));
//		sisModuleDistributedQueuesAndServers.put("expediter.OnlineConnectorIn", Arrays.asList("sisconnectorhx06", "sisconnectorhx07"));
//		sisModuleDistributedQueuesAndServers.put("expediter.OnlineConnectorOut", Arrays.asList("sisconnectorhx06", "sisconnectorhx07"));
//		sisModuleDistributedQueuesAndServers.put("expediter_velox.OnlineConnectorIn", Arrays.asList("sisconnectorhx06", "sisconnectorhx07"));	
//		sisModuleDistributedQueuesAndServers.put("expediter_velox.OnlineConnectorOut", Arrays.asList("sisconnectorhx06", "sisconnectorhx07"));
//		sisModuleDistributedQueuesAndServers.put("gos.OnlineConnectorIn", Arrays.asList("sisconnectorhx06", "sisconnectorhx07"));
//		sisModuleDistributedQueuesAndServers.put("gos.OnlineConnectorOut", Arrays.asList("sisconnectorhx06", "sisconnectorhx07"));
//		sisModuleDistributedQueuesAndServers.put("loader.OnlineConnectorIn", Arrays.asList("sisconnectorhx06", "sisconnectorhx07"));
//		sisModuleDistributedQueuesAndServers.put("loader.OnlineConnectorOut", Arrays.asList("sisconnectorhx06", "sisconnectorhx07"));
//		sisModuleDistributedQueuesAndServers.put("m2m.OnlineConnectorIn", Arrays.asList("sisconnectorhx06", "sisconnectorhx07"));
//		sisModuleDistributedQueuesAndServers.put("m2m.OnlineConnectorOut", Arrays.asList("sisconnectorhx06", "sisconnectorhx07"));
//		sisModuleDistributedQueuesAndServers.put("mesox.OnlineConnectorIn", Arrays.asList("sisconnectorhx06", "sisconnectorhx07"));
//		sisModuleDistributedQueuesAndServers.put("mesox.OnlineConnectorOut", Arrays.asList("sisconnectorhx06", "sisconnectorhx07"));
//		sisModuleDistributedQueuesAndServers.put("mesox.OnlineConnectorOut_mesoxba", Arrays.asList("sisconnectorhx06", "sisconnectorhx07"));
//		sisModuleDistributedQueuesAndServers.put("mesox.OnlineConnectorOut_mesoxce", Arrays.asList("sisconnectorhx06", "sisconnectorhx07"));
//		sisModuleDistributedQueuesAndServers.put("mesox.OnlineConnectorOut_mesoxmg", Arrays.asList("sisconnectorhx06", "sisconnectorhx07"));
//		sisModuleDistributedQueuesAndServers.put("mesox.OnlineConnectorOut_mesoxpe", Arrays.asList("sisconnectorhx06", "sisconnectorhx07"));
//		sisModuleDistributedQueuesAndServers.put("mesox.OnlineConnectorOut_mesoxrj", Arrays.asList("sisconnectorhx06", "sisconnectorhx07"));
//		sisModuleDistributedQueuesAndServers.put("NetworkIn", Arrays.asList("sisnetworkhx08a", "sisnetworkhx08b", "sisnetworkhx09a", "sisnetworkhx09b"));
//		sisModuleDistributedQueuesAndServers.put("NetworkNalReturnProcessor", Arrays.asList("sisnetworkhx08a", "sisnetworkhx08b", "sisnetworkhx09a", "sisnetworkhx09b"));
//		sisModuleDistributedQueuesAndServers.put("NetworkPendantBatchReplyItem", Arrays.asList("sisnetworkhx08a", "sisnetworkhx08b", "sisnetworkhx09a", "sisnetworkhx09b"));		
//		sisModuleDistributedQueuesAndServers.put("NetworkReceivedBatchReplyItem", Arrays.asList("sisnetworkhx08a", "sisnetworkhx08b", "sisnetworkhx09a", "sisnetworkhx09b"));
//		sisModuleDistributedQueuesAndServers.put("NetworkReplyAlternativeAggregation", Arrays.asList("sisprovisioninghx06", "sisprovisioninghx07"));
//		sisModuleDistributedQueuesAndServers.put("NetworkReplyAlternative", Arrays.asList("sisprovisioninghx06", "sisprovisioninghx07"));
//		sisModuleDistributedQueuesAndServers.put("NetworkReplyDefaultAggregation", Arrays.asList("sisprovisioninghx06", "sisprovisioninghx07"));
//		sisModuleDistributedQueuesAndServers.put("NetworkReplyDefault", Arrays.asList("sisprovisioninghx06", "sisprovisioninghx07"));
//		sisModuleDistributedQueuesAndServers.put("NetworkReply", Arrays.asList("sisnetworkhx08a", "sisnetworkhx08b", "sisnetworkhx09a", "sisnetworkhx09b"));
//		sisModuleDistributedQueuesAndServers.put("oms.r2.OnlineConnectorIn", Arrays.asList("sisconnectorhx06", "sisconnectorhx07"));
//		sisModuleDistributedQueuesAndServers.put("oms.r2.OnlineConnectorOut", Arrays.asList("sisconnectorhx06", "sisconnectorhx07"));
//		sisModuleDistributedQueuesAndServers.put("ProvisionerInAlternative", Arrays.asList("sisprovisioninghx06", "sisprovisioninghx07"));
//		sisModuleDistributedQueuesAndServers.put("ProvisionerInDefault", Arrays.asList("sisprovisioninghx06", "sisprovisioninghx07"));
//		sisModuleDistributedQueuesAndServers.put("ProvisionerIn", Arrays.asList("sisprovisioninghx06", "sisprovisioninghx07"));
//		sisModuleDistributedQueuesAndServers.put("ProvisionerOut", Arrays.asList("sisprovisioninghx06", "sisprovisioninghx07"));
//		sisModuleDistributedQueuesAndServers.put("sac-soa.OnlineConnectorIn", Arrays.asList("sisconnectorhx06", "sisconnectorhx07"));
//		sisModuleDistributedQueuesAndServers.put("sac-soa.OnlineConnectorOut", Arrays.asList("sisconnectorhx06", "sisconnectorhx07"));
//		sisModuleDistributedQueuesAndServers.put("sac.r2.OnlineConnectorIn", Arrays.asList("sisconnectorhx06", "sisconnectorhx07"));
//		sisModuleDistributedQueuesAndServers.put("sac.r2.OnlineConnectorOut", Arrays.asList("sisconnectorhx06", "sisconnectorhx07"));
//		sisModuleDistributedQueuesAndServers.put("soa.OnlineConnectorIn", Arrays.asList("sisconnectorhx06", "sisconnectorhx07"));
//		sisModuleDistributedQueuesAndServers.put("soa.OnlineConnectorOut", Arrays.asList("sisconnectorhx06", "sisconnectorhx07"));
//		sisModuleDistributedQueuesAndServers.put("som.OnlineConnectorIn", Arrays.asList("sisconnectorhx06", "sisconnectorhx07"));
//		sisModuleDistributedQueuesAndServers.put("som.OnlineConnectorOut", Arrays.asList("sisconnectorhx06", "sisconnectorhx07"));
//		sisModuleDistributedQueuesAndServers.put("vas.OnlineConnectorIn", Arrays.asList("sisconnectorhx06", "sisconnectorhx07"));
//		sisModuleDistributedQueuesAndServers.put("vas.OnlineConnectorOut", Arrays.asList("sisconnectorhx06", "sisconnectorhx07"));
//		sisModuleDistributedQueuesAndServers.put("wli.OnlineConnectorIn", Arrays.asList("sisconnectorhx06", "sisconnectorhx07"));
//		sisModuleDistributedQueuesAndServers.put("wli.OnlineConnectorOut", Arrays.asList("sisconnectorhx06", "sisconnectorhx07"));
//		sisModuleDistributedQueuesAndServers.put("ogs.OnlineConnectorIn", Arrays.asList("sisconnectorhx06", "sisconnectorhx07"));
//		sisModuleDistributedQueuesAndServers.put("ogs.OnlineConnectorOut", Arrays.asList("sisconnectorhx06", "sisconnectorhx07"));
//		sisModuleDistributedQueuesAndServers.put("wms.OnlineConnectorIn", Arrays.asList("sisconnectorhx06", "sisconnectorhx07"));
//		sisModuleDistributedQueuesAndServers.put("wms.OnlineConnectorOut", Arrays.asList("sisconnectorhx06", "sisconnectorhx07"));
//		sisModuleDistributedQueuesAndServers.put("WorkflowDefinition", Arrays.asList("sisprovisioninghx06", "sisprovisioninghx07"));
//		sisModuleDistributedQueuesAndServers.put("xdsl.OnlineConnectorIn", Arrays.asList("sisconnectorhx06", "sisconnectorhx07"));
//		sisModuleDistributedQueuesAndServers.put("xdsl.OnlineConnectorOut", Arrays.asList("sisconnectorhx06", "sisconnectorhx07"));
//	
//	}
//
//	private static void createPyFile(Enviroment enviroment) {
//		WLSTCommands wlstCommands = new WLSTCommands();
//		FileWriter fileOutStream;
//		PrintWriter printStream;
//		String caminhoParaSalvarArquivo = ".";
//		StringBuilder nomeDoArquivo = new StringBuilder();
//		
//		try {
//			String conteudoArquivo = wlstCommands.createConfiguration(enviroment);
//			
//			Calendar calendario = Calendar.getInstance();
//			String agora = new SimpleDateFormat("yyyyMMdd_HHmmss").format(calendario.getTime());
//			nomeDoArquivo.append(enviroment.getDomain().getName()).append("_").append(agora);
//			
//			String caminhoCompleto = caminhoParaSalvarArquivo + "/" + nomeDoArquivo + ".py";
//			
//			//Salvar arquivo .py				
//			fileOutStream = new FileWriter(caminhoCompleto);
//			printStream = new PrintWriter(fileOutStream);
//			printStream.printf(conteudoArquivo.toString());
//			printStream.close();
//			
//			System.out.println("Arquivo '" + nomeDoArquivo + ".py' gerado com sucesso!");
//			
//			System.out.println("Iniciando a execucao do script gerado.....");
//			WLST.main( new String[]{caminhoCompleto});
//			
//		} catch(Exception e) {
//			System.out.println("Erro ao ler caminho digitado! Caminho atual esta sendo assumido para salvar o arquivo.");
//			e.printStackTrace();
//		}
//	}
}
