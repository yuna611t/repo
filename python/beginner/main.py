# -*- coding: utf-8 -*- 

class sample_class:
    def __init__(self,name):
        self.name = name

if __name__ == "__main__":
    classList = []
    classList.append(sample_class("Test1"))
    classList.append(sample_class("Test2"))

    for obj in classList:
        print("-------------")
        print("object name is", obj)
        print("object id is", id(obj))
