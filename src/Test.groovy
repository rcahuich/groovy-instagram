import groovy.instagram.ImageParser
import groovy.json.JsonSlurper

def tag = "grails48"
def response = new URL("https://api.instagram.com/v1/tags/${tag}/media/recent?client_id=e1d53419c04e4ab79e8e535bfc601871").text
println response

def parser = new ImageParser()
def images = parser.parse(response)


images.each{

	println it.thumbnail_url
 }




