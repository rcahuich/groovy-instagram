package groovy.instagram

import groovy.instagram.domain.User
import groovy.instagram.http.HttpUtility

class OAuth {

    /**
     *   This method represents Step 1 in Instagram's server-side (explicit) flow authentication. Step 1 is to direct your
     *   users to Instagram's authorization URL. This method constructs that authorization URL.
     *
     * @param responseType    Only token supported at this time.
     * @param redirectUrI     This is your callback uri
     * @param responseType    Code is the only responseType supported at this time for server side flow.
     * @param scope           Instagram supports the following scopes basic, comments, relationships, likes. You can chain them as such likes+comments.
     * 
     * @return Instagram authorization url
     */
	static String getAuthorizationURL(String clientId, String redirectUrI, String responseType = "code", String scope = "basic"){

        def params = [client_id: clientId, redirect_uri: redirectUrI, response_type: responseType, scope: scope]
        def paramString = Utils.getParameterString(params)

        return "https://api.instagram.com/oauth/authorize/?${paramString}"
    }
	
	
		/**
		 * 	Step 3 - Request Instagram access token for user.
		 *  
		 *  Step 2 was to receive redirect from Instagram and get code.
		 *  
		 * @param clientId					Your Instagram client id
		 * @param clientSecret			Your Instagram client secret
		 * @param redirectUrI				This is your callback uri
		 * @param code							Code received from Instagram callback from authorizatio url
		 * 
		 * @return User object containing Instagram access token.
		 */
		static User requestAccessToken(String clientId, String clientSecret, String redirectUrI, String code, String grantType = "authorization_code"){
		
				def params = [client_id: clientId, client_secret: clientSecret, grant_type: grantType, redirect_uri: redirectUrI, code: code]
				String requestURL = 'https://api.instagram.com/oauth/access_token';
				String accessToken
				def user = null
				
        try {
            HttpUtility.sendPostRequest(requestURL, params);
            def response = HttpUtility.readSingleLineRespone()
						user = new Parser().parseUser(response);
						
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        HttpUtility.disconnect();
				return user
    }
		




}
