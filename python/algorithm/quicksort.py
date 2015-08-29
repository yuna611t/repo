#coding: UTF-8

def quicksort(seq):
    if len(seq) < 1:
        return seq
    pivot = seq[0]
    left = []
    right = []
    for x in range(1, len(seq)):
        if seq[x] <= pivot:
            left.append(seq[x])
        else:
            right.append(seq[x])
    left = quicksort(left)
    right = quicksort(right)

    foo = [pivot]
    return left + foo + right


if __name__ == "__main__":
    arr = [10,9,8,3,6,1,2,4,5,7]
    print "Start"
    print "before sort : ", arr
    print "after sort  : ", quicksort(arr)
    print "End"
