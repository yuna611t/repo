# DJangoの確認

## 環境

anacondaを使用しているため、pyenv, pyvertualenvの代わり

## 下記サイトの手順で進める

https://docs.djangoproject.com/en/1.11/intro/tutorial01/

## 手順

### Project作成

    $ django-admin startproject mysite

* mysiteディレクトリが生成される
* mystite/ : rootディレクトリ
* manage.py : Djangoと対話するcommand-line utility
* ¥__init__.py : Python にこのディレクトリがPython package 伝えるための空ファイル
* settings.py : Django プロジェクト用Settings/Configuration
* urls.py : DjangoプロジェクトのURL宣言
* wsgi.py : プロジェクトをWSGI(Web Server Gateway Interface)互換Web Serverに提供するためのエントリーポイント

### Deploy

