package groovy.instagram.test;

import groovy.instagram.Parser
import groovy.instagram.endpoint.Users
import groovy.instagram.endpoint.*

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
        assert user.media == null

        def response2 = '{"meta":{"code":200},"user":{"username":"jeffthorne","bio":"","website":"http://www.twitter.com/jeffthorne","profile_picture":"http://images.instagram.com/profiles/profile_10684384_75sq_1319143832.jpg","full_name":"Jeff Thorne","counts":{"media":45,"followed_by":4,"follows":0},"id":"10684384"}}'

        def user2 = new Parser().parseUser(response2)
        assert user2.accessToken == null
        assert user2.username == "jeffthorne"
        assert user2.bio == ""
        assert user2.fullName == "Jeff Thorne"
        assert user2.instagramId == "10684384"
        assert user2.website == "http://www.twitter.com/jeffthorne"
        assert user2.profilePicture == "http://images.instagram.com/profiles/profile_10684384_75sq_1319143832.jpg"
        assert user2.media == 45
        assert user2.followedBy == 4
        assert user2.follows == 0



        def snoopdog = new Users().getBasicUserInfo(user.accessToken, "1574083")
        assert snoopdog.instagramId == "1574083"
        assert snoopdog.username == "snoopdogg"
        assert snoopdog.website == "http://snoopdogg.com"
        assert snoopdog.accessToken == null
	}

}
