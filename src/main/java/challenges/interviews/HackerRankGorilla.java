package challenges.interviews;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class HackerRankGorilla {
	
	private static final String PREFIX_LOG_FILE_NAME = "records_";

	private static final Function<String, Log> TRANSFORM_TO_LOG = logInFile -> {
		String[] divideElements = logInFile.split(" ");
		
		if(divideElements.length == 0) {
			throw new IllegalArgumentException("The row's file must contain at least one element");
		}
		
		return new Log(divideElements[0], Log.amount++);
	};
	
	public static void main(String[] args) throws Exception {
		String fileName = "hosts_00.txt";
		List<String> linesFile = Files.readAllLines(Paths.get(fileName));
		
		Map<String, List<Log>> logs = generateOutput(linesFile);
		
		writelogFile(logs, "hosts");
	}
	
	private static Map<String, List<Log>> generateOutput(List<String> logElementsInFile){
        Map<String, List<Log>> hosts = logElementsInFile
        		.stream()
        		.map(TRANSFORM_TO_LOG)
        		.collect(
        				Collectors.groupingBy(Log::getColum1, HashMap::new, Collectors.toCollection(ArrayList::new)));
        
        hosts.forEach((entry, value) -> System.out.println(String.format("%s %d", entry, value.size())));
        
        return hosts;
    }

	private static void writelogFile(Map<String, List<Log>> logs, String fileName) throws IOException {
		OpenOption[] options = {StandardOpenOption.CREATE_NEW, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING};
		Set<String> hosts = logs.keySet();
		try(BufferedWriter bufferW = Files.newBufferedWriter(Paths.get(PREFIX_LOG_FILE_NAME + fileName), StandardCharsets.UTF_8, options)){
			
			for (String host : hosts) {
				bufferW.write(String.format("%s %d", host, logs.get(host).size()));
				bufferW.newLine();
			}
		}
	}
	
	private static class Log {

		private String colum1;
		private int id;
		private static int amount = 0;
		
		public Log(String colum1, int colum2) {
			this.colum1 = colum1;
			this.id = colum2;
		}

		public String getColum1() {
			return colum1;
		}

		@Override
		public String toString() {
			return "Log [colum1=" + colum1 + ", id=" + id + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((colum1 == null) ? 0 : colum1.hashCode());
			result = prime * result + id;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Log other = (Log) obj;
			if (colum1 == null) {
				if (other.colum1 != null)
					return false;
			} else if (!colum1.equals(other.colum1))
				return false;
			if (id != other.id)
				return false;
			return true;
		}
		
	}

}
