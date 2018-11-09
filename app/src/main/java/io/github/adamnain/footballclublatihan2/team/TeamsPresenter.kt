package io.github.adamnain.footballclublatihan2.team

import com.google.gson.Gson
import io.github.adamnain.footballclublatihan2.api.ApiRepository
import io.github.adamnain.footballclublatihan2.api.TheSportDBApi
import io.github.adamnain.footballclublatihan2.model.TeamResponse
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class TeamsPresenter(private val view: TeamsView,
                     private val apiRepository: ApiRepository,
                     private val gson: Gson) {

    fun getTeamList(league: String?) {
        view.showLoading()
        doAsync {
            val data = gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.getTeams(league)),
                TeamResponse::class.java
            )

            uiThread {
                view.hideLoading()
                view.showTeamList(data.teams)
            }
        }
    }

}
