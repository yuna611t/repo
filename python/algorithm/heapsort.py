#coding: UTF-8
#
def heapsort(aList):
    listSize = len(aList) - 1
    print "リストの要素数-1: ", listSize
    for i in range((listSize / 2), -1, -1):
        print "A リストを処理 : ", aList
        shiftDown(aList, i, listSize)
    for i in range(listSize, 0, -1):
        print "B リストを処理 : ", aList
        if aList[0] > aList[i]:
            temp = aList[0]
            aList[0] = aList[i]
            aList[i] = temp
            print "shiftDown(",aList, ",", 0, ",", i - 1, ")"
            shiftDown(aList, 0, i - 1)
    return aList

def shiftDown(aList, root, bottom):
    print "**ヒープツリーの作成**"
    print "   リスト:", aList
    print "   ヒープの仮ルート:", root, " = ", aList[root]
    print "   ヒープの仮最小値:", bottom, " = ", aList[bottom]
    while (root * 2) <= bottom:
        if (root * 2) == bottom:
            maxChild = root * 2
        elif aList[root * 2] > aList[(root * 2) + 1]:
            maxChild = root * 2
        else:
            maxChild = root * 2 + 1

            print "   +maxChild", maxChild

        if aList[root] < aList[maxChild]:
            temp = aList[root]
            aList[root] = aList[maxChild]
            aList[maxChild] = temp
            root = maxChild
            print "    +-ヒープの仮ルート:", root, " = ", aList[root]
            print "    +-ヒープの仮最小値:", bottom, " = ", aList[bottom]
        else:
            return

if __name__ == "__main__":
    arr = [4,9,8,3,6,2,1,10,5,7]
    print "Start"
    print "before sort : ", arr
    sorted = heapsort(arr)
    print "after sort  : ", sorted
    print "End"
