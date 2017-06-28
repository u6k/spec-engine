# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](http://keepachangelog.com/en/1.0.0/)
and this project adheres to [Semantic Versioning](http://semver.org/spec/v2.0.0.html).

## [Unreleased]

### Added

- `spec-engine-tool`を提供します。
    - 単一の`pu`ファイルを読み込みます。
- 画面遷移図(ステートマシン図)を読み込み、整合性を検証します。
    - 画面遷移図に、以下の要素を記述できます。
        - `画面 --> 画面`
            - 逆遷移も可能。
            - ハイフンはいくつでも書ける。
        - `!` プリプロセッサ
            - 単純に無視します。
        - `state` による画面・帳票の定義
            - ステレオタイプ(`<<screen>>`, `<<report>>`)。
            - `as`による別名。
            - ネストした状態は未対応。
    - 以下の場合、エラーになります。
        - 遷移関係の中に開始点が存在しない。
        - どの画面からも遷移されない画面が存在する。
- 画面遷移図から、画面一覧を出力します。
