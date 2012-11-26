package groovy.instagram.domain

class User {

	def username
	def website
	def bio
	def instagramId										
	def fullName
	def profilePicture
	def accessToken 				//OAuth access token
	
	def media         			//media count
	def followedBy					//followed by count
	def follows							//following count

}
