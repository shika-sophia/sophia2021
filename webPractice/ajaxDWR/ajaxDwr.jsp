<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AjaxAddress検索</title>
</head>
<!-- DWRの動作に必要な JavaScriptライブラリをインポート -->
<!-- 【註】 src=""の pathは実際のファイルを配置するわけではない。
     DWR Servletが解析し、必要な jsライブラリをインポートするための固定値
     *アプリケーション名「selfjsp」のみ変更する -->
<script type="text/javascript" src="/selfjsp/dwr/interface/Address.js"></script>
<script type="text/javascript" src="/selfjsp/dwr/engine.js"></script>
<script type="text/javascript" src="/selfjsp/dwr/util.js"></script>

<!-- JavaScript処理 -->
<script type="text/javascript">
<!--
//ページロード時の処理 (通信メッセージ表示の有効化)
function init() {
    DWRUtil.useLoadingMessage();
}

//[検索]ボタンのクリック時に実行する処理
function getResult() {
    AjaxAddress.getInfoByName( $('name').value,
        function(result) {
          var msg = '<table border="1">'
          msg += '<tr><th>名前</th><th>住所</th><th>TEL</th><th>Email</th></tr';

          for(i = 0; i < result.length; i++){
              msg += '<tr>';
              msg += '<td>' + result[i].name + '</td>';
              msg += '<td>' + result[i].address + '</td>';
              msg += '<td>' + result[i].tel + '</td>';
              msg += '<td>' + result[i].email + '</td>';
              msg += '</tr>'
          }//for

          msg += '</table>'
          $('result').innerHtml = msg;
        }//function
    );
}//function getResult()
//-->
</script>

<body onload="init()">
<form>
  <input type="text" name="name" size="20" />
  <input type="button" value="検索" onclick="getResult()" />
</form>
<div id="result">

</div>
</body>
</html>