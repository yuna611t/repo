# -*- coding: utf-8 -*- 

source_list = ["Morning", "Evening", "Night", "Mid Night"]
pair_list = ["朝", "昼", "夜", "深夜"]

[print(index, ":", element) for index, element in enumerate(source_list)]
print("")
[print(english, ":", japanese) for english, japanese in zip(source_list, pair_list)]