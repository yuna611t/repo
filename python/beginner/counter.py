country_list = []
def generate_list():
    for i in range(0,10000000):
        if i % 3 == 0:
            country_list.append("Itally")
        elif i % 4 == 0:
            country_list.append("France")
        elif i % 5 == 0:
            country_list.append("German")
        else:
            country_list.append("Japan")

generate_list()
#print("country_list is following:")
#[print(" - ",c) for c in country_list]
#print("---------")

# which is faster? => real    0m5.101s 
country_names = {c:0 for c in country_list}
for c in country_names:
    print("{}:{}".format(c, country_list.count(c)))

# which is faster? => real    0m6.156s   
#results = {}                                                                                                                                    
#for c in country_list:                                                                                                                          
#    if c in results:                                                                                                                            
#        results[c] += 1                                                                                                                         
#    else:                                                                                                                                       
#        results[c] = 1                                                                                                                          
#                                                                                                                                                
#for c in results:                                                                                                                               
#    print("{}:{}".format(c, results[c]))  
