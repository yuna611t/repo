#coding: UTF-8

bits = 0b101010011
mask = 0b000011111

print "ビット = ", bin(bits), " = ", bits
print "マスク = ", bin(mask), " = ", mask

print "***下位5bit取り出す***"
print "  ", bin(bits)
print "&)", bin(mask)
print "  ____________________"
print "  ",bin(bits & mask)
print "dec => ",(bits & mask)

print "***4~8ビット目の値を取り出す***"
print bin(bits), ">> 3 & ", bin(mask) 
print bin( bits >> 3 & mask )

print "***下位3ビットを101に置き換える***"
mask = 0b111111000
print "  ", bin(bits)
print "&)", bin(mask)
print "  ______________________"
print "  ", bin(bits & mask)
print "|) 0b101"
print "  _____________________"
print "  ", bin(bits & mask | 0b101) 

print "***間違い探し***"
mask = 0b110101010
print "  ",bin(bits)
print "^)",bin(mask)
print "  ______________"
print bin(bits ^ mask)


