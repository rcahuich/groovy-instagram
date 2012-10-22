package groovy.instagram.test
import groovy.instagram.endpoint.Media;
import groovy.instagram.endpoint.Tags;

def params = ["client_id" : "e1d53419c04e4ab79e8e535bfc601871"]
def instagram_tag = "justin"
def item_id = 306365019237680238

def images = Tags.recent("grails48", params)
images.each{ println it.caption }
def item = Media.mediaItem(item_id, params)
println item.tags
