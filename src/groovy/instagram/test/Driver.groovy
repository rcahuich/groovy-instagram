package groovy.instagram.test
import groovy.instagram.endpoint.Media;
import groovy.instagram.endpoint.Tags;

def params = ["client_id" : "e1d53419c04e4ab79e8e535bfc601871"]
def instagram_tag = "grails48"

def images = Tags.recent(instagram_tag, params)

println images.size()
images.each {
	println it.id
 println it.standard_resolution_url	
 println it.caption
 println it.next_max_id
}

//def images2 = Media.popular(params)

