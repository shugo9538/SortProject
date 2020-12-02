import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Integer.parseInt
import java.util.*

lateinit var arr : MutableList<Int>
lateinit var tmp : MutableList<Int>
var indexingList = mutableListOf<Int>()

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = parseInt(br.readLine())
    arr = MutableList<Int>(N, { it*0 })
    var st = StringTokenizer(br.readLine())

    for (i in 0 until N) {
        var inputNum = st.nextToken().toInt()
        arr.set(i, inputNum)
    }

    arr.sort()

    var n1 = arr.get(0)
    indexingList.add(n1)

    for(i in arr.indices) {
        if(n1 == arr.get(i)) continue
        else {
            n1 = arr.get(i)
            indexingList.add(n1)
        }
    }
    indexingList.sort()

    sortList()
    for(i in arr.indices) print("${arr.get(i)} ")
}

fun swap(index1: Int, index2: Int) {
    val tmp = arr.get(index1)
    arr.set(index1, arr.get(index2))
    arr.set(index2, tmp)
}

fun sortList() {
    tmp = arr.toMutableList()
    var index = 0

    for(i in 0 until arr.size-1) {
        if(arr.get(i)+1 == arr.get(i+1)) {
            var arrvalue = arr.get(i+1)
            var indexinglistindex = indexingList.indexOf(arrvalue)
            if(indexingList.size != indexinglistindex+1) {
                index = arr.indexOf(indexingList.get(indexinglistindex+1))
                swap(i+1, index)
            }
            else swap(i, i+1)
            break
        }
    }

    if(!tmp.equals(arr)) sortList()
}