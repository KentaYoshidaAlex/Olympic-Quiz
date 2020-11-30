
window.onload = function() {

  // 好きなメインジャンルの選択肢

  subGenre = document.getElementById("subGenre");

  // ジャンルの選択肢が変更された際の動作

  category = document.getElementById("category");

  category.onchange = changeCategory;

}

// ジャンルの選択肢が変更された際の動作

function changeCategory() {

  // 変更後のカテゴリを取得

  var changedCategory = category.value;

  if (changedCategory == "0") {

    // カテゴリに「世界のあいさつ」が選択された場合

    setGreeting();

  } else if (changedCategory == "1") {

    // カテゴリに「オリンピック雑学」が選択された場合

    setOlympics();

  } else if (changedCategory == "2") {

    // カテゴリに「国内観光の雑学」が選択された場合

    setTourism();

  } else {

    // カテゴリに「基本英会話」が選択された場合

    setConversation();

  }

}

// 「世界のあいさつ」の選択肢を設定する

function setGreeting() {

  // サブジャンルの選択肢を空にする

  subGenre.textContent = null;

  // サブジャンルの選択肢

  var greeting = [

    {cd:"", label:""},

    {cd:"hello", label:"こんにちは"},

    {cd:"thankYou", label:"ありがとう"},

    {cd:"haveANiceDay", label:"よい一日を"}

  ];

  greeting.forEach(function(value) {

    var op = document.createElement("option");

    op.value = value.cd;

    op.text = value.label;

    subGenre.appendChild(op);

  });

}

// 「オリンピック雑学」の選択肢を設定する

function setOlympics() {

  // サブジャンルの選択肢を空にする

	subGenre.textContent = null;

  // サブジャンルの選択肢

  var olympics = [

    {cd:"", label:""},

    {cd:"origin", label:"オリンピック競技の発祥国"},

    {cd:"location", label:"歴代オリンピック開催地"},

    {cd:"player", label:"オリンピック参加選手"},

    {cd:"olympicelse", label:"その他（由来など）"}

  ];

  olympics.forEach(function(value) {

    var op = document.createElement("option");

    op.value = value.cd;

    op.text = value.label;

    subGenre.appendChild(op);

  });

}

// 「国内観光の雑学」の選択肢を設定する

function setTourism() {

  // サブジャンルの選択肢を空にする

	subGenre.textContent = null;

  // ヨーロッパ料理の選択肢

  var tourism = [

    {cd:"", label:""},

    {cd:"japaneseTourism", label:"有名な観光地"},

    {cd:"localSpecialty", label:"ご当地名物"}

  ];

  tourism.forEach(function(value) {

    var op = document.createElement("option");

    op.value = value.cd;

    op.text = value.label;

    subGenre.appendChild(op);

  });

}

// 「基本英会話」の選択肢を設定する

function setConversation() {

  // サブジャンルの選択肢を空にする

	subGenre.textContent = null;

  // サブジャンルの選択肢

  var conversation = [

    {cd:"", label:""},

    {cd:"introduction", label:"はじめまして～紹介～"},

    {cd:"guide", label:"道案内"},

    {cd:"tourism", label:"観光案内"},

    {cd:"others", label:"その他（感嘆表現・スラング）"}

  ];

  conversation.forEach(function(value) {

    var op = document.createElement("option");

    op.value = value.cd;

    op.text = value.label;

    subGenre.appendChild(op);

  });

}

