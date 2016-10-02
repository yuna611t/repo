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

    print("-------------")
    print("check relationship of calculation and number variable")
    n1 = 1
    id_n1_bef = id(n1)
    print("id of n1 is", id(n1))
    n2 = 2
    print("id of n2 is", id(n2))
    n1 = n1 + n2
    id_n1_aft = id(n1)
    print("id of 'n1 = n1 + n2' is", id(n1))
    print("--compare n1 which is before calculated with n1 which is after calculated --")
    if id_n1_bef == id_n1_aft:
        print("same")
    else:
        print("different")
