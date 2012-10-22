package groovy.instagram

class Utils {
	
	//takes params map and produces parameter string
	public static String getParameterString(params){
	  
		def paramsString = ""
		
		params.eachWithIndex() { it , i ->
			paramsString += it.key + "=" + it.value
			i < params.size() ?: (paramsString += "&")
		  }
		
		paramsString
			
	}

}
