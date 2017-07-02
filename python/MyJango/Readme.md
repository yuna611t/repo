# DJangoの確認

## 環境

anacondaを使用しているため、pyenv, pyvertualenvの代わり

## 下記サイトの手順で進める

https://docs.djangoproject.com/en/1.11/intro/tutorial01/

## 手順

### Project作成

```console
$ django-admin startproject mysite
```

* mysiteディレクトリが生成される
* mystite/ : rootディレクトリ
* manage.py : Djangoと対話するcommand-line utility
* ¥__init__.py : Python にこのディレクトリがPython package 伝えるための空ファイル
* settings.py : Django プロジェクト用Settings/Configuration
* urls.py : DjangoプロジェクトのURL宣言
* wsgi.py : プロジェクトをWSGI(Web Server Gateway Interface)互換Web Serverに提供するためのエントリーポイント

### Deploy

Development用のサーバーが下記コマンドで立ち上がる

```console
$ python manage.py runserver
```

Portを変更する場合は、

```console
$ python manage.py runserver 8080
```

### Applicationの作成

```console
$ python manage.py startapp polls
```

#### Viewの作成

/polls/views.pyに下記を記述

__mysite/polls/views.py__

```python
from django.http import HttpResponse


def index(request):
    return HttpResponse("Hello, world. You're at the polls index.")
```


ViewとURLのマッピング

Viewを呼び出すためには、ViewとURLをマッピングする必要がある。
urls.pyを作成してURLConfを作成する。

__mysite/polls/urls.py__

```python
from django.conf.urls import url

from .import views

urlpatterns = [
    url(r'^$', views.index, name='index'),
]
```

Rootディレクトリを指し示す

__/mysite/mysite/urls.py__

```python
from django.conf.urls import url, include
from django.contrib import admin

urlpatterns = [
    url(r'^polls/', include('polls.urls')),
    url(r'^admin/', admin.site.urls),
]
```

<details><summary>include() function </summary>
別のURLConfへの参照
include()はマッチした部分を切り取って残りをincludeに渡す
</details>

index viewとURL confの紐付けが完了したのでサーバーを動かす

```console
$ python manage.py runserver
```

