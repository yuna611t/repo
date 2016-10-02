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

results = {}
for c in country_list:
    if c in results:
        results[c] += 1
    else:
        results[c] = 1

for c in results:
    print("{}:{}".format(c, results[c]))
