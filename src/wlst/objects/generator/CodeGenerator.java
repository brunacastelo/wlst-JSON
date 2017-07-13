package wlst.objects.generator;

import wlst.objects.beans.Bean;

public abstract class CodeGenerator <T extends Bean>{
	
	protected static final String QUEBRA_DE_LINHA = "\r\n";
	protected static final String IDENTACAO = "\t";

	protected T bean;
	public void setBean(T bean) {
		this.bean = bean;
	}
	
	public abstract String createObject();
	public abstract String createFunction();
	
}
