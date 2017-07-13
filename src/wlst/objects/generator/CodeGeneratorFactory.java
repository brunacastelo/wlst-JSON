package wlst.objects.generator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import wlst.objects.beans.Bean;
import wlst.objects.beans.FileStore;

@SuppressWarnings({"rawtypes", "unchecked"})
public class CodeGeneratorFactory {

	private static Map<Class, Class> classes;
	static {
		classes = new HashMap<Class, Class>();
		classes.put(FileStore.class, FileStoreGenerator.class);
	};
	
	public static CodeGenerator getGenarator(Bean baseObject) {
		for (Entry<Class, Class> entry : classes.entrySet()) {
			try  {
				baseObject.getClass().asSubclass(entry.getKey());
				CodeGenerator generator = (CodeGenerator) entry.getValue().newInstance();
				generator.setBean(baseObject);
				return generator;
			} catch (ClassCastException | InstantiationException | IllegalAccessException e) {
				// Ignore
			}
		}
		return null;
	}
	
	public static List<CodeGenerator> getGenerators() {
		List<CodeGenerator> list = new ArrayList<CodeGenerator>();
		
		for (Entry<Class, Class> entry : classes.entrySet()) {
			try {
				list.add((CodeGenerator)entry.getValue().newInstance());
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
//	public static void main(String args[]) {
////		System.out.println(getGenarator("teste"));
//		System.out.println(getGenarator(new FileStore(null, null, null, null)));
//	}

}
