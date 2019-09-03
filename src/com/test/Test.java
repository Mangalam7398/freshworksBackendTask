package com.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Scanner;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Test {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		// JSON parser object to parse read file
		JSONParser jsonParser = new JSONParser();
		StrikersWrapper outputList = new StrikersWrapper();

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the file location");
		String fileLoc = sc.next();
		System.out.println("Enter the input file base name");
		String inputFile = sc.next();
		System.out.println("Enter the output file base name");
		String outputFile = sc.next();
		File dir = new File(fileLoc);
		File files[] = dir.listFiles(new FilenameFilter() {

			@Override
			public boolean accept(File dir, String name) {
				// TODO Auto-generated method stub
				return name.startsWith(inputFile) && name.endsWith(".json");
			}
		});
		for (File file : files) {
			try (FileReader reader = new FileReader(file)) {
				// Read JSON file
				Object obj = jsonParser.parse(reader);

				JSONArray strikerList = (JSONArray) ((JSONObject) obj).get("strikers");
				for (int i = 0; i < strikerList.size(); i++) {
					outputList.add(parseStrikerObject((JSONObject) strikerList.get(i)));
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		try (FileWriter file = new FileWriter(fileLoc+"\\"+outputFile+".json")) {
			ObjectMapper mapper = new ObjectMapper();
			String result = mapper.writeValueAsString(outputList);
			file.write(result);
			file.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static Strikers parseStrikerObject(JSONObject striker) throws Exception {
		Strikers data = new Strikers();

		String name = (String) striker.get("name");
		data.setName(name);
		String club = (String) striker.get("club");
		data.setClub(club);
		return data;
	}
}
