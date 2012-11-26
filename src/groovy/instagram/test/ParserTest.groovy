package groovy.instagram.test;

import groovy.instagram.Parser

class ParserTest extends GroovyTestCase {
	
	void testParseUser(){
		
		def response = '{"access_token":"10684384.5948ec7.be0b59572bda44e593684d19465ab24e","user":{"username":"jeffthorne","bio":"","website":"http://www.twitter.com/jeffthorne","profile_picture":"http://images.instagram.com/profiles/profile_10684384_75sq_1319143832.jpg","full_name":"Jeff Thorne","id":"10684384"}}'
		def user = new Parser().parseUser(response)
		
		assert user.accessToken == "10684384.5948ec7.be0b59572bda44e593684d19465ab24e"
		assert user.username == "jeffthorne"
		assert user.bio == ""
		assert user.fullName == "Jeff Thorne"
		assert user.instagramId == "10684384"
		assert user.website == "http://www.twitter.com/jeffthorne"
		assert user.profilePicture == "http://images.instagram.com/profiles/profile_10684384_75sq_1319143832.jpg"
	}

}
