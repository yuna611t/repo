country_list = []
def generate_list():
    for i in range(0,100):
        if i % 3 == 0:
            country_list.append("Itally")
        elif i % 4 == 0:
            country_list.append("France")
        elif i % 5 == 0:
            country_list.append("German")
        else:
            country_list.append("Japan")

generate_list()
print("country_list is following:")
[print(" - ",c) for c in country_list]
print("---------")

country_names = {c:0 for c in country_list}
for c in country_names:
    print("{}:{}".format(c, country_list.count(c)))
