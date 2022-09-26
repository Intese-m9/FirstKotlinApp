package com.example.newsapplication.models

import androidx.room.Entity
import androidx.room.PrimaryKey

//Добавить аннотации по бд
@Entity(tableName = "articles")//Создание таблицы
data class Article(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: Source,
    val title: String,
    val url: String,
    val urlToImage: String
)