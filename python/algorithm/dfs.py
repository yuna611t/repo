def dfs_paths(graph, start, goal):
    # [('A', ['A'])]
    stack = [(start, [start])]

    while stack:
        # stackの状態(1週目)  |_('A', ['A'])_|  => |_|
        # stackの状態(2週目)  |_('C', ['A', 'C'])_|  => |_|      
        (vertex, path) = stack.pop()
        # 通過済みのノードを除いた現在の頂点に隣接するノードを処理する
        for next in graph[vertex] - set(path):
            if next == goal:
                # 隣接するノードが目的地の場合、訪問済みパスに隣接するノードを追加してyeildにスタック
                yield path + [next]
            else:
                # 隣接するノードが目的地でない場合、隣接するノードを頂点として隣接するノードまでのパスをStack
                # stackの状態(1週目)  ||_|  => |_('C', ['A', 'C'])_|
                stack.append((next, path + [next]))


if __name__ == '__main__':
    #  探索対象のグラフ
    graph = {'A': set(['B', 'C']), 
        'B': set(['A', 'D', 'E']), 
        'C': set(['A', 'F']),
        'D': set(['B']),
        'E': set(['B', 'F']),
        'F': set(['C', 'E'])}
    
    # AからFまでの経路取得
    paths = list(dfs_paths(graph, 'A', 'F'))
    [print(path) for path in paths]
   