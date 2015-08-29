#coding: UTF-8
#
# クイックソートのアルゴリズム
# 要素数が１以下ならば整列済み
# ピボットとなる要素をピックアップ
# ピボットより小さい値をピボットの左にピボットより大きい値をピボットの右に
# 分割された部分に再帰的にアルゴリズム適用

def quicksort(seq):
    print seq, " ソート対象リスト"
    if len(seq) < 1:
        print "要素数が１以下なのでソート終了"
        return seq
    pivot = seq[0]
    print "  ピボット: ", pivot
    left = []
    right = []
    for x in range(1, len(seq)):
        if seq[x] <= pivot:
            print  "     ", seq[x] , " <= " , pivot  , "        ピボット以下は左へ"
            left.append(seq[x])
        else:
            print  "            ", pivot , " => ", seq[x] , " ピボットより大きいものは右へ"
            right.append(seq[x])
    print "--左のサブリストに対してクイックソート"
    left = quicksort(left)
    print "++右のサブリストに対してクイックソート"
    right = quicksort(right)

    print "**ソート済みサブリスト** ", left + [pivot] + right
    return left + [pivot] + right


if __name__ == "__main__":
    arr = [4,9,8,3,6,2,1,10,5,7]
    print "Start"
    print "before sort : ", arr
    sorted = quicksort(arr)
    print "after sort  : ", sorted
    print "End"
