package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

import weblogic.WLST;
import wlst.WLSTCommands;
import wlst.objects.beans.Enviroment;

import com.google.gson.Gson;

public class Main {
	
	public static void main(String[] args) {
//		main2("D:\\Tools\\workspaceTools\\wlstDomain-prod\\arquivos\\ModeloMSisPrd38_Web.json", true);
//		main2("D:\\Tools\\workspaceTools\\wlstDomain-prod\\arquivos\\ModeloMSisPrd39_Hist.json", true);
//		main2("D:\\Tools\\workspaceTools\\wlstDomain-prod\\arquivos\\ModeloMSisPrd40_Con.json", true);
//		main2("D:\\Tools\\workspaceTools\\wlstDomain-prod\\teste\\ModeloMSisPrd41_Prov.json", true);
//		main2("D:\\Tools\\workspaceTools\\wlstDomain-prod\\arquivos\\ModeloMSisPrd42_Net.json", true);

//		main2("D:\\Tools\\workspaceTools\\wlstDomain-prod\\arquivos\\ModeloMSisPrd38_Web.json", true, WLSTCommands.IGNORED_ITEM.MACHINE, WLSTCommands.IGNORED_ITEM.CLUSTER, WLSTCommands.IGNORED_ITEM.DATA_SOURCE, WLSTCommands.IGNORED_ITEM.MANAGED_SERVER);
//		main2("D:\\Tools\\workspaceTools\\wlstDomain-prod\\arquivos\\ModeloMSisPrd39_Hist.json", true, WLSTCommands.IGNORED_ITEM.MACHINE, WLSTCommands.IGNORED_ITEM.CLUSTER, WLSTCommands.IGNORED_ITEM.DATA_SOURCE, WLSTCommands.IGNORED_ITEM.MANAGED_SERVER);
//		main2("D:\\Tools\\workspaceTools\\wlstDomain-prod\\arquivos\\ModeloMSisPrd40_Con.json", true, WLSTCommands.IGNORED_ITEM.MACHINE, WLSTCommands.IGNORED_ITEM.CLUSTER, WLSTCommands.IGNORED_ITEM.DATA_SOURCE, WLSTCommands.IGNORED_ITEM.MANAGED_SERVER);
//		main2("D:\\Tools\\workspaceTools\\wlstDomain-prod\\arquivos\\ModeloMSisPrd41_Prov.json", true, WLSTCommands.IGNORED_ITEM.MACHINE, WLSTCommands.IGNORED_ITEM.CLUSTER, WLSTCommands.IGNORED_ITEM.DATA_SOURCE, WLSTCommands.IGNORED_ITEM.MANAGED_SERVER);
		main2("D:\\Tools\\workspaceTools\\wlstDomain-prod\\arquivos\\ModeloMSisPrd42_Net.json", true, WLSTCommands.ITEM.MACHINE, WLSTCommands.ITEM.CLUSTER, WLSTCommands.ITEM.DATA_SOURCE, WLSTCommands.ITEM.MANAGED_SERVER);

		
	}

	private static void main2(String jsonFile, boolean somenteGerar, WLSTCommands.ITEM ... ignoredItems) {
		Scanner scanner = new Scanner(System.in);
		Gson jsonConverter = new Gson();
		WLSTCommands wlstCommands = new WLSTCommands(ignoredItems);
		FileWriter fileOutStream;
		PrintWriter printStream;
		
		String caminhoParaSalvarArquivo = "";
		StringBuilder nomeDoArquivo = new StringBuilder();
		String conteudoArquivo = "";
		
		try {
//			String jsonFile = 
//"D:\\Tools\\workspaceTools\\wlstDomain-prod\\uteis\\arquivosJson\\ModeloMSisPrd40.json";
//			String jsonFile = "D:\\Tools\\workspaceTools\\wlstDomain-prod\\uteis\\arquivosJson\\DevOi.txt";
//			String jsonFile = "D:\\Tools\\workspaceTools\\wlstDomain-prod\\uteis\\arquivosJson\\Modelo arquivo Json.txt";

//			if (args.length > 0 && args[0] != null) {
//				jsonFile = loadFile(args[0]);
//			} else {
//				System.out.print("Qual o caminho do arquivo que deseja abrir: ");
//				jsonFile = loadFile(scanner.nextLine());
//			}
			jsonFile = loadFile(jsonFile);

			Enviroment enviroment = jsonConverter.fromJson(jsonFile, Enviroment.class);
			//conteudoArquivo = wlstCommands.createEnviroment(enviroment);
			conteudoArquivo = wlstCommands.createConfiguration(enviroment);
//			System.out.println(jsonConverter.toJson(enviroment));
			
			System.out.println("Criacao do ambiente feita com sucesso!");
			System.out.println("Arquivo de configuracao gerado com sucesso.");
//			System.out.print("Digite o caminho em que deseja salvar o mesmo ou deixe em branco para salvar no local de onde a aplicacao esta sendo rodada: ");
			
			try {
//				caminhoParaSalvarArquivo = scanner.nextLine();
//				
//				if(caminhoParaSalvarArquivo == null || caminhoParaSalvarArquivo.equals("")) {
					caminhoParaSalvarArquivo = "./arquivos";
//				}
				
				Calendar calendario = Calendar.getInstance();
				String agora = new SimpleDateFormat("yyyyMMdd_HHmmss").format(calendario.getTime());
				nomeDoArquivo.append(agora).append("_").append(enviroment.getDomain().getName());
				
				String caminhoCompleto = caminhoParaSalvarArquivo + "/" + nomeDoArquivo + ".py";
				
				//Salvar arquivo .py				
				fileOutStream = new FileWriter(caminhoCompleto);
				printStream = new PrintWriter(fileOutStream);
				printStream.printf(conteudoArquivo.toString());
				printStream.close();
				
				System.out.println("Arquivo '" + nomeDoArquivo + ".py' gerado com sucesso!");
				
				if (!somenteGerar) {
					//executar python
					System.out.println("Iniciando a execucao do script gerado.....");
					WLST.main( new String[]{caminhoCompleto});
				}
				
			} catch(Exception e) {
				System.out.println("Erro ao ler caminho digitado! Caminho atual esta sendo assumido para salvar o arquivo.");
				e.printStackTrace();
			}
		} catch(FileNotFoundException e) {
			System.out.println("Erro ao ler o arquivo no endereco passado. Erro: " + e.getMessage());
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println("Erro ao criar o ambiente a partir do arquivo passado. Erro: " + e.getMessage());
			e.printStackTrace();
		}
		
	}

	private static String loadFile(String path) throws FileNotFoundException{
		String fileContent = "";

		fileContent = new Scanner(new File(path)).useDelimiter("\\A").next();
		System.out.println("Arquivo no caminho " + path + " lido com sucesso.");

		return fileContent;
	}
}
