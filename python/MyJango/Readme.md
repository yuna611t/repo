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

### Viewの作成とURLマッピング

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

### Database Setup

今回は手順簡略かのためにデフォルトのSQLiteをそのまま使用する

__mysite/settings.py

```python
DATABASES = {
    'default': {
        'ENGINE': 'django.db.backends.sqlite3',
        'NAME': os.path.join(BASE_DIR, 'db.sqlite3'),
    }
}
```

TimeZoonを変更しておく

__mysite/settings.py

```python
TIME_ZONE = 'Asia/Tokyo'
```
DBの作成

```console
$ python manage.py migrate
```

Modelの作成

__mysite/polls/models.py

```python
from django.db import models

# Create your models here.
class Question(models.Model):
    question_text = models.CharField(max_length=200)
    pub_date = models.DateTimeField('date published')

class Choice(models.Model):
    question = models.ForeignKey(Question, on_delete=models.CASCADE)
    choice_text = models.CharField(max_length=200)
    votes = models.IntegerField(default=0)
```

Modelのアクティベーション

settings.pyのINSTALLED_APPSにアプリケーションを追加する

polls.apps.PollsConfigは/mysite/polls/apps.py

__mysites/mysite/settings.py__

```python
INSTALLED_APPS = [
    'polls.apps.PollsConfig',
    'django.contrib.admin',
    'django.contrib.auth',
    'django.contrib.contenttypes',
    'django.contrib.sessions',
    'django.contrib.messages',
    'django.contrib.staticfiles',
]
```

Modelをアクティベートする

```console
$ python mange.py makemigrations polls
```

Migrationファイルを使用してMigrationを行う

```console
$ python manage.py sqlmigrate polls 0001
```

実行結果

```sql
BEGIN;
--
-- Create model Choice
--
CREATE TABLE "polls_choice" (
    "id" integer NOT NULL PRIMARY KEY AUTOINCREMENT, 
    "choice_text" varchar(200) NOT NULL, 
    "votes" integer NOT NULL
);
--
-- Create model Question
--
CREATE TABLE "polls_question" (
    "id" integer NOT NULL PRIMARY KEY AUTOINCREMENT, 
    "question_text" varchar(200) NOT NULL, 
    "pub_date" datetime NOT NULL
);
--
-- Add field question to choice
--
ALTER TABLE "polls_choice" RENAME TO "polls_choice__old";
CREATE TABLE "polls_choice" (
    "id" integer NOT NULL PRIMARY KEY AUTOINCREMENT, 
    "choice_text" varchar(200) NOT NULL, 
    "votes" integer NOT NULL, 
    "question_id" integer NOT NULL REFERENCES "polls_question" ("id")
);

INSERT INTO "polls_choice" ("question_id", "id", "choice_text", "votes") SELECT NULL, "id", "choice_text", "votes" FROM "polls_choice__old";
DROP TABLE "polls_choice__old";
CREATE INDEX "polls_choice_question_id_c5b4b260" ON "polls_choice" ("question_id");

COMMIT;
```

DBにModelを反映

```console
$ python manage.py migrate
```

#### Modelの反映方法結論

* アプリケーションのmodels.pyにもModelクラスを追加

* Djangoのsettings.pyにアプリケーションのapps.pyのメインクラスを追加

* python mange.py makemigrations polls

* python manage.py migrate

