
def print_dictionary(dict):
    for key in dict:
        print(dict[key])

def delete_element(key, dict):
    print ("id of dict is", id(dict))
    print("  Delete", key, "if this key exists")
    if key in dict:
        del dict[key]
        print(" ...deleted")
    else:
        print(" ...not deleted")


source_dict = {
    "morning": "朝",
    "evening": "夕方",
    "night": "夜"
}

print ("id of dict is", id(source_dict))

print("--befor--")
print_dictionary(source_dict)
delete_element("morning", source_dict)

print("--after--")
print_dictionary(source_dict)

delete_element("noon", source_dict)

print("--after--")
print_dictionary(source_dict)

