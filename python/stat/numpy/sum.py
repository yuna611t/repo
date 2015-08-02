# -*- coding: utf-8 -*-
import numpy as np

def main():
    # データ(気温)
    data = np.array([31,30,27,25,29,34,32,31,30,29])
    sum = np.sum(data)
    print(u"max:" + str(sum))

if __name__ == '__main__':
    main()
