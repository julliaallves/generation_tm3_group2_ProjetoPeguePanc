package com.generation.projetopanc.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.generation.projetopanc.data.db.dao.CarrinhoDao
import com.generation.projetopanc.data.db.entity.Carrinho

@Database(entities = [Carrinho::class], version = 1, exportSchema = false)
abstract class CarrinhoDatabase : RoomDatabase() {

    abstract fun carrinhoDao(): CarrinhoDao

    companion object{
        @Volatile
        private var INSTANCE: CarrinhoDatabase? = null

        fun getDatabase(context: Context): CarrinhoDatabase {
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                context.applicationContext,
                CarrinhoDatabase::class.java,
                "carrinho_database"
                ).build()
                INSTANCE = instance
                return instance

            }


        }
    }
}
