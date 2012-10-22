package groovy.instagram.endpoint

import groovy.instagram.Configuration;
import groovy.instagram.Parser;
import groovy.instagram.Utils;

class Media {
	
	//Returns extended information of a given media item
	def static mediaItem(item_id, params){
		def json_response = new URL(Configuration.DEFAULT_ENDPOINT + "media/${item_id}?" + Utils.getParameterString(params)).text
		def parser = new Parser()
		def image = parser.parseMediaItem(json_response)
		image
	}


}
