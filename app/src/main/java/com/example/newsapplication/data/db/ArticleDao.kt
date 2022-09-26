package com.example.newsapplication.data.db

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.newsapplication.models.Article

//Данный интерфейс будет получать статьи, вставлять и удалять статью

interface ArticleDao {
    @Query("SELECT * FROM articles")
    suspend fun getAllArticles():LiveData<List<Article>>
    //создаем две функции которые будут добавлять и удалять статью
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(article: Article)

    @Delete
    suspend fun delete(article: Article)
}