package io.github.adamnain.footballclublatihan2.team

import io.github.adamnain.footballclublatihan2.model.Team

interface TeamsView {
    fun showLoading()
    fun hideLoading()
    fun showTeamList(data: List<Team>)
}