package com.khjin.tdd_practice.week2.lotto.enums

enum class Rank {
    FIRST(6,  2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false,1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3,  5_000),
    MISS(0, 0);

    private val matches: Int?
    private val isBonusNumberMatch: Boolean?
    private val prizeMoney: Int?


    constructor(matches: Int, isBonusNumberMatch: Boolean, prizeMoney: Int){
        this.matches = matches
        this.isBonusNumberMatch = isBonusNumberMatch
        this.prizeMoney = prizeMoney

    }
    constructor(matches: Int, prizeMoney: Int){
        this.matches = matches
        this.prizeMoney = prizeMoney
        this.isBonusNumberMatch = null
    }

    companion object{
        fun getRank(matches: Int, isBonusNumberMatch: Boolean): Rank{

            for(r in entries){
                if(r.matches == matches){
                    if(r.isBonusNumberMatch == null){
                        return r
                    }else{
                        if(r.isBonusNumberMatch == isBonusNumberMatch){
                            return r
                        }
                    }
                }
            }
            return MISS
        }
    }
}