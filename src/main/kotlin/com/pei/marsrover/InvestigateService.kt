package com.pei.marsrover

interface InvestigateService {
    fun doInvestigate(position: Position): Result

    enum class Result {
        SUCCESS, FAILURE
    }
}

class WaterInvestigateService : InvestigateService {
    override fun doInvestigate(position: Position): InvestigateService.Result {
        return if (position.x == 3 && position.y == 3) {
            InvestigateService.Result.SUCCESS
        } else {
            InvestigateService.Result.FAILURE
        }
    }

}