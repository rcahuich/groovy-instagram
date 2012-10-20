package groovy.instagram

import groovy.json.JsonSlurper

class ImageParser {
	
	def parse(json_response){
	  def slurper = new JsonSlurper()
	  def result = slurper.parseText(json_response)
	  def image
	  def user = new User()
	  def images = []
	  
	  println "Size: " + result.data.size()
	  result.data.each{ it ->
		  image = new Image()
		  image.latitude = it.location?.latitude
		  image.longitude = it.location?.longitude
		  image.id = it.id
	
		  image.thumbnail_url = it.images.thumbnail?.url
		  image.thumbnail_height = it.images.thumbnail?.height
		  image.thumbnail_width = it.images.thumbnail?.width
		  
		  image.standard_resolution_url = it.images.standard_resolution?.url
		  image.standard_resolution_height = it.images.standard_resolution?.height
		  image.standard_resolution_width = it.images.standard_resolution?.width
		  
		  image.low_resolution_url = it.images.low_resolution?.url
		  image.low_resolution_height = it.images.low_resolution?.height
		  image.low_resolution_width = it.images.low_resolution?.width
		  
		  image.caption = it.caption?.text
		  image.caption_created_at = it.caption?.created_at
		  image.caption_from = it.caption?.from
		  image.caption_from_profile_picture = it.caption?.from?.profile_picture   ///thisi s a url
		  image.caption_from_id = it.caption?.id
		  image.caption_from_id_full_name = it.caption?.full_name
		  
		  user.username = it.user?.username
		  user.website = it.user?.website
		  user.bio = it.user?.bio
		  user.profile_picture = it.user?.profile_picture
		  user.full_name = it.user?.full_name
		  user.id = it.user?.id
		  
		  image.user = user
		  image.tags = it.tags.toString().replaceAll(/[\[\]]/, "").split(",") as List  //force tags to string. Replace all [] and push back to list.
		  images.add(image)
	  }//end each
	  
	  images
	  
	}//end parse()

}
