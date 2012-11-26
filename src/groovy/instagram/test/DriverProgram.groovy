package groovy.instagram.test

import groovy.instagram.endpoint.Media;
import groovy.instagram.endpoint.Tags
import groovy.instagram.OAuth
import groovy.instagram.Configuration;
import groovy.json.JsonSlurper


/* def params = ["client_id" : ""]
def instagram_tag = "grails48"

def images = Tags.recent(instagram_tag, params)

println images.size()
images.each {
    println it.id
    println it.standard_resolution_url
    println it.caption
    println it.next_max_id
    println()
}         */

//def oauth = new OAuth();
//def authURL = OAuth.getAuthorizationURL(Configuration.CLIENT_ID, "http://www.grails47.com:8080/grails48/twitter/cb")


//println OAuth.requestAccessToken(Configuration.CLIENT_ID, Configuration.CLIENT_SECRET, "http://www.grails47.com:8080/grails48/instagram/cb/", "a90a5b26b1364744bb5fd084384c11f2")

def response = '{"access_token":"10684384.5948ec7.be0b59572bda44e593684d19465ab24e","user":{"username":"jeffthorne","bio":"","website":"http://www.twitter.com/jeffthorne","profile_picture":"http://images.instagram.com/profiles/profile_10684384_75sq_1319143832.jpg","full_name":"Jeff Thorne","id":"10684384"}}'
def result = new JsonSlurper().parseText(response)
println result
