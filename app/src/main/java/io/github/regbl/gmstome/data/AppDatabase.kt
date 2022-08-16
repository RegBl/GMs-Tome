package io.github.regbl.gmstome.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import io.github.regbl.gmstome.data.models.Player
import io.github.regbl.gmstome.data.models.PlayerCharacter

@Database(
    entities = [Player::class, PlayerCharacter::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun playerDao(): PlayerDao
    abstract fun playerCharacterDao(): PlayerCharacterDao

    companion object {
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, "gms-tome-db")
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}