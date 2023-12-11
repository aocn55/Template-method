package alo1211;


import java.util.Arrays;

/**
 * 并查集模板
 */
public class UnionFind {
    static int n; // 大小
    static int[] size; // 节点数目
    static int[] parent; // 父节点
    static int setCount; // 连通分量数目

    public UnionFind(int n) {
        UnionFind.n = n;
        size = new int[n];
        Arrays.fill(size, 1);
        parent = new int[n];
        setCount = n;

        for(int i = 0; i < n; i++) { /* 初始化 */
            parent[i] = i;
        }
    }

    public static int find(int x) {
        return parent[x] == x ? x : (parent[x] = find(parent[x]));
    }

    public static boolean union(int x, int y) {
        x = find(x);
        y = find(y);
        if(x == y) {
            return false;
        }
        if (size[x] < size[y]) {
            int temp = x;
            x = y;
            y = temp;
        }
        parent[y] = x;
        size[x] += size[y];
        setCount--;
        return true;
    }

    public static boolean connected(int x, int y) {
        x = find(x);
        y = find(y);
        return x == y;
    }
}
