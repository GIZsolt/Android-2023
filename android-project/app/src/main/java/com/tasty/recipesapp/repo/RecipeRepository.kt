package com.tasty.recipesapp.repo

import android.content.Context
import com.google.gson.Gson
import com.tasty.recipesapp.dto.RecipeResultDTO
import com.tasty.recipesapp.dto.RecipeDTO
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.Reader
import java.io.StringWriter
import java.io.Writer

class RecipeRepository  (val context: Context){
    fun readRecipes(): Array<RecipeDTO>{
        val gson = Gson()
        val file = context.resources.openRawResource(com.tasty.recipesapp.R.raw.all_recipes)
        try{
            val reader: Reader = BufferedReader(InputStreamReader(file, "UTF-8"))
            val result = gson.fromJson<RecipeResultDTO>(reader, RecipeResultDTO::class.java)
            return result.results
        }finally{
            file.close()
        }
    }
}