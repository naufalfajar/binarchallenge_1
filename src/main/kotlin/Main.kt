import java.util.Scanner
class Pyramid {
    var row:Int  //rows
    var col:Int  //columns
    var ast:Int = 0 //asterisk/bintang
    var lim:Int = 0 //space before/afer asterisk

    constructor(row:Int){
        this.row = row
        this.col = row*2-1
        this.ast = ast
        this.lim = lim
    }
}
fun main() {
    val read = Scanner(System.`in`)
    println("Press Enter (Ngga tau kenapa di IntelliJ kalo pake user input di console, dia ngeread di second input)")
    print("Code ini butuh console untuk user input")
    read.nextLine()
    while(true) {
        println("Bentuk apa yang ingin anda buat?")
        print(
            "1. Piramida Bintang\n" +
                    "2. Piramida Terbalik Bintang\n" +
                    "3. Diamond\n" +
                    "4. X Bintang\n" +
                    "5. Setengah Piramida\n" +
                    "6. Keluar\n"
        )

        val choice = read.nextInt()
        when(choice){
            6->break
        }

        println("Berapa tinggi dari bentuk yang anda inginkan (rows of asterisk)")
        var tinggi = read.nextInt()

        when (choice) {
            1 -> pb(tinggi)
            2 -> ptb(tinggi, false)
            3 -> d(tinggi)
            4 -> xb(tinggi)
            5 -> sp(tinggi)
            else -> println("Nomor bentuk yang diminta tidak ada di list!")
        }
    }
}
//piramida bintang
fun pb(tinggi: Int){
    var pb = Pyramid(tinggi)

    for(i in 1..pb.row){
        pb.ast = i*2-1
        for(j in 1..pb.col){
            pb.lim = (pb.col-pb.ast)/2
            if(j<=pb.lim || j>pb.lim+pb.ast)
                print(" ")
            else
                print("*")
        }
        println("")
    }
}
//piramida terbalik bintang
fun ptb(tinggi: Int, mix:Boolean){
    var ptb = Pyramid(tinggi)

    for(i in ptb.row.downTo(1)){
        ptb.ast = i*2-1
        if(i==ptb.row && mix) continue
        for(j in 1..ptb.col){
            ptb.lim = (ptb.col-ptb.ast)/2
            if(j<=ptb.lim || j>ptb.lim+ptb.ast)
                print(" ")
            else
                print("*")
        }
        println("")
    }
}
//diamond
fun d(tinggi: Int){
    if(tinggi%2==1) {
        pb(tinggi/2+1)
        ptb(tinggi/2+1,true)
    }
    else {
        pb(tinggi / 2)
        ptb(tinggi / 2,false)
    }
}
//xbintang
fun xb(tinggi: Int){
    for(i in 1..tinggi){
        for(j in 1..tinggi){
            if(j==i || j==(tinggi-i+1))
                print("*")
            else
                print(" ")
        }
        println("")
    }
}
//setengahpiramida
fun sp(tinggi: Int){
    for(i in 1..tinggi) {
        for (j in 1..i)
            print("*")
        println("")
    }
}
