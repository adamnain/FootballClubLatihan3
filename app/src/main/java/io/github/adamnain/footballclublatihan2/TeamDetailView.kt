package io.github.adamnain.footballclublatihan2

import io.github.adamnain.footballclublatihan2.model.Team

interface TeamDetailView {
    fun showLoading()
    fun hideLoading()
    fun showTeamDetail(data: List<Team>)
}