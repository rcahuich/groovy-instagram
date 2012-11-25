package groovy.instagram.test

import groovy.instagram.endpoint.Media;
import groovy.instagram.endpoint.Tags
import groovy.instagram.OAuth
import groovy.instagram.Configuration;


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

def oauth = new OAuth();
def authURL = OAuth.getAuthorizationURL(Configuration.CLIENT_ID, "http://www.grails47.com:8080/grails48/twitter/cb")


println OAuth.requestAccessToken(Configuration.CLIENT_ID, Configuration.CLIENT_SECRET, "http://www.grails47.com:8080/grails48/instagram/cb/", "a90a5b26b1364744bb5fd084384c11f2")

