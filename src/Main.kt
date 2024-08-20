//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val array = createList(Array(10){""})
    for (i in array) println(i)
}

fun createList(list: Array<String>):Array<String>{
    val greeting = {name:String->
        println("Приветсвую вас в нашем клубе, $name\n")
    }
    for (i in list){
        print("Введите Имя и Фамилию: ")
        val name = readln()
        if (name.trim() == "") throw MyException("Данное поле не может быть пустым")
        print("В какое положение его поставить 1-${list.size}: ")
        var index = readln().toInt()
        if (index < 1 || index > list.size) throw MyException("Индекс выходит за пределы")
        while (list[index - 1].isNotEmpty()){
            println("Данная позиция уже занята")
            print("В какое положение поставить $name 1-${list.size}: ")
            index = readln().toInt()
            if (index < 1 || index > list.size) throw MyException("Индекс выходит за пределы")
        }
        list[index-1] = name
        greeting(name)
    }
    return list
}

class MyException(message:String): Exception(message)