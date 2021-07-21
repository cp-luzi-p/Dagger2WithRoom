package com.example.movieapplicationdemo.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.movieapplicationdemo.utils.TABLE_NAME
import com.google.gson.annotations.SerializedName

@Entity(tableName = TABLE_NAME)
class Movie {

    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    private var id: Int = 0

    fun setId(id: Int) {
        this.id = id
    }

    fun getId(): Int {
        return id
    }

    @SerializedName("title")
    private var title: String = ""

    @SerializedName("image")
    private var image: String = ""

    @SerializedName("rating")
    private var rating: String = ""

    @SerializedName("releaseYear")
    private var releaseYear: Int = 0

    fun getRating(): String {
        return rating
    }

    fun setRating(rating: String) {
        this.rating = rating
    }

    fun setTitle(title: String) {
        this.title = title
    }

    fun getTitle(): String {
        return title
    }

    fun setImage(image: String) {
        this.image = image
    }

    fun getImage(): String {
        return image
    }

    fun setReleaseYear(releaseYear: Int) {
        this.releaseYear = releaseYear
    }

    fun getReleaseYear(): Int {
        return releaseYear
    }

    /* @SerializedName("genre")
    private var genreList: MutableList<String> = ArrayList()

    fun getGenre(): MutableList<String> {
        return genreList
    }

    fun setGenre(genreList: MutableList<String>) {
        this.genreList =  genreList
    }*/

}