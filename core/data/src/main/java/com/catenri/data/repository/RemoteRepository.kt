package com.catenri.data.repository

import android.util.Log
import com.catenri.network.model.HarryPotterCharacterResponse
import com.catenri.network.service.HarryPotterCharactersClient
import okhttp3.ResponseBody
import javax.inject.Inject

class RemoteRepository @Inject constructor(
    private val client: HarryPotterCharactersClient
) {

    suspend fun fetchCharacters() {
        val response = client.fetchCharacters()
        when {
            response.isSuccessful -> handleSuccessResponse(response.body())
            else -> handleErrorResponse(response.errorBody())
        }
    }

    private fun handleErrorResponse(errorBody: ResponseBody?) {
        errorBody?.let { error ->
            Log.e("Remote", error.string())
        }
    }

    private fun handleSuccessResponse(body: List<HarryPotterCharacterResponse>?) {
        Log.i("Remote", body.toString())
    }
}