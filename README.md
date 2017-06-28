# spec-engine

__spec-engine__ は、仕様書を検証、プロトタイプ動作確認する、仕様書開発ツールです。

## 詳細

### 解決したい問題

書式があいまいで自然言語で書かれた仕様書は、整合性・妥当性の検証ができず、製造してみるまで仕様バグに気付きづらいです。

spec-engineは、いわゆる「実行可能な仕様書」を開発、プロトタイプ動作確認を行う開発ツールです。仕様情報の記述様式を定義し、仕様書を開発、検証、プロトタイプ動作確認を行うことで、上流工程で品質が高い仕様情報を開発することを目的とします。

### 対応工程

spec-engineは、要件定義工程、基本設計(外部設計)工程を想定しており、以下のような想いがあります。

- 上流工程で、仕様を素早く記述して、整合性や妥当性を検証できるように構造化したい。
- 実装と切り離した、仕様を定義したい。
- 内部設計は実装に近く、アーキテクチャがしっかりしていれば、仕様から(限りなく)機械的に設計書や実装ソースコードを出力できるはず。

以下は対応しません。

- 画面レイアウト、UI挙動の定義
    - 実装寄りの定義であり、仕様定義とは異なる視点が必要です。
- 帳票、ファイルなどの具体的なレイアウト定義
    - クラス構造としては定義しますが、具体的な定義はやはり実装寄りの定義です。

## デモンストレーション

TODO

## 機能

- 仕様書ファイルは、ソースコードと同様にテキストで記述します。また、複数の仕様書ファイルでプロジェクトを構成します。
    - 仕様書ファイルは、PlantUMLを拡張した書式で記述します。
    - 現時点で、以下の書式を読み込むことができます。
        - 画面遷移図(ステートマシン図)
- 仕様書の整合性を検証することができます。

## 前提条件

- Java 8以上

## インストール

TODO

## 使い方

TODO

## その他

### 画面遷移図(ステートマシン図)の記述仕様

#### 単純な画面遷移図

画面遷移図はステートマシン図として記述します。ステートが画面(または帳票)、矢印が遷移になります。

```
@startuml

[*] --> ログイン画面
ログイン画面 --> 顧客検索画面 : ログインした
顧客検索画面 --> 顧客詳細画面 : 検索して顧客を選択した

@enduml
```

#### 複合状態

複合状態を未実装です。

#### 長い言葉

キーワード `state` で長い画面名称を使用することができます。また、キーワード `as` で画面に別名を使用することができます。

```
@startuml

[*] --> Login
Login --> CustomerList : ログインした
CustomerList --> CustomerDetail : 検索して顧客を選択した

state "SCR001 ログイン画面" as Login
state "SCR002 顧客検索画面" as CustomerList
state "SCR003 顧客詳細画面" as CustomerDetail

@enduml
```

#### 同時状態

画面遷移図に同時状態は存在しないため、定義できません。

#### 矢印の方向

矢印の方向は未実装です。現在は `-->` のみ許容します。

画面遷移図から生成される図は、左上から右下に向かって図オブジェクトを展開します。

#### コメント

コメントは未実装です。

#### スキン

スキンは未実装です。

## コピーライト

(C) 2017 u6k.apps@gmail.com

## ライセンス

[MIT License](https://github.com/u6k/spec-engine/blob/master/LICENSE)
