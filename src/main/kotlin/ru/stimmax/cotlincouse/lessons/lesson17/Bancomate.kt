package ru.stimmax.cotlincouse.lessons.lesson17

import jdk.jfr.DataAmount

class Bancomate(private var pinCode: String ) {

    private var balance: Double = 0.0
    private var pinCodeCounter = 0

    private fun checkPinCode(pinCode: String): Boolean {
        if (this.pinCode == pinCode) {
            return true
        } else {
            println("Пин код неверный")
            return false
        }

    }

    fun getBalance(pinCode: String): Double {
        return if (checkPinCode(pinCode)) {
            balance
        } else {
            0.0
        }

    }

    fun deposit(pinCode: String, deposit: Double) {
        if (checkPinCode(pinCode) && deposit > 0) {
            balance += deposit
        }
    }

    fun withDrop(pinCode: String, amount: Double): Double {
        if (checkPinCode(pinCode) && amount > 0) {
            if (balance > amount) {
                balance -= amount
                return amount
            } else {
                val balance2 = balance
                balance = 0.0
                return balance2

            }
        } else {
            return 0.0
    }
    }


}