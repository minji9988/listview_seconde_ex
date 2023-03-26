package com.example.listview_seconde_ex

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

//Adpater로 넘어온 data를 listview_layout.xml 파일로 넘겨주는 것

class ListViewAdapter (val List: MutableList<ListViewModel>) : BaseAdapter(){
    override fun getCount(): Int {
        return List.size
    }

    override fun getItem(position: Int): Any {
        return List[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var convertView = convertView

        if (convertView == null) {
            convertView = LayoutInflater.from(parent?.context).inflate(R.layout.listview_layout, parent, false)
        }

        val title = convertView!!.findViewById<TextView>(R.id.listviewItemText)

        // listview_layout.xml의 TextView 인 'listviewItemText2'를 title2에 저장해준다.
        val title2 = convertView!!.findViewById<TextView>(R.id.listviewItemText2)


        title.text = List[position].text1
        title2.text = List[position].text2


        //text1에는 아래 List에 있는 a, c, eㄹ

        //List = [
//        ListViewModel("a", "b"),
//        ListViewModel("c", "d"),
//        ListViewModel("e", "f"),
//        ]


        return convertView!!
    }


}