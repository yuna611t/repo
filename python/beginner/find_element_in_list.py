# -*- coding: utf-8 -*- 

class ElementFinder:

    @classmethod
    def find_element_in_list(cls, target_element, source_list):
        print("target is", target_element)
        print("list type is", type(source_list))
        [print("", x, ",", end="") for x in source_list]
        print("")

        if target_element in source_list:
            print("element exists")
        else:
            print("element does not exist")


if __name__ == "__main__":    
    ElementFinder.find_element_in_list(2, [1, 2, 3] )
    ElementFinder.find_element_in_list(2, (1, 2, 3) )
