JNA Webアプリ 講座
====
Webアプリ研修。

現場で用いられている技術に触れてみよう！！

# 目次

***[目的・構成・知識](#目的構成知識)***

- [課題実施目的](#課題実施目的)

- [ミドルウェア](#ミドルウェア)

- [知識](#知識)

- [ソースコードのパッケージ構成](#ソースコードのパッケージ構成)

***[導入手順・機能要件・アプトプット（制作物）](#導入手順機能要件アプトプット制作物）)***

- [導入手順](#導入手順)

- [機能要件](#機能要件)

- [その他](#その他)

- [アプトプット（制作物）](#アプトプット)

**[設計](#設計)**

- [画面シーケンス図](#画面シーケンス図)

- [API一覧](#API一覧)

- [DB定義書](#DB定義書)

**[課題](#課題)**

- [課題1](#課題1)

- [課題2](#課題2)

- [課題3](#課題3)

- [課題4](#課題4)

- [課題5](#課題5)

- [課題6](#課題6)

# 目的・構成・知識
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

## ざっくり知識（まずは、へぇ～程度で見る）

- Webアプリケーションの仕組み【特に重要】

https://www.sejuku.net/blog/1046

- MVCモデル【特に重要】

https://qiita.com/konkipiano/items/50b22c8fb79aa67a5b71

- フレームワーク：Spring Boot

https://www.slideshare.net/OgawaTakeshi/spring-boot-71285225

- データベース：MySQL

http://html2php.starrypages.net/mysql/sql-list

- O/Rマッパー：MyBatis

https://qiita.com/5zm/items/e1faac61a1d00998fb1f

- テンプレートエンジン：Thymeleaf

https://www.nttdata.com/jp/ja/data-insight/2019/0805/

- CSSフレームワーク：Semantic UI

https://qiita.com/Yuta_Fujiwara/items/8abeda1b92dcaf505149

- READMEの書き方（Markdown記法 チートシート）

https://gist.github.com/mignonstyle/083c9e1651d7734f84c99b8cf49d57fa

## ソースコードのパッケージ構成

***
**Application層**
***
Resource

    リクエストやレスポンスのオブジェクト。

Controller

    入出力とサービスのマッピングをする。

***
**Domain層**
***
Domain Object（Value Object）

    ビジネスを行う上で必要なモデルを表現する（不変）オブジェクト。
    一般的には顧客の名前、電話番号など属性の1つ1つがValue Objectとなることが多い。

Service

    ビジネスロジック本体。

***
Infrastructure層
***

Entity

    DBに登録・更新する値を入れておく。
    DBから取得した値を保持しておく。

mapper

    DBアクセスするクラス。
   
# 導入手順・機能要件・アプトプット（制作物） 
## 導入手順

**1.Git for Windowsのインストール**  
https://eng-entrance.com/git-install

**2.GitHubアカウント作成**  
https://note.com/snmal_jp/n/n3ef510a8181e

**3.公開鍵/秘密鍵の生成＆GitHubに公開鍵登録**  
https://qiita.com/coffee_g9/items/e1b9ab28cfa54f854308

**4.Gradleのダウンロード**  
https://qiita.com/quwahara/items/9c4e5fbda421cfcb09ad  
　・Gradleのバージョンはv6.3を指定する  

**5.IntelliJのインストール**  
https://sukkiri.jp/technologies/ides/intellij-idea/intellij-idea-win.html  
　・「step2 IntelliJ IDEAのダウンロード」ではCommunity版を選択。

　・「step4 IntelliJ IDEAの日本語化」の実施は任意です。  
　　ただし日本語化すると処理速度が落ちるので注意が必要。

　・「step5 IntelliJ IDEAの実行」は以下の手順を実施し、Java演習で使用したフォルダを指定しましょう。  
　　①選択肢の「開く(OPEN)」を選択  
　　②Java演習で使用したフォルダを指定  
　　　例)C:\workspace\Java\Study  
　　③college.intro1などのパッケージが存在することを確認

**6.Javaの環境変数を設定**  
https://drive.google.com/drive/u/0/folders/1RR6sXYYIMw5MYcDzz_taycg_iyOsgUzQ  
　・06.環境変数の設定.pptx 参照

**7.IntelliJとGitHubの連携**  
https://www.task-notes.com/entry/20160511/1462935600  
　・上記URLのGitコマンド確認、GitHub認証を参照  

**8.jnaWebCourseをクローン & アプリ起動**  
https://drive.google.com/drive/u/0/folders/1RR6sXYYIMw5MYcDzz_taycg_iyOsgUzQ  
　・08.Webアプリ講座起動手順書.pptx 参照



## 機能要件
社員情報管理システム

    [画面構成及び処理概要]
    0.TOP
	1.社員情報登録
	2.社員情報一覧（検索・削除）
    3.社員情報編集
	
## その他
1.画面イメージ/画面遷移	

	設計時は、画面イメージと画面遷移図はExcel等で示す

2.デザイン

	スタイルシートを用いてグラフィカルなデザインに仕上げると尚良い。
	ただし、htmlにベタ書きするのではなく、cssファイルに切り出すようにして、class名でデザインが適用されるようにすること。

3.javascript

	スタイルシート同様に、javascriptの処理はjsファイルに切り出すようにする。

## アプトプット
1.設計

- 必要に応じた設計（画面、API、DB）を実施
- クラス図/構成図(今回無し)

	⇒クラス図の作成は求めないが、MVCに則った実装を行うこと。

2.実装

- ソースコード

	⇒課題に応じたソースコード作成。MVCに則った実装を行うこと。

3.試験

- 試験項目マトリクス

	⇒試験項目の漏れが無いように、マトリクス表を作成すること。

- 試験項目書

	⇒試験項目マトリクスをもとに項目を作成すること。

- エビデンス

	⇒試験項目書の実施結果をエビデンス（証跡）として作成すること。

# 設計

## 画面設計

本来は画面設計書（イメージ、画面遷移図）を作成しますが、今回は実装を画面設計とします。

### TOP

![image](https://user-images.githubusercontent.com/64938514/84006238-5b9ffc00-a9a9-11ea-99cb-50e99e37bf40.png)

***処理概要***

- 他の画面へ遷移

***画面項目***

|大項目|項目|遷移先|概要|備考|
| ---- | ---- | ---- | ---- | ---- |
| メニュー | TOP | TOP画面 | TOP画面へ遷移する | - |
| | 社員情報一覧 | 社員情報一覧画面 | 社員情報一覧画面へ遷移する | - |
| | 社員情報登録 | 社員情報登録画面 | 社員情報登録画面へ遷移する | - |
| 表示領域 | コンテンツ | - | 内容表示 | - |

### 社員情報登録

![image](https://user-images.githubusercontent.com/64938514/84006412-a6ba0f00-a9a9-11ea-8076-69f590ace89c.png)

***処理概要***

- 他の画面へ遷移
- 登録ボタンで情報登録
- 登録時、入力内容のチェック

***画面項目***

|大項目|項目|遷移先|概要|備考|
| ---- | ---- | ---- | ---- | ---- |
| メニュー | TOP | TOP画面 | TOP画面へ遷移する | - |
| | 社員情報一覧 | 社員情報一覧画面 | 社員情報一覧画面へ遷移する | - |
| | 社員情報登録 | 社員情報登録画面 | 社員情報登録画面へ遷移する | - |
| 社員情報 | 社員番号 | - | 入力 | - |
|  | 氏名 | - | 入力 | - |
|  | パスワード | - | 入力 | - |
|  | 生年月日 | - | 入力 | - |
|  | 性別 | - | 選択 | - |
|  | 出身地 | - | 選択 | - |
|  | ニックネーム | - | 入力欄 | - |
|  | 配属先 | - | 選択 | - |
|  | プロフィール画像 | - | ドラッグ＆ドロップで画像表示 | - |
| ボタン | 登録 | - | 社員情報を登録する | - |


### 社員情報一覧

![image](https://user-images.githubusercontent.com/64938514/84034281-17c2ec00-a9d5-11ea-8ca2-258e443cc845.png)

***処理概要***

- 他の画面へ遷移
- 検索ボタンで情報検索
- 編集ボタンで社員情報編集画面へ遷移
- 削除ボタンで社員情報削除

***画面項目***

|大項目|項目|遷移先|概要|備考|
| ---- | ---- | ---- | ---- | ---- |
| メニュー | TOP | TOP画面 | TOP画面へ遷移する | - |
| | 社員情報一覧 | 社員情報一覧画面 | 社員情報一覧画面へ遷移する | - |
| | 社員情報登録 | 社員情報登録画面 | 社員情報登録画面へ遷移する | - |
| 社員情報 | 社員番号 | - | 入力 | 検索条件は部分一致 |
|  | 氏名 | - | 入力 | 検索条件は部分一致 |
| ボタン | 検索 | - | 社員情報を検索する | - |
| | 編集 | - | 社員情報編集画面へ遷移する | - |
| | 削除 | - | 社員情報を削除する | - |

## 画面シーケンス図

プロジェクト内の「docs」 - 「sequence」フォルダ内に格納しています。

拡張子が「puml」のファイルでシーケンス図を作成しています。

___

【社員情報登録画面】

![社員情報登録画面](https://user-images.githubusercontent.com/64938514/82010133-31119a80-96ac-11ea-8ac3-a2c1efe132af.png)

___

【社員情報一覧画面（検索）】

![社員情報一覧画面（検索）](https://user-images.githubusercontent.com/64938514/83995113-74051c00-a993-11ea-95ee-c4407132a16e.png)

___

【社員情報一覧画面（削除）】

![社員情報一覧画面（削除）](./docs/sequence/社員情報一覧画面（削除）.png)

___

【社員情報編集画面】

![社員情報編集画面](./)
## API一覧

現場では画面シーケンス図は作成せず、API仕様を作成する場合が多いです。

画面は、エクセルやパワーポイントでイメージと処理概要を共有され、

その情報をもとにAPI設計する。といった流れになります。

API設計では「[API一覧](#API一覧)」、「[API仕様](#API仕様)」を作成します。

|画面|API名|メソッド|エントリポイント|画面内のみで使用しているエントリポイント|備考|
| ---- | ---- | ---- | ---- | ---- | ---- |
| TOP | - | - | - | - | - |
| 社員情報登録 | 社員情報登録API | POST | /register | - | - |
| | | POST | | /upload | - | -|
| 社員情報一覧 | 社員情報一覧検索API | GET | /viewer/search | - | - |
| 社員情報一覧 | 社員情報削除API | GET | /delete/{empNo} | - | - |
| 社員情報編集 | 社員情報編集API | POST | /editor | - | - |

## API仕様

### 【社員情報登録API】
  ___
  
  #### 概要
  
  社員情報を登録する。
  
  #### シーケンス図
  
  ![社員情報登録API](https://user-images.githubusercontent.com/64938514/84002754-df56ea00-a9a3-11ea-8d0c-81c940d9556d.png)
  
  #### リクエスト
  
  |項目名|パラメータ名|入力規則|備考|
  | ---- | ---- | ---- | ---- |
  | 社員番号 | empNo | 6桁整数 | 必須 |
  | 氏名 | userName || 必須 |
  | パスワード | password || 必須 |
  | 生年月日 | birthDate |||
  | 性別 | sex || 必須 |
  | 出身地 | birthPlace || 必須 |
  | ニックネーム | nickName |||
  | 配属先 | assignee || 必須 |
  | プロフィール画像 | photo |||
  
  #### レスポンス
  
  なし

### 【社員情報一覧検索API】
___

#### 概要

社員情報を検索する。

#### シーケンス図

![社員情報一覧検索API](https://user-images.githubusercontent.com/64938514/84035773-388c4100-a9d7-11ea-8f0a-6bc2cb8bc156.png)

#### リクエスト

|項目名|パラメータ名|入力規則|備考|
| ---- | ---- | ---- | ---- |
| 社員番号 | empNo |||
| 氏名 | userName |||

#### レスポンス

|返却値|概要|備考|
| ---- | ---- | ---- |
| List＜ViewerResponseResource＞ | 社員情報一覧 ||

***ViewerResponseResource***

|項目名|パラメータ名|備考|
| ---- | ---- | ---- |
| 社員番号 | empNo ||
| 氏名 | userName ||
| パスワード | password ||
| 生年月日 | birthDate ||
| 性別 | sex ||
| 出身地 | birthPlace ||
| ニックネーム | nickName ||
| 配属先 | assignee ||
| プロフィール画像 | photo ||

### 【社員情報削除API】
___

#### 概要

社員情報を削除する。

#### シーケンス図

![社員情報削除API](./docs/sequence/api/deleteAPI.png)

#### リクエスト

|項目名|パラメータ名|入力規則|備考|
| ---- | ---- | ---- | ---- |
| 社員番号 | empNo |||
| 氏名 | userName |||

#### レスポンス

なし

## DB定義書

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

◆m_ASSIGNEE（配属先マスター）テーブル

|PK|物理名|論理名|データ型|長さ(バイト)|NOT NULL|備考|
| ---- | ---- | ---- | ---- | ---- | ---- | ---- |
|〇|ASSIGNEE_ID|ID|TINYINT|||
| |ASSIGNEE_NAME|名称|VARCHAR(255)|255|〇|

### DB初期構築
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
    
    
    -- 配属先マスターテーブル作成
    CREATE TABLE JNA.m_ASSIGNEE (
        ASSIGNEE_ID AUTO_INCREMENT TINYINT PRIMARY KEY,
        ASSIGNEE_NAME VARCHAR(255) NOT NULL
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

    -- 配属先マスターテーブル
    INSERT INTO `jna`.`m_assignee` (`ASSIGNEE_ID`, `ASSIGNEE_NAME`) VALUES (1,'神奈川営業所');
    INSERT INTO `jna`.`m_assignee` (`ASSIGNEE_ID`, `ASSIGNEE_NAME`) VALUES (2,'新宿営業所');
    INSERT INTO `jna`.`m_assignee` (`ASSIGNEE_ID`, `ASSIGNEE_NAME`) VALUES (3,'大阪営業所');
    INSERT INTO `jna`.`m_assignee` (`ASSIGNEE_ID`, `ASSIGNEE_NAME`) VALUES (4,'福岡営業所');
    INSERT INTO `jna`.`m_assignee` (`ASSIGNEE_ID`, `ASSIGNEE_NAME`) VALUES (5,'仙台営業所');
    INSERT INTO `jna`.`m_assignee` (`ASSIGNEE_ID`, `ASSIGNEE_NAME`) VALUES (6,'宇都宮営業所');
    INSERT INTO `jna`.`m_assignee` (`ASSIGNEE_ID`, `ASSIGNEE_NAME`) VALUES (7,'大宮営業所');
    INSERT INTO `jna`.`m_assignee` (`ASSIGNEE_ID`, `ASSIGNEE_NAME`) VALUES (8,'名古屋営業所');
    ***


# 課題

## 動作方法

***[前提条件]***
- xampp等でMySQLが使えること。

- [DB初期構築](#DB初期構築)のDDL、DMLを実施済みであること。

- 「jnaWebCourse\src\main\resources\application.yml」の「username」、「password」を自身のMySQLに合わせて変更すること。
___

![Gradleの起動キャプチャ](https://user-images.githubusercontent.com/64938514/84041269-92dcd000-a9de-11ea-98c3-acd2b5dd06a2.png)

1. 「Gradle」をクリック
1. 更新マークをクリック（更新が完了するまで待機）
1. 「bootRun」をダブルクリック
1. Webブラウザ（Google Chrome推奨）を起動し、URLに「http://localhost:8080/」を入力してEnterキー


## 課題1

以下の画面を開いた時、画面名称がわからない。

そのため、各画面のhtmlファイルに画面名称が表示されるようにしなさい。

【作成物】

1. ソースコード

    - 実装

## 課題2

社員情報登録画面の配属先リストはプログラムで固定文字列を設定している。

固定文字列ではなく、DBから取得して表示に修正せよ。

【作成物】

1. 設計

    - [テーブル定義書](#テーブル定義書)
    
            ・配属先一覧のテーブル
            ・DDL、DML

2. ソースコード

    - 実装
        
3. 結合試験
    　　
    - 試験項目マトリクス
    - 試験項目書
    - 試験実施エビデンス

## 課題3

社員情報一覧画面で検索実行後、

生年月日を降順でソートした結果を画面に返却しなさい。

【作成物】

1. ソースコード

    - 実装
        
2. 結合試験
    　　
    - 試験項目マトリクス
    - 試験項目書
    - 試験実施エビデンス

## 課題4

社員情報削除は、画面遷移のみできるようになっています。

DBのテーブルから削除する処理を実装しなさい。

【作成物】

1. 設計

    - [画面シーケンス図](#画面シーケンス図)
    - [API仕様](#API仕様)

2. ソースコード

    - 実装
    - 可能なら単体試験（実装箇所のJUnitを作成）
        
3. 結合試験
    　　
    - 試験項目マトリクス
    - 試験項目書
    - 試験実施エビデンス

## 課題5

社員情報編集画面は、「更新」ボタンをクリックしても編集されません。

編集処理を実装せよ。

1. 設計

    - [画面シーケンス図](#画面シーケンス図)
    - [API仕様](#API仕様)

2. ソースコード

    - 実装
    - 可能なら単体試験（実装箇所のJUnitを作成）
        
3. 結合試験
    　　
    - 試験項目マトリクス
    - 試験項目書
    - 試験実施エビデンス

## 課題6

【課題2】で作成したマスターテーブルを画面から操作（参照、追加、編集、削除）できるようにせよ。

画面デザインや画面数については各自で考えること。

1. 設計

    - [設計](#設計)

2. ソースコード

    - 実装
    - 可能なら単体試験（実装箇所のJUnitを作成）
        
3. 結合試験
    　　
    - 試験項目マトリクス
    - 試験項目書
    - 試験実施エビデンス
