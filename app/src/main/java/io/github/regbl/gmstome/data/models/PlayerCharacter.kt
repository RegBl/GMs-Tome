package io.github.regbl.gmstome.data.models

data class PlayerCharacter(
    val name: String,
    val characterClass: CharacterClass,
    val race: CharacterRace
)

enum class CharacterClass { WIZARD, ROGUE, RANGER, BARBARIAN }
enum class CharacterRace { HUMAN, ELF, HALFLING, ORC }