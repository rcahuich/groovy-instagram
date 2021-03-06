package groovy.instagram

import groovy.instagram.domain.Image;
import groovy.instagram.domain.Tag;
import groovy.instagram.domain.User;
import groovy.json.JsonSlurper


class Parser {
	
	def parseImages(json_response){
	  def slurper = new JsonSlurper()
	  def result = slurper.parseText(json_response)
	  def image
	  def images = []
	  def next_max_id = result.pagination?.next_max_tag_id

	  result.data.each{ it ->
		  image = parseItem(it)
		  image.next_max_id = next_max_id
		  images.add(image)
	  }//end each
	  
	  return images
	  
	}//end parse()

	def parseTag(json_response){
		def slurper = new JsonSlurper()
		def result = slurper.parseText(json_response)
		println result
		def tag 
		def tags = []
		
		result.each{
		  tag = new Tag()
		  tag.name = result?.data?.name
		  tag.media_count = result?.data?.media_count
		  tag.code = result?.meta?.code
		  tags.add(tag)
		}
		
		tags
	}
	
	public User parseUser(jsonResponse){
		
		def slurper = new JsonSlurper()
		def result = slurper.parseText(jsonResponse)
		println result
		User user = new User()
		
		user.instagramId = result?.user?.id
		user.profilePicture = result?.user?.profile_picture
		user.accessToken = result?.access_token
		user.fullName = result?.user?.full_name
		user.bio = result?.user?.bio
		user.username = result?.user?.username
		user.website = result?.user?.website
        user.media = result?.user?.counts?.media
        user.follows = result?.user?.counts?.follows
        user.followedBy = result?.user?.counts?.followed_by

		return user
	}
	
	def parseMediaItem(json_response){
	  def slurper = new JsonSlurper()
	  def result = slurper.parseText(json_response)
	  def image = parseItem(result.data)
		
	  return image
	}

	def private Image parseItem(HashMap itemMap){
		def image = new Image()
		def user = new User()
		
		image.latitude = itemMap.location?.latitude
		image.longitude = itemMap.location?.longitude
		
		image.id = itemMap.id
  
		image.thumbnail_url = itemMap.images.thumbnail?.url
		image.thumbnail_height = itemMap.images.thumbnail?.height
		image.thumbnail_width = itemMap.images.thumbnail?.width
		
		image.standard_resolution_url = itemMap.images.standard_resolution?.url
		image.standard_resolution_height = itemMap.images.standard_resolution?.height
		image.standard_resolution_width = itemMap.images.standard_resolution?.width
		
		image.low_resolution_url = itemMap.images.low_resolution?.url
		image.low_resolution_height = itemMap.images.low_resolution?.height
		image.low_resolution_width = itemMap.images.low_resolution?.width
		
		image.caption = itemMap.caption?.text
		image.caption_created_time = itemMap.caption?.created_time
		image.caption_from = itemMap.caption?.from
		image.caption_from_profile_picture = itemMap.caption?.from?.profile_picture   ///thisi s a url
		image.caption_from_id = itemMap.caption?.id
		image.caption_from_id_full_name = itemMap.caption?.full_name

		
		user.username = itemMap.user?.username
		user.website = itemMap.user?.website
		user.bio = itemMap.user?.bio
		user.profilePicture = itemMap.user?.profile_picture
		user.fullName = itemMap.user?.full_name
		user.instagramId = itemMap.user?.id
		
		image.user = user
		image.tags = itemMap.tags.toString().replaceAll(/[\[\]]/, "").split(",") as List  //force tags to string. Replace all [] and push back to list.
		return image
		
	}	
	
}
