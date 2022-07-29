package tictactoe

fun main() {
    var seq = "         " 
    println("---------")
    println("| ${seq[0]} ${seq[1]} ${seq[2]} |")
    println("| ${seq[3]} ${seq[4]} ${seq[5]} |")
    println("| ${seq[6]} ${seq[7]} ${seq[8]} |")
    println("---------")
    for (k in 1..9) {
        var done = true 
        do{
            //enter
            print("Enter the coordinates:")
            val inp = readln().split(" ").toMutableList()
            if (inp[0].toInt() > 3 || inp[1].toInt() > 3) {
                println("Coordinates should be from 1 to 3!")
                done = false
            }
            if (inp[1].toIntOrNull() == null && inp[1].toIntOrNull() == null) {
                println("You should enter numbers!")
                done = false
            } 
    
            val cor = mutableListOf( // list of positions if inp is == one of these then we will it will point this spot
                mutableListOf("1", "1"), // this is seq[0]
                mutableListOf("1", "2"), // this is seq[1]
                mutableListOf("1", "3"),
                mutableListOf("2", "1"),
                mutableListOf("2", "2"),
                mutableListOf("2", "3"),
                mutableListOf("3", "1"),
                mutableListOf("3", "2"),
                mutableListOf("3", "3")
            )
            
            //check occupation then input
            for (i in 0..8) {
                if (cor[i] == inp) {
                    if (seq[i] == 'X' || seq[i] == 'O') {
                        println("This cell is occupied! Choose another one!")
                        done = false
                    } else {
                        done = true
                        if (k % 2 != 0) seq = seq.substring(0, i) + 'X' + seq.substring(i + 1)
                        else if (k % 2 == 0) seq = seq.substring(0, i) + 'O' + seq.substring(i + 1)
                        println("---------")
                        println("| ${seq[0]} ${seq[1]} ${seq[2]} |")
                        println("| ${seq[3]} ${seq[4]} ${seq[5]} |")
                        println("| ${seq[6]} ${seq[7]} ${seq[8]} |")
                        println("---------")
                    }
                }
            }
    
            val xo = mutableListOf('X','O')
            var winner = 2
            var wins = 0
            for (i in 0..1) {
                if (
                    (seq[0] == seq[1] && seq[1] == seq[2] && seq[2] == xo[i]) ||
                    (seq[3] == seq[4] && seq[4] == seq[5] && seq[5] == xo[i]) ||
                    (seq[6] == seq[7] && seq[7] == seq[8] && seq[8] == xo[i]) ||
                    (seq[0] == seq[4] && seq[4] == seq[8] && seq[8] == xo[i]) ||
                    (seq[2] == seq[4] && seq[4] == seq[6] && seq[6] == xo[i]) ||
                    (seq[0] == seq[3] && seq[3] == seq[6] && seq[6] == xo[i]) ||
                    (seq[1] == seq[4] && seq[4] == seq[7] && seq[7] == xo[i]) ||
                    (seq[2] == seq[5] && seq[5] == seq[8] && seq[8] == xo[i]) ) {
                        winner = i
                        wins++
                    }
            }
    
            var x = 0 ; var o = 0 ; var s = 0
            for (i in 0..8) {
                if (seq[i] == '_' || seq[i] == ' ') ++s
                else if (seq[i] == 'X') ++x
                else if (seq[i] == 'O') ++o
            }
            if (s == 0 && winner != 0 && winner != 1) {
                println("Draw")
                return
            } 
            else if (winner == 0) {
                println("X wins")
                return
            }
            else if (winner == 1) {
                println("O wins") 
                return
            } 
        } while (!done) //stops when done is true
    }    
}