package groovy.instagram.endpoint

import groovy.instagram.*
import groovy.instagram.domain.User

/**
 * This class represents the Users Instagram Endpoint and defines methods relevant to users.
 */
class Users {

    /**
     * This method returns basic information about an Instagram user.
     *
     * @param accessToken    Requesting users OAuth access token. Looks like this request needs to be authenticated and made on behalf of user.
     * @param userId         The Instagram id of the requested user
     * @return  User         returns a groovy.instagram.domain.User object with basic info.
     */
		public static User getBasicUserInfo(String accessToken, String userId){
			
			def params = [access_token: accessToken]
			def jsonResponse = new URL(Configuration.DEFAULT_ENDPOINT + "users/${userId}/?" + Utils.getParameterString(params)).text
			jsonResponse = jsonResponse.replaceFirst("\"data\"", "\"user\"");
            println jsonResponse
			def newUser = new Parser().parseUser(jsonResponse);
            return newUser
		}
		
}
