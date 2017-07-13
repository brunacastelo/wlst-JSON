package wlst.objects.generator;

import wlst.objects.beans.FileStore;

public class FileStoreGenerator extends CodeGenerator<FileStore>{

	@Override
	public String createObject() {
		StringBuilder builder = new StringBuilder();
		builder.append("CriarFileStore('");		
		builder.append(bean.getName());
		builder.append("','");
		builder.append(bean.getPath());
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
		//FUNCTION CRIAR FILE STORE
		StringBuilder builder = new StringBuilder();
		builder.append("def CriarFileStore(name, path, target, targetType):");	
			builder.append(QUEBRA_DE_LINHA);
			builder.append(IDENTACAO);
			builder.append("print ('Criando FileStore: ' + name )");
			builder.append(QUEBRA_DE_LINHA);
			builder.append(IDENTACAO);
			builder.append("cd('/')");
			builder.append(QUEBRA_DE_LINHA);
			builder.append(IDENTACAO);
			builder.append("create(name,'FileStore')");
			builder.append(QUEBRA_DE_LINHA);
			builder.append(IDENTACAO);
			builder.append("cd('FileStores/'+name)");
			builder.append(QUEBRA_DE_LINHA);
			builder.append(IDENTACAO);
			builder.append("set('Directory',path)");
			builder.append(QUEBRA_DE_LINHA);
			builder.append(IDENTACAO);
			builder.append("set('Targets',jarray.array([ObjectName('com.bea:Name='+target+',Type='+targetType)], ObjectName))");
			builder.append(QUEBRA_DE_LINHA);
			builder.append(QUEBRA_DE_LINHA);
		return builder.toString();
	}

}
