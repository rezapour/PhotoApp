package me.rezapour.photoapp.data.network.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

//Todo fix the null problem in moshi and read the article
@JsonClass(generateAdapter = true)
data class UnSplashSearchResult(
    val id: String,

    @Json(name = "created_at")
    val createdAt: String,

    @Json(name = "updated_at")
    val updatedAt: String,

    @Json(name = "promoted_at")
    val promotedAt: Any? = null,

    val width: Int,
    val height: Int,
    val color: String,

//    @Json(name = "blur_hash")
//    val blurHash: String,

//    val description: Any? = null,

//    @Json(name = "alt_description")
//    val altDescription: String,

    val urls: Urls,
//    val links: Welcome1Links,
//    val categories: List<Any?>,
//    val likes: Long,

//    @Json(name = "liked_by_user")
//    val likedByUser: Boolean,

//    @Json(name = "current_user_collections")
//    val currentUserCollections: List<Any?>,

//    val sponsorship: Sponsorship?,
//    val user: User
)

@JsonClass(generateAdapter = true)
data class Welcome1Links(
    val self: String,
    val html: String,
    val download: String,

    @Json(name = "download_location")
    val downloadLocation: String
)

@JsonClass(generateAdapter = true)
data class Sponsorship(
    @Json(name = "impression_urls")
    val impressionUrls: List<String>,

    val tagline: String,

    @Json(name = "tagline_url")
    val taglineURL: String,

    val sponsor: User?
)

@JsonClass(generateAdapter = true)
data class User(
    val id: String,

    @Json(name = "updated_at")
    val updatedAt: String,

    val username: String,
    val name: String,

    @Json(name = "first_name")
    val firstName: String,

    @Json(name = "last_name")
    val lastName: Any? = null,

    @Json(name = "twitter_username")
    val twitterUsername: String?,

    @Json(name = "portfolio_url")
    val portfolioURL: String,

    val bio: String,
    val location: Any? = null,
    val links: UserLinks,

    @Json(name = "profile_image")
    val profileImage: ProfileImage,

    @Json(name = "instagram_username")
    val instagramUsername: String,

    @Json(name = "total_collections")
    val totalCollections: Long,

    @Json(name = "total_likes")
    val totalLikes: Long,

    @Json(name = "total_photos")
    val totalPhotos: Long,

    @Json(name = "accepted_tos")
    val acceptedTos: Boolean,

    @Json(name = "for_hire")
    val forHire: Boolean
)

@JsonClass(generateAdapter = true)
data class UserLinks(
    val self: String,
    val html: String,
    val photos: String,
    val likes: String,
    val portfolio: String,
    val following: String,
    val followers: String
)

@JsonClass(generateAdapter = true)
data class ProfileImage(
    val small: String,
    val medium: String,
    val large: String
)

@JsonClass(generateAdapter = true)
data class Urls(
    val raw: String,
    val full: String,
    val regular: String,
    val small: String,
    val thumb: String
)
