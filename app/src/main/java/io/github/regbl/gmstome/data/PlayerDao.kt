package io.github.regbl.gmstome.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.github.regbl.gmstome.data.models.Player
import io.github.regbl.gmstome.data.models.PlayerWithPlayerCharacters
import kotlinx.coroutines.flow.Flow

@Dao
interface PlayerDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertPlayer(player: Player)

    @Query("SELECT * FROM players WHERE id = :id")
    fun getPlayer(id: Int): Flow<Player>

    @Query("SELECT * FROM players ORDER BY name ASC")
    fun getPlayersByName(): Flow<List<Player>>

    @Query("SELECT * FROM players WHERE id = :id")
    fun getPlayerWithCharacters(id: Int): Flow<PlayerWithPlayerCharacters>
}