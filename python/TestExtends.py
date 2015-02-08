# -*- coding: utf-8 -*-

class TestExtends(list):

    def __init__(self):
        list.__init__(self)

    def append(self,value):
        list.append(self,value)
        print u"値が追加されました" + str(value)

if __name__ == "__main__":
    
    test = TestExtends()
    test.append("python")
    test.append("-")
    test.append("izm")

    print "==================="

    for i in test:
        print i

