public class MySmartArray {
    String[] arr;    // массив с данным
    int size;        // size - сколько реально элементов в массиве == индекс следующего свободного элемента
                    //  вначале size = 0
                    //  добавили один элемент size увеличили:
                    //  в массиве один элемент, следующий запишем в первый индекс

    MySmartArray(){
        this.arr = new String[3];
        this.size=0;
    }

    public void add(String element){
        if(this.size>=this.arr.length){  // если реальное количество элементов в массиве >= размеру массива
            growArray();                 // увеличиваем массив
        }
        this.arr[size]=element;          // заполняем следующий свободный элемент массива
        size++;                          // изменяем size
    }

    public String get(int i){
        return arr[i];
    }

    // метод увеличивает массив
    public void growArray(){
        String[] newArray = new String[arr.length*2];  // создаем новый массив
        for (int i = 0; i < arr.length; i++) {         // копируем из старого массива в новый
            newArray[i]=this.arr[i];
        }
        this.arr = newArray;                            // теперь новый массив станет основным

    }


}
