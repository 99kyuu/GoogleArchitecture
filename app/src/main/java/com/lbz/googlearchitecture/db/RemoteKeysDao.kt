package com.lbz.googlearchitecture.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.lbz.googlearchitecture.model.ArticleType

/**
 * @author: laibinzhi
 * @date: 2020-07-11 02:31
 * @github: https://github.com/laibinzhi
 * @blog: https://www.laibinzhi.top/
 */
@Dao
interface RemoteKeysDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(remoteKey: List<RemoteKeys>)

    @Query("SELECT * FROM remote_keys WHERE articleId = :articleId AND articleType =:articleType")
    suspend fun remoteKeysArticleId(articleId: Int, articleType: Int): RemoteKeys?

    @Query("DELETE FROM remote_keys WHERE articleType =:articleType")
    suspend fun clearRemoteKeys(articleType: Int)
}

