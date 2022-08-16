package io.github.regbl.gmstome.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "player_characters")
data class PlayerCharacter(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "player_id")
    val playerId: Int,
    val name: String,
    @ColumnInfo(name = "character_class")
    val characterClass: CharacterClass,
    val race: CharacterRace
)

enum class CharacterClass { WIZARD, ROGUE, RANGER, BARBARIAN }
enum class CharacterRace { HUMAN, ELF, HALFLING, ORC }