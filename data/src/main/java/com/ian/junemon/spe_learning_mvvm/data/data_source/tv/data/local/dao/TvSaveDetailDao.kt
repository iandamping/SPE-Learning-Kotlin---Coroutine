package com.ian.junemon.spe_learning_mvvm.tv.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ian.junemon.spe_learning_mvvm.data.data_source.tv.data.local.model.TvSaveDetailData

/**
 *
Created by Ian Damping on 26/09/2019.
Github = https://github.com/iandamping
 */
@Dao
interface TvSaveDetailDao {
    @Query("SELECT * FROM tv_save_detail_data")
    fun loadAll(): LiveData<List<TvSaveDetailData>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(inputMovie: TvSaveDetailData)

    @Query("DELETE FROM tv_save_detail_data")
    suspend fun deleteAllData()

    @Query("DELETE FROM tv_save_detail_data where localID = :selectedId")
    suspend fun deleteSelectedId(selectedId: Int)
}