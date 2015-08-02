# -*- coding: utf-8 -*-
import numpy as np

def main():
    data = np.array([31,30,27,25,29,34,32,31,30,29])
    var = np.var(data)
    print(u"var: " + str(var))

if __name__ == '__main__':
    main()
