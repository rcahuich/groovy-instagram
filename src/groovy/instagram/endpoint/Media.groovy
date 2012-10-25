package groovy.instagram.endpoint

import groovy.instagram.Configuration
import groovy.instagram.Parser
import groovy.instagram.Utils
import groovy.instagram.domain.Image

class Media {
	
	//Returns extended information of a given media item
	def static Image mediaItem(item_id, params){
		def json_response = new URL(Configuration.DEFAULT_ENDPOINT + "media/${item_id}?" + Utils.getParameterString(params)).text
		def parser = new Parser()
		def image = parser.parseMediaItem(json_response)
		image
	}
	
	//Returns a list of the overall most popular media
	def static popular(params){
		def json_response = new URL(Configuration.DEFAULT_ENDPOINT + "media/popular?" + Utils.getParameterString(params)).text
		println json_response
		def parser = new Parser()
		def images = parser.parseImages(json_response)
		images
	}


}
