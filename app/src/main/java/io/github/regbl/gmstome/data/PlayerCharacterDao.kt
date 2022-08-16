package io.github.regbl.gmstome.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.github.regbl.gmstome.data.models.PlayerCharacter
import kotlinx.coroutines.flow.Flow

@Dao
interface PlayerCharacterDao {
    @Query("SELECT * FROM player_characters WHERE id = :id")
    fun getPlayerCharacter(id: Int): PlayerCharacter

    @Query("SELECT * FROM player_characters ORDER BY id DESC")
    fun getPlayerCharacters(): Flow<List<PlayerCharacter>>

    @Insert(onConflict = androidx.room.OnConflictStrategy.IGNORE)
    suspend fun insertPlayerCharacter(playerCharacter: PlayerCharacter)
}