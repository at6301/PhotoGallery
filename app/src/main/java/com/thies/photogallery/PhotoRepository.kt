package com.thies.photogallery

import com.thies.photogallery.api.FlickrApi
import com.thies.photogallery.api.GalleryItem
import retrofit2.Retrofit
//import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.create

class PhotoRepository {

    private val flickrApi: FlickrApi

    init {
        // building retrofit object
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://api.flickr.com/")
            .addConverterFactory(ScalarsConverterFactory.create())
           // .addConverterFactory(MoshiConverterFactory.create())
            .build()
       flickrApi = retrofit.create()


    }

    suspend fun fetchPhotos() = flickrApi.fetchPhotos()
   // suspend fun fetchPhotos(): List<GalleryItem> = flickrApi.fetchPhotos().photos.galleryItems
}