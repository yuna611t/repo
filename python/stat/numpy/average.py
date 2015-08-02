# -*- coding: utf-8 -*-
import numpy as np

def main():
    data = np.array([31,30,27,25,29,34,32,31,30,29])
    ave = np.average(data)
    print(u"ave: " + str(ave))

if __name__ == '__main__':
    main()
