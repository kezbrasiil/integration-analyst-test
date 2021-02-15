package com.aplicacaoFluid;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONObject;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import aplicacaoFluid.DataCsv;

public class FluidApplication {

	 public static void main(String[] args) throws IOException {
	
		 FluidApplication obj = new FluidApplication();
		    obj.run();
	          
	       
		
	}
	 public void run() {

		    String arquivoCSV = "src/integration-analyst-test/data/input.csv";
		    BufferedReader br = null;
		    String linha = "";
		    String csvDivisor = ",";
		    DataCsv data = new DataCsv();
		  //Cria um Objeto JSON
			

			FileWriter writeFile = null;
		    try {

		        br = new BufferedReader(new FileReader(arquivoCSV));
		        while ((linha = br.readLine()) != null) {

		            String[] linhas = linha.split(csvDivisor);
		          
		            data.setDate(linhas[linhas.length-5]);
		            data.setCases(linhas[linhas.length-4]);
		            data.setDeaths(linhas[linhas.length-3]);
		            
		            JSONObject jsonObject = new JSONObject();

		    
		    		jsonObject.put("month", data.getDate().toString());
		    		jsonObject.put("cases", data.getCases().toString());
		    		jsonObject.put("deaths", data.getDeaths().toString());
		   
		            
		            
		            try{
		    			writeFile = new FileWriter("src/integration-analyst-test/data/output.json");
		    			//Escreve no arquivo conteudo do Objeto JSON
		    			for (int i = 0; i < linhas.length; i++) {
		    				writeFile.write(jsonObject.toJSONString());
		    				}
		    			
		    			writeFile.close();
		    		}
		    		catch(IOException e){
		    			e.printStackTrace();
		    		}

		    		//Imprimne na Tela o Objeto JSON para vizualização
		    		System.out.println(jsonObject);

		           

		        }

		    } catch (FileNotFoundException e) {
		        e.printStackTrace();
		    } catch (IOException e) {
		        e.printStackTrace();
		    } finally {
		        if (br != null) {
		            try {
		                br.close();
		            } catch (IOException e) {
		                e.printStackTrace();
		            }
		        }
		    }
		  }

		}

