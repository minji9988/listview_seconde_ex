//1. listview에 있는 item(A, B, C)를 클릭 시
// toast 메세지가 뜨도록 한다.

// 2. data model 개념을 활용해서
// listview를 만들어 보도록 한다.

package com.example.listview_seconde_ex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val list_item = mutableListOf<String>()
//
//        list_item.add("A")
//        list_item.add("B")
//        list_item.add("C")

//        위에는 data를 한 개씩 넣는 방법
//        아래는 data를 model로 해서 여러 개씩 넣는 방법

        //list_item2란 이름을 가진 listviewModel 생성
        val list_item2 = mutableListOf<ListViewModel>()

        // ListViewMode 파일에 있는 ListViewModel이란 이름을 가진
        // data의 모델에 데이터 덩어리를 넣었다.
        list_item2.add(ListViewModel("a", "b")) //a와 b라는 덩어리
        list_item2.add(ListViewModel("c", "d")) // c와 d라는 덩어리
        list_item2.add(ListViewModel("e", "f"))


        //list_item에 저장된 data(A, B, C)를
        // ListViewAdapter로 보낸 후 Adapter가 listview_item.xml
        // 형태로 data를 치장시킨 후, 치장된 data(A, B, C)를 val adapter란 변수에 저장

        // val listviewAdapter = ListViewAdapter(list_item2)
        // 위와 같은 형태로 작성하면 안된다.
        // ListViewAdapter에서 9번째 줄에 'MutableList<String>' 즉
        // String만 받는다고 했는 데 현재 위에서 data model을 집어넣었다.
        // 그래서 ListViewAdatper.kt에서 'MutableList<ListViewModel>로 수정해서
        // ListViewModel로 받는다고 해줘야 한다.

        // 또한 32번 line의 title.text = List[position] 를
        // title.text = List[position].text1로 변경하도록 한다.


        //activity_main.xml에 있는 ListView 이름인 mainListView를 listview 변수에 저장
        val listview = findViewById<ListView>(R.id.mainListView)

        val listviewAdapter = ListViewAdapter(list_item2)
        listview.adapter = listviewAdapter


        //list에 있는 item(A, B, C)가 클릭되면 Toast msg가 뜬다.
        listview.setOnItemClickListener { parent, view, position, id ->

            Toast.makeText(this, list_item2[position].text1, Toast.LENGTH_LONG).show()
        }

    }
}