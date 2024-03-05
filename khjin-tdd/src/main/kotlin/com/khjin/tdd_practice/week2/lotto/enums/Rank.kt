package com.khjin.tdd_practice.week2.lotto.enums

enum class Rank(
    private val matches: Int,
    private val isCheckBonusNumber: Boolean,
    private val isBonusNumberMatch: Boolean?,
    private val prizeMoney: Int
) {
    FIRST(6,  false, null, 2_000_000_000),
    SECOND(5, true, true, 30_000_000),
    THIRD(5, true, false,1_500_000),
    FOURTH(4, false, null,50_000),
    FIFTH(3,  false, null, 5_000),
    MISS(0, false, null,0);

    fun getPrizeMoney(): Int{
        return this.prizeMoney
    }
    fun getMatches(): Int{
        return this.matches
    }

    companion object{
        fun getRank(matches: Int, isBonusNumberMatch: Boolean): Rank{

            for(r in entries){
                if(r.matches == matches){
                    if(r.isCheckBonusNumber){
                        if(r.isBonusNumberMatch == isBonusNumberMatch){
                            return r
                        }
                    }else{
                        return r
                    }
                }
            }
            return MISS
        }
    }
}