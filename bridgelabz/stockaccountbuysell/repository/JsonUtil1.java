package com.bridgelabz.stockaccountbuysell.repository;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;



public class JsonUtil1 
{
	private static ObjectMapper mapper;
	static 
	{
		mapper = new ObjectMapper();
	}

	public static Object readMapper(String path, Object object)
			throws JsonParseException, JsonMappingException, IOException 
			
	{
		mapper.readValue(new File(path), object.getClass());
		return "Successfully reading from the file!!!";

	}
	

	public static String writeMapper(String path, Object object)
			throws JsonGenerationException, JsonMappingException, IOException
	{
		mapper.writeValue(new File(path), object);
		return "Successfully writing into the file!!!";
	}
}

/**
 * JsonParseException --subset of the SyntaxError error type
 *  Exception type for parsing problems, used when non-well-formed content 
 * (content that does not conform to JSON syntax as per specification) is encountered
 *
 */

/**
 * JsonMappingException --
 * Checked exception used to signal fatal problems with mapping of content, 
 * distinct from low-level I/O problems 
 * (signaled using simple IOExceptions) or data encoding/decoding problems
 */
 

/**
 * IO Exception --
 * This exception happens when there is a 
 * failure during reading, writing and searching 
 * file or directory operations.
 */
