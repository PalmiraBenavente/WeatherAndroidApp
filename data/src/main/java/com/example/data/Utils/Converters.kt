package com.example.data.Utils

import androidx.room.TypeConverter
import com.example.data.database.entities.ListDB
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object Converters {
    val gson = Gson()

    @TypeConverter
    fun arrayListToJsonListDB(list: List<ListDB>?): String = if (list == null) ConstantUtils.DEFAULT_STRING else gson.toJson(list)

    @TypeConverter
    fun jsonToArrayListListDB(jsonData: String?): List<ListDB>? {
        return if (jsonData == null) null else gson.fromJson(jsonData, object : TypeToken<List<ListDB>?>() {}.type)
    }
}
