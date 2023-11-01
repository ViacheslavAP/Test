package ru.perelyginva.test.api

import retrofit2.Response
import retrofit2.http.GET
import ru.perelyginva.test.helper.Constants
import ru.perelyginva.test.models.TvShowResponse

interface ApiService {
    @GET(Constants.END_POINT)
    suspend fun  getTvShows():Response<TvShowResponse>
}

