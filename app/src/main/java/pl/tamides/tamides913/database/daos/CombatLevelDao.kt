package pl.tamides.tamides913.database.daos

import androidx.room.Dao
import pl.tamides.tamides913.database.BaseDao
import pl.tamides.tamides913.database.entities.CombatLevel

@Dao
interface CombatLevelDao : BaseDao<CombatLevel> {
}