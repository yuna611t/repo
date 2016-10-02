# -*- coding: utf-8 -*- 

message = "Hello, {}.\n{}".format("Yuta", "How are you?")
print(message)

message = "{1}, {0}".format("Hello", "Good Morning")
print(message)

float_number = 10 / 3.14
print(float_number)
formated_float_number = "{:.3f}".format(float_number)
print(formated_float_number)