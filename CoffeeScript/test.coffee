###
CoffeeScriptの基本文法
###
i = 1
if i is 1
    console.log('変数iは1')

### 同盟変数の扱い ###
x = 100
hoge = ->
    ### コンパイル後グローバル変数として扱われる ###
    x = 200
    return

### 変数展開 ###
title = 'Rails4'
msg = "Let's try , #{title} !!"
console.log(msg)

### ヒアドキュメント ###
body = """
        ヒアドキュメントの
        サンプル
       """
console.log(body)

### 配列・ハッシュ ###
ary1 = [100,200,300,]
hash1 = {a:100,b:200,c:300,}
### YAMLっぽい階層構造 ###
picture =
    Landscape:
        title: '雪と梅'
        price: 1000
        delete: false
    Portrait:
        title: '傘さす子ども'
        price: 2500
        delete: false

### 存在チェック ###
if title?
    console.log(title)
value = null
value ?= "wing"
initial = value ? 0

### 関数funcが存在する場合のみ実行 ###
console.log(func?())
### オブジェクトobjが存在する場合fooにアクセス ###
console.log(obj?.foo)

### if文 ###
if x is 1
    console.log("1")
else
    console.log("not 1")
x = 1
console.log('success') if x is 1

### switch case ###
point = 1
switch point
    when 3
        console.log('3')
    when 2, 1
        console.log('2 or 1')
    else
        console.log("else")

### while ###
i = 0
while i < 10
    console.log(i)
    i++

### for ###
ary = ['Red','Yellow','Green']
for color in ary
    console.log(color)
hash = {name:'Uta',age:1,kind:'hamster'}
for key, value of hash
    console.log("#{key}=#{value}")
for i in [5..10]
    console.log(i)
for i in [5...10]
    console.log(i)

### 関数 ###
bmi = (height, weight) ->
    weight / (height * height)
console.log(bmi 1.65, 70)
area = (base,height,type='triangle') ->
    if type is 'triangle'
        base * height / 2
    else
        base * height
console.log(area 2, 4)
product = (nums...) ->
    total = 1
    total *= num for num in nums
    total
console.log(product 1, 3, 5, 8, 10, 20)

### 匿名関数 ###
###
$ ->
    $('#button').hover ->
        $(this).attr 'src', 'enter.gif'
        return
    , ->
        $(this).attr 'src', 'out.gif'
        return
    return
###

### class ###
class Dog
    voice: 'わんわん'
    constructor: (@name) ->
    bark: ->
        console.log("#{@name}は#{@voice}吠えています")
        return
dog = new Dog 'シロ'
dog.bark()

class ExtendDog extends Dog
    bark: ->
        super()
        console.log("大声で")
        return
dog = new ExtendDog 'クロ'
dog.bark()

Dog::eat = ->
    console.log("#{@name}は食べています")
    return
dog = new Dog("グレイ")
dog.eat()

class Figure
    @pi: 3.14
    @square: (base, height) ->
        base * height
console.log(Figure.pi)
console.log(Figure.square 3, 4)
