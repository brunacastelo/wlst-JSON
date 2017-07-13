package main.deprecated;

import org.python.util.InteractiveInterpreter;

import weblogic.management.scripting.utils.WLSTInterpreter;

public class EmbeddedWLST {
	static InteractiveInterpreter interpreter = null;

	EmbeddedWLST() {
		interpreter = new WLSTInterpreter();
	}

	private static void connect() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("connect('weblogic','welcome1')");
		interpreter.exec(buffer.toString());
	}

	private static void createServers() {
		StringBuffer buf = new StringBuffer();
		buf.append(startTransaction());
		buf.append("man1=create('msEmbedded1','Server')\n");
		buf.append("man2=create('msEmbedded2','Server')\n");
		buf.append("clus=create('clusterEmbedded','Cluster')\n");
		buf.append("man1.setListenPort(8001)\n");
		buf.append("man2.setListenPort(9001)\n");
		buf.append("man1.setCluster(clus)\n");
		buf.append("man2.setCluster(clus)\n");
		buf.append(endTransaction());
		buf.append("print 'Script ran successfully ...' \n");
		interpreter.exec(buf.toString());
	}

	private static String startTransaction() {
		StringBuffer buf = new StringBuffer();
		buf.append("edit()\n");
		buf.append("startEdit()\n");
		return buf.toString();
	}

	private static String endTransaction() {
		StringBuffer buf = new StringBuffer();
		buf.append("save()\n");
		buf.append("activate(block='true')\n");
		return buf.toString();
	}

	public static void main(String[] args) {
		new EmbeddedWLST();
		connect();
		createServers();
	}
}