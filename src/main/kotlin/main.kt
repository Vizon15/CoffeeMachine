
import java.util.*
import kotlin.math.min

fun main(args: Array<String>) {

    val x = CoffeeMachine()
//    x.printer()
    x.menuChooser()

}

class CoffeeMachine(var water: Int = 400, var milk: Int = 540, var beans: Int = 120,
                    var cups: Int = 9, var money: Int = 550, var price: Int = 0) {
    val scanner = Scanner(System.`in`)
    fun printer () {
        println("""
            The coffee machine has:
            $water of water
            $milk of milk
            $beans of coffee beans
            $cups of disposable cups
            $money of money
        """.trimIndent())
    }
    fun menuChooser () {
        var neededWater = 0
        var neededMilk = 0
        var neededBeans = 0
        var updatedCups = 0
        do {
            print("Write action (buy, fill, take, remaining, exit): ")
            val menu = readLine()!!.toLowerCase()
            if (menu == "exit") break
            when (menu) {

                "buy" -> {
                    print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ")
                    when (readLine()!!.toLowerCase()) {
                        "1" -> {
                            price = 4
                            neededWater = 250
                            neededBeans = 16
                        }
                        "2" -> {
                            price = 7
                            neededWater = 350
                            neededBeans = 20
                            neededMilk = 75
                        }
                        "3" -> {
                            price = 6
                            neededWater = 200
                            neededBeans = 12
                            neededMilk = 100
                        }
                        "back" -> {
                            continue
                        }
                    }
                    if (neededWater > water || neededMilk > milk || neededBeans > beans) {
                        if (neededWater > water) {
                            println("Sorry, not enough Water!")
                        }
                        else if (neededWater > milk) {
                            println("Sorry, not enough Milk!")
                        }
                        else {
                            println("Sorry, not enough Beans!")
                        }
                    }
                    else {
                        println("I have enough resources, making you a coffee!")
                        water -= neededWater
                        milk -= neededMilk
                        beans -= neededBeans
                        cups -= 1
                        updatedCups = cups
                        money += price

//                        printer()
                    }
                }
                "fill" -> {
                    print("Write how many ml of water do you want to add: ")
                    val water2 = readLine()!!.toInt()
                    print("Write how many ml of milk do you want to add: ")
                    val milk2 = readLine()!!.toInt()
                    print("Write how many grams of coffee beans do you want to add: ")
                    val beans2 = readLine()!!.toInt()
                    print("Write how many disposable cups of coffee do you want to add: ")
                    val cups2 = readLine()!!.toInt()

                    water += water2
                    milk += milk2
                    beans += beans2
                    cups += cups2

//                    printer()
                }
                "take" -> {
                    println("I gave you $money")
                    money = 0
//                    printer()
                }
                "remaining" -> {
                    printer()
                }

                else -> println("Invalid Input! Try again...")
            }
        } while (menu != "exit")
    }
}
