JNA Webアプリ 講座
====
Webアプリ研修。


## 課題実施目的
- MVCモデルを理解する。
- DB ⇒ API ⇒ 画面 の流れを理解する。

## ミドルウェア
- Webサーバ：Apache
- 開発言語：Java
- フレームワーク：Spring Boot
- データベース：MySQL
- O/Rマッパー：MyBatis
- テンプレートエンジン：Thymeleaf
- CSSフレームワーク：Semantic UI

※ xampp等でMySQLが使えることが前提条件です。

　　また、DBのテーブル設計のDDL、DMLを実行済みであること。

## 導入手順

◆Git for Windowsのインストール、GitHubに接続してみた。

https://qiita.com/manabu-watanabe/items/ecf1b434baf305adaa00

◆IntelliJ IDEAとGitHubを連携するときの設定メモ

https://qiita.com/rubytomato@github/items/b2ca27712146ed6f1426

◆lombokを有効にする

IntellijのSettingダイアログを開く。

(1) Plugin

    Settings>Plugins>Browse Repository>"lombok"でみつかるのでそれをinstall。version v0.14.16

(2) IDEAをrestart
(3) Annotation Processorを有効に
   
    Settings>Build, Execution, Deployment>Compiler>Annotation ProcessorsでEnable annotation processingにチェック。

◆ログなどの文字化け対応

idea64.exe.vmoptionsファイルに以下を記述すると、Intellijが起動しなくなる。

2020/03時点のアップデートから発生するそう。

    -Dfile.encoding=UTF-8

対応方法
https://blog.jetbrains.com/jp/2020/03/24/2872

対応方法詳細
https://youtrack.jetbrains.com/issue/IDEA-235472?_ga=2.82989974.1811515303.1589072864-102098850.1585802369#focus=streamItem-27-4080413.0-0





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
Domain Object（Value Object）

    ビジネスを行う上で必要なモデルを表現するオブジェクト

Service

    ビジネスロジック本体

Exception

    Exceptionたち

***
Infrastructure層
***

Entity

    通信時の構造体を表現するオブジェクト

mapper

    DBアクセス。

## DBのテーブル設計

◆t_EMPLOYEE（社員情報）テーブル

|PK|物理名|論理名|データ型|長さ(バイト)|NOT NULL|備考|
| ---- | ---- | ---- | ---- | ---- | ---- | ---- |
|〇|EMP_NO|社員番号|VARCHAR(6)|6|||
| |USER_NAME|氏名|VARCHAR(255)|255|〇||
| |PASSWORD|パスワード|VARCHAR(255)|255|〇||
| |BIRTH_DATE|生年月日|DATE||||
| |SEX_ID|性別|TINYINT| |〇|0:不明、1:男性、2:女性|
| |BIRTH_PLACE_ID|出身地|TINYINT||〇||
| |NICK_NAME|あだ名|VARCHAR(255)|255|||
| |ASSIGNEE_ID|配属先|TINYINT||〇||
| |PHOTO|写真|LONGBLOB| | ||
| |UPDATE_AT|更新日時|DATETIME||〇||
| |CREATE_AT|作成日時|DATETIME||〇||

◆m_SEX（性別マスター）テーブル

|PK|物理名|論理名|データ型|長さ(バイト)|NOT NULL|備考|
| ---- | ---- | ---- | ---- | ---- | ---- | ---- |
|〇|SEX_ID|ID|TINYINT||||
| |SEX_NAME|名称|VARCHAR(255)|255|〇|0:不明、1:男性、2:女性|

◆m_PREFECTURES（都道府県マスター）テーブル

|PK|物理名|論理名|データ型|長さ(バイト)|NOT NULL|備考|
| ---- | ---- | ---- | ---- | ---- | ---- | ---- |
|〇|PLACE_ID|ID|TINYINT|||
| |PLACE_NAME|名称|VARCHAR(255)|255|〇|


