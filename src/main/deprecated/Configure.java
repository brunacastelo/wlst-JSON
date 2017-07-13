package main.deprecated;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import weblogic.WLST;
import wlst.WLSTCommands;
import wlst.objects.beans.AdminServer;
import wlst.objects.beans.Cluster;
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
import wlst.objects.beans.Topic;
import wlst.objects.beans.WorkManager;


/**
 *  
 *  Classe com as configuracoes referentes ao ambiente de produção. 
 *  Considerando que o ambiente ja esta configurado com servidores, cluster e DataSource 
 *  Author: Bruna Castelo Branco Santos
 *  Data: 21/02/2017
 *  
 *  
 * */

public class Configure {
//	
//	private static LinkedHashMap<String, List<String>> sisModuleTopicAndServers = new LinkedHashMap<>();
//	private static LinkedHashMap<String, List<String>> sisModuleQueuesAndServers = new LinkedHashMap<>();
//	private static LinkedHashMap<String, List<Integer>> sisModuleDeliveryFailure = new LinkedHashMap<>();
//	private static LinkedHashMap<String, List<String>> sisModuleDistributedQueuesAndServers = new LinkedHashMap<>();
//	
//	private static LinkedHashMap<String, List<Integer>> sisNetworkDeliveryFailure = new LinkedHashMap<>();
//	private static LinkedHashMap<String, List<String>> sisNetworkDistributedQueuesAndServers = new LinkedHashMap<>();
//	
//	private static LinkedHashMap<String, List<String>> sisProvisioningQueuesAndServers = new LinkedHashMap<>();
//	private static LinkedHashMap<String, List<Integer>> sisProvisioningDeliveryFailure = new LinkedHashMap<>();
//	
//	private static final String[] MODULES = {"sismodule", "sisnetworkmodule", "sisprovisioningmodule"};
//
//	/**
//	 * @param args
//	 * @throws Exception 
//	 */
//	public static void main(String[] args) throws Exception {
//		
//		topicAndServersSimodule();
//		queuesAndServersSimodule();
//		distributedQueuesAndServersSimodule();
//		distributedQueuesAndServersSisNetwork();
//		distributedQueuesAndServersProvisioning();
//		
//		List<Cluster> clusters = new ArrayList<Cluster>();
//		List<Topic> topics = new ArrayList<Topic>();
//		List<DataSource> dataSources = new ArrayList<DataSource>();
//		List<WorkManager> workManagers = new ArrayList<WorkManager>();
//		List<ManagedServer> managedServeres = new ArrayList<ManagedServer>();
//		List<Machine> machines = new ArrayList<Machine>();
//		
//		/* Criando topic */
//		for(Map.Entry<String, List<String>> entry: sisModuleTopicAndServers.entrySet()) {
//			String topicEach = entry.getKey();
//			
//			List<Target> targets = new ArrayList<Target>();
//			
//			List<Integer> deliveryParams = sisModuleDeliveryFailure.get(topicEach);
//			int redeliveryDelayOverride = deliveryParams.get(0);
//			int redeliveryLimit = deliveryParams.get(1);
//
//			List<FileStore> fileStores = new ArrayList<FileStore>();
//			List<JmsServer> jmsServers = new ArrayList<JmsServer>();
//			
//			List<Target> targetsJsmModuleSismoduleTopic = new ArrayList<Target>();
//			String targetType = "Server";
//			
//			for(int i = 0; i < entry.getValue().size(); i++) {
//				String target = entry.getValue().get(i);
//				Target targetes = new Target(target, Target.TargetType.Server);
//				targets.add(targetes);
//				
//				Target targetJmsTopic = new Target("JMSServer_"+topicEach+"_"+target, Target.TargetType.JMSServer);
//				targetsJsmModuleSismoduleTopic.add(targetJmsTopic);
//				
//				FileStore fileStore = new FileStore("FileStore_"+topicEach+"_"+target, "./FileStore/FileStore_"+topicEach+"_"+target, target, targetType);
//				fileStores.add(fileStore);
//				
//				JmsServer jmsServer = new JmsServer("JMSServer_"+topicEach+"_"+target, "FileStore_"+topicEach+"_"+target, target, targetType, 200000, 0);
//				jmsServers.add(jmsServer);
//				
//				Subdeployment subdeployment = new Subdeployment("Sub_"+topicEach, targetsJsmModuleSismoduleTopic, jmsServers);
//					
//				Topic topic = new Topic("sis."+topicEach+"Topic", subdeployment.getName(), fileStore, redeliveryDelayOverride, -1, "Delivery", redeliveryLimit, targets);
//				topics.add(topic);
//			}
//		}
//
//		/* Criando AdminServer */
//		AdminServer adminServer = new AdminServer("AdminServer", 7001, 7002);
//		
//		/* Criando Domain */
//		Domain domain = new Domain("sisdevdomain", "weblogic", "welcome1", "t3://localhost:7001", machines, adminServer, managedServeres, clusters);
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
//				/* Criando PriorityDestinationKey */
//				PriorityDestinationKey priorityDestinationKey = new PriorityDestinationKey("PriorityDestinationKey", "JMSPriority", "long", "descending");
//				
//				/* Criando Queue Sismodule */
//				for(Map.Entry<String, List<String>> entry: sisModuleQueuesAndServers.entrySet()) {
//					String queue = entry.getKey();
//					String targetType = "Server";	
//					
//					
//					List<Integer> deliveryParams = sisModuleDeliveryFailure.get(queue);
//					int redeliveryDelayOverride = deliveryParams.get(0);
//					int redeliveryLimit = deliveryParams.get(1);
//					
//					/* Criando deliveryFailure */
//					DeliveryFailure deliveryFailure = new DeliveryFailure(redeliveryDelayOverride, redeliveryLimit, "discard", "", -1, "No-Delivery");
//					
//					for(int i = 0; i < entry.getValue().size(); i++) {
//						String target = entry.getValue().get(i);
//						
//						List<Target> targetsJsmModuleSismoduleQueue = new ArrayList<Target>();
//						Target targetJmsQueue = new Target("JMSServer_"+queue+"_"+target, Target.TargetType.JMSServer);
//						targetsJsmModuleSismoduleQueue.add(targetJmsQueue);
//						
//						FileStore fileStore = new FileStore("FileStore_"+queue+"_"+target, "./FileStore/FileStore_"+queue+"_"+target, target, targetType);
//						fileStores.add(fileStore);
//						
//						List<JmsServer> auxJmsServers = new ArrayList<JmsServer>();
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
//				/* Criando DistributedQueues Sismodule */
//				for(Map.Entry<String, List<String>> entry: sisModuleDistributedQueuesAndServers.entrySet()) {
//					String distributedQueues = entry.getKey();
//					
//					List<Integer> deliveryParams = sisModuleDeliveryFailure.get(distributedQueues);
//					int redeliveryDelayOverride = deliveryParams.get(0);
//					int redeliveryLimit = deliveryParams.get(1);
//
//					/* Criando deliveryFailure */
//					DeliveryFailure deliveryFailure = new DeliveryFailure(redeliveryDelayOverride, redeliveryLimit, "discard", "", -1, "No-Delivery");
//
//					List<JmsServer> auxNetwork = new ArrayList<JmsServer>();
//					List<JmsServer> listnetwork = new ArrayList<JmsServer>();
//					List<Target> targetsJsmModule = new ArrayList<Target>();
//					String targetType = "Server";
//					
//					for(int i = 0; i < entry.getValue().size(); i++) {
//						String target = entry.getValue().get(i);
//
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
//								listnetwork.add(jmsServer);
//							}
//						}
//					
//						for (Target targets : targetsJsmModuleSisModule) {
//							if(targets.getName().equals("JMSServer_"+distributedQueues+"_"+target)){
//								targetsJsmModule.add(targets);
//							}
//						}
//					}
//					
//					Subdeployment subdeployment = new Subdeployment("Sub_"+distributedQueues, targetsJsmModule, listnetwork);			
//					subdeployments.add(subdeployment);	
//					
//					DistributedQueue distributedQueue = new DistributedQueue("sis."+distributedQueues, "Sub_"+distributedQueues, "TEMPLATE_SISTEMAS_EXTERNOS", deliveryFailure, "sis."+distributedQueues+"DLQ", priorityDestinationKey, null);
//					distributedSismodule.add(distributedQueue);
//				}
//				
//				/* Criando targets do modulo */
//				List<Target> targets = new ArrayList<Target>();
//								
//				String targetesSisconnector = "sisdx06a";
//				Target targetesConnector = new Target(targetesSisconnector, Target.TargetType.Server);
//				targets.add(targetesConnector);
//				/*String targetesSishistory = "sishistoryprd";
//				Target targetesHistory = new Target(targetesSishistory, Target.TargetType.Cluster);
//				targets.add(targetesHistory);
//				String targetesSisnetwork = "sisnetworkprd";
//				Target targetesNetwork = new Target(targetesSisnetwork, Target.TargetType.Cluster);
//				targets.add(targetesNetwork);
//				String targetesSisprovisioning = "sisprovisioningprd";
//				Target targetesProvisioning = new Target(targetesSisprovisioning, Target.TargetType.Cluster);
//				targets.add(targetesProvisioning);
//				String targetessisdx06aconnhx06 = "sismonprd39a";
//				Target targetesServerconnhx06 = new Target(targetessisdx06aconnhx06, Target.TargetType.Server);
//				targets.add(targetesServerconnhx06);
//				String targetesSishistoryhx10a = "serverconnprd41a";
//				Target targetesServerhistoryhx10a = new Target(targetesSishistoryhx10a, Target.TargetType.Server);
//				targets.add(targetesServerhistoryhx10a);
//				*/
//				JmsModule jmsModule = new JmsModule(module, targets, null, subdeployments, priorityDestinationKey, topics, distributedSismodule, queues, null, null, null);
//				jmsModules.add(jmsModule);
//
//			} 
//			else if(module.equals("sisnetworkmodule")){
//				
//				/* Criando PriorityDestinationKey */
//				PriorityDestinationKey priorityDestinationKey = new PriorityDestinationKey("NetworkPriorityDestinationKey", "JMSPriority", "long", "descending");
//				
//				List<DistributedQueue> distributedNetwork = new ArrayList<DistributedQueue>();
//
//				List<Target> targetsJsmModuleSisNetwork = new ArrayList<Target>();
//				String targetType = "Server";
//
//				/* Criando DistributedQueues sisnetworkmodule */
//				for(Map.Entry<String, List<String>> entry: sisNetworkDistributedQueuesAndServers.entrySet()) {
//					String distributedQueuesNetwork = entry.getKey();
//					
//					List<Integer> deliveryParams = sisNetworkDeliveryFailure.get(distributedQueuesNetwork);
//					int redeliveryDelayOverride = deliveryParams.get(0);
//					int redeliveryLimit = deliveryParams.get(1);
//					
//					/* Criando deliveryFailure */
//					DeliveryFailure deliveryFailure = new DeliveryFailure(redeliveryDelayOverride, redeliveryLimit, "discard", "", -1, "No-Delivery");
//					
//					List<Target> targetsJsmModule = new ArrayList<Target>();
//					List<JmsServer> auxNetwork = new ArrayList<JmsServer>();
//					List<JmsServer> listnetwork = new ArrayList<JmsServer>();
//					
//					for(int i = 0; i < entry.getValue().size(); i++) {
//						String target = entry.getValue().get(i);
//
//						FileStore fileStore = new FileStore("FileStore_"+distributedQueuesNetwork+"_"+target, "./FileStore/FileStore_"+distributedQueuesNetwork+"_"+target, target, targetType);
//						fileStores.add(fileStore);
//						
//						JmsServer jmsServert = new JmsServer("JMSServer_"+distributedQueuesNetwork+"_"+target, "FileStore_"+distributedQueuesNetwork+"_"+target, target, targetType, 200000, 0);
//						jmsServers.add(jmsServert);
//						auxNetwork.add(jmsServert);
//						
//						Target targetJms = new Target("JMSServer_"+distributedQueuesNetwork+"_"+target, Target.TargetType.JMSServer);
//						targetsJsmModuleSisNetwork.add(targetJms);
//	
//						for (JmsServer jmsServer : auxNetwork) {
//							if(jmsServer.getName().contains(distributedQueuesNetwork)){
//								listnetwork.add(jmsServer);
//							}
//						}
//						
//						for (Target targets : targetsJsmModuleSisNetwork) {
//							if(targets.getName().contains(distributedQueuesNetwork)){
//								targetsJsmModule.add(targets);
//							}
//						}
//					}
//					Subdeployment subdeployment = new Subdeployment("Sub_"+distributedQueuesNetwork, targetsJsmModule, listnetwork);			
//					subdeploymentsNetworking.add(subdeployment);	
//					
//					DistributedQueue distributedQueue = new DistributedQueue(distributedQueuesNetwork, "Sub_"+distributedQueuesNetwork, "TEMPLATE_SISTEMAS_EXTERNOS", deliveryFailure, distributedQueuesNetwork+"_DLQ", priorityDestinationKey, null);
//					distributedNetwork.add(distributedQueue);
//	
//				}
//				
//				List<Target> targets = new ArrayList<Target>();
//				
//				String targetesSisnetwork = "sisdx06a";
//				Target targetesNetwork = new Target(targetesSisnetwork, Target.TargetType.Server);
//				targets.add(targetesNetwork);
//				
//				JmsModule jmsModule = new JmsModule(module, targets, null, subdeploymentsNetworking, priorityDestinationKey, null, distributedNetwork, null, null, null, null);			
//				jmsModules.add(jmsModule);
//			
//			}
//			else if(module.equals("sisprovisioningmodule")){
//				/* Criando PriorityDestinationKey */
//				PriorityDestinationKey priorityDestinationKey = new PriorityDestinationKey("PriorityDestinationKey", "JMSPriority", "long", "descending");
//								
//				List<DistributedQueue> distributedProvisioning = new ArrayList<DistributedQueue>();						
//
//				List<Target> targetsJsmModuleSisprovisioning = new ArrayList<Target>();
//				String targetType = "Server";
//
//				/* Criando DistributedQueues sisprovisioningmodule */
//				for(Map.Entry<String, List<String>> entry: sisProvisioningQueuesAndServers.entrySet()) {
//					String distributedQueuesProvisioning = entry.getKey();
//					
//					List<Integer> deliveryParams = sisProvisioningDeliveryFailure.get(distributedQueuesProvisioning);
//					int redeliveryDelayOverride = deliveryParams.get(0);
//					int redeliveryLimit = deliveryParams.get(1);
//					
//					/* Criando deliveryFailure */
//					DeliveryFailure deliveryFailure = new DeliveryFailure(redeliveryDelayOverride, redeliveryLimit, "discard", "", -1, "No-Delivery");
//					
//					List<Target> targetsJsmModule = new ArrayList<Target>();
//					List<JmsServer> auxProvisioning = new ArrayList<JmsServer>();
//					List<JmsServer> listProvisioning = new ArrayList<JmsServer>();
//					
//					for(int i = 0; i < entry.getValue().size(); i++) {
//						String target = entry.getValue().get(i);
//
//						FileStore fileStore = new FileStore("FileStore_"+distributedQueuesProvisioning+"_"+target, "./FileStore/FileStore_"+distributedQueuesProvisioning+"_"+target, target, targetType);
//						fileStores.add(fileStore);
//						
//						JmsServer jmsServert = new JmsServer("JMSServer_"+distributedQueuesProvisioning+"_"+target, "FileStore_"+distributedQueuesProvisioning+"_"+target, target, targetType, 200000, 0);
//						jmsServers.add(jmsServert);
//						auxProvisioning.add(jmsServert);
//						
//						Target targetJms = new Target("JMSServer_"+distributedQueuesProvisioning+"_"+target, Target.TargetType.JMSServer);
//						targetsJsmModuleSisprovisioning.add(targetJms);
//						
//						for (JmsServer jmsServer : auxProvisioning) {
//							if(jmsServer.getName().contains(distributedQueuesProvisioning)){
//								listProvisioning.add(jmsServer);
//							}
//						}
//						
//						for (Target targets : targetsJsmModuleSisprovisioning) {
//							if(targets.getName().contains(distributedQueuesProvisioning)){
//								targetsJsmModule.add(targets);
//							}
//						}
//					}
//					
//					Subdeployment subdeployment = new Subdeployment("Sub_"+distributedQueuesProvisioning, targetsJsmModule, listProvisioning);			
//					subdeploymentsProvisioning.add(subdeployment);	
//					
//					DistributedQueue distributedQueue = new DistributedQueue("sis."+distributedQueuesProvisioning, "Sub_"+distributedQueuesProvisioning, "TEMPLATE_SISTEMAS_EXTERNOS", deliveryFailure, "sis."+distributedQueuesProvisioning+"DLQ", priorityDestinationKey, null);
//					distributedProvisioning.add(distributedQueue);
//				}
//				
//
//				List<Target> targets = new ArrayList<Target>();
//				
//				String targetesSisprovisioning = "sisdx06a";
//				Target targetesProvisioning = new Target(targetesSisprovisioning, Target.TargetType.Server);
//				targets.add(targetesProvisioning);
//
//				JmsModule jmsModule = new JmsModule(module, targets, null, subdeploymentsProvisioning, priorityDestinationKey, null, distributedProvisioning, null, null, null, null);			
//				jmsModules.add(jmsModule);
//				
//			}
//
//		}
//
//		List<JdbcStore> jdbcStores = new ArrayList<JdbcStore>();
//		
//		Enviroment enviroment = new Enviroment("TEMPLATE_PLATAFORMAS", null, domain, dataSources, fileStores, jdbcStores, jmsServers, jmsModules, "welcome1", "localhost:7001", "weblogic", workManagers, null, null);
//																	
//		createPyFile(enviroment);
//		
//	}
//
//	private static void topicAndServersSimodule() {
//		/* Criando Topic e associcações server sismodule */
//		sisModuleTopicAndServers.put("MonConnectors", Arrays.asList("sisdx06a"));
//		sisModuleTopicAndServers.put("SupervisorToMonitorNetwork", Arrays.asList("sisdx06a"));
//		sisModuleTopicAndServers.put("SupervisorToMonitorProvisioning", Arrays.asList("sisdx06a"));
//		
//		/* Criando Delivery Failure sismodule */
//		sisModuleDeliveryFailure.put("MonConnectors", Arrays.asList(2000, 1));
//		sisModuleDeliveryFailure.put("SupervisorToMonitorNetwork", Arrays.asList(2000, 1));
//		sisModuleDeliveryFailure.put("SupervisorToMonitorProvisioning", Arrays.asList(1, 0));		
//	}
//	
//	private static void queuesAndServersSimodule() {
//		/* Criando Filas e associcações server sismodule */
//		sisModuleQueuesAndServers.put("ProvisionerAggregation", Arrays.asList("sisdx06a"));
//		sisModuleQueuesAndServers.put("NetworkConnectorOut", Arrays.asList("sisdx06a"));
//		sisModuleQueuesAndServers.put("NetworkSupervisorDetail", Arrays.asList("sisdx06a"));
//		sisModuleQueuesAndServers.put("ProvisioningSupervisorDetail", Arrays.asList("sisdx06a"));
//		
//		/* Criando Delivery Failure sismodule */
//		sisModuleDeliveryFailure.put("ProvisionerAggregation", Arrays.asList(30, 5));
//		sisModuleDeliveryFailure.put("NetworkConnectorOut", Arrays.asList(2000, 1));
//		sisModuleDeliveryFailure.put("NetworkSupervisorDetail", Arrays.asList(2000, 1));
//		sisModuleDeliveryFailure.put("ProvisioningSupervisorDetail", Arrays.asList(1, -1));
//	}
//	
//	private static void distributedQueuesAndServersSimodule() {
//		/* Criando Filas Distribuidas e associcações server sismodule */
//		sisModuleDistributedQueuesAndServers.put("db.ConnectorOut", Arrays.asList("sisdx06a"));
//		sisModuleDistributedQueuesAndServers.put("EventHistory", Arrays.asList("sisdx06a"));
//		sisModuleDistributedQueuesAndServers.put("expediter.OnlineConnectorIn", Arrays.asList("sisdx06a"));
//		sisModuleDistributedQueuesAndServers.put("expediter.OnlineConnectorOut", Arrays.asList("sisdx06a"));
//		sisModuleDistributedQueuesAndServers.put("gos.OnlineConnectorIn", Arrays.asList("sisdx06a"));
//		sisModuleDistributedQueuesAndServers.put("gos.OnlineConnectorOut", Arrays.asList("sisdx06a"));
//		sisModuleDistributedQueuesAndServers.put("loader.OnlineConnectorIn", Arrays.asList("sisdx06a"));
//		sisModuleDistributedQueuesAndServers.put("loader.OnlineConnectorOut", Arrays.asList("sisdx06a"));
//		sisModuleDistributedQueuesAndServers.put("mesox.OnlineConnectorIn", Arrays.asList("sisdx06a"));
//		sisModuleDistributedQueuesAndServers.put("mesox.OnlineConnectorOut", Arrays.asList("sisdx06a"));
//		sisModuleDistributedQueuesAndServers.put("mesox.OnlineConnectorOutMesoxba", Arrays.asList("sisdx06a"));
//		sisModuleDistributedQueuesAndServers.put("mesox.OnlineConnectorOutMesoxmg", Arrays.asList("sisdx06a"));
//		sisModuleDistributedQueuesAndServers.put("mesox.OnlineConnectorOutMesoxpe", Arrays.asList("sisdx06a"));
//		sisModuleDistributedQueuesAndServers.put("mesox.OnlineConnectorOutMesoxrj", Arrays.asList("sisdx06a"));
//		sisModuleDistributedQueuesAndServers.put("mesox.OnlineConnectorOutMesxoce", Arrays.asList("sisdx06a"));
//		sisModuleDistributedQueuesAndServers.put("NetworkBatchReply", Arrays.asList("sisdx06a"));
//		sisModuleDistributedQueuesAndServers.put("NetworkIn", Arrays.asList("sisdx06a"));
//		sisModuleDistributedQueuesAndServers.put("NetworkPendantBatchReplyItem", Arrays.asList("sisdx06a"));
//		sisModuleDistributedQueuesAndServers.put("NetworkReceivedBatchReplyItem", Arrays.asList("sisdx06a"));
//		sisModuleDistributedQueuesAndServers.put("NetworkReplyAlternativeAggregation", Arrays.asList("sisdx06a"));
//		sisModuleDistributedQueuesAndServers.put("NetworkReplyAlternative", Arrays.asList("sisdx06a"));
//		sisModuleDistributedQueuesAndServers.put("NetworkReplyDefaultAggregation", Arrays.asList("sisdx06a"));
//		sisModuleDistributedQueuesAndServers.put("NetworkReplyDefault", Arrays.asList("sisdx06a"));
//		sisModuleDistributedQueuesAndServers.put("NetworkReply", Arrays.asList("sisdx06a"));
//		sisModuleDistributedQueuesAndServers.put("ProvisionerAssyncTask", Arrays.asList("sisdx06a"));
//		sisModuleDistributedQueuesAndServers.put("ProvisionerInAlternative", Arrays.asList("sisdx06a"));
//		sisModuleDistributedQueuesAndServers.put("ProvisionerInDefault", Arrays.asList("sisdx06a"));
//		sisModuleDistributedQueuesAndServers.put("ProvisionerIn", Arrays.asList("sisdx06a"));
//		sisModuleDistributedQueuesAndServers.put("ProvisionerOut", Arrays.asList("sisdx06a"));
//		sisModuleDistributedQueuesAndServers.put("ProvisionerReplyAggregationAlternative", Arrays.asList("sisdx06a"));
//		sisModuleDistributedQueuesAndServers.put("ProvisionerReplyAggregation", Arrays.asList("sisdx06a"));
//		sisModuleDistributedQueuesAndServers.put("soa.OnlineConnectorIn", Arrays.asList("sisdx06a"));
//		sisModuleDistributedQueuesAndServers.put("soa.OnlineConnectorOut", Arrays.asList("sisdx06a"));
//		sisModuleDistributedQueuesAndServers.put("som.OnlineConnectorIn", Arrays.asList("sisdx06a"));
//		sisModuleDistributedQueuesAndServers.put("som.OnlineConnectorOut", Arrays.asList("sisdx06a"));
//		sisModuleDistributedQueuesAndServers.put("vas.OnlineConnectorIn", Arrays.asList("sisdx06a"));
//		sisModuleDistributedQueuesAndServers.put("vas.OnlineConnectorOut", Arrays.asList("sisdx06a"));
//		sisModuleDistributedQueuesAndServers.put("wli.OnlineConnectorIn", Arrays.asList("sisdx06a"));
//		sisModuleDistributedQueuesAndServers.put("wli.OnlineConnectorOut", Arrays.asList("sisdx06a"));
//		sisModuleDistributedQueuesAndServers.put("WorkflowDefinition", Arrays.asList("sisdx06a"));
//		sisModuleDistributedQueuesAndServers.put("m2m.OnlineConnectorIn", Arrays.asList("sisdx06a"));
//		sisModuleDistributedQueuesAndServers.put("m2m.OnlineConnectorOut", Arrays.asList("sisdx06a"));
//		sisModuleDistributedQueuesAndServers.put("ogs.OnlineConnectorIn", Arrays.asList("sisdx06a"));
//		sisModuleDistributedQueuesAndServers.put("ogs.OnlineConnectorOut", Arrays.asList("sisdx06a"));
//		sisModuleDistributedQueuesAndServers.put("NetworkNalReturnProcessor", Arrays.asList("sisdx06a"));
//		
//		/* Criando Delivery Failure sismodule */
//		sisModuleDeliveryFailure.put("db.ConnectorOut", Arrays.asList(5000, 5));
//		sisModuleDeliveryFailure.put("EventHistory", Arrays.asList(30000, 0));
//		sisModuleDeliveryFailure.put("expediter.OnlineConnectorIn", Arrays.asList(30000, 50000));
//		sisModuleDeliveryFailure.put("expediter.OnlineConnectorOut", Arrays.asList(30000, 50000));
//		sisModuleDeliveryFailure.put("gos.OnlineConnectorIn", Arrays.asList(50000, 5));
//		sisModuleDeliveryFailure.put("gos.OnlineConnectorOut", Arrays.asList(50000, 5));
//		sisModuleDeliveryFailure.put("loader.OnlineConnectorIn", Arrays.asList(2000, 1));
//		sisModuleDeliveryFailure.put("loader.OnlineConnectorOut", Arrays.asList(2000, 1));
//		sisModuleDeliveryFailure.put("mesox.OnlineConnectorIn", Arrays.asList(30000, 5));
//		sisModuleDeliveryFailure.put("mesox.OnlineConnectorOut", Arrays.asList(30000, 5));
//		sisModuleDeliveryFailure.put("mesox.OnlineConnectorOutMesoxba", Arrays.asList(50000, 5));
//		sisModuleDeliveryFailure.put("mesox.OnlineConnectorOutMesoxmg", Arrays.asList(50000, 5));
//		sisModuleDeliveryFailure.put("mesox.OnlineConnectorOutMesoxpe", Arrays.asList(50000, 5));
//		sisModuleDeliveryFailure.put("mesox.OnlineConnectorOutMesoxrj", Arrays.asList(50000, 30000));
//		sisModuleDeliveryFailure.put("mesox.OnlineConnectorOutMesxoce", Arrays.asList(50000, 5));
//		sisModuleDeliveryFailure.put("NetworkBatchReply", Arrays.asList(50000, 5));
//		sisModuleDeliveryFailure.put("NetworkIn", Arrays.asList(2000, 1));
//		sisModuleDeliveryFailure.put("NetworkPendantBatchReplyItem", Arrays.asList(50000, 5));
//		sisModuleDeliveryFailure.put("NetworkReceivedBatchReplyItem", Arrays.asList(30000, 5));
//		sisModuleDeliveryFailure.put("NetworkReplyAlternativeAggregation", Arrays.asList(2000, 1));
//		sisModuleDeliveryFailure.put("NetworkReplyAlternative", Arrays.asList(2000, 1));
//		sisModuleDeliveryFailure.put("NetworkReplyDefaultAggregation", Arrays.asList(2000, 1));
//		sisModuleDeliveryFailure.put("NetworkReplyDefault", Arrays.asList(2000, 1));
//		sisModuleDeliveryFailure.put("NetworkReply", Arrays.asList(2000, 1));
//		sisModuleDeliveryFailure.put("ProvisionerAssyncTask", Arrays.asList(30000, 1));
//		sisModuleDeliveryFailure.put("ProvisionerInAlternative", Arrays.asList(2000, 1));
//		sisModuleDeliveryFailure.put("ProvisionerInDefault", Arrays.asList(2000, 1));
//		sisModuleDeliveryFailure.put("ProvisionerIn", Arrays.asList(2000, 1));
//		sisModuleDeliveryFailure.put("ProvisionerOut", Arrays.asList(2000, 1));
//		sisModuleDeliveryFailure.put("ProvisionerReplyAggregationAlternative", Arrays.asList(2000, 1));
//		sisModuleDeliveryFailure.put("ProvisionerReplyAggregation", Arrays.asList(2000, 1));
//		sisModuleDeliveryFailure.put("soa.OnlineConnectorIn", Arrays.asList(2000, 1));
//		sisModuleDeliveryFailure.put("soa.OnlineConnectorOut", Arrays.asList(2000, 1));
//		sisModuleDeliveryFailure.put("som.OnlineConnectorIn", Arrays.asList(2000, 1));
//		sisModuleDeliveryFailure.put("som.OnlineConnectorOut", Arrays.asList(2000, 1));
//		sisModuleDeliveryFailure.put("vas.OnlineConnectorIn", Arrays.asList(2000, 1));
//		sisModuleDeliveryFailure.put("vas.OnlineConnectorOut", Arrays.asList(2000, 1));
//		sisModuleDeliveryFailure.put("wli.OnlineConnectorIn", Arrays.asList(2000, 1));
//		sisModuleDeliveryFailure.put("wli.OnlineConnectorOut", Arrays.asList(2000, 1));
//		sisModuleDeliveryFailure.put("WorkflowDefinition", Arrays.asList(30000, 5));
//		sisModuleDeliveryFailure.put("m2m.OnlineConnectorIn", Arrays.asList(30000, 5));
//		sisModuleDeliveryFailure.put("m2m.OnlineConnectorOut", Arrays.asList(30000, 5));
//		sisModuleDeliveryFailure.put("ogs.OnlineConnectorIn", Arrays.asList(2000, 1));
//		sisModuleDeliveryFailure.put("ogs.OnlineConnectorOut", Arrays.asList(2000, 1));
//		sisModuleDeliveryFailure.put("NetworkNalReturnProcessor", Arrays.asList(2000, 1));
//	
//	}
//	
//	private static void distributedQueuesAndServersSisNetwork() {
//		
//		/* Criando Filas Distribuidas e associcações server sisnetwork */	
//		sisNetworkDistributedQueuesAndServers.put("EPAP01", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("EPAP02", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("EPAP03", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("EPAP04", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("EPAP05", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("EPAP06", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("HLR01", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("HLR02", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("HLR03", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("HLR09", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("HLR11", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("HLR12", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("HLR13", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("HLR14", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("HLR19", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("HLR20", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("HLR22", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("HLR23", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("HLR29", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("HLR30", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("HLR31", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("HLR32", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("HLR33", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("HLR39", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("HLR40", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("HLR41", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("HLR42", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("HLR43", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("HLR44", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("HLR45", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("HLR46", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("HLR49", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("HLR50", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("HLR51", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("HLR52", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("HLR53", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("HLR64", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("HLR65", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("HLR69", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("HLR70", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("HLR71", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("HLR72", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("HLR73", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("HLR74", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("HLR75", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("HLR76", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("HLR77", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("HLR78", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("HLR79", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("HLR80", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("HLR81", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("HLR90", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("HLR99", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("LSMS01", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("MASC01", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("NPS01", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("OTA01", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("PMS01", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("PMS02", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("PMS03", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("PMS04", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("PMS05", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("PMS06", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("PMS07", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("PMS08", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("PMS09", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("PMSFIXA", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("PPM01", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("PTS01", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("PTS02", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("PTS03", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("RIM01", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("SMSC03", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("SMSC04", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("SMSC05", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("SMSC06", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("UDR01", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("VMP01", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("VMP02", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("VMP03", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("VMP04", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("VMP05", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("VMP06", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("VMP07", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("VMP08", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("VMP09", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("VMS01", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("VMS02", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("VMS03", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("VMS04", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("EMA01", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("NAPTI01", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("PMS10", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("SMSC07", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("SMSC08", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("UDR02", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("UDR03", Arrays.asList("sisdx06a"));
//		sisNetworkDistributedQueuesAndServers.put("NetworkInSub43_c_b", Arrays.asList("sisdx06a"));
//		
//		/* Criando Delivery Failure sisnetwork */
//		sisNetworkDeliveryFailure.put("EPAP01",  Arrays.asList(30000, 50000));
//		sisNetworkDeliveryFailure.put("EPAP02",  Arrays.asList(30000, 50000));
//		sisNetworkDeliveryFailure.put("EPAP03", Arrays.asList(30000, 50000));
//		sisNetworkDeliveryFailure.put("EPAP04", Arrays.asList(30000, 50000));
//		sisNetworkDeliveryFailure.put("EPAP05", Arrays.asList(30000, 50000));
//		sisNetworkDeliveryFailure.put("EPAP06", Arrays.asList(30000, 50000));
//		sisNetworkDeliveryFailure.put("HLR01", 	Arrays.asList(30000, 50000));
//		sisNetworkDeliveryFailure.put("HLR02", 	Arrays.asList(30000, 50000));
//		sisNetworkDeliveryFailure.put("HLR03", 	Arrays.asList(30000, 50000));
//		sisNetworkDeliveryFailure.put("HLR09", 	Arrays.asList(30000, 50000));
//		sisNetworkDeliveryFailure.put("HLR11", 	Arrays.asList(30000, 50000));
//		sisNetworkDeliveryFailure.put("HLR12", 	Arrays.asList(30000, 50000));
//		sisNetworkDeliveryFailure.put("HLR13", 	Arrays.asList(30000, 50000));
//		sisNetworkDeliveryFailure.put("HLR14", 	Arrays.asList(30000, 50000));
//		sisNetworkDeliveryFailure.put("HLR19", 	Arrays.asList(30000, 50000));
//		sisNetworkDeliveryFailure.put("HLR20", 	Arrays.asList(30000, 50000));
//		sisNetworkDeliveryFailure.put("HLR22", 	Arrays.asList(30000, 50000));
//		sisNetworkDeliveryFailure.put("HLR23", 	Arrays.asList(30000, 50000));
//		sisNetworkDeliveryFailure.put("HLR29", 	Arrays.asList(30000, 50000));
//		sisNetworkDeliveryFailure.put("HLR30", 	Arrays.asList(30000, 50000));
//		sisNetworkDeliveryFailure.put("HLR31", 	Arrays.asList(30000, 50000));
//		sisNetworkDeliveryFailure.put("HLR32", 	Arrays.asList(30000, 50000));
//		sisNetworkDeliveryFailure.put("HLR33", 	Arrays.asList(30000, 50000));
//		sisNetworkDeliveryFailure.put("HLR39", 	Arrays.asList(30000, 50000));
//		sisNetworkDeliveryFailure.put("HLR40", 	Arrays.asList(30000, 50000));
//		sisNetworkDeliveryFailure.put("HLR41", 	Arrays.asList(30000, 50000));
//		sisNetworkDeliveryFailure.put("HLR42", 	Arrays.asList(30000, 50000));
//		sisNetworkDeliveryFailure.put("HLR43", 	Arrays.asList(30000, 50000));
//		sisNetworkDeliveryFailure.put("HLR44", 	Arrays.asList(30000, 50000));
//		sisNetworkDeliveryFailure.put("HLR45", 	Arrays.asList(30000, 50000));
//		sisNetworkDeliveryFailure.put("HLR46", 	Arrays.asList(30000, 50000));
//		sisNetworkDeliveryFailure.put("HLR49", 	Arrays.asList(30000, 50000));
//		sisNetworkDeliveryFailure.put("HLR50", 	Arrays.asList(30000, 50000));
//		sisNetworkDeliveryFailure.put("HLR51", 	Arrays.asList(30000, 50000));
//		sisNetworkDeliveryFailure.put("HLR52", 	Arrays.asList(30000, 50000));
//		sisNetworkDeliveryFailure.put("HLR53", 	Arrays.asList(30000, 50000));
//		sisNetworkDeliveryFailure.put("HLR64", 	Arrays.asList(30000, 50000));
//		sisNetworkDeliveryFailure.put("HLR65", 	Arrays.asList(30000, 50000));
//		sisNetworkDeliveryFailure.put("HLR69", 	Arrays.asList(30000, 50000));
//		sisNetworkDeliveryFailure.put("HLR70", 	Arrays.asList(30000, 50000));
//		sisNetworkDeliveryFailure.put("HLR71", 	Arrays.asList(30000, 50000));
//		sisNetworkDeliveryFailure.put("HLR72", 	Arrays.asList(30000, 50000));
//		sisNetworkDeliveryFailure.put("HLR73", 	Arrays.asList(30000, 50000));
//		sisNetworkDeliveryFailure.put("HLR74", 	Arrays.asList(30000, 50000));
//		sisNetworkDeliveryFailure.put("HLR75", 	Arrays.asList(30000, 50000));
//		sisNetworkDeliveryFailure.put("HLR76", 	Arrays.asList(30000, 50000));
//		sisNetworkDeliveryFailure.put("HLR77", 	Arrays.asList(30000, 50000));
//		sisNetworkDeliveryFailure.put("HLR78", 	Arrays.asList(30000, 50000));
//		sisNetworkDeliveryFailure.put("HLR79", 	Arrays.asList(30000, 50000));
//		sisNetworkDeliveryFailure.put("HLR80", 	Arrays.asList(30000, 50000));
//		sisNetworkDeliveryFailure.put("HLR81", 	Arrays.asList(30000, 50000));
//		sisNetworkDeliveryFailure.put("HLR90", 	Arrays.asList(30000, 50000));
//		sisNetworkDeliveryFailure.put("HLR99", 	Arrays.asList(30000, 50000));
//		sisNetworkDeliveryFailure.put("LSMS01",	Arrays.asList(30000, 50000));
//		sisNetworkDeliveryFailure.put("MASC01",	Arrays.asList(30000, 50000));
//		sisNetworkDeliveryFailure.put("NPS01", 	Arrays.asList(30000, 50000));
//		sisNetworkDeliveryFailure.put("OTA01", 	Arrays.asList(30000, 50000));
//		sisNetworkDeliveryFailure.put("PMS01", 	Arrays.asList(30000, 50000));
//		sisNetworkDeliveryFailure.put("PMS02", 	Arrays.asList(30000, 50000));
//		sisNetworkDeliveryFailure.put("PMS03", 	Arrays.asList(30000, 50000));
//		sisNetworkDeliveryFailure.put("PMS04", 	Arrays.asList(30000, 50000));
//		sisNetworkDeliveryFailure.put("PMS05", 	Arrays.asList(30000, 50000));
//		sisNetworkDeliveryFailure.put("PMS06", 	Arrays.asList(30000, 50000));
//		sisNetworkDeliveryFailure.put("PMS07", 	Arrays.asList(30000, 50000));
//		sisNetworkDeliveryFailure.put("PMS08", 	Arrays.asList(30000, 50000));
//		sisNetworkDeliveryFailure.put("PMS09", 	Arrays.asList(30000, 50000));
//		sisNetworkDeliveryFailure.put("PMSFIXA",Arrays.asList(30000, 50000));
//		sisNetworkDeliveryFailure.put("PPM01", 	Arrays.asList(30000, 50000));
//		sisNetworkDeliveryFailure.put("PTS01", 	Arrays.asList(30000, 50000));
//		sisNetworkDeliveryFailure.put("PTS02", 	Arrays.asList(30000, 50000));
//		sisNetworkDeliveryFailure.put("PTS03", 	Arrays.asList(30000, 50000));
//		sisNetworkDeliveryFailure.put("RIM01", 	Arrays.asList(30000, 50000));
//		sisNetworkDeliveryFailure.put("SMSC03", Arrays.asList(30000, 50000));
//		sisNetworkDeliveryFailure.put("SMSC04", Arrays.asList(30000, 50000));
//		sisNetworkDeliveryFailure.put("SMSC05", Arrays.asList(30000, 50000));
//		sisNetworkDeliveryFailure.put("SMSC06", Arrays.asList(30000, 50000));
//		sisNetworkDeliveryFailure.put("UDR01", 	Arrays.asList(-1, -1));
//		sisNetworkDeliveryFailure.put("VMP01", 	Arrays.asList(30000, 50000));
//		sisNetworkDeliveryFailure.put("VMP02", 	Arrays.asList(30000, 50000));
//		sisNetworkDeliveryFailure.put("VMP03", 	Arrays.asList(30000, 50000));
//		sisNetworkDeliveryFailure.put("VMP04", 	Arrays.asList(30000, 50000));
//		sisNetworkDeliveryFailure.put("VMP05", 	Arrays.asList(30000, 50000));
//		sisNetworkDeliveryFailure.put("VMP06", 	Arrays.asList(30000, 50000));
//		sisNetworkDeliveryFailure.put("VMP07", 	Arrays.asList(30000, 50000));
//		sisNetworkDeliveryFailure.put("VMP08", 	Arrays.asList(30000, 50000));
//		sisNetworkDeliveryFailure.put("VMP09", 	Arrays.asList(30000, 50000));
//		sisNetworkDeliveryFailure.put("VMS01", 	Arrays.asList(30000, 50000));
//		sisNetworkDeliveryFailure.put("VMS02", 	Arrays.asList(30000, 50000));
//		sisNetworkDeliveryFailure.put("VMS03", 	Arrays.asList(30000, 50000));
//		sisNetworkDeliveryFailure.put("VMS04", 	Arrays.asList(30000, 50000));
//		sisNetworkDeliveryFailure.put("EMA01", Arrays.asList(30000, 50000));
//		sisNetworkDeliveryFailure.put("NAPTI01", Arrays.asList(30000, 1000));
//		sisNetworkDeliveryFailure.put("PMS10", Arrays.asList(30000, 50));
//		sisNetworkDeliveryFailure.put("SMSC07", Arrays.asList(30000, 50000));
//		sisNetworkDeliveryFailure.put("SMSC08", Arrays.asList(30000, 50));
//		sisNetworkDeliveryFailure.put("UDR02", Arrays.asList(30000, 50));
//		sisNetworkDeliveryFailure.put("UDR03", Arrays.asList(30000, 50));
//		sisNetworkDeliveryFailure.put("NetworkInSub43_c_b", Arrays.asList(-1, -1));
//
//	}
//	
//	private static void distributedQueuesAndServersProvisioning() {
//		/* Criando Filas Distribuidas e associcações server Provisioning */
//		sisProvisioningQueuesAndServers.put("Mno", Arrays.asList("sisdx06a"));
//		sisProvisioningQueuesAndServers.put("Sisgen", Arrays.asList("sisdx06a"));
//
//		/* Criando Delivery Failure Provisioning */
//		sisProvisioningDeliveryFailure.put("Mno", Arrays.asList(2000, 1));
//		sisProvisioningDeliveryFailure.put("Sisgen", Arrays.asList(2000, 1));
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
//			
//			
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
