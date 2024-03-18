package com.khjin.tdd_practice.week1.calculator

import com.khjin.tdd_practice.week1.calculator.exception.InvalidExpressionException

class Calculator {

    private val delimiterPrefix = "//"

    fun add(expression: String): Int{

        if(expression.isEmpty()){   //empty string
            return 0

        }else if( isNumeric(expression) ){ //one number
            return expression.toInt()

        }else{ //expression

            var sum = 0
            var newExpression = expression

            val exceptionMessageBuilder = StringBuilder()
            val invalidDelimiter = StringBuilder()
            var invalidDelimiterPos = 0
            val negativeNums = arrayListOf<Int>()
            val validDelimiters = arrayListOf<String>()

            // set delimiter
            if (expression.startsWith(delimiterPrefix) ) {
                val delimiter = extractDelimiter(expression)
                validDelimiters.add(delimiter)
                newExpression = expression.substring(delimiterPrefix.length + delimiter.length + 1)
            }else{
                validDelimiters.addAll(listOf(",", "\n"))
            }

            val numList = newExpression.split(*validDelimiters.toTypedArray())

            // check if expression ends with delimiter
            if(numList.last().isEmpty()) {
                throw InvalidExpressionException("Expression should not end with delimiters")
            }

            for(i in numList.indices){

                if( isNumeric(numList[i] )){
                    val num = numList[i].toInt()

                    if(num < 0)
                        negativeNums.add(num)
                    else if(num < 1000)
                        sum += num

                    invalidDelimiterPos += numList[i].length

                }else { // check if other delimiter is included
                    // extract invalid Delimiter
                    var foundInvalid = false

                    for(c in numList[i].toCharArray().indices){
                        if( !numList[i][c].isDigit() ){
                            if( !foundInvalid ) foundInvalid = true
                            invalidDelimiterPos++
                            invalidDelimiter.append(numList[i][c])
                        }else{
                            if(foundInvalid) break
                        }
                    }
                }
            }

            // create error message
            if(negativeNums.isNotEmpty()){
                // build exception message
                exceptionMessageBuilder.append("Negative number(s) not allowed : ")
                    .append(negativeNums.joinToString(", "))
            }

            if(invalidDelimiter.isNotEmpty()){
                if(exceptionMessageBuilder.isNotEmpty()){
                    exceptionMessageBuilder.append("\n")
                }
                exceptionMessageBuilder
                    .append("'").append(validDelimiters[0]).append("' expected but '")
                    .append(invalidDelimiter.toString()).append("' found at position ").append(invalidDelimiterPos)
            }

            if( exceptionMessageBuilder.isNotEmpty() ){
                throw InvalidExpressionException(exceptionMessageBuilder.toString())
            }

            return sum
        }
    }

    private fun isNumeric(str : String): Boolean {
        return str.toIntOrNull() != null
    }

    fun extractDelimiter(expression: String): String{
        var delimiterEndIdx = 2
        for( i in delimiterPrefix.length until expression.length ){
            if( expression[i].isDigit() ){
                delimiterEndIdx = i-1
                break
            }
        }
        return expression.substring(delimiterPrefix.length, delimiterEndIdx)
    }

}