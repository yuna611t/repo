#coding: UTF-8
# マージソートアルゴリズム
# ２つのサブリストに分割
# サブリストを整列
# サブリストをマージする
#   リストAとリストの先頭を比較して小さい方をリストCに追加
#    リストAかリストBのどちらかの要素がなくなるまで繰り返し
#   残った要素をリストCの末尾に追加

def mergeSort(aList):
    if len(aList) <= 1:
        return aList

    print " 分割対象リスト: ", aList
    mid = len(aList) // 2
    print " リストを分割する位置: ", mid
    left = aList[:mid]
    print " 左半分のリスト: ", left
    right = aList[mid:]
    print " 右半分のリスト: ", right

    print " * 左半分のリストを分割 ", left
    left = mergeSort(left)
    print " * 右半分のリストを分割 ", right
    right = mergeSort(right)

    print " 左のリストと右のリストをマージする"
    return list(merge(left,right))

def merge(left,right):
    print "   ---マージ---   "
    sortedList = []
    leftIndex = 0
    rightIndex = 0

    print "  マージする左のリスト : " , left
    print "  マージする右のリスト : " , right
    print "  左のリストか右のリストが空になるまでソート済みリストに追加"
    while leftIndex < len(left) and rightIndex < len(right):
        print "     +++左のリストと右のリストの最小値を比較する+++     "
        if left[leftIndex] <= right[rightIndex]:
            sortedList.append(left[leftIndex])
            leftIndex += 1
            print "    左のリストの最小値をソート済みリストに格納"
            print "    左のリストのインデックスを１つ増やす"
        else:
            sortedList.append(right[rightIndex])
            rightIndex += 1
            print "    右のリストの最小値をソート済みリストに格納"
            print "    右のリストのインデックスを１つ増やす"
        print "   ソート済みリスト: ", sortedList
        print "   左リストのインデックス値 : " , leftIndex , "/" , len(left)
        print "   右リストのインデックス値 : " , rightIndex , "/" , len(right)

    if left:
        print "  余った左のリストをソート済みリストに追加"
        sortedList.extend(left[leftIndex:])
    if right:
        print "  余った右のリストをソート済みリストに追加"
        sortedList.extend(right[rightIndex:])

    print "  ソート済みリスト: ", sortedList
    return sortedList


if __name__ == '__main__':
    arr = [4,9,8,3,6,2,1,10,5,7]
    print "Start"
    print "before sort : ", arr
    sorted = mergeSort(arr)
    print "after sort  : ", sorted
    print "End"
