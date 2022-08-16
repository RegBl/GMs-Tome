package io.github.regbl.gmstome.data.models

import androidx.room.Embedded
import androidx.room.Relation

data class PlayerWithPlayerCharacters(
    @Embedded val player: Player,
    @Relation(
        parentColumn = "id",
        entityColumn = "player_id"
    )
    val playerCharacters: List<PlayerCharacter>
)
