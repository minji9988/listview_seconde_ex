package com.example.listview_seconde_ex


//ListViewMode이란 이름의 data 모델 생성
data class ListViewModel (

    // 데이터 모델 안에 text1, text2를 만들어줌
    // 이 2개를 이용해서 data를 한 꺼번에, 한 덩어리 씩 넣어보려함
    val text1: String,
    val text2: String

)