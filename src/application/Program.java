package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Program {

	public static void main(String[] args) {
		String patch = "C:\\Users\\rapha\\Documents\\Workspace_eclipse\\Aula214_Map\\in.txt";
	try {
		BufferedReader br =  new BufferedReader(new FileReader(patch));
		Map<String, Integer> apuracao = new HashMap<>();
		String line = br.readLine();
		while (line != null) {
			String[] splitLine = line.split(",");
			String candidato = splitLine[0];
			int votos = Integer.parseInt(splitLine[1]);
			if(!apuracao.containsKey(splitLine[0])) {
				apuracao.put(candidato, votos);
			}
			else {
				int oldVotos = apuracao.get(candidato);
				apuracao.replace(candidato, oldVotos , oldVotos+votos); //poderia ter usado o map.put como na linha abaixo comentada
//				apuracao.put(candidato, oldVotos+votos);				
			}
			line = br.readLine();
				
		}
		for (String candidato : apuracao.keySet()) {
			System.out.println(candidato + ": " + apuracao.get(candidato));
		}
	}
	catch (IOException e) {
		System.out.println("Error"+e.getMessage());
	}
	}

}
