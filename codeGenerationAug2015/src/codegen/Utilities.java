package codegen;


import java.io.FileInputStream;
import java.util.UUID;
//import org.apache.catalina.tribes.util.UUIDGenerator;

import org.apache.commons.io.IOUtils;


public class Utilities {
	public synchronized static UUID generateUniqueId() {

		//&byte[] bytes = UUIDGenerator.randomUUID(true);
		UUID uuid = UUID.randomUUID();
				//UUID.nameUUIDFromBytes(bytes);
		return uuid;

	}
	
	public static String readFile(String fileName){
		try{
		FileInputStream inputStream = new FileInputStream(fileName);
		try {

		    String everything = IOUtils.toString(inputStream);
		    return everything;
		} finally {
			inputStream.close();
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		return "";
		
	}
	
}
