JNA Webアプリ 講座
====
Webアプリ研修。


## 課題実施目的
- MVCモデルを理解する。
- DB ⇒ API ⇒ 画面 の流れを理解する。

## ミドルウェア
- Webサーバ：Apache
- 開発言語：Java
- データベース：MySQL
- フレームワーク：Spring Boot
- テンプレートエンジン：Thymeleaf
- CSSフレームワーク：Semantic UI

## 導入手順

◆Git for Windowsのインストール、GitHubに接続してみた。

https://qiita.com/manabu-watanabe/items/ecf1b434baf305adaa00

◆IntelliJ IDEAとGitHubを連携するときの設定メモ

https://qiita.com/rubytomato@github/items/b2ca27712146ed6f1426

## 機能要件
社員情報管理システム

    [画面構成]
    0.TOP
	1.社員情報追加
	2.社員情報編集(確認)
	3.社員情報一覧表示
	4.社員情報検索
	5.社員情報削除

## その他
1.画面イメージ/画面遷移	

	★画面イメージと画面遷移図はExcel等で示す

2.デザイン

	スタイルシートを用いてグラフィカルなデザインに仕上げると尚良い。
	ただし、htmlにベタ書きするのではなく、cssファイルに切り出すようにして、class名でデザインが適用されるようにすること。

3.javascript

	スタイルシート同様に、javascriptの処理はjsファイルに切り出すようにする。

## アプトプット
1.設計

	DB定義書
	クラス図/構成図(今回無し)
	→クラス図の作成は求めないが、MVCに則った実装を行うこと。

2.実装

	ソースコード
3.試験

	試験項目マトリクス
	試験項目書
	エビデンス等
	
## パッケージ構成

***
**Application層**
***
Resource

    リクエストやレスポンスのオブジェクト

Controller

    入出力とサービスのマッピングをする

***
**Domain層**
***
Domain Object

    ビジネスを行う上で必要なモデルを表現するオブジェクト

Service

    ビジネスロジック本体

Repository Interface

    Infrastructure Layerとのインタフェース
    依存関係逆転の原則ってやつ

Exception

    Exceptionたち

***
Infrastructure層
***

Entity

    通信時の構造体を表現するオブジェクト

Repository Implement

    Repository Interfaceの実装。

## DBのテーブル設計

|PK|物理名|論理名|データ型|長さ(バイト)|NOT NULL|備考|
| ---- | ---- | ---- | ---- | ---- | ---- | ---- |
|〇|EMP_NO|社員番号|VARCHAR(6)|6|||
| |USER_NAME|氏名|VARCHAR(255)|255|〇||
| |PASSWORD|パスワード|VARCHAR(255)|255|〇||
| |BIRTH_DATE|生年月日|DATE||||
| |SEX|性別|TINYINT| |〇|0:不明、1:male、2:female、3:not applicable|
| |BIRTH_PLACE|出身地|VARCHAR(255)|255|||
| |NICK_NAME|あだ名|VARCHAR(255)|255|||
| |ASSIGNEE|配属先|VARCHAR(255)|255|〇||
| |PHOTO|写真|LONGBLOB| | ||

**DB初期構築**
***

    -- DB作成
    CREATE DATABASE JNA;
    
    -- テーブル作成
    CREATE TABLE JNA.EMPLOYEE (
        EMP_NO VARCHAR(6) PRIMARY KEY,
        USER_NAME VARCHAR(255) NOT NULL, 
        PASSWORD VARCHAR(255) NOT NULL, 
        BIRTH_DATE DATE, 
        SEX TINYINT NOT NULL, 
        BIRTH_PLACE VARCHAR(255), 
        NICK_NAME VARCHAR(255), 
        ASSIGNEE VARCHAR(255) NOT NULL, 
        PHOTO LONGBLOB 
    );


## 課題1
社員情報削除


## Author

[tcnksm](https://github.com/tcnksm)