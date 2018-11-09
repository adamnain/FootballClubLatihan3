package io.github.adamnain.footballclublatihan2

import com.google.gson.Gson
import io.github.adamnain.footballclublatihan2.api.ApiRepository
import io.github.adamnain.footballclublatihan2.api.TheSportDBApi
import io.github.adamnain.footballclublatihan2.model.TeamResponse
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class TeamDetailPresenter(private val view: TeamDetailView,
                          private val apiRepository: ApiRepository,
                          private val gson: Gson
) {

    fun getTeamDetail(teamId: String) {
        view.showLoading()
        doAsync {
            val data = gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.getTeamDetail(teamId)),
                TeamResponse::class.java
            )

            uiThread {
                view.hideLoading()
                view.showTeamDetail(data.teams)
            }
        }
    }
}