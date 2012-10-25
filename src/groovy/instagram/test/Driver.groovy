package groovy.instagram.test
import groovy.instagram.endpoint.Media;
import groovy.instagram.endpoint.Tags;

def params = ["client_id" : "add your id here"]
def instagram_tag = "justin"
def item_id = 306365019237680238

def images = Tags.recent("snow", params)

def images2 = Media.popular(params)

