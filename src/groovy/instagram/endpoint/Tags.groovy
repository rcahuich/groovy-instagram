package groovy.instagram.endpoint

import groovy.instagram.Configuration;
import groovy.instagram.Parser;
import groovy.instagram.Utils;

class Tags {
	
	//Return a list of all media (images) as groovy.instragram.Image objects for a given Instagram tag. Ignores pagination and gets all.
	def static recent(tag, params){

        def response = new URL(Configuration.DEFAULT_ENDPOINT + "tags/${tag}/media/recent?" + Utils.getParameterString(params)).text
        //println response
        def parser = new Parser()
		def images = parser.parseImages(response)
	   
	    def temp_max_id	= 0

	    while(images.last().next_max_id && images.last().next_max_id != temp_max_id){  // Check to see if more images exist
		    temp_max_id = images.last().next_max_id
		    params["max_id"] = images.last().next_max_id

            response = new URL(Configuration.DEFAULT_ENDPOINT + "tags/${tag}/media/recent?" + Utils.getParameterString(params)).text
            //println response
		        def additional_images = parser.parseImages(response)
		        additional_images.each{ images << it}
		    }
		
	    return images
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


	//returns the 20 most recent images for a tag
  def static recent20(tag, params){

        def counter = 1;
        def response = new URL(Configuration.DEFAULT_ENDPOINT + "tags/${tag}/media/recent?" + Utils.getParameterString(params)).text
        def parser = new Parser()
        def images = parser.parseImages(response)

        def temp_max_id	= 0
        while(images.last().next_max_id && images.last().next_max_id != temp_max_id && counter <= 20){
            temp_max_id = images.last().next_max_id
            params["max_id"] = images.last().next_max_id
            response = new URL(Configuration.DEFAULT_ENDPOINT + "tags/${tag}/media/recent?" + Utils.getParameterString(params)).text
            def additional_images = parser.parseImages(response)
            additional_images.each{ images << it}
            counter++
        }

        images
    }


}
