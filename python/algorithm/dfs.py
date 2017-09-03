def dfs_paths(graph, start, goal, path=None):
    if path is None:
        path = [start]
    if path == goal:
        yield path
    
    yield path
    for next_node in graph[start] - set(path):
        for q in dfs_paths(graph, next_node, goal, path + [next_node]):
            yield q


if __name__ == '__main__':
    #  探索対象のグラフ
    graph = {'A': set(['B', 'C']), 
        'B': set(['A', 'D', 'E']), 
        'C': set(['A', 'F']),
        'D': set(['B']),
        'E': set(['B', 'F']),
        'F': set(['C', 'E'])}

    # AからFまでの経路取得
    [print(x) for x in dfs_paths(graph, 'A', 'F')]
