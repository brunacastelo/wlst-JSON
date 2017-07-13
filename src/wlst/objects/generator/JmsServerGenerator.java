package wlst.objects.generator;

import wlst.objects.beans.JmsServer;

public class JmsServerGenerator extends CodeGenerator<JmsServer>{

	@Override
	public String createObject() {
		StringBuilder builder = new StringBuilder();
		
		builder.append("CriarJmsServer('");		
		builder.append(bean.getName());
		builder.append("','");
		builder.append(bean.getPersistentStore());
		builder.append("','");
		builder.append(bean.getTarget());
		builder.append("','");
		builder.append(bean.getTargetType());
		builder.append("')");
		builder.append(QUEBRA_DE_LINHA);
		
		return builder.toString();
	}


	@Override
	public String createFunction() {
		StringBuilder builder = new StringBuilder();
		//FUNCTION CRIAR JMS SERVER
		builder.append("def CriarJmsServer(name, persistentStore, target, targetType):");	
		builder.append(QUEBRA_DE_LINHA);
		builder.append(IDENTACAO);
		builder.append("print ('Criando JmsServer: ' + name )");
		builder.append(QUEBRA_DE_LINHA);
		builder.append(IDENTACAO);
		builder.append("cd('/')");
		builder.append(QUEBRA_DE_LINHA);
		builder.append(IDENTACAO);
		builder.append("create(name,'JMSServer')");
		builder.append(QUEBRA_DE_LINHA);
		builder.append(IDENTACAO);
		builder.append("cd('JMSServers/'+name)");
		builder.append(QUEBRA_DE_LINHA);
		builder.append(IDENTACAO);
		builder.append("set('PersistentStore',ObjectName('com.bea:Name='+persistentStore+',Type=FileStore'))");
		builder.append(QUEBRA_DE_LINHA);
		builder.append(IDENTACAO);
		builder.append("set('Targets',jarray.array([ObjectName('com.bea:Name='+target+',Type='+targetType)], ObjectName))");
		builder.append(QUEBRA_DE_LINHA);
		builder.append(QUEBRA_DE_LINHA);	
		return builder.toString();
	}

}
