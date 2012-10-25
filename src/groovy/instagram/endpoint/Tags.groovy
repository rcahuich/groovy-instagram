package groovy.instagram.endpoint

import groovy.instagram.Configuration;
import groovy.instagram.Parser;
import groovy.instagram.Utils;

class Tags {
	
	//Return a list of media (images) as groovy.instragram.Image objects for a given Instagram tag
	def static recent(tag, params){
		def response = new URL(Configuration.DEFAULT_ENDPOINT + "tags/${tag}/media/recent?" + Utils.getParameterString(params)).text
		println response
		def parser = new Parser()
		def images = parser.parseImages(response)	
		images
	}
	
	
	//Returns extended information of a given Instagram tag
	def static tag(instagram_tag, params){
		def json_response = new URL(Configuration.DEFAULT_ENDPOINT + "tags}/${instagram_tag}?" + Utils.getParameterString(params)).text
		def tags = new Parser().parseTag(json_response)
		tags.get(0)
	}
	
	
    // Returns a list of tags starting with the given search query
	def static search(instagram_tag, params){
		def json_response = new URL(Configuration.DEFAULT_ENDPOINT + "tags/search?q=${instagram_tag}&" + Utils.getParameterString(params)).text
		def tags = new Parser().parseTag(json_response)
		tags
	}

}
