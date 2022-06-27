package com.generation.projetopanc.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.generation.projetopanc.data.db.dao.ProdutosCarrinhoDao
import com.generation.projetopanc.data.db.entity.ProdutosCarrinhoEntity

@Database(entities = [ProdutosCarrinhoEntity::class], version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract val produtosCarrinhoDao: ProdutosCarrinhoDao

    companion object{
        @Volatile
        private var INSTANCE: AppDataBase? = null

        fun getInstance(context: Context): AppDataBase {
            synchronized(this) {
                var instance: AppDataBase? = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context,
                        AppDataBase::class.java,
                        "app_database"
                    ).build()
                }

                return instance
            }
        }
    }
}