**DB初期構築**
***

    -- DB作成
    CREATE DATABASE JNA;
    
    -- 【DDL】
    -- 社員情報テーブル作成
    CREATE TABLE JNA.t_EMPLOYEE (
        EMP_NO VARCHAR(6) PRIMARY KEY,
        USER_NAME VARCHAR(255) NOT NULL, 
        PASSWORD VARCHAR(255) NOT NULL, 
        BIRTH_DATE DATE, 
        SEX_ID TINYINT NOT NULL, 
        BIRTH_PLACE_ID TINYINT NOT NULL,
        NICK_NAME VARCHAR(255), 
        ASSIGNEE_ID TINYINT NOT NULL, 
        PHOTO LONGBLOB,
        UPDATE_AT DATETIME NOT NULL,
        CREATE_AT DATETIME NOT NULL
    );

    -- 性別マスターテーブル作成
    CREATE TABLE JNA.m_SEX (
        SEX_ID TINYINT PRIMARY KEY,
        SEX_NAME VARCHAR(255) NOT NULL
    );
    
    -- 都道府県マスターテーブル作成
    CREATE TABLE JNA.m_PREFECTURES (
        PLACE_ID TINYINT PRIMARY KEY,
        PLACE_NAME VARCHAR(255) NOT NULL
    );

    -- 【DML】
    -- 性別マスターテーブル
    INSERT INTO `jna`.`m_sex` (`SEX_ID`, `SEX_NAME`) VALUES (0,'不明');
    INSERT INTO `jna`.`m_sex` (`SEX_ID`, `SEX_NAME`) VALUES (1,'男性');
    INSERT INTO `jna`.`m_sex` (`SEX_ID`, `SEX_NAME`) VALUES (2,'女性');

    -- 都道府県マスターテーブル
    INSERT INTO `jna`.`m_prefectures` (`PLACE_ID`, `PLACE_NAME`) VALUES (1,'北海道');
    INSERT INTO `jna`.`m_prefectures` (`PLACE_ID`, `PLACE_NAME`) VALUES (2,'青森');
    INSERT INTO `jna`.`m_prefectures` (`PLACE_ID`, `PLACE_NAME`) VALUES (3,'岩手');
    INSERT INTO `jna`.`m_prefectures` (`PLACE_ID`, `PLACE_NAME`) VALUES (4,'宮城');
    INSERT INTO `jna`.`m_prefectures` (`PLACE_ID`, `PLACE_NAME`) VALUES (5,'秋田');
    INSERT INTO `jna`.`m_prefectures` (`PLACE_ID`, `PLACE_NAME`) VALUES (6,'山形');
    INSERT INTO `jna`.`m_prefectures` (`PLACE_ID`, `PLACE_NAME`) VALUES (7,'福島');
    INSERT INTO `jna`.`m_prefectures` (`PLACE_ID`, `PLACE_NAME`) VALUES (8,'茨城');
    INSERT INTO `jna`.`m_prefectures` (`PLACE_ID`, `PLACE_NAME`) VALUES (9,'栃木');
    INSERT INTO `jna`.`m_prefectures` (`PLACE_ID`, `PLACE_NAME`) VALUES (10,'群馬');
    INSERT INTO `jna`.`m_prefectures` (`PLACE_ID`, `PLACE_NAME`) VALUES (11,'埼玉');
    INSERT INTO `jna`.`m_prefectures` (`PLACE_ID`, `PLACE_NAME`) VALUES (12,'千葉');
    INSERT INTO `jna`.`m_prefectures` (`PLACE_ID`, `PLACE_NAME`) VALUES (13,'東京');
    INSERT INTO `jna`.`m_prefectures` (`PLACE_ID`, `PLACE_NAME`) VALUES (14,'神奈川');
    INSERT INTO `jna`.`m_prefectures` (`PLACE_ID`, `PLACE_NAME`) VALUES (15,'新潟');
    INSERT INTO `jna`.`m_prefectures` (`PLACE_ID`, `PLACE_NAME`) VALUES (16,'富山');
    INSERT INTO `jna`.`m_prefectures` (`PLACE_ID`, `PLACE_NAME`) VALUES (17,'石川');
    INSERT INTO `jna`.`m_prefectures` (`PLACE_ID`, `PLACE_NAME`) VALUES (18,'福井');
    INSERT INTO `jna`.`m_prefectures` (`PLACE_ID`, `PLACE_NAME`) VALUES (19,'山梨');
    INSERT INTO `jna`.`m_prefectures` (`PLACE_ID`, `PLACE_NAME`) VALUES (20,'長野');
    INSERT INTO `jna`.`m_prefectures` (`PLACE_ID`, `PLACE_NAME`) VALUES (21,'岐阜');
    INSERT INTO `jna`.`m_prefectures` (`PLACE_ID`, `PLACE_NAME`) VALUES (22,'静岡');
    INSERT INTO `jna`.`m_prefectures` (`PLACE_ID`, `PLACE_NAME`) VALUES (23,'愛知');
    INSERT INTO `jna`.`m_prefectures` (`PLACE_ID`, `PLACE_NAME`) VALUES (24,'三重');
    INSERT INTO `jna`.`m_prefectures` (`PLACE_ID`, `PLACE_NAME`) VALUES (25,'滋賀');
    INSERT INTO `jna`.`m_prefectures` (`PLACE_ID`, `PLACE_NAME`) VALUES (26,'京都');
    INSERT INTO `jna`.`m_prefectures` (`PLACE_ID`, `PLACE_NAME`) VALUES (27,'大阪');
    INSERT INTO `jna`.`m_prefectures` (`PLACE_ID`, `PLACE_NAME`) VALUES (28,'兵庫');
    INSERT INTO `jna`.`m_prefectures` (`PLACE_ID`, `PLACE_NAME`) VALUES (29,'奈良');
    INSERT INTO `jna`.`m_prefectures` (`PLACE_ID`, `PLACE_NAME`) VALUES (30,'和歌山');
    INSERT INTO `jna`.`m_prefectures` (`PLACE_ID`, `PLACE_NAME`) VALUES (31,'鳥取');
    INSERT INTO `jna`.`m_prefectures` (`PLACE_ID`, `PLACE_NAME`) VALUES (32,'島根');
    INSERT INTO `jna`.`m_prefectures` (`PLACE_ID`, `PLACE_NAME`) VALUES (33,'岡山');
    INSERT INTO `jna`.`m_prefectures` (`PLACE_ID`, `PLACE_NAME`) VALUES (34,'広島');
    INSERT INTO `jna`.`m_prefectures` (`PLACE_ID`, `PLACE_NAME`) VALUES (35,'山口');
    INSERT INTO `jna`.`m_prefectures` (`PLACE_ID`, `PLACE_NAME`) VALUES (36,'徳島');
    INSERT INTO `jna`.`m_prefectures` (`PLACE_ID`, `PLACE_NAME`) VALUES (37,'香川');
    INSERT INTO `jna`.`m_prefectures` (`PLACE_ID`, `PLACE_NAME`) VALUES (38,'愛媛');
    INSERT INTO `jna`.`m_prefectures` (`PLACE_ID`, `PLACE_NAME`) VALUES (39,'高知');
    INSERT INTO `jna`.`m_prefectures` (`PLACE_ID`, `PLACE_NAME`) VALUES (40,'福岡');
    INSERT INTO `jna`.`m_prefectures` (`PLACE_ID`, `PLACE_NAME`) VALUES (41,'佐賀');
    INSERT INTO `jna`.`m_prefectures` (`PLACE_ID`, `PLACE_NAME`) VALUES (42,'長崎');
    INSERT INTO `jna`.`m_prefectures` (`PLACE_ID`, `PLACE_NAME`) VALUES (43,'熊本');
    INSERT INTO `jna`.`m_prefectures` (`PLACE_ID`, `PLACE_NAME`) VALUES (44,'大分');
    INSERT INTO `jna`.`m_prefectures` (`PLACE_ID`, `PLACE_NAME`) VALUES (45,'宮崎');
    INSERT INTO `jna`.`m_prefectures` (`PLACE_ID`, `PLACE_NAME`) VALUES (46,'鹿児島');
    INSERT INTO `jna`.`m_prefectures` (`PLACE_ID`, `PLACE_NAME`) VALUES (47,'沖縄');

## 課題1

◆配属先一覧をDBから取得する用に修正せよ


## Author

[tcnksm](https://github.com/tcnksm